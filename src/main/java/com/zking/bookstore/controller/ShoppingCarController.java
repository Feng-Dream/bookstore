package com.zking.bookstore.controller;

import com.zking.bookstore.model.ShoppingCar;
import com.zking.bookstore.model.User;
import com.zking.bookstore.service.IShoppingCarService;
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
@RequestMapping("/shoppingCar")
public class ShoppingCarController {

    @Autowired
    private IShoppingCarService shoppingCarService;

    public void init() {

    }

    @RequestMapping("myShoppingcar")
    public String myShoppingcar(Model model, HttpSession session) {
        //根据用户编号查询购物车
        List<ShoppingCar> shoppingCarList = shoppingCarService.selectAll(getCurrentUser(session).getUserId());
        //存到 Model.
        model.addAttribute("shoppingCarList", shoppingCarList);

        return "show/shoppingCar";
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
