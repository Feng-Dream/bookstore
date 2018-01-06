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

    <!--con-->
    <div class="w960 mt10">
        <%@ include file="../base/left.jsp" %>

        <div class="w740 right">
            <div class="order02">
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                        <th width="20%" class="bd2">书名</th>
                        <th width="20%" class="bd2">单价</th>
                        <th width="20%" class="bd2">数量</th>
                        <th width="20%" class="bd2">小计</th>
                        <th width="20%" class="bd2">操作</th>
                    </tr>


                    <c:forEach items="${shoppingCarList}" var="shoppingCar">
                    <tr>
                        <td width="20%" class="text">${shoppingCar.bookName}</td>
                        <td width="20%" class="text">${shoppingCar.bookPrice}</td>
                        <td width="20%" class="text">
                            <input class="input" style="width: 50px;text-align: center;" type="text" id="bookNum" value="${shoppingCar.bookNum}">
                        </td>
                        <td width="20%" class="text">${shoppingCar.bookPrice * shoppingCar.bookNum}</td>
                        <td width="20%" class="text">
                            <a href="#">删除</a>
                            <a href="#">更新</a>
                        </td>
                    </tr>
                    </c:forEach>

                    <tr>
                        <td width="20%" class="text">第一商会</td>
                        <td width="20%" class="text">24.80</td>
                        <td width="20%" class="text">
                            <input class="input" style="width: 50px;text-align: center;" type="text" id="" value="1">
                        </td>
                        <td width="20%" class="text">24.80</td>
                        <td width="20%" class="text">
                            <a href="#">删除</a>
                            <a href="#">更新</a>
                        </td>
                    </tr>


                </table>

                <table width="100%" border="0" cellspacing="0" cellpadding="0"  class="bd2">
                    <tr bgcolor="#fefcea">
                        <td width="80%" align="right"><strong>订单总价：</strong></td>
                        <td width="20%" align="left"><strong><span class="STYLE1">53.30</span></strong></td>
                    </tr>
                </table>
                <table width="738" border="0" cellspacing="0" cellpadding="0" class="mt10">
                    <tr>
                        <td width="5%" align="center" ></td>
                        <td width="30%" align="center" >
                            <a href="shoppingCar/emptiedShoppingcar"><img src="resources/images/btn_shoppingcart.png"/></a>
                        </td>
                        <td width="30%" align="center" >
                            <a href="book/toIndex"><img src="resources/images/btn_jxgm.png"/></a>
                        </td>
                        <td width="30%" align="center" >
                            <a href="order/toAddOrder"><img src="resources/images/btn_accounts.png"/></a>
                        </td>
                        <td width="5%"></td>
                    </tr>
                </table>

            </div>
        </div>
        <div class="fixed"></div>
    </div>
    <!--end con-->

    <%@ include file="../base/foot.jsp" %>

</body>
</html>
