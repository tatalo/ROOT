<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title><g:message code="default.webname.label"/></title>
</head>

<body>

<g:render template="/lotto/narbar1"/>
<g:render template="/lotto/narbar2" model="[lv1IDX: lv1IDX]"/>
<hr class="soften"/>

<div class="container">
    <g:render template="/base/content/content1" model="[nw400I: nw400I]"/>
</div>

</body>
</html>