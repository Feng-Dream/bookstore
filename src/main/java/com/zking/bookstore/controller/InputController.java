package com.zking.bookstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 页面跳转控制器
 *
 * @Author Zeng LongFeng
 * @CreateTime 2017-12-28 15:24
 * @Version 1.0
 */
@Controller
@RequestMapping("/input")
public class InputController {

	@RequestMapping("/{dir}/{page}")
	public String toDirOfPage(Model model, @PathVariable String dir, @PathVariable String page) {
		System.out.println("toDirOfPage");
		return dir + "/" + page;
	}

	@RequestMapping("/{page}")
	public String toPage(Model model, @PathVariable String page) {
		System.out.println("toPage");
		return page;
	}
}
