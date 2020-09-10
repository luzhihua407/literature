# literature
中国璀璨的文化，博大精深！老祖宗给我们留下了大量的宝贵精神财富。
不管是周易、道德经，论语等国学，还是唐诗宋词等文学，都深深的吸引着我。
如何在浩如烟海的文字中，寻找到心目中那句优美的词句或者圣人哲理？从而温故而知新，陶冶性情？
有了此念头，于是着手开发了本应用。
本源码利用ElasticSearch搜索引擎技术结合Web UI 构成。

> 源码开发环境以及使用到的一些技术：

 - elasticsearch-7.5.1、elasticsearch-analysis-ik-7.5.1 
 - spring boot 2.2.5.RELEASE
 - bootstrap 4.5.0
 - mysql-8.0.17-winx64
 - jquery 3.5.1
 - mysql-8.0.17-winx64
 - window10
 - jdk1.8
 - IntelliJ IDEA 2019.2.2 (Ultimate Edition)

> ElasticSearch和IK的下载与安装

1. 到https://www.elastic.co/cn/downloads/elasticsearch 下载ElasticSearch7.5.1的Window版本。
2. 到https://github.com/medcl/elasticsearch-analysis-ik/releases 下载IK，版本号跟上面的ElasticSearch对应。
3. 将ElasticSearch压缩包解压到本地任意路径。
4. 找到ElasticSearch安装路径，打开根目录下plugins文件夹，并在里面创建IK文件夹，将下载的IK压缩包的文件，解压到该文件夹里面。

> ElasticSearch的启动

打开ElasticSearch安装路径下的bin目录，找到elasticsearch.bat文件，双击运行。
启动后，打开浏览器，在地址栏输入http://localhost:9200 如果看到页面上输出ElasticSearch的有关信息，则表示ElasticSearch已经正常运行。
