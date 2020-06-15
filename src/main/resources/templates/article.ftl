<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <title>唐诗宋词</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
</head>
<body>
<#include "nav.ftl"/>
<ul class="navbar nav justify-content-end navbar-light bg-light">
    <li class="nav-item">
    <form action="/article/query" method="post" id="queryForm">
        <div class="form-row align-items-center">
            <input type="hidden" name="pageNumber" id="pageNumber" value="1">
            <input type="hidden" name="category" id="category" value="${category}">
            <div class="col-auto">
                <label class="sr-only" for="inlineFormInput">作者</label>
                <input type="text" class="form-control mb-2" name="author" placeholder="请输入作者名" value="${author!""}">
            </div>
            <div class="col-auto">
                <label class="sr-only" for="inlineFormInputGroup">内容</label>
                <div class="input-group mb-2">
                    <input type="text" class="form-control" name="keyword" placeholder="请输入内容关键字" value="${keyword!""}">
                </div>
            </div>
            <div class="col-auto">
                <button type="submit" class="btn btn-primary mb-2" id="search">查询</button>
            </div>
        </div>
    </form>
    </li>
</ul>
<div class="container">
<table class="table">
    <thead>
    <tr>
        <th scope="col">标题</th>
        <th scope="col">内容</th>
        <th scope="col">作者</th>
    </tr>
    </thead>
    <tbody>
    <#if page.content??>
    <#list page.content as item>

    <tr>
        <td width="10%">
            ${item.title!""}
        </td>
        <td width="80%">
            ${item.body!""}

        </td>
        <td width="10%">
            ${item.author!""}

        </td>
    </tr>
    </#list>
    </#if>
    <#if page.getTotalPages()==0>
        <tr>
            <td colspan="3">

                <p class="text-center">搜索不到任何内容</p>
            </td>
        </tr>
    </#if>
    </tbody>
</table>
<#if page.getTotalPages() gt 0>

<nav aria-label="Page navigation example">
    <ul class="pagination justify-content-center">
        <#assign span=5>
        <!--because page start in 0 -->
        <#assign pageNumber=page.getNumber()+1>

        <#if pageNumber%span!=0>
            <#assign begin=pageNumber-2>
        </#if>
        <#assign begin=pageNumber/span*span/>

        <#if pageNumber%span!=0>
            <#assign end=pageNumber+2>
        <#else>
        <#assign end=(pageNumber/span+1)*span/>
        </#if>
        <#if page.getTotalPages() lte end>
            <#assign end=page.getTotalPages()/>
        </#if>
        <#assign next=pageNumber+1/>
        <#if pageNumber gte 2>
            <li class="page-item"><a class="page-link" href="#?" onclick="querySubmit(1)">首页</a></li>
         <li class="page-item"><a class="page-link" href="#?" onclick="querySubmit(${pageNumber-1})">上一页</a></li>
        </#if>
        <#list begin..end as i>
            <#if pageNumber==i>
                <li class="page-item active" aria-current="page">
                  <span class="page-link">
                    ${i}
                    <span class="sr-only">(current)</span>
                  </span>
                </li>
            <#else>
            <li class="page-item"><a class="page-link" href="#?" onclick="querySubmit(${i})">${i}</a></li>
            </#if>
        </#list>
        <#if pageNumber!=page.getTotalPages() && page.getTotalPages() gt span >
            <li class="page-item"><a class="page-link" href="#?" onclick="querySubmit(${next})">下一页</a></li>
            <li class="page-item"><a class="page-link" href="#?" onclick="querySubmit(${page.getTotalPages()})">尾页</a></li>
        </#if>
    </ul>
</nav>

</#if>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
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