<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="side left">


    <h3>图书分类</h3>

    <ul class="classify bgf7e4e4 bdf7e4e4">
        <c:forEach items="${bookTypeList }" var="bookType">
            <li> <a href="book/selectAllByBookType/${bookType.value }">${bookType.text }</a></li>
        </c:forEach>
        <div class="fixed"></div>
    </ul>

</div>