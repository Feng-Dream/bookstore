<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/page/base/first.jsp" %>
</head>
<body>

<%@ include file="../base/head.jsp" %>
<!--nav-->
<div id="nav">
    <ul id="menu"></ul>
</div>
<!--end nav-->

<!--content-->
<div class="w960 mt10">
    <div class="breadcrumb"></div>
</div>

<div class="w960">

    <%@ include file="/WEB-INF/page/base/manager.jsp" %>
    <div class="w740 right">
        <div class="o-mt">
            <c:choose>
                <c:when test="${status == 1 }">
                    <h2>未发货订单</h2>
                </c:when>
                <c:when test="${status == 2 }">
                    <h2>已发货订单</h2>
                </c:when>
                <c:when test="${status == 3 }">
                    <h2>已签收订单</h2>
                </c:when>
            </c:choose>
        </div>
        <div class="order01">
            <form name="" method="post" action="">
                <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
                    <tr>
                        <td width="15%" align="right">收货人电话：</td>
                        <td width="15%">
                            <input type="text" name="" value="" class="w110 input">
                        </td>
                        <td width="15%" align="right"></td>
                        <td width="15%">
                            <input type="image" name="imageField2" src="resources/images/btn_cx.png"/>
                        </td>
                        <td width="15%" align="right"></td>
                        <td width="25%"></td>
                    </tr>
                </table>
            </form>
        </div>

        <div class="order02">
            <table width="100%" border="0" cellspacing="0" cellpadding="0">
                <tr>
                    <c:choose>
                        <c:when test="${status == 1 }">
                            <th width="10%" class="bd2">下单日期</th>
                        </c:when>
                        <c:when test="${status == 2 }">
                            <th width="10%" class="bd2">发货日期</th>
                        </c:when>
                        <c:when test="${status == 3 }">
                            <th width="10%" class="bd2">签收日期</th>
                        </c:when>
                    </c:choose>
                    <th width="15%" class="bd2">收货人</th>
                    <th width="15%" class="bd2">收货人电话</th>
                    <th width="15%" class="bd2">收货人邮编</th>
                    <th width="15%" class="bd2">收货人地址</th>
                    <th width="10%" class="bd2">发货方式</th>
                    <th width="10%" class="bd2">订单总价</th>
                    <th width="10%" class="bd2">操作</th>
                </tr>

                <c:forEach items="${orderList}" var="order">
                    <tr>
                        <c:choose>
                            <c:when test="${status == 1 }">
                                <td width="10%" class="text">
                                    <fmt:formatDate value="${order.createTime}" pattern="yyyy-MM-dd"/>
                                </td>
                            </c:when>
                            <c:when test="${status == 2 }">
                                <td width="10%" class="text">
                                    <fmt:formatDate value="${order.consignTime}" pattern="yyyy-MM-dd"/>
                                </td>
                            </c:when>
                            <c:when test="${status == 3 }">
                                <td width="10%" class="text">
                                    <fmt:formatDate value="${order.signTime}" pattern="yyyy-MM-dd"/>
                                </td>
                            </c:when>
                        </c:choose>
                        <td width="15%" class="text">${order.orderShipping.receiverName}</td>
                        <td width="15%" class="text">${order.orderShipping.receiverPhone}</td>
                        <td width="15%" class="text">${order.orderShipping.receiverZip}</td>
                        <td width="15%" class="text">${order.orderShipping.receiverAddress}</td>
                        <td width="10%" class="text">${order.orderShipping.delivery}</td>
                        <td width="10%" class="text">￥${order.totalPrice}</td>
                        <td width="10%" class="text">
                            <c:if test="${status == 1 }"><a href="order/ship/${order.orderId}">发货</a></c:if>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>

        <!-- page -->
        <div style="text-align: right;">
            <v:page pageBean="${pageBean}"/>
        </div>
        <!-- end page -->
    </div>
    <div class="fixed"></div>
</div>
<!--end content-->

<%@ include file="/WEB-INF/page/base/foot.jsp" %>

</body>
</html>
