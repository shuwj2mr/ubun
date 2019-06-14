package com.example.ubun.config.encrypt;


import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.security.SecureRandom;

public class DesEncrypt {
    private static final String secretKey="shwj";

    public static void desEncrypt() {
        try {
            KeyGenerator keygenerator = KeyGenerator.getInstance ("DES");    //指定秘钥生成的算法
            keygenerator.init (56,new SecureRandom (secretKey.getBytes ("UTF-8")));                                      //秘钥生成长度
            SecretKey secretKey = keygenerator.generateKey ();                //生成对称秘钥

            String encode = new BASE64Encoder ().encode (secretKey.getEncoded ());

            Cipher cipher = Cipher.getInstance ("DES");
            cipher.init (Cipher.ENCRYPT_MODE,secretKey);
            byte[] password = cipher.doFinal ("123456".getBytes ());
            System.out.println (new String (password));

        } catch (Exception e) {
            e.printStackTrace ();
        }
    }

    /**
     * 获取对称密钥
     * @param key base64编码后的密钥字符串
     * @return
     * @throws Exception
     */
    private SecretKey getKey(String key) throws Exception
    {
        DESKeySpec desKeySpec = new DESKeySpec (new BASE64Encoder().encode ((key.getBytes ())).getBytes ());
        SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("DES");
        return secretKeyFactory.generateSecret(desKeySpec);
    }

    public static void main(String[] args) {
        desEncrypt ();
    }
}
