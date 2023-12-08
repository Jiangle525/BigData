package com.jiangle.bigevent.utils;

import org.mindrot.jbcrypt.BCrypt;

public class EncryptionUtils {
    // 加密算法盐的长度
    private static final int SALT_ROUNDS = 12;

    // 加密密码
    public static String encryptPassword(String plainPassword) {
        // 生成盐，并使用盐对密码进行哈希
        String salt = BCrypt.gensalt(SALT_ROUNDS);
        return BCrypt.hashpw(plainPassword, salt);
    }

    // 验证密码
    public static boolean verifyPassword(String plainPassword, String encryptPassword) {
        return BCrypt.checkpw(plainPassword, encryptPassword);
    }

}
