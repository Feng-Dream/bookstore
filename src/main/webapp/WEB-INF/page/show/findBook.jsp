<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../base/first.jsp" %>

<script>
    $(function () {
        $(".docPic").each(function (i) {
            var src = this.src;
            var newSrc = src.replace("file:///D:/temp/upload", "/pic");
            this.src = newSrc;
        });
    });
</script>
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
			<c:forEach items="${bookTypeList }" var="bookType">
                <li> <a href="book/selectAllByBookType/${bookType.value }">${bookType.text }</a></li>
			</c:forEach>
                <div class="fixed"></div>
            </ul>

        </div>

        <div class="w740 right">
            <div class="order02 pb10">

                <c:forEach items="${bookList}" var="book">
                <dl class="findbook">
                    <dt class="left"><img class="docPic" src="${book.doc.docpath}" alt="${book.bookName}"  /></dt>
                    <dd class="right">
                        <h4>${book.bookName}</h4>
                        <p><strong>作者：</strong>${book.bookAuthor}</p>
                        <p><strong>价格：</strong>￥${book.bookPrice}</p>
                        <p><strong>出版社：</strong>${book.bookPress}</p>
                        <p><strong>书籍简介：</strong>${book.bookRemark}</p>
                        <p class="mt10"><a href="shoppingCar/addShoppingCar"><img src="resources/images/btn_shopping.png" /></a><a href="#"><img src="resources/images/btn_accounts.png" /></a> </p>
                    </dd>
                    <div class="fixed"></div>
                </dl>
                </c:forEach>

            </div>

            <!-- page -->
            <div style="text-align: right;">
                <v:page pageBean="${pageBean}"/>
            </div>
            <!-- end page -->

        </div>
        <div class="fixed"></div>
    </div>
    <!--end con-->
    <!--end con-->

    <%@ include file="../base/foot.jsp" %>

</body>
</html>
