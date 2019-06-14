package com.example.ubun.config.encrypt;
import org.springframework.util.DigestUtils;
import sun.security.provider.MD5;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class EncryptUtils {

    public static void main(String[] args) throws NoSuchPaddingException, BadPaddingException, NoSuchAlgorithmException, IllegalBlockSizeException, UnsupportedEncodingException, InvalidKeyException {
    }
    public static void encryptWithMD5() throws NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException, UnsupportedEncodingException, BadPaddingException, IllegalBlockSizeException {
        String src = "";//加密内容
        String pkey = "";//秘钥

        //配置--加密与解密公用的
        KeyGenerator kgen = KeyGenerator.getInstance("DES");
        kgen.init(56, new SecureRandom (pkey.getBytes()));
        SecretKey secretKey = kgen.generateKey();
        byte[] enCodeFormat = secretKey.getEncoded();
        SecretKeySpec key = new SecretKeySpec(enCodeFormat, "DES");

        Cipher cipher = Cipher.getInstance("DES");// 创建密码器
        //加密
        byte[] byteContent = src.getBytes("utf-8");
        cipher.init(Cipher.ENCRYPT_MODE, key);// 初始化加密器
        byte[] result = cipher.doFinal(byteContent);

        String p = parseByte2HexStr(result);//不可直接转成字符串
        System.out.println ("密码:"+p);

        //解密
        cipher.init(Cipher.DECRYPT_MODE, key);// 初始化解密器
        byte[] decryptFrom = parseHexStr2Byte(p);
        byte[] result1 = cipher.doFinal(decryptFrom);
        System.out.println("原文：" + new String(result1));
    }

    /**
     * 二进制转换成16进制，加密后的字节数组不能直接转换为字符串
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
