<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--nav-->
<div class="side left">
    <h4>书籍管理</h4>
    <ul class="classify E6">
        <li>&nbsp;&nbsp;<a href="book/toAddBook">新&nbsp;增</a></li>
        <li>&nbsp;&nbsp;<a href="book/selectAllBookByStatus/1">未上架</a></li>
        <li>&nbsp;&nbsp;<a href="book/selectAllBookByStatus/2">已上架</a></li>
        <li>&nbsp;&nbsp;<a href="book/selectAllBookByStatus/3">已下架</a></li>
        <div class="fixed"></div>
    </ul>
    <h4>订单管理</h4>
    <ul class="classify E6">
        <li>&nbsp;&nbsp;<a href="order/selectAllOrderByStatus/1">未发货</a></li>
        <li>&nbsp;&nbsp;<a href="order/selectAllOrderByStatus/2">已发货</a></li>
        <li>&nbsp;&nbsp;<a href="order/selectAllOrderByStatus/3">已签收</a></li>
        <div class="fixed"></div>
    </ul>
</div>
<!--end nav-->
