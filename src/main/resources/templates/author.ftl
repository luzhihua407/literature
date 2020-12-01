<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <title>唐诗宋词</title>
    <link rel="stylesheet" href="/static/css/bootstrap.min.css">
</head>
<body>
<#include "nav.ftl"/>
<div class="container">
    <div class="row">
    <#list page.getContent() as item>
        <div class="col-sm-2 mt-4">
                <a class="text-reset" href="/article/authorDetail?author=${item.author}">
                    ${item.author}<span class="badge badge-light">${item.count}</span>
                </a>
        </div>
    </#list>
    </div>

<script src="/static/js/jquery-3.5.1.slim.min.js"></script>
<script src="/static/js/popper.min.js"></script>
<script src="/static/js/bootstrap.min.js"></script>
<script>
    function querySubmit(pageNumber){
        $("#pageNumber").val(pageNumber);
        $("#queryForm").submit();
    }
$(document).ready(function () {


})
</script>
</div>
</body>
</html>
