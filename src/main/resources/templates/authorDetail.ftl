<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>唐诗宋词</title>
    <link rel="stylesheet" href="/static/css/bootstrap.min.css">
</head>
<body>
<#include "nav.ftl"/>
<div class="container">
    <div class="row">

    <div class="col-xl-8">
    <#list page.getContent() as item>
        <div class="card mt-4">
            <div class="card-body">
                <h5 class="card-title">${item.title}</h5>
                <p class="card-text">${item.body}</p>
                <p class="card-text">${item.author}</p>
            </div>
        </div>
    </#list>
    </div>
    <div class="card col-xl-4 mt-4">
        <div class="row">
            <#list authorAgg.getContent() as item>

             <div class="col-xl-4"><a class="text-reset" href="/article/authorDetail?author=${item.author}">${item.author}<span class="badge badge-light">${item.count}</span></a></div>
            </#list>
        </div>
    </div>

    </div>
    </div>
<script src="/static/js/jquery-3.5.1.slim.min.js"></script>
<script src="/static/js/popper.min.js"></script>
<script src="/static/js/bootstrap.min.js"></script></body>
</html>
