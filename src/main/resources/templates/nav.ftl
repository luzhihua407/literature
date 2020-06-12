<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
    <a class="navbar-brand" href="#"></a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" href="#">首页</a>
            </li>
            <li class="nav-item <#if category==3>active</#if>">
                <a class="nav-link" href="/article/authorAgg?category=3">作者索引</a>
            </li>
            <li class="nav-item <#if category==1>active</#if>">
                <a class="nav-link" href="/article/query?category=1">唐诗宋词</a>
            </li>
            <li class="nav-item <#if category==2>active</#if>">
                <a class="nav-link" href="/article/query?category=2">道德经</a>
            </li>
        </ul>
    </div>
</nav>