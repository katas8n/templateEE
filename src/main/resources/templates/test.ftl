<!DOCTYPE html>
<html>
<head>
<title>Test Page</title>
<link rel="stylesheet" type="text/css" href="/assets/test-css.css">
</head>

<body>
    HELLO!
    <h1>${message}</h1>
    <ul>
        <#list items as item>
            <li>${item}</li>
        </#list>
    </ul>
<#if items??>
    <ul>
        <#list items as item>
            <li>${item}</li>
        </#list>
    </ul>
<#else>
    <p>No items available.</p>
</#if>

   <script src="/assets/test-js.js"></script>
</body>
</html>
