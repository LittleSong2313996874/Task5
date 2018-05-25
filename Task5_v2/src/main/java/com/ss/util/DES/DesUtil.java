package com.ss.util.DES;



import com.alibaba.druid.sql.visitor.functions.Char;
import org.junit.Test;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Arrays;

//对称加密器
public class DesUtil {

    private static  Cipher cipher;
    private static String algorithm;  // 算法，如DES
    public   static String strkey;
    public static  SecretKey Skey;
    static KeyGenerator keyGenerator;

    /**
     *  产生固定密钥;将原来的静态方法改为静态代码块，因为总是出现空指针异常的情况
     *  推测可能是密钥没有成功生成。
     *
     *  静态方法是在别的程序调用时被动执行
     *  静态代码块则是在类加载时主动执行
     */
    static {
        algorithm = "DES";
        strkey = "effed53d23fe5d76";
        Skey = new SecretKeySpec(HextoBytes(strkey),algorithm);

    }


    /***** 加密函数，将原文加密成密文   */
    public static String EnCipherMsg(String plainText, Key key0) {
        byte[] cipherText = null;

        try {

            // 生成Cipher对象
            cipher = Cipher.getInstance(algorithm);
            // 用密钥加密明文(plainText),生成密文(cipherText)
            cipher.init(Cipher.ENCRYPT_MODE, key0); // 操作模式为加密(Cipher.ENCRYPT_MODE),key为密钥
            cipherText = cipher.doFinal(plainText.getBytes("utf-8")); // 得到加密后的字节数组

        } catch (Exception e) {
            e.printStackTrace();
        }
        return bytesToHexFun1(cipherText);
    }

    /***  解密函数，将密文解密回原文 */
    public static String DeCipherMsg(String cipherText, Key k) {
        byte[] cipherBytes =  HextoBytes(cipherText);

        byte[] sourceText = null;

        try {
            cipher.init(Cipher.DECRYPT_MODE, k); // 操作模式为解密,key为密钥
            sourceText = cipher.doFinal(cipherBytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new String(sourceText);
    }


    // 用于产生固定密钥时使用;

    /*  public static SecretKey getConstantKey() {

        SecretKey Skey = null;
        Skey = new SecretKeySpec(HextoBytes(strkey),algorithm);

        return Skey;
    }*/

    // 用于产生随机密钥时使用;
    public static SecretKey gatRandomKey() {

        SecretKey Skey = null;
        try {
            // 初始化密钥key
            keyGenerator = KeyGenerator.getInstance(algorithm);
            keyGenerator.init(56); // 选择DES算法,密钥长度必须为56位
            Skey = keyGenerator.generateKey();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return Skey;
    }




    //测试过关。
    public static byte[] HextoBytes(String str) {
        if(str == null || str.trim().equals("")) {
            return new byte[0];
        }

        byte[] bytes = new byte[str.length() / 2];
        for(int i = 0; i < str.length() / 2; i++) {
            String subStr = str.substring(i * 2, i * 2 + 2);
            bytes[i] = (byte) Integer.parseInt(subStr, 16);
        }

        return bytes;
    }

    //测试过关。
    public static String bytesToHexFun1(byte[] bytes) {
        char[] HEX_CHAR = {'0', '1', '2', '3', '4', '5',
                '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

        char[] buf = new char[bytes.length * 2];
        int index = 0;
        for(byte b : bytes) { // 利用位运算进行转换，可以看作方法一的变种
            buf[index++] = HEX_CHAR[b >>> 4 & 0xf];
            buf[index++] = HEX_CHAR[b & 0xf];
        }

        return new String(buf);
    }

/*
    @Test
    public  void testmain(){

      String str = "nihao我好大家好嘻嘻";

        byte[] keybytes = gatRandomKey().getEncoded();

        StringBuffer sb = new StringBuffer();
        System.out.println(Arrays.toString(keybytes)); // [64, 115, -57, -48, 97, -32, -85, -62]
        for (int i = 0; i < keybytes.length; i++) {
           sb.append(Integer.toBinaryString(keybytes[i])+",");

        }
        System.out.println(sb.toString());



        byte[] bytes = new byte[strkey.length() / 2];
        for(int i = 0; i < strkey.length() / 2; i++) {
            String subStr = strkey.substring(i * 2, i * 2 + 2);
            System.out.println(Integer.parseInt(subStr, 16));
            bytes[i] = (byte) Integer.parseInt(subStr, 16);

        }
        System.out.println(Arrays.toString(bytes));


    }
*/

}


