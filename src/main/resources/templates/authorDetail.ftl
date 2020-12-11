<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>唐诗宋词</title>
    <link rel="stylesheet" href="/css/bootstrap.min.css">
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
        <li class="row">
            <ul class="list-group  list-group-flush">
            <#list authorAgg.getContent() as item>
                <li class="list-group-item">
                <div class="media">

                    <div class="mr-3">${item.firstLetter!""}</div>

                    <div class="media-body">
                        <#list item.authors as author>
                            <a class="text-reset  col-xl-6 " href="/article/authorDetail?author=${author}">
                                <#if currentAuthor==author>
                                    <button type="button" class="btn btn-secondary btn-sm">${author}</button>
                                <#else>
                                    ${author}
                                </#if>
                            </a>
                        </#list>
                    </div>
                </div>
                </li>

<#--             <div class="col-xl-4">-->
<#--                 <div class="row">-->
<#--                     <div class="col-xl-12 bg-secondary text-white">-->
<#--                         ${item.firstLetter!""}-->
<#--                     </div>-->
<#--                 </div>-->
<#--                 <#list item.authors as author>-->
<#--                     <span class="col-xl-12">-->
<#--                     <a class="text-reset" href="/article/authorDetail?author=${author}">-->
<#--                         <#if currentAuthor==author>-->
<#--                             <button type="button" class="btn btn-secondary btn-sm">${author}</button>-->
<#--                         <#else>-->
<#--                             ${author}-->
<#--                         </#if>-->
<#--                     </a>-->
<#--                    </span>-->
<#--                 </#list>-->
<#--             </div>-->
            </#list>
            </ul>
        </div>
    </div>

    </div>
    </div>
<script src="/js/jquery-3.5.1.slim.min.js"></script>
<script src="/js/popper.min.js"></script>
<script src="/js/bootstrap.min.js"></script></body>
</html>
