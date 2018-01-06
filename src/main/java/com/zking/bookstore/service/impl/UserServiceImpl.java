package com.zking.bookstore.service.impl;

import com.zking.bookstore.exception.CustomException;
import com.zking.bookstore.mapper.UserMapper;
import com.zking.bookstore.mapper.UserMapperCustom;
import com.zking.bookstore.model.User;
import com.zking.bookstore.service.IUserService;
import com.zking.bookstore.utils.PasswordEncryption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description 用户业务接口实现类
 * @Author LongFeng Zeng
 * @CreateTime 2018-01-04 11:41
 * @Version 1.0
 */
@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserMapper userMapper;
	@Autowired
	private UserMapperCustom userMapperCustom;

	@Override
	public User doLogin(User user) throws CustomException {
		try {
			// 根据用户帐号查询此用户的盐值
			String salt = userMapperCustom.selectByUsername2Salt(user.getUsername());
			if (null == salt || "".equals(salt.trim())) {
				throw new CustomException("用户名或密码错误");
			}
			// 根据明文密码和盐值生成密文
			user.setPassword(PasswordEncryption.getEncryptedPassword(user.getPassword(), salt));
			// 根据用户帐号和用户密码查询用户信息
			User u = userMapperCustom.selectByUsernameAndPassword(user);
			if (null == u || null == u.getPassword()) {
				throw new CustomException("用户名或密码错误");
			}
			return u;
		} catch (Exception e) {
			e.printStackTrace();
			throw new CustomException("登录失败", e);
		}
	}

	@Override
	public void doRegister(User user) throws CustomException {
		try {
			String salt = PasswordEncryption.generateSalt();// 生成盐值
			user.setSalt(salt);// 设置盐值
			String encryptedPassword = PasswordEncryption.getEncryptedPassword(user.getPassword(), salt);// 根据明文密码和盐值生成密文
			user.setPassword(encryptedPassword);// 设置密码为加密后的密文

			userMapper.insert(user);// 新增
		} catch (Exception e) {
			throw new CustomException("注册失败", e);
		}
	}

	@Override
	public Boolean selectIsUserByUsername(String username) {
		return userMapperCustom.selectIsUserByUsername(username) > 0;
	}
}
