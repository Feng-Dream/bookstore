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

    <!--content-->
    <div class="w960 mt10">
        <div class="breadcrumb"></div>
    </div>

    <div class="w960">

        <%@ include file="/WEB-INF/page/base/manager.jsp" %>

        <div class="w740 right">
	        <c:choose>
	        	<c:when test="${status == 1 }">
	        		<div class="o-mt">
		                <h2>未上架书籍</h2>
		            </div>
	        	</c:when>
	        	<c:when test="${status == 2 }">
	        		<div class="o-mt">
		                <h2>已上架书籍</h2>
		            </div>
	        	</c:when>
	        	<c:when test="${status == 3 }">
	        		<div class="o-mt">
		                <h2>已下架书籍</h2>
		            </div>
	        	</c:when>
	        </c:choose>
           
            <div class="order01">
                <form name="" method="post" action="book/selectAllBookByStatus/${status }">
                    <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" >
                        <tr>
                            <td width="15%" align="right">书名：</td>
                            <td width="15%">
                                <input type="text" name="bookName" value="${book.bookName }" class="w110 input">
                            </td>
                            <td width="15%" align="right"></td>
                            <td width="15%">
                                <input type="image" name="imageField2" src="resources/images/btn_cx.png" />
                            </td>
                            <td width="15%" align="right"></td>
                            <td width="25%"></td>
                        </tr>
                    </table>
                </form>
            </div>

            <div class="order02">
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                        <th width="15%" class="bd2">书名</th>
                        <th width="15%" class="bd2">作者</th>
                        <th width="15%" class="bd2">价格</th>
                        <th width="25%" class="bd2">出版社</th>
                        
                        <c:choose>
				        	<c:when test="${status == 1 || status == 2  }">
				        		<th width="30%" class="bd2">操作</th>
				        	</c:when>
				        	<c:when test="${status == 3 }">
				        		<th width="30%" class="bd2">销量</th>
				        	</c:when>
				        </c:choose>
                    </tr>
                    
                    <c:forEach items="${bookList }" var="book">
                    <tr>
                        <td width="15%" class="text">${book.bookName }</td>
                        <td width="15%" class="text">${book.bookAuthor }</td>
                        <td width="15%" class="text">
                            ${book.bookPrice }
                        </td>
                        <td width="25%" class="text">${book.bookPress }</td>
                        <td width="30%" class="text">
                            <c:choose>
					        	<c:when test="${status == 1 }">
					        		<a href="book/toUploadBookImage/${book.bookId }">图片上传</a>
		                            <a href="book/toEditBook/${book.bookId }">修改</a>
		                            <a onclick="javascript:if(confirm('确定要删除此条记录吗？'))location.href = 'book/deleteBook/${book.bookId }';">删除</a>
					        		<a href="book/putaway/${book.bookId }">上架</a>
					        	</c:when>
					        	<c:when test="${status == 2 }">
					        		<a href="book/soldOut/${book.bookId }">下架</a>
					        	</c:when>
					        	<c:when test="${status == 3 }">
					        		${book.salesVolume }
					        	</c:when>
					        </c:choose>
                        </td>
                    </tr>
                    </c:forEach>

                </table>
            </div>

            <!-- page -->
            <div style="text-align: right;">
            	<v:page pageBean="${pageBean }"/>
            </div>
            <!-- end page -->
        </div>
        <div class="fixed"></div>
    </div>
    <!--end content-->

    <%@ include file="/WEB-INF/page/base/foot.jsp" %>

</body>
</html>
