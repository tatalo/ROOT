<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title><g:message code="default.webname.label"/></title>
</head>

<body>

<g:render template="/lotto/narbar1" model="[lv1IDX: lv1IDX]"/>
<g:render template="/lotto/narbar2" model="[lv1IDX: lv1IDX,lv2IDX: lv2IDX]"/>
<hr class="soften"/>

<div class="container">
    <div class="form-group">
        <div class="pull-left">
            <g:img dir="images" file="lotto/lotto${pType}.png"/>
        </div>

        <div class="pull-right">
            <g:if test="${showSpBtn == "1"}">
                <g:if test="${params.pUnSPNO == "1"}">
                    <a class="btn btn-danger" href="${pLink}?max=${params.max}&pUnSPNO=0">
                        顯示特別號
                    </a>
                </g:if>
                <g:else>
                    <a class="btn btn-danger" href="${pLink}?max=${params.max}&pUnSPNO=1">
                        不顯示特別號
                    </a>
                </g:else>
            </g:if>
            <a class="btn btn-primary" href="${pLink}?max=25&pUnSPNO=${params.pUnSPNO}">
                25
            </a>
            <a class="btn btn-primary" href="${pLink}?max=50&pUnSPNO=${params.pUnSPNO}">
                50
            </a>
            <a class="btn btn-primary" href="${pLink}?max=100&pUnSPNO=${params.pUnSPNO}">
                100
            </a>
            <a class="btn btn-primary" href="${pLink}?max=150&pUnSPNO=${params.pUnSPNO}">
                150
            </a>
            <a class="btn btn-primary" href="${pLink}?max=200&pUnSPNO=${params.pUnSPNO}">
                200
            </a>
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
</div>

</body>
</html>
