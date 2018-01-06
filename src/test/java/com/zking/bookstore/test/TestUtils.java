package com.zking.bookstore.test;

import com.zking.bookstore.utils.PasswordEncryption;
import org.junit.Test;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

/**
 * @Description 测试
 * @Author LongFeng Zeng
 * @CreateTime 2018-01-06 18:26
 * @Version 1.0
 */
public class TestUtils {

    @Test
    public void testPassword() throws InvalidKeySpecException, NoSuchAlgorithmException {
        String password = PasswordEncryption.getEncryptedPassword("zs1234", "f03552f1b85874930d80e02f1543445b");
        System.out.println(password);
    }
}
