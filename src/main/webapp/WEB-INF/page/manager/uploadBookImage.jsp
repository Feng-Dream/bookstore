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
                <h2>图片上传</h2>
            </div>
            <div class="order02 pb10">
                <form action="book/doUploadBookImage" method="post" enctype="multipart/form-data">
                    <table width="738" align="center" cellpadding="0" cellspacing="0">
                        <tr class="bd2">
                            <th width="20%" align="center" class="bd2">图片</td>
                            <td width="80%"  align="left" class="bd1 pl9" >
                                <input type="hidden" name="bookId" value="${bookId}">
                                <input type="file" id="bookPic" name="bookPic" class="input w300" required/><span class="required">*</span>
                            </td>
                        </tr>
                    </table>

                    <table width="738" border="0" cellspacing="0" cellpadding="0" class="mt10" align="center">
                        <tr>
                            <td width="20%" align="center" class="bd2"></td>
                            <td width="80%" align="left" class="pl9" >
                                <input type="submit" value="确定" class="btn"/>
                            </td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
        <div class="fixed"></div>
    </div>
    <!--end content-->

    <%@ include file="/WEB-INF/page/base/foot.jsp" %>

</body>
</html>
