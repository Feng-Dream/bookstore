package com.zking.bookstore.tag.ui;

import com.zking.bookstore.utils.PageBean;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;
import java.util.Map;

public class PageTag extends BodyTagSupport {

	private static final long serialVersionUID = -6650240612580556566L;

	private PageBean pageBean;

	public PageTag() {
		super();
	}

	public PageBean getPageBean() {
		return pageBean;
	}

	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}

	@Override
	public int doStartTag() throws JspException {
		try {
			if (null != pageBean) {
				JspWriter out = pageContext.getOut();
				out.write(getHtml());
			}
			return SKIP_BODY;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/** 生成分页相关的html */
	public String getHtml() {
		StringBuffer sb = new StringBuffer();

//		sb.append("<style>");
//		sb.append("#pageForm{margin:0px; padding:0px;}");
//		sb.append("body{margin:0 auto; color:#666; font-family:\"微软雅黑\", Simsun;}");
//		sb.append("li{list-style:none;}");
//		sb.append("img{border:none;}");
//		sb.append("a, a:visited{text-decoration:none;}");
//
//		sb.append(
//				".tong{ background:url(../images/images/sy-toubjing_03.gif) repeat-x 0px -11px; width:100%; height:40px;}");
//		sb.append(".wrap{ width:auto; max-width:320px; margin:0 auto;}");
//		sb.append(".center{ width:103%; margin:0 auto;}");
//
//		sb.append("/***************分页******************/");
//		sb.append(".fenye{ float:right; margin-top:10px;}");
//		sb.append(".fenye ul{ float:left; margin-left:32px; }");
//		sb.append(
//				".fenye ul li{ float:left; margin-left:5px;padding: 4px 6px; border:1px solid #ccc;  font-weight:bold; cursor:pointer; color:#999;}");
//		sb.append(".fenye ul li a{ color:#999;}");
//		sb.append(
//				".fenye ul li.xifenye{ width:45px; text-align:center; float:left; position:relative;cursor: pointer;}");
//		sb.append(
//				".fenye ul li .xab{ float:left; position:absolute; width:39px; border:1px solid #ccc; height:123px; overflow-y: auto;overflow-x: hidden;top:-125px; background-color: #fff; display:inline;left:-1px; width:50px;}");
//		sb.append(".fenye ul li .xab ul{ margin-left:0; padding-bottom:0;}");
//		sb.append(
//				".fenye ul li .xab ul li{ border:0; padding:4px 0px; color:#999; width:34px; margin-left:0px; text-align:center;}");
//
//		sb.append("</style>");

		// 1.生成表单数据
		sb.append("<form action='" + pageBean.getUrl() + "' method='post' id='pageForm'>");
		String[] values = null;// 参数值
		Map<String, String[]> m = pageBean.getParameterMap();
		for (String name : m.keySet()) {
			if ("curPage".equals(name)) {
				continue;// 忽略页码
			}
			values = m.get(name);
			for (String value : values) {
				sb.append("<input type='hidden' name='" + name + "' value='" + value + "'>");
			}
		}
		sb.append("<input type='hidden' name='curPage' value=''>");
		sb.append("</form>");

		// 2.生成按钮
		/*sb.append("<div style='text-align: right;display: inline-block;' class='fenye'>");
		sb.append("<ul>");

		sb.append("<li id='first' onclick='gotoPage(1);'>首页</li>");// 首页
		sb.append("<li id='top' onclick='gotoPage(" + pageBean.getPreviousPageNumber() + ")' >上一页</li>");// 上一页

		sb.append("<li class='xifenye' id='xifenye'>");
		sb.append("<a id='xiye'>" + pageBean.getCurPage() + "</a>/<a id='mo'>" + pageBean.getMaxPageNumber() + "</a>");// 当前页码/最大页码
		sb.append("<div class='xab' id='xab' style='display:none'>");
		sb.append("<ul id='uljia'>");
		sb.append("</ul>");
		sb.append("</div>");
		sb.append("</li>");

		sb.append("<li id='down' onclick='gotoPage(" + pageBean.getNextPageNumber() + ");' >下一页</a></li>");// 下一页
		sb.append("<li id='last' onclick='gotoPage(" + pageBean.getMaxPageNumber() + ");' >末页</li>");// 尾页

		sb.append("<li>跳转到&nbsp;&nbsp;");
		sb.append("<input id='skipcurPage' type='text' style='width:40px;text-align:center;' value=''>");
		sb.append("&nbsp;&nbsp;页</li>");
		sb.append("<li onclick='skipPage();'>确定</li>");

		sb.append("</ul>");
		sb.append("</div>");*/

		sb.append(" 每页 " + pageBean.getPageRecord() + " 行 共 " + pageBean.getTotalRecord() + " 行 第 "
				+ pageBean.getCurPage() + " 页 共 " + pageBean.getMaxPageNumber()
				+ " 页 <a href='javascript:gotoPage(1)'>首页</a> <a href='javascript:gotoPage("
				+ pageBean.getPreviousPageNumber() + ")'>上一页</a> <a href='javascript:gotoPage("
				+ pageBean.getNextPageNumber() + ")'>下一页</a> <a href='javascript:gotoPage("
				+ pageBean.getMaxPageNumber()
				+ ")'>尾页</a> 页数 <input id='skipcurPage' type='text' id='pageNumber'  style='width:20px;' /> <a href='javascript:skipPage();'>GO</a>");

		// 3.生成js代码
		sb.append("<script type='text/javascript'>");

		// 3.1 跳转页码
		sb.append("	function gotoPage(curPage) {");
		sb.append("		document.getElementById('pageForm').curPage.value = curPage;");
		sb.append("		document.getElementById('pageForm').submit();");
		sb.append("	}");

		// 3.2 跳转到指定页码处
		sb.append("	var min = 1;");// 最小页码数
		sb.append("	var max = " + pageBean.getMaxPageNumber() + ";");// 最大页码数
		sb.append("	function skipPage(curPage) {");
		sb.append("		var curPage = document.getElementById('skipcurPage').value;");
		sb.append("		if(!curPage || isNaN(curPage) || parseInt(curPage) < min || parseInt(curPage) > max){");
		sb.append("			alert('请输入一个'+ min +'-'+ max +'之间的数字！');");
		sb.append("			return;");
		sb.append("		}");
		sb.append("		gotoPage(curPage);");
		sb.append("	}");

		sb.append("</script>");

		pageContext.setAttribute("pageBean", pageBean);
		return sb.toString();
	}
}
