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
        <div class="o-mt">
            <h2>订单新增</h2>
        </div>
        <div class="order02 pb10">
            <f:form action="order/addOrder" method="post" modelAttribute="orderShipping">
                <table width="738" align="center" cellpadding="0" cellspacing="0">
                    <tr class="bd2">
                        <th width="20%" align="center" class="bd2">收货人</th>
                        <td width="80%" align="left" class="bd1 pl9">
                            <input type="hidden" name="bookId" value="${bookId}" id="bookId">
                            <input type="text" minlength="2" maxlength="15" name="receiverName" value="${orderShipping.receiverName}"
                                   id="receiverName" class="input w300" required autofocus><span
                                class="required">*</span>
                            &nbsp;<font style="color: red;"><f:errors path="receiverName"></f:errors></font>
                        </td>
                    </tr>
                    <tr class="bd2">
                        <th width="20%" align="center" class="bd2">收货人电话</th>
                        <td width="80%" align="left" class="bd1 pl9">
                            <input type="tel" pattern="^1[3,4,5,7,8][0-9]{9}$" title="请填写正确的手机号" name="receiverPhone" value="${orderShipping.receiverPhone}"
                                   id="receiverPhone" class="input w300" required><span class="required">*</span>
                            &nbsp;<font style="color: red;"><f:errors path="receiverPhone"></f:errors></font>
                        </td>
                    </tr>
                    <tr class="bd2">
                        <td width="20%" align="center" class="bd2">收货人邮编
                        </td>
                        <td width="80%" align="left" class="bd1 pl9">
                            <input type="text" pattern="^[0-9]{6}$" title="请填写正确的邮编" name="receiverZip" value="${orderShipping.receiverZip}" id="receiverZip"
                                   class="input w300" required><span class="required">*</span>
                            &nbsp;<font style="color: red;"><f:errors path="receiverZip"></f:errors></font>
                        </td>
                    </tr>
                    <tr class="bd2">
                        <th width="20%" align="center" class="bd2">收货人地址
                        </th>
                        <td width="80%" align="left" class="bd1 pl9">
                            <input type="text" name="receiverAddress" value="${orderShipping.receiverAddress}"
                                   id="receiverAddress" class="input w300" required><span class="required">*</span>
                            &nbsp;<font style="color: red;"><f:errors path="receiverAddress"></f:errors></font>
                        </td>
                    </tr>

                    <tr class="bd2">
                        <th width="20%" align="center" class="bd2">发货方式
                        </th>
                        <td width="80%" align="left" class="bd1 pl9">
                            <select name="delivery" id="delivery" style="width:305px;" required>
                                <option value="">--请选择--</option>
                                <c:forEach items="${deliveryList}" var="delivery">
                                    <option value="${delivery.value}"
                                            <c:if test="${orderShipping.delivery == delivery.value}">selected</c:if>>${delivery.text}</option>
                                </c:forEach>
                            </select><span class="required">*</span>
                        </td>
                    </tr>
                </table>

                <table width="738" border="0" cellspacing="0" cellpadding="0" class="mt10" align="center">
                    <tr>
                        <td width="20%" align="center" class="bd2"></td>
                        <td width="80%" align="left" class="pl9">
                            <input type="submit" value="确定" class="btn"/>
                        </td>
                    </tr>
                </table>
            </f:form>
        </div>
    </div>
    <div class="fixed"></div>
</div>
<!--end con-->

<%@ include file="../base/foot.jsp" %>

</body>
</html>
