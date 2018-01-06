package com.zking.bookstore.mapper;


import com.zking.bookstore.model.User;

/**
 * 用户数据访问对象扩展类
 *
 * @Author Zeng LongFeng
 * @CreateTime 2017/12/28 15:18
 * @Version 1.0
 */
public interface UserMapperCustom {
    /**
     * 根据用户帐号和用户密码查询用户信息
     *
     * @param user 包含用户帐号和用户密码
     * @return 用户信息
     */
    User selectByUsernameAndPassword(User user);

    /**
     * 根据用户帐号查询此用户的盐值
     *
     * @param username 用户帐号
     * @return 此用户的盐值
     */
    String selectByUsername2Salt(String username);

    /**
     * 根据用户帐号查询此用户是否存在
     *
     * @param username 用户帐号
     * @return 查出来个数
     */
    int selectIsUserByUsername(String username);
}
