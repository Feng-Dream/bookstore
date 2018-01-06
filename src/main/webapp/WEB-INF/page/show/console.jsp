<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../base/first.jsp" %>
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
        <div class="side left">

            <%@ include file="../base/myorder.jsp" %>
        </div>

        <div class="w740 right">
        <div align="center"><font color="#00bfff" size="5">当前时间：<%= new java.text.SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒").format(new java.util.Date())%></font></div>
        </div>
        <div class="fixed"></div>
    </div>
    <!--end content-->

    <%@ include file="../base/foot.jsp" %>

</body>
</html>
