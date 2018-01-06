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

<!--end top-->

<!--content-->
<div class="w960 mt10">
    <div class="breadcrumb"></div>
</div>

<div class="w960">

    <%@ include file="/WEB-INF/page/base/manager.jsp" %>

    <div class="w740 right">
        <div class="o-mt">
            <h2>书籍新增</h2>
        </div>
        <div class="order02 pb10">
            <f:form action="book/addBook" name="bookForm" method="post" modelAttribute="book">
                <table width="738" align="center" cellpadding="0" cellspacing="0">
                    <tr class="bd2">
                        <th width="20%" align="center" class="bd2">书名
                        </td>
                        <td width="80%" align="left" class="bd1 pl9">
                            <input type="text" pattern="^[0-9A-Za-z\u4e00-\u9fa5]{1,20}$" title="书名必须是1-20位中文、英文或数字" name="bookName" value="${book.bookName }" id="bookName" class="input w300" required="required" autofocus="autofocus"><span class="required">*</span>&nbsp; <font style="color: red;"><f:errors path="bookName"></f:errors></font>
                        </td>
                    </tr>
                    <tr class="bd2">
                        <th width="20%" align="center" class="bd2">类别
                        </td>
                        <td width="80%" align="left" class="bd1 pl9">

                            <select name="bookType" id="bookType" style="width:305px;" required>
                                <option value="">--请选择--</option>
                                <c:forEach items="${bookTypeList }" var="bookType">
                                	<option value="${bookType.value }" <c:if test="${book.bookType == bookType.value}">selected</c:if>>${bookType.text }</option>
                                </c:forEach>
                            </select><span class="required">*</span>&nbsp; <font style="color: red;"><f:errors path="bookType"></f:errors></font>
                        </td>
                    </tr>
                    <tr class="bd2">
                        <th width="20%" align="center" class="bd2">作者
                        </td>
                        <td width="80%" align="left" class="bd1 pl9">
                            <input type="text" pattern="^[A-Za-z\u4e00-\u9fa5]{2,30}$" title="作者必须是2-30位中文或英文" name="bookAuthor" value="${book.bookAuthor }" id="bookAuthor" class="input w300" required><span class="required">*</span>&nbsp; <font style="color: red;"><f:errors path="bookAuthor"></f:errors></font>
                        </td>
                    </tr>
                    <tr class="bd2">
                        <th width="20%" align="center" class="bd2">价格
                        </td>
                        <td width="80%" align="left" class="bd1 pl9">
                            <input type="number" step="0.01" max="10000.00" min="0.01" title="请填写0.01-10000.00之间的数字或者小数" name="bookPrice" value="${book.bookPrice }" id="bookPrice" class="input w300" required><span class="required">*</span>&nbsp; <font style="color: red;"><f:errors path="bookPrice"></f:errors></font>
                            <%-- <input type="text" pattern="^[1-9]+(\.[0-9]+)?$" title="价格必须填写数字或者小数" name="bookPrice" value="${book.bookPrice }" id="bookPrice" class="input w300" required><span class="required">*</span>&nbsp; <font style="color: red;"><f:errors path="bookPrice"></f:errors></font> --%>
                        </td>
                    </tr>
                    <tr class="bd2">
                        <th width="20%" align="center" class="bd2">出版社
                        </td>
                        <td width="80%" align="left" class="bd1 pl9">
                            <input type="text" pattern="^[A-Za-z\u4e00-\u9fa5]{5,20}$" title="出版社必须是5-20位中文或英文" name="bookPress" value="${book.bookPress }" id="bookPress" class="input w300" required><span class="required">*</span>&nbsp; <font style="color: red;"><f:errors path="bookPress"></f:errors></font>
                        </td>
                    </tr>
                    <tr class="bd2">
                        <th width="20%" align="center" class="bd2">简介
                        </td>
                        <td width="80%" align="left" class="bd1 pl9" rowspan="3">
                            <textarea name="bookRemark" rows="6" id="bookRemark" class="w300" required>${book.bookRemark }</textarea><span class="required">*</span>&nbsp; <font style="color: red;"><f:errors path="bookRemark"></f:errors></font>
                        </td>
                    </tr>
                    <tr class="">
                        <th width="20%" align="center" class="bd2">
                        </td>
                    </tr>
                    <tr class="">
                        <th width="20%" align="center" class="bd2">
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
<!--end content-->

<%@ include file="/WEB-INF/page/base/foot.jsp" %>

</body>
</html>
