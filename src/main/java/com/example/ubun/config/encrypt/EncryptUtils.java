package com.example.ubun.config.encrypt;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class EncryptUtils {
    private static final String secretKey = "ubun?qy::";
    private static final String ALGORITHM = "AES";
    private static final String ENCODE = "UTF-8";

    public static void main(String[] args) throws NoSuchPaddingException, BadPaddingException, NoSuchAlgorithmException, IllegalBlockSizeException, UnsupportedEncodingException, InvalidKeyException {
        encrypt ("kyb1");
    }

    public static void encrypt(String data) throws NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException, UnsupportedEncodingException, BadPaddingException, IllegalBlockSizeException {
        //生成响应的秘钥
        KeyGenerator kgen = KeyGenerator.getInstance (ALGORITHM);
        kgen.init (128, new SecureRandom (secretKey.getBytes ()));
        SecretKey secretKey = kgen.generateKey ();
        byte[] enCodeFormat = secretKey.getEncoded ();
        //秘钥对象
        SecretKeySpec key = new SecretKeySpec (enCodeFormat, ALGORITHM);

        Cipher cipher = Cipher.getInstance (ALGORITHM);// 创建密码器
        //加密
        cipher.init (Cipher.ENCRYPT_MODE, key);// 初始化加密器

        //加密内容
        byte[] byteContent = data.getBytes (ENCODE);
        byte[] result = cipher.doFinal (byteContent);

        String p = parseByte2HexStr (result);//不可直接转成字符串
        System.out.println ("密码:" + p);

        //解密
        cipher.init (Cipher.DECRYPT_MODE, key);// 初始化解密器
        byte[] decryptFrom = parseHexStr2Byte (p);
        byte[] result1 = cipher.doFinal (decryptFrom);
        System.out.println ("原文：" + new String (result1));
    }

    /**
     * 二进制转换成16进制，加密后的字节数组不能直接转换为字符串
     * 2进制字符转化为 --->高八位低八位 16进制的
     */
    static String parseByte2HexStr(byte buf[]) {
        StringBuffer sb = new StringBuffer ();
        for (int i = 0; i < buf.length; i++) {
            String hex = Integer.toHexString (buf[i] & 0xFF);
            if (hex.length () == 1) {
                hex = '0' + hex;
            }
            sb.append (hex.toUpperCase ());
        }
        return sb.toString ();
    }

    /**
     * 16进制转换成二进制
     */
    static byte[] parseHexStr2Byte(String hexStr) {
        if (hexStr.length () < 1)
            return null;
        byte[] result = new byte[hexStr.length () / 2];
        for (int i = 0; i < hexStr.length () / 2; i++) {
            int high = Integer.parseInt (hexStr.substring (i * 2, i * 2 + 1), 16);
            int low = Integer.parseInt (hexStr.substring (i * 2 + 1, i * 2 + 2), 16);
            result[i] = (byte) (high * 16 + low);
        }
        return result;
    }

}
