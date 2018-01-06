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
        <div class="side left">


            <h3>图书分类</h3>

            <ul class="classify bgf7e4e4 bdf7e4e4">

                <li> <a href="#">文艺</a></li>

                <li> <a href="#">小说</a></li>

                <li> <a href="#">青春</a></li>

                <li> <a href="#">童书</a></li>

                <li> <a href="#">励志/成功</a></li>

                <li> <a href="#">生活</a></li>

                <li> <a href="#">人文社科</a></li>

                <li> <a href="#">经管</a></li>

                <li> <a href="#">科技</a></li>

                <li> <a href="#">教育</a></li>

                <li> <a href="#">工具书</a></li>

                <li> <a href="#">期刊</a></li>

                <div class="fixed"></div>
            </ul>

        </div>
        <div class="w740 right">
            <div class="o-mt">
                <h2>订单新增</h2>
            </div>
            <div class="order02 pb10">
                <form >
                    <table width="738" align="center" cellpadding="0" cellspacing="0">
                        <tr class="bd2">
                            <th width="20%" align="center" class="bd2">收货人</td>
                            <td width="80%"  align="left" class="bd1 pl9" >
                                <input type="text" name="" value="" id="" class="input w300"><span class="required">*</span>
                            </td>
                        </tr>
                        <tr class="bd2">
                            <th width="20%" align="center" class="bd2">收货人电话</td>
                            <td width="80%"  align="left" class="bd1 pl9" >
                                <input type="text" name="" value="" id="" class="input w300"><span class="required">*</span>
                            </td>
                        </tr>
                        <tr class="bd2">
                            <th width="20%" align="center" class="bd2">收货人邮编</td>
                            <td width="80%"  align="left" class="bd1 pl9" >
                                <input type="text" name="" value="" id="" class="input w300"><span class="required">*</span>
                            </td>
                        </tr>
                        <tr class="bd2">
                            <th width="20%" align="center" class="bd2">收货人地址</td>
                            <td width="80%"  align="left" class="bd1 pl9" >
                                <input type="text" name="" value="" id="" class="input w300"><span class="required">*</span>
                            </td>
                        </tr>

                        <tr class="bd2">
                            <th width="20%" align="center" class="bd2">发货方式</td>
                            <td width="80%"  align="left" class="bd1 pl9">
                                <select name="" id="" style="width:305px;"><option value="">--请选择--</option>
                                    <option value="1">平邮</option>
                                    <option value="2">快递</option></select><span class="required">*</span>
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
    <!--end con-->

    <%@ include file="../base/foot.jsp" %>

</body>
</html>
