package com.example.ubun.config.encrypt;

import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.apache.commons.codec.binary.Base64;

/**
 * 非对称加密 唯一广泛接受并实现 数据加密&数字签名 公钥加密、私钥解密 私钥加密、公钥解密
 *
 * @author jjs
 *  暂时不可用
 */
public class RsaEncrypt {
    private static String src = "shwj";
    private static RSAPublicKey rsaPublicKey;
    private static RSAPrivateKey rsaPrivateKey;


    static {
        // 1、初始化密钥
        KeyPairGenerator keyPairGenerator;
        try {
            keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(1024);// 512的倍数
            KeyPair keyPair = keyPairGenerator.generateKeyPair();
            rsaPublicKey = (RSAPublicKey) keyPair.getPublic();
            rsaPrivateKey = (RSAPrivateKey) keyPair.getPrivate();
            System.out.println("Public Key : " + Base64.encodeBase64String(rsaPublicKey.getEncoded()));
            System.out.println("Private Key : " + Base64.encodeBase64String(rsaPrivateKey.getEncoded()));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    /**
     * 公钥加密，私钥解密
     * @author jijs
     */
    public static String pubKeyEncrypt(String src) throws NoSuchAlgorithmException, InvalidKeySpecException, InvalidKeyException, NoSuchPaddingException, BadPaddingException, IllegalBlockSizeException {
        //公钥加密
        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(rsaPublicKey.getEncoded());
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PublicKey publicKey = keyFactory.generatePublic(x509EncodedKeySpec);
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] result = cipher.doFinal(src.getBytes());
        return Base64.encodeBase64String (result);
    }

    public static String priKeyDecrypt(String secret) throws NoSuchAlgorithmException, InvalidKeySpecException, InvalidKeyException, NoSuchPaddingException, BadPaddingException, IllegalBlockSizeException {
        //私钥解密
        PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(rsaPrivateKey.getEncoded());
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PrivateKey privateKey = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] result = cipher.doFinal(Base64.decodeBase64 (secret));
        return new String (result);
    }




    /**
     * 私钥加密，公钥解密
     * @author jijs
     */
//    public static void priEn2PubDe() throws NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
//
//        //私钥加密
//        PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(rsaPrivateKey.getEncoded());
//        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
//        PrivateKey privateKey = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
//        Cipher cipher = Cipher.getInstance("RSA");
//        cipher.init(Cipher.ENCRYPT_MODE, privateKey);
//        byte[] result = cipher.doFinal(src.getBytes());
//        System.out.println("私钥加密，公钥解密 --加密 : " + Base64.encodeBase64String(result));
//
//        //公钥解密
//        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(rsaPublicKey.getEncoded());
//        keyFactory = KeyFactory.getInstance("RSA");
//        PublicKey publicKey = keyFactory.generatePublic(x509EncodedKeySpec);
//        cipher = Cipher.getInstance("RSA");
//        cipher.init(Cipher.DECRYPT_MODE, publicKey);
//        result = cipher.doFinal(result);
//        System.out.println("私钥加密，公钥解密   --解密: " + new String(result));
//    }

    public static void main(String[] args) throws NoSuchPaddingException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException, InvalidKeySpecException {
        String s = priKeyDecrypt ("afKA1EL6u0Q3MbZhYuRdepOs9wCu3tts1ptG+vuRFRtb9o26ZBVp9WSU16mkWixCTaFybo5UVXX/HX56GdPCX5QAAnwkrcPcb/D0ubj0edh53lcgETbm85V5MPSC9ipv7ZF0JeEdJLroHmHPtOP4Wdl1VjgChnQHqVNntiHXD+A=");
    }
}