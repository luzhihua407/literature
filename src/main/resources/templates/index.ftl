<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
</head>
<body>
<form>
    <div class="form-row align-items-center">
        <form action="/query" method="post" id="queryForm">
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
        </form>
    </div>
</form>
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
    </tbody>
</table>
<nav aria-label="Page navigation example">
    <ul class="pagination justify-content-center">
        <#assign span=5>
        <#assign begin=page.getNumber()/span*span/>
        <#assign end=(page.getNumber()/span+1)*span/>
        <#if page.getTotalPages() lte end>
        <#assign end=page.getTotalPages()-1/>
        </#if>
        <#assign next=page.getNumber()+1/>
        <#if page.getNumber() gte 2>
            <li class="page-item"><a class="page-link" href="query?author=${author}&keyword=${keyword}&pageNumber=0">首页</a></li>
         <li class="page-item"><a class="page-link" href="query?author=${author}&keyword=${keyword}&pageNumber=${page.getNumber()-1}">上一页</a></li>
        </#if>
        <#list begin..end as i>
            <#if page.getNumber()==i>
                <li class="page-item active" aria-current="page">
                  <span class="page-link">
                    ${i}
                    <span class="sr-only">(current)</span>
                  </span>
                </li>
            <#else>
            <li class="page-item"><a class="page-link" href="query?author=${author}&keyword=${keyword}&pageNumber=${i}">${i}</a></li>
            </#if>
        </#list>
        <#if page.getNumber()!=page.getTotalPages()-1 && page.getTotalPages() gt span >
            <li class="page-item"><a class="page-link" href="query?author=${author}&keyword=${keyword}&pageNumber=${next}">下一页</a></li>
            <li class="page-item"><a class="page-link" href="query?author=${author}&keyword=${keyword}&pageNumber=${page.getTotalPages()-1}">尾页</a></li>
        </#if>
    </ul>
</nav>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
<script>
$(document).ready(function () {

})
</script>
</body>
</html>