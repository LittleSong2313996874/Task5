package com.ss.util.DES;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.security.Key;
import java.util.*;


public class DesUtilTest {


    @Test
    public void testMd5() {
        String s = "维多利亚123456";   // e5907f2617fb0d7c3edbfd3fa58534bd     维多利亚123456  db68e8d80ac3ac0862770e4a8d658ed8

        System.out.println(s);
        s = Md5Util.string2MD5(s);
        System.out.println(s);


    }

    @Test
    public void testMd52() {
        String s = "";   // e8dc4081b13434b45189a720b77b6818    维多利亚123456  db68e8d80ac3ac0862770e4a8d658ed8

        System.out.println(s);
        s = Md5Util.string2MD5(s);
        System.out.println(s);


    }






    @Test
    public void testString() throws Exception{

        final Base64.Decoder decoder = Base64.getDecoder();
        final Base64.Encoder encoder = Base64.getEncoder();
        final String text = "abc";
        final byte[] textByte = text.getBytes("UTF-8");
//编码
        final String encodedText = encoder.encodeToString(textByte);
        System.out.println(encodedText);
//解码
        System.out.println(new String(decoder.decode(encodedText), "UTF-8"));



    }

}