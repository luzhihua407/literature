<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>唐诗宋词</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
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
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
</body>
</html>