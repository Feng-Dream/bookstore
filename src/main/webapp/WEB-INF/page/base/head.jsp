<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--top-->
<div id="top_div">
    <c:choose>
        <c:when test="${null != currentUser}">
            <p class="left">您好${currentUser.username}，欢迎来到飞凡网上书店 ！</p>
            <p class="right"><a href="input/manager/console">后台管理</a> | <a href="input/show/shoppingCar">我的购物车</a> | <a href="input/show/console">我的订单</a> | <a href="user/doLogout">退出系统</a> | <a href="input/index">网站首页</a></p>
        </c:when>
        <c:otherwise>
            <p class="left">您好，欢迎来到飞凡网上书店 ！</p>
            <p class="right"><a href="input/login">登陆</a> | <a href="input/register">注册</a> | <a href="input/index">网站首页</a></p>
        </c:otherwise>
    </c:choose>
    <div class="fixed"></div>
</div>

<div id="header_div">
    <div id="search">
        <!--下面form标签的id属性不能修改，因为在css中使用了一个id选择器-->
        <!--form的id与下面文本框的id不能修改，因为使用了id选择器定义样式-->
        <form name="bookForm" id="form" method="post" action="book/selectAll">
            <table width="413" border="0" cellspacing="0" cellpadding="0">
                <tr>
                    <td>
                        <input type="text" name="" value="" id="input">
                    </td>
                    <td>
                        <input align="center" type="image" name="imageField" src="resources/images/btn_search.png"/>
                    </td>
                </tr>
            </table>
        </form>
    </div>
</div>
