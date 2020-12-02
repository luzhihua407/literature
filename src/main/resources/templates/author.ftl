<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <title>唐诗宋词</title>
    <link rel="stylesheet" href="/css/bootstrap.min.css">
</head>
<body>
<#include "nav.ftl"/>
<div class="container">
        <#if firstLetterPage??>
            <div>按字母索引</div>
<#--         <div class="row">-->
            <#list firstLetterPage.getContent() as item>
                <div class="card" style="width: 18rem;"><div class="card-header">
                        <h6 class="card-subtitle mb-2 text-muted">${item.firstLetter!""}<span class="badge badge-light">${item.count}</span></h6>
                    </div>
                    <div class="card-body">
                        <#list item.authors as author>
                        <p class="card-text"><a class="text-reset" href="/article/authorDetail?author=${author!""}">${author!""}</a></p>
                        </#list>
                    </div>
                </div>
<#--                <div class="card" style="width: 18rem;">-->
<#--                    <div class="card-header">-->
<#--                        ${item.firstLetter!""}<span class="badge badge-light">${item.count}</span>-->
<#--                    </div>-->
<#--                    <ul class="list-group list-group-flush">-->
<#--                        <#list item.authors as author>-->
<#--                        <li class="list-group-item"><a class="text-reset" href="/article/authorDetail?author=${author!""}">${author!""}</a></li>-->
<#--                        </#list>-->
<#--                    </ul>-->
<#--                </div>-->
<#--                <div class="col-sm-2 mt-4">-->
<#--                            ${item.firstLetter!""}<span class="badge badge-light">${item.count}</span>-->
<#--                     <#list item.authors as author>-->
<#--                        <a class="text-reset" href="/article/authorDetail?author=${author!""}">${author!""}</a>-->
<#--                     </#list>-->
<#--                </div>-->
            </#list>
<#--        </div>-->
        </#if>
<#--        <#if authorPage??>-->
<#--            <div>按名称索引</div>-->
<#--            <div class="row">-->
<#--            <#list authorPage.getContent() as item>-->

<#--                <div class="col-sm-2 mt-4">-->
<#--                        <a class="text-reset" href="/article/authorDetail?author=${item.author!""}">-->
<#--                            ${item.author!""}<span class="badge badge-light">${item.count}</span>-->
<#--                        </a>-->
<#--                </div>-->
<#--            </#list>-->
<#--            </div>-->
<#--        </#if>-->

<script src="/js/jquery-3.5.1.slim.min.js"></script>
<script src="/js/popper.min.js"></script>
<script src="/js/bootstrap.min.js"></script>
</div>
</body>
</html>
