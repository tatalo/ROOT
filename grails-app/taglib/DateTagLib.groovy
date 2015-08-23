class DateTagLib {
    def toolsService

    static namespace = "df"

    static returnObjectForTags = [
            "yyyList"
    ]

    //�d�ߵ��G
    def yyyList = { attrs, body ->
        def pYearList = grailsApplication.config.grails.dataStart.yyyy.toInteger()..g.formatDate(date: new Date(),format: 'yyyy').toInteger()

        return pYearList
    }

    def params_text_date_transform = { attrs ->
        def p = attrs.params
        def l = attrs.list
        def s = (attrs.sqldate == "true" || attrs.sqldate == true)

        for (name in l) {
            if (params[name]) {
                def v = toolsService.g_date_time_yyyyMMdd(params, name)?.time
                if (!v) {
                    try { //�ץ�����������date����null���D
                        params[name] = new Date(params[name])
                    } catch (Exception e) {
                        params[name] = null
                    } finally {}
                } else {
                    if (s) {
                        params[name] = new java.sql.Date(v.time)
                    } else {
                        params[name] = v
                    }
                }
            } else {
                params[name] = null
            }
        }
    }
}
