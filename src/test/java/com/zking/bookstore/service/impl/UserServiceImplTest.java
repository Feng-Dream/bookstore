package com.zking.bookstore.service.impl;

import com.zking.bookstore.base.BaseTestCase;
import com.zking.bookstore.exception.CustomException;
import com.zking.bookstore.model.User;
import com.zking.bookstore.service.IUserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImplTest extends BaseTestCase {

    @Autowired
    private IUserService userService;

    private User user;

    @Override
    public void setUp() throws Exception {
        this.user = new User();
    }

    @Test
    public void doLogin() throws CustomException {
        this.user.setUsername("zs");
        this.user.setPassword("123");
        User u = userService.doLogin(this.user);
        System.out.println(u);
    }

    @Test
    public void doRegister() {
    }

    @Test
    public void selectIsUserByUsername() {
    }
}
