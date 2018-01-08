package com.zking.bookstore.controller;

import com.zking.bookstore.model.Dict;
import com.zking.bookstore.model.Order;
import com.zking.bookstore.model.OrderShipping;
import com.zking.bookstore.model.User;
import com.zking.bookstore.service.IDictService;
import com.zking.bookstore.service.IOrderService;
import com.zking.bookstore.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 订单控制器
 *
 * @Author Zeng LongFeng
 * @CreateTime 2017-12-28 15:24
 * @Version 1.0
 */
@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private IOrderService orderService;
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
     * 跳转到添加订单页面
     *
     * @param model   Model
     * @param session 会话
     * @return 逻辑视图名
     */
    @RequestMapping("/toAddOrder")
    public String toAddOrder(Model model, HttpSession session, OrderShipping orderShipping, String bookId) {
        init(model);

        model.addAttribute("orderShipping", orderShipping);
        model.addAttribute("bookId", bookId);

        //跳转到添加订单页面
        return "show/addOrder";
    }

    /**
     * 添加订单
     *
     * @param model         Model
     * @param session       会话
     * @param order         订单
     * @param orderShipping 订单发货
     * @param bookId        图书编号
     * @return 逻辑视图名
     */
    @RequestMapping("/addOrder")
    public String addOrder(Model model, HttpSession session, Long bookId, Order order, @ModelAttribute @Validated OrderShipping orderShipping, BindingResult bindingResult) {
        if (null == getCurrentUser(session)) {
            return "redirect:/input/login";
        }

        if (bindingResult.hasErrors()) {
            return "show/addOrder";
        }

        //设置用户编号
        order.setUserId(getCurrentUser(session).getUserId());
        //新增订单
        orderService.insert(order, orderShipping, bookId);

        //跳转到我的订单 (未发货状态)
        return "redirect:toMyOrder/1";
    }

    /**
     * 撤单
     *
     * @param session 会话
     * @param orderId 订单编号
     * @param order   订单
     * @return 逻辑视图名
     */
    @RequestMapping("/cancelOrder/{orderId:[0-9]+}")
    public String cancelOrder(HttpSession session, @ModelAttribute @PathVariable Long orderId, Order order) {
        if (null == getCurrentUser(session)) {
            return "redirect:/input/login";
        }

        //删除 (假删)
        order.setDel(true);

        orderService.doFalseDel(orderId, order);

        //跳转到我的订单 (未发货状态)
        return "redirect:/order/toMyOrder/1";
    }

    /**
     * 发货
     *
     * @param session 会话
     * @param orderId 订单编号
     * @param order   订单
     * @return 逻辑视图名
     */
    @RequestMapping("/ship/{orderId:[0-9]+}")
    public String ship(HttpSession session, @ModelAttribute @PathVariable Long orderId, Order order) {
        if (null == getCurrentUser(session)) {
            return "redirect:/input/login";
        }

        if (!getCurrentUser(session).getAdmin()) {
            return "redirect:/book/toIndex";
        }

        //设置为发货状态
        order.setStatus(2L);

        orderService.updateStatusByPrimaryKey(orderId, order);

        //跳转到订单页面 (已发货状态)
        return "redirect:/order/toListOrder/2";
    }

    /**
     * 签收
     *
     * @param session 会话
     * @param orderId 订单编号
     * @param order   订单
     * @return 逻辑视图名
     */
    @RequestMapping("/sign/{orderId:[0-9]+}")
    public String sign(HttpSession session, @ModelAttribute @PathVariable Long orderId, Order order) {
        if (null == getCurrentUser(session)) {
            return "redirect:/input/login";
        }

        //设置为签收状态
        order.setStatus(3L);

        orderService.updateStatusByPrimaryKey(orderId, order);

        //跳转到我的订单 (已签收状态)
        return "redirect:/order/toMyOrder/3";
    }


    /**
     * 跳转到我的订单
     *
     * @param model   Model
     * @param request 请求
     * @param session 会话
     * @param status  订单状态
     * @param order   订单
     * @return 逻辑视图名
     */
    @RequestMapping("/toMyOrder/{status:[0-9]+}")
    public String toMyOrder(Model model, HttpServletRequest request, HttpSession session, @ModelAttribute @PathVariable Long status, Order order) {
        if (null == getCurrentUser(session)) {
            return "redirect:/input/login";
        }

        //设置订单状态
        order.setStatus(status);
        //设置用户编号
        order.setUserId(getCurrentUser(session).getUserId());

        //查询全部订单并且存到Model中
        selectAll(model, order, request);

        //跳转到我的订单页面
        return "show/listMyOrder";
    }

    /**
     * 跳转到订单页面
     *
     * @param model   Model
     * @param request 请求
     * @param session 会话
     * @param status  订单状态
     * @param order   订单
     * @return 逻辑视图名
     */
    @RequestMapping("toListOrder/{status:[0-9]+}")
    public String toListOrder(Model model, HttpServletRequest request, HttpSession session, @ModelAttribute @PathVariable Long status, Order order) {
        if (null == getCurrentUser(session)) {
            return "redirect:/input/login";
        }
        if (!getCurrentUser(session).getAdmin()) {
            return "redirect:/book/toIndex";
        }

        //设置订单状态
        order.setStatus(status);

        //查询全部订单并且存到Model中
        selectAll(model, order, request);

        //跳转到我的订单页面
        return "manager/listOrder";
    }

    /**
     * 查询全部订单并且存到Model中
     *
     * @param model   Model
     * @param order   图书信息
     * @param request 请求
     */
    private void selectAll(Model model, Order order, HttpServletRequest request) {
        List<Order> orderList = orderService.selectAll(order, handlerPageBean(request));// 查询全部订单
        model.addAttribute("orderList", orderList);// 存到model中
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

    /**
     * 初始化分页 Bean (PageBean) .
     *
     * @param request 请求.
     * @return PageBean
     */
    private PageBean handlerPageBean(HttpServletRequest request) {
        PageBean pageBean = new PageBean();
        pageBean.setRequest(request);

        request.setAttribute("pageBean", pageBean);

        return pageBean;
    }
}
