package com.zking.bookstore.model;

import java.util.Date;

public class Doc {
	private String docid;

	private String docname;

	private String doctype;

	private Long docbook;

	private Long docman;

	private Date docdate;

	private Boolean docisdel;

	private String docpath;
	
	public Doc(String docid, String docname, String doctype, Long docbook, Long docman, Date docdate, Boolean docisdel,
			String docpath) {
		this.docid = docid;
		this.docname = docname;
		this.doctype = doctype;
		this.docbook = docbook;
		this.docman = docman;
		this.docdate = docdate;
		this.docisdel = docisdel;
		this.docpath = docpath;
	}

	public Doc() {
		super();
	}

	public String getDocid() {
		return docid;
	}

	public void setDocid(String docid) {
		this.docid = docid;
	}

	public String getDocname() {
		return docname;
	}

	public void setDocname(String docname) {
		this.docname = docname;
	}

	public String getDoctype() {
		return doctype;
	}

	public void setDoctype(String doctype) {
		this.doctype = doctype;
	}

	public Long getDocbook() {
		return docbook;
	}

	public void setDocbook(Long docbook) {
		this.docbook = docbook;
	}

	public Long getDocman() {
		return docman;
	}

	public void setDocman(Long docman) {
		this.docman = docman;
	}

	public Date getDocdate() {
		return docdate;
	}

	public void setDocdate(Date docdate) {
		this.docdate = docdate;
	}

	public Boolean getDocisdel() {
		return docisdel;
	}

	public void setDocisdel(Boolean docisdel) {
		this.docisdel = docisdel;
	}

	public String getDocpath() {
		return docpath;
	}

	public void setDocpath(String docpath) {
		this.docpath = docpath;
	}
}