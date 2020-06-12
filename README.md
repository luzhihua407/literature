# literature
如果你对唐诗宋词感兴趣，想搜索关于描述春天的唐诗宋词，那么源码应用可以帮助你！<br>源码利用搜索引擎，可以根据所要搜索的诗词关键字，找到相关的唐诗宋词，包括内容，作者，标题。<br>数据库收集了500多首唐诗宋词，来源于互联网，不敢保证100%数据正确性!

源码开发环境以及使用到的一些技术：<br>
1、elasticsearch-7.5.1、elasticsearch-analysis-ik-7.5.1 <br>
2、spring boot 2.2.5.RELEASE<br>
3、bootstrap 4.5.0<br>
4、mysql-8.0.17-winx64<br>
5、jquery 3.5.1<br>
6、mysql-8.0.17-winx64<br>
7、window10<br>
8、jdk1.8<br>
9、IntelliJ IDEA 2019.2.2 (Ultimate Edition)<br>

ElasticSearch和IK的下载与安装<br>
1、到https://www.elastic.co/cn/downloads/elasticsearch 下载ElasticSearch7.5.1的Window版本。<br>
2、到https://github.com/medcl/elasticsearch-analysis-ik/releases 下载IK，版本号跟上面的ElasticSearch对应。<br>
3、将ElasticSearch压缩包解压到本地任意路径。<br>
4、找到ElasticSearch安装路径，打开根目录下plugins文件夹，并在里面创建IK文件夹，将下载的IK压缩包的文件，解压到该文件夹里面。<br>

ElasticSearch的启动<br>
打开ElasticSearch安装路径下的bin目录，找到elasticsearch.bat文件，双击运行。<br>
启动后，打开浏览器，在地址栏输入http://localhost:9200 如果看到页面上输出ElasticSearch的有关信息，则表示ElasticSearch已经正常运行。<br>
