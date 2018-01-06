<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="base/first.jsp" %>
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
                <li> <a href="book/selectAllByBookType/${bookType.value }">${bookType.text }</a></li>
			</c:forEach>
                <div class="fixed"></div>
            </ul>

        </div>
        <div class="w740 right">
            <div class="main_div">
                <div class="banner left"><img src="resources/images/banner.png" /></div>
                <div class="fixed"></div>
            </div>

            <div class="main_div mt10">
                <h2>
                    <cite class="left">新书上架</cite>
                    <div class="fixed"></div>
                </h2>

                <ul class="arivals">

                    <li>
                        <a href="#"><img src="resources/imgs/9.png" /></a><p>爱的样子</p><p class="red">￥23.60</p>
                    </li>

                    <li>
                        <a href="#"><img src="resources/imgs/8.png" /></a><p>时光走了你还在</p><p class="red">￥18.50</p>
                    </li>

                    <li>
                        <a href="#"><img src="resources/imgs/7.png" /></a><p>AutoCAD入门到精通</p><p class="red">￥27.92</p>
                    </li>

                    <li>
                        <a href="#"><img src="resources/imgs/6.png" /></a><p>Java从入门到精通</p><p class="red">￥29.90</p>
                    </li>

                    <li>
                        <a href="#"><img src="resources/imgs/5.png" /></a><p>Python自动化运维</p><p class="red">￥58.60</p>
                    </li>

                    <div class="fixed"></div>
                </ul>
            </div>

            <div class="main_div mt10">
                <h2>
                    <cite class="left">热销图书</cite>
                    <div class="fixed"></div>
                </h2>

                <ul class="arivals">

                    <li>
                        <a href="#"><img src="resources/imgs/1.png" /></a><p>冷间谍</p><p class="red">￥28.50</p>
                    </li>

                    <li>
                        <a href="#"><img src="resources/imgs/2.png" /></a><p>第一商会</p><p class="red">￥24.80</p>
                    </li>

                    <li>
                        <a href="#"><img src="resources/imgs/3.png" /></a><p>狂人摄影日记</p><p class="red">￥115.30</p>
                    </li>

                    <li>
                        <a href="#"><img src="resources/imgs/4.png" /></a><p>伊文思与纪录电影</p><p class="red">￥39.60</p>
                    </li>

                    <li>
                        <a href="#"><img src="resources/imgs/5.png" /></a><p>Python自动化运维</p><p class="red">￥58.60</p>
                    </li>

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
