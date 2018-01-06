package com.zking.bookstore.model;

import java.util.Date;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Book {
	private Long bookId;

	@Pattern(regexp = "^[0-9A-Za-z\\u4e00-\\u9fa5]{1,20}$", message = "书名必须是1-20位中文、英文或数字")
	private String bookName;

	@NotNull(message = "类别不能为空")
	private Long bookType;

	@Pattern(regexp = "^[A-Za-z\\u4e00-\\u9fa5]{2,30}$", message = "作者必须是2-30位中文或英文")
	private String bookAuthor;

	// @Pattern(regexp = "^[1-9]+(\\.[0-9]+)?$", message = "价格必须填写数字或者小数")
	// @Size(min = 0, max = 10000, message = "价格必须填写1-10000之间的数字或者小数")
	@DecimalMin(value = "0.01", message = "价格必须填写1-10000之间的数字或者小数")
	@DecimalMax(value = "10000.00", message = "价格必须填写1-10000之间的数字或者小数")
	private Float bookPrice;

	@Pattern(regexp = "^[A-Za-z\\u4e00-\\u9fa5]{5,20}$", message = "出版社必须是5-20位中文或英文")
	private String bookPress;

	private Long status;

	private Long salesVolume;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date created;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date updated;

	@NotBlank(message = "简介不能为空")
	private String bookRemark;

	private Doc doc;

	public Book(Long bookId, String bookName, Long bookType, String bookAuthor, Float bookPrice, String bookPress,
			Long status, Long salesVolume, Date created, Date updated, String bookRemark) {
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookType = bookType;
		this.bookAuthor = bookAuthor;
		this.bookPrice = bookPrice;
		this.bookPress = bookPress;
		this.status = status;
		this.salesVolume = salesVolume;
		this.created = created;
		this.updated = updated;
		this.bookRemark = bookRemark;
	}

	public Book() {
		super();
	}

	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public Long getBookType() {
		return bookType;
	}

	public void setBookType(Long bookType) {
		this.bookType = bookType;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public Float getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(Float bookPrice) {
		this.bookPrice = bookPrice;
	}

	public String getBookPress() {
		return bookPress;
	}

	public void setBookPress(String bookPress) {
		this.bookPress = bookPress;
	}

	public Long getStatus() {
		return status;
	}

	public void setStatus(Long status) {
		this.status = status;
	}

	public Long getSalesVolume() {
		return salesVolume;
	}

	public void setSalesVolume(Long salesVolume) {
		this.salesVolume = salesVolume;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	public String getBookRemark() {
		return bookRemark;
	}

	public void setBookRemark(String bookRemark) {
		this.bookRemark = bookRemark;
	}

	public Doc getDoc() {
		return doc;
	}

	public void setDoc(Doc doc) {
		this.doc = doc;
	}
}