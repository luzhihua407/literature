<!DOCTYPE html>
<html lang="zh">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" charset="UTF-8"/>
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
    <style type="text/css">
        body, html,#allmap {width: 100%;height: 100%;overflow: hidden;margin:0;}
    </style>
    <script type="text/javascript" src="//api.map.baidu.com/api?type=webgl&v=1.0&ak=8WE1dmPP3lX2DfXixH0duQOTFBaGvDaA"></script>
    <title>设置地图3D视角</title>
</head>
<body>
<div id="allmap"></div>
</body>
</html>
<script type="text/javascript">
    // GL版命名空间为BMapGL
    // 按住鼠标右键，修改倾斜角和角度
    var map = new BMapGL.Map("allmap");    // 创建Map实例
    map.centerAndZoom(new BMapGL.Point(113.25816549,22.72811473), 6);  // 初始化地图,设置中心点坐标和地图级别
    map.enableScrollWheelZoom(true);     //开启鼠标滚轮缩放
    map.setHeading(64.5);
    map.setTilt(73);
    // 创建信息窗口

    // 格式 "lng,lat lng,lat..."
    var points="${points}";
    var arr=points.split(" ");
    for(var i=0;i < arr.length;i++){
        var opts = {
            width: 200,
            height: 100,
            title: '故宫博物院'
        };
        var infoWindow = new BMapGL.InfoWindow('地址：北京市东城区王府井大街88号乐天银泰百货八层', opts);
        var point=arr[i];
        var loc=point.split(",");
        var p=new BMapGL.Point(loc[0],loc[1]);
        var marker = new BMapGL.Marker(p);
        // 点标记添加点击事件
        marker.addEventListener('click', function () {
            map.openInfoWindow(infoWindow, p); // 开启信息窗口
        });
        map.addOverlay(marker); // 增加点
    }

</script>
