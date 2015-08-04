<div class="panel panel-default">
    <div class="table-responsive">
        <!-- Default panel contents -->
        <table class="table table-hover table-striped">
            <thead>
            <tr>
                <th class="col-sm-1">#</th>
                <th class="col-sm-3">網站</th>
                <th class="col-sm-8">連結</th>
            </tr>
            </thead>
            <tbody>
            <g:each in="${nw200I}" var="nw200" status="i">
                <tr>
                    <td>${i + 1}</td>
                <td>
                    ${nw200?.webnm}
                </td>
                <td>
                    <g:if test="${nw200?.manageurl != null}">
                        <a href="${nw200?.manageurl}" class="btn btn-primary btn-sm" target="_blank">檢視</a>
                    </g:if>
                </td>
            </g:each>
            </tbody>
        </table>
    </div>
</div>