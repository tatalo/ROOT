<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title><g:message code="default.webname.label"/></title>
</head>

<body>

<g:render template="/lotto/narbar1" model="[lv1IDX: lv1IDX]"/>
<g:render template="/lotto/narbar2" model="[lv1IDX: lv1IDX, lv2IDX: lv2IDX]"/>
<hr class="soften"/>

<div class="container">
    <div class="form-group">
        <div class="pull-left">
            <g:img dir="images" file="lotto/lotto${pType}.png"/>
        </div>

        <div class="pull-right">
            <form method="post">
                <g:hiddenField name="max" value="${params.int('max')}"/>
                <g:if test="${showSpBtn == "1"}">
                    <g:hiddenField name="pUnSPNO" value="${params.int('pUnSPNO')}"/>
                    <g:if test="${params.int('pUnSPNO') == 1}">
                        <g:submitButton class="btn btn-danger" onclick="jQuery('#pUnSPNO').val('0');" name="顯示特別號"/>
                    </g:if>
                    <g:else>
                        <g:submitButton class="btn btn-danger" onclick="jQuery('#pUnSPNO').val('1');" name="不顯示特別號"/>
                    </g:else>
                </g:if>
                <g:submitButton class="btn btn-primary" onclick="jQuery('#max').val('25');" name="25"/>
                <g:submitButton class="btn btn-primary" onclick="jQuery('#max').val('50');" name="50"/>
                <g:submitButton class="btn btn-primary" onclick="jQuery('#max').val('100');" name="100"/>
                <g:submitButton class="btn btn-primary" onclick="jQuery('#max').val('150');" name="150"/>
                <g:submitButton class="btn btn-primary" onclick="jQuery('#max').val('200');" name="200"/>
            </form>
        </div>

        <div class="clearfix"/>
    </div>

    <div class="pull-left">
        <g:render template="/lotto/lottoHelp1"/>
    </div>

    <div class="pull-right">查詢最新 ${totalCount} 期</div>

    <div class="clearfix"></div>


    <div class="table-responsive">
        <!-- Default panel contents -->
        <table border="1" style="width: 100%">
            <g:render template="/lotto/lottoDataList1" model="[columnsNOs: columnsNOs, nw300I: nw300I]"/>
            <g:render template="/lotto/lottoDataTitleList1" model="[columnsNOs: columnsNOs, nw300I: nw300I]"/>
            <g:render template="/lotto/lottoDataCntsList1"
                      model="[columnsNOs: columnsNOs, nw300IC: nw300IC, nw300ICMax: nw300ICMax]"/>
            <g:render template="/lotto/lottoDataLastOpenList1"
                      model="[columnsNOs: columnsNOs, nw300IL: nw300IL, nw300ILMax: nw300ILMax]"/>
        </table>
    </div>
    <g:render template="/base/board/board1" model="[name: params.action]"/>
</div>

</body>
</html>
