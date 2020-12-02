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
            <#if navList??>
                <#list navList as item>
                    <li class="nav-item <#if category==item.value>active</#if>">
                        <#if item.value==1>
                                <a class="nav-link" href="/article/authorDetail?category=${item.value}">${item.name}</a>
                            <#else>
                                <a class="nav-link" href="/article/query?category=${item.value}">${item.name}</a>
                        </#if>
                    </li>
                </#list>
            </#if>
        </ul>
    </div>
</nav>
