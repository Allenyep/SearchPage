<%--
  Created by IntelliJ IDEA.
  User: allen
  Date: 2017/4/9
  Time: 22:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>chart</title>
    <script src="/assert/echarts.common.min.js"></script>
    <script src="assert/jquery.min.js"></script>
</head>
<body>
<div id="first" style="width: 800px;height:400px;"></div>
</body>
<script type="text/javascript">
    var myChart = echarts.init(document.getElementById('first'));

    myChart.setOption({
        title : {
            text: '',
            subtext: ''
        },
        tooltip : {
            trigger: 'axis'
        },
        legend: {
            data:['点击数']
        },
        toolbox: {
            show : true,
            feature : {
                mark : {show: true},
                dataView : {show: true, readOnly: false},
                magicType : {show: true, type: ['line', 'bar']},
                restore : {show: true},
                saveAsImage : {show: true}
            }
        },
        calculable : true,
        xAxis: {
            data: []
        },
        yAxis: {},
        series: [{
            name: '点击数',
            type: 'bar',
            data: []
        }]
    });
    myChart.showLoading();
    // 异步加载数据
    $.ajax({
        url:"/ChartServlet",
        type:"GET",
        dataType:"json",
        success:function (data) {
            myChart.hideLoading();
            var day=new Array();
            var daynums=new Array();
            for (var i=0;i<data.length;i++){
                day[i]=data[i].day;
                daynums[i]=data[i].daynums;
            }
            myChart.setOption({
                xAxis: {
                    data: day
                },
                series: [{
                    // 根据名字对应到相应的系列
                    name: '点击数',
                    data: daynums,
                    markPoint : {
                        data : [
                            {type : 'max', name: '最大值'},
                            {type : 'min', name: '最小值'}
                        ]
                    },
                    markLine : {
                        data : [
                            {type : 'average', name: '平均值'}
                        ]
                    }
                }]
            });
        }
    });
</script>
</html>
