package com.zking.bookstore.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {

	private static final long serialVersionUID = 3533515100900765996L;

	private Long userId;

	@NotBlank(message = "帐号不能为空")
	@Pattern(regexp = "^[a-z][a-zA-Z0-9]{3,9}$", message = "请输入4-10位字母或数字的帐号")
	private String username;

	@NotBlank(message = "密码不能为空")
	@Size(min = 6, max = 16, message = "请输入6-16位的密码")
	private String password;

	private String salt;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date created;

	private String message;

	public User(Long userId, String username, String password, String salt, Date created) {
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.salt = salt;
		this.created = created;
	}

	public User() {
		super();
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}