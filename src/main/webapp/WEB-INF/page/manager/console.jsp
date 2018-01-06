<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../base/first.jsp" %>

<script type="text/javascript">

    window.onload=function(){
        var oDiv=document.getElementById('time');  //  获取DIV
        function theTime(){
            var theDate=new Date();   //  创建一个日期对象
            var year=theDate.getFullYear();;  // 获取年份
            var month=theDate.getMonth()+1;   //  获取月份
            var day=theDate.getDate();   //获取日
            var hour=theDate.getHours();   //获取小时
            var minues=theDate.getMinutes();  // 获取分钟
            var second=theDate.getSeconds();  //  获取秒
            oDiv.innerHTML="当前时间："+year+"年"+month+"月"+day+"日  "+hour+":"+minues+":"+second;
        }
        theTime();  //  执行时间函数
        setInterval(theTime,1000);  //  更新时间
    }

</script>
</head>
<body>

<%@ include file="../base/head.jsp" %>
    <!--nav-->
    <div id="nav">
        <ul id="menu"></ul>
    </div>
    <!--end nav-->

    <!--end top-->

    <!--content-->
    <div class="w960 mt10">
        <div class="breadcrumb"></div>
    </div>

    <div class="w960">
        
        <%@ include file="../base/manager.jsp" %>

        <div class="w740 right">
            <div align="center"><font color="#00bfff" size="5"><div id="time"></div></font></div>
        </div>
        <div class="fixed"></div>
    </div>
    <!--end content-->

    <%@ include file="../base/foot.jsp" %>

</body>
</html>
