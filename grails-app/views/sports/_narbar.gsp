<div class="form-group">
    <div class="container-fluid defaultBgColor1">
        <div class="container">
            <ul class="nav nav-pills nav-justified HDivider-outer">
                <g:each in="${hl.getSportsTabs().findAll{it.tabLv == 1}}" var="tab" status="i">
                    <li role="presentation" class="${hl.chkActiveClass(chkValue:(params.lv1IDX as Integer?:1),matchValue:tab?.lv1IDX)} HDivider-inner">
                        <a href="${tab?.link}">
                            ${tab?.text}
                        </a>
                    </li>
                </g:each>
            </ul>
        </div>
    </div>
</div>