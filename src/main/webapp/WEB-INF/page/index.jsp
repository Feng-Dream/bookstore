<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="base/first.jsp" %>

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

<%@ include file="base/head.jsp" %>

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

        <c:if test="${null == bookTypeList }">
            <jsp:forward page="/book/toIndex"></jsp:forward>
        </c:if>
        <ul class="classify bgf7e4e4 bdf7e4e4">

            <c:forEach items="${bookTypeList }" var="bookType">
                <li><a href="book/selectAllByBookType/${bookType.value }">${bookType.text }</a></li>
            </c:forEach>
            <div class="fixed"></div>
        </ul>

    </div>
    <div class="w740 right">
        <div class="main_div">
            <div class="banner left"><img src="resources/images/banner.png"/></div>
            <div class="fixed"></div>
        </div>

        <div class="main_div mt10">
            <h2>
                <cite class="left">新书上架</cite>
                <div class="fixed"></div>
            </h2>

            <ul class="arivals">

                <c:forEach items="${top5NewBookList}" var="top5NewBook">
                    <li>
                        <a href="#"><img class="docPic" src="${top5NewBook.doc.docpath}"/></a>
                        <p>${top5NewBook.bookName}</p>
                        <p class="red">￥${top5NewBook.bookPrice}</p>
                    </li>
                </c:forEach>

                <div class="fixed"></div>
            </ul>
        </div>

        <div class="main_div mt10">
            <h2>
                <cite class="left">热销图书</cite>
                <div class="fixed"></div>
            </h2>

            <ul class="arivals">

                <c:forEach items="${top5SalesVolumeList}" var="top5SalesVolume">
                    <li>
                        <a href="#"><img class="docPic" src="${top5SalesVolume.doc.docpath}"/></a>
                        <p>${top5SalesVolume.bookName}</p>
                        <p class="red">￥${top5SalesVolume.bookPrice}</p>
                    </li>
                </c:forEach>

                <div class="fixed"></div>
            </ul>
        </div>
    </div>
    <div class="fixed"></div>
</div>
<!--end con-->

<%@ include file="base/foot.jsp" %>

</body>
</html>
