package com.zking.bookstore.service;

import com.zking.bookstore.exception.CustomException;
import com.zking.bookstore.model.User;

/**
 * 用户业务接口
 *
 * @Author Zeng LongFeng
 * @CreateTime 2017/12/28 15:14
 * @Version 1.0
 */
public interface IUserService {

    /**
     * 登录
     *
     * @param user 包含用户帐户和用户密码的用户
     * @return 用户信息
     * @throws CustomException
     */
    User doLogin(User user) throws CustomException;

    /**
     * 注册
     *
     * @param user 用户信息
     * @throws CustomException
     */
    void doRegister(User user) throws CustomException;

    /**
     * 根据用户帐号查询此用户是否存在
     *
     * @param username 用户帐号
     * @return 查出来个数
     */
    Boolean selectIsUserByUsername(String username);
}
