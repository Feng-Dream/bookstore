package com.zking.bookstore.controller;

import com.zking.bookstore.model.Dict;
import com.zking.bookstore.model.User;
import com.zking.bookstore.service.IDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 购物车控制器
 *
 * @Author Zeng LongFeng
 * @CreateTime 2017-12-28 15:24
 * @Version 1.0
 */
@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private IDictService dictService;

    /**
     * 初始化操作
     *
     * @param model Model
     */
    public void init(Model model) {
        List<Dict> bookTypeList = dictService.selectAllByDictName("图书类别");// 查询所有的图书类别
        List<Dict> deliveryList = dictService.selectAllByDictName("发货方式");// 查询所有的图书类别
        model.addAttribute("bookTypeList", bookTypeList);// 存到model中
        model.addAttribute("deliveryList", deliveryList);// 存到model中
    }

    /**
     * 我的购物车
     *
     * @param model
     * @param session
     * @return
     */
    @RequestMapping("/toAddOrder")
    public String toAddOrder(Model model, HttpSession session) {
        init(model);

        return "show/addOrder";
    }

    /**
     * 从会话中获得当前登录的用户
     *
     * @param session 会话
     * @return 当前登录的用户
     */
    private User getCurrentUser(HttpSession session) {
        return (User) session.getAttribute("currentUser");
    }

}
