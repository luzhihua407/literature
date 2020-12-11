<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>唐诗宋词</title>
    <link rel="stylesheet" href="/css/bootstrap.min.css">
</head>
<body>
<#include "nav.ftl"/>
<#import "pagination.ftl" as pagination />
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
        <nav aria-label="Page navigation example" style="float:right;">
            <ul class="pagination justify-content-center">
                <li class="page-item"><@pagination.first /></li>
                <li class="page-item"><@pagination.previous /></li>
                <li class="page-item"><@pagination.numbers /></li>
                <li class="page-item"><@pagination.next /></li>
                <li class="page-item"><@pagination.last /></li>
            </ul>
        </nav>
        <@pagination.counter />
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
