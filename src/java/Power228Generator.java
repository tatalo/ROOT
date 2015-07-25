/* The whole class is copied from Hibernate source code SequenceGenerator.java
 * because somehow extending the class and overriding configure() doesn't work.
 *
 * The only code changed was a line in configure():
 *
 * this.sql = "select " + dialect.getSelectSequenceNextValString(sequenceName) + " + power(2, 28) from dual";
 */

import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.cfg.ObjectNameNormalizer;
import org.hibernate.dialect.Dialect;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.*;
import org.hibernate.internal.util.config.ConfigurationHelper;
import org.hibernate.mapping.Table;
import org.hibernate.type.Type;
import org.jboss.logging.Logger;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * <b>sequence</b><br>
 * <br>
 * Generates <tt>long</tt> values using an oracle-style sequence. A higher
 * performance algorithm is <tt>SequenceHiLoGenerator</tt>.<br>
 * <br>
 * Mapping parameters supported: sequence, parameters.
 *
 * @see SequenceHiLoGenerator
 * @author Gavin King
 */
public class Power228Generator
    implements PersistentIdentifierGenerator, BulkInsertionCapableIdentifierGenerator, Configurable {

    private static final Logger LOG = Logger.getLogger( SequenceGenerator.class.getName() );

    /**
     * The sequence parameter
     */
    public static final String SEQUENCE = "sequenceName";

    /**
     * The parameters parameter, appended to the create sequence DDL.
     * For example (Oracle): <tt>INCREMENT BY 1 START WITH 1 MAXVALUE 100 NOCACHE</tt>.
     */
    public static final String PARAMETERS = "parameters";

    private String sequenceName;
    private String parameters;
    private Type identifierType;
    private String sql;

    protected Type getIdentifierType() {
        return identifierType;
    }

    public Object generatorKey() {
        return getSequenceName();
    }

    public String getSequenceName() {
        return sequenceName;
    }

    @Override
    public void configure(Type type, Properties params, Dialect dialect) throws MappingException {
        ObjectNameNormalizer normalizer = ( ObjectNameNormalizer ) params.get( IDENTIFIER_NORMALIZER );
        sequenceName = normalizer.normalizeIdentifierQuoting(
            ConfigurationHelper.getString( SEQUENCE, params, "NESEQ" )
            );
        parameters = params.getProperty( PARAMETERS );

        if ( sequenceName.indexOf( '.' ) < 0 ) {
            final String schemaName = normalizer.normalizeIdentifierQuoting( params.getProperty( SCHEMA ) );
            final String catalogName = normalizer.normalizeIdentifierQuoting( params.getProperty( CATALOG ) );
            sequenceName = Table.qualify(
                dialect.quote( catalogName ),
                dialect.quote( schemaName ),
                dialect.quote( sequenceName )
                );
        }
        else {
            // if already qualified there is not much we can do in a portable manner so we pass it
            // through and assume the user has set up the name correctly.
        }

        this.identifierType = type;
        this.sql = "select " + dialect.getSelectSequenceNextValString(sequenceName) + " + power(2, 28) from dual";
    }

    @Override
    public Serializable generate(SessionImplementor session, Object obj) {
        return generateHolder( session ).makeValue();
    }

    protected IntegralDataTypeHolder generateHolder(SessionImplementor session) {
        try {
            PreparedStatement st = session.getTransactionCoordinator().getJdbcCoordinator().getStatementPreparer().prepareStatement( sql );
            try {
                ResultSet rs = session.getTransactionCoordinator().getJdbcCoordinator().getResultSetReturn().extract( st );
                try {
                    rs.next();
                    IntegralDataTypeHolder result = buildHolder();
                    result.initialize( rs, 1 );
                    LOG.debugf( "Sequence identifier generated: %s", result );
                    return result;
                }
                finally {
                    session.getTransactionCoordinator().getJdbcCoordinator().release( rs, st );
                }
            }
            finally {
                session.getTransactionCoordinator().getJdbcCoordinator().release( st );
            }

        }
        catch (SQLException sqle) {
            throw session.getFactory().getSQLExceptionHelper().convert(
                sqle,
                "could not get next sequence value",
                sql
                );
        }
    }

    protected IntegralDataTypeHolder buildHolder() {
        return IdentifierGeneratorHelper.getIntegralDataTypeHolder( identifierType.getReturnedClass() );
    }

    @Override
    @SuppressWarnings( {"deprecation"})
    public String[] sqlCreateStrings(Dialect dialect) throws HibernateException {
        String[] ddl = dialect.getCreateSequenceStrings( sequenceName );
        if ( parameters != null ) {
            ddl[ddl.length - 1] += ' ' + parameters;
        }
        return ddl;
    }

    @Override
    public String[] sqlDropStrings(Dialect dialect) throws HibernateException {
        return dialect.getDropSequenceStrings(sequenceName);
    }

    @Override
    public boolean supportsBulkInsertionIdentifierGeneration() {
        return true;
    }

    @Override
    public String determineBulkInsertionIdentifierGenerationSelectFragment(Dialect dialect) {
        return dialect.getSelectSequenceNextValString( getSequenceName() );
    }
}
