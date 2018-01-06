package com.zking.bookstore.controller;

import com.zking.bookstore.exception.CustomException;
import com.zking.bookstore.model.User;
import com.zking.bookstore.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

/**
 * @Description 用户控制器
 * @Author LongFeng Zeng
 * @CreateTime 2018-01-04 12:01
 * @Version 1.0
 */
@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private IUserService userService;

	public void init(Model model, User user) {
		model.addAttribute("user", user);
	}

	/**
	 * 据用户帐号查询此用户是否存在
	 *
	 * @param response
	 *            响应
	 * @param username
	 *            用户帐号
	 */
	@RequestMapping(value = "selectIsUser", method = { RequestMethod.POST })
	public void selectIsUser(HttpServletResponse response, String username) throws CustomException {

		Boolean isUser = userService.selectIsUserByUsername(username);
		try {
			PrintWriter printWriter = response.getWriter();
			printWriter.print(isUser);
		} catch (Exception e) {
			throw new CustomException("服务器繁忙", e);
		}
	}

	/**
	 * 注册
	 *
	 * @param user
	 *            用户注册相关信息
	 * @return 跳转页面
	 * @throws CustomException
	 */
	@RequestMapping(value = "doRegister", method = { RequestMethod.POST })
	public String doRegister(Model model,@ModelAttribute @Validated User user, BindingResult bindingResult) throws CustomException {
		try {
			if (bindingResult.hasErrors()) {
				return "register";
			}
			if (userService.selectIsUserByUsername(user.getUsername())) {
				bindingResult.rejectValue("username", "IsUserError", "此帐号已被占用");
				return "register";
			}

			userService.doRegister(user);// 注册
			return "redirect:/input/login";
		} catch (Exception e) {
			bindingResult.rejectValue("message", "RegisterError", "注册失败");
			return "register";
		}
	}

	/**
	 * 登录
	 *
	 * @param session
	 *            会话
	 * @param user
	 *            用户登录相关信息
	 * @return 跳转页面
	 * @throws CustomException
	 */
	@RequestMapping(value = "doLogin", method = { RequestMethod.POST })
	public String doLogin(Model model, HttpSession session, @Validated @ModelAttribute User user,
			BindingResult bindingResult) throws CustomException {
		if (bindingResult.hasErrors()) {
			return "login";
		}
		try {
			User u = userService.doLogin(user);
			session.setAttribute("currentUser", u);

			if(u.getAdmin()){
				return "redirect:/input/manager/console";
			}

			return "redirect:/input/index";
		} catch (Exception e) {
			bindingResult.rejectValue("message", "UsernameOrPasswordError", "用户名或密码错误");
			return "login";
		}
	}

	/**
	 * 注销登录
	 *
	 * @param session
	 *            会话
	 * @return 跳转页面
	 * @throws CustomException
	 */
	@RequestMapping(value = "doLogout")
	public String doLogout(HttpSession session) throws CustomException {
		session.invalidate();
		return "redirect:/input/index";
	}
}
