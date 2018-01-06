package com.zking.bookstore.utils;

import java.io.IOException;
import java.util.Properties;

/**
 * MIME意为多目Internet邮件扩展，它设计的最初目的是为了在发送电子邮件时附加多媒体数据，
 * 让邮件客户程序能根据其类型进行处理。每个MIME类型由两部分组成，前面是数据的大类别，后面为具体的种类。
 * 例如：image/bmp、image/jpeg、audio/mpeg 用于获得MIME类型的工具类
 * 
 * 一个用于获取各种后缀名所对应MIME类型的工具类
 * 
 */
public class MimeUtils {

	private final static Properties pros;

	static {
		try {
			pros = new Properties();
			pros.load(MimeUtils.class.getResourceAsStream("mime.properties"));
		} catch (IOException ex) {
			throw new RuntimeException(ex);
		}
	}

	private MimeUtils() {
	}

	/**
	 * 根据文件名获得MIME类型。
	 * 
	 */
	public static String getMime(String fileName) {
		if (-1 == fileName.trim().lastIndexOf(".")
				|| fileName.trim().lastIndexOf(".") == fileName.trim().length() - 1) {
			return pros.getProperty("*");
		} else {
			String mime = pros.getProperty(fileName.substring(
					fileName.lastIndexOf(".") + 1).toLowerCase());
			return mime == null ? pros.getProperty("*") : mime;
		}

	}

	public static void main(String[] args) {
		String fileName = "数据库设计.zip";
		System.out.println(getMime(fileName));
	}
}
