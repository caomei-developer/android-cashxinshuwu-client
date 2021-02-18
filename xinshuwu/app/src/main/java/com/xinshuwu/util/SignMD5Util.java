package com.xinshuwu.util;

import java.net.URLEncoder;
import java.security.MessageDigest;

public class SignMD5Util {
    public static final String MD5(String paramString) {
        char[] arrayOfChar = new char[16];
        arrayOfChar[0] = '0';
        arrayOfChar[1] = '1';
        arrayOfChar[2] = '2';
        arrayOfChar[3] = '3';
        arrayOfChar[4] = '4';
        arrayOfChar[5] = '5';
        arrayOfChar[6] = '6';
        arrayOfChar[7] = '7';
        arrayOfChar[8] = '8';
        arrayOfChar[9] = '9';
        arrayOfChar[10] = 'a';
        arrayOfChar[11] = 'b';
        arrayOfChar[12] = 'c';
        arrayOfChar[13] = 'd';
        arrayOfChar[14] = 'e';
        arrayOfChar[15] = 'f';
        try {
            byte[] arrayOfByte1 = paramString.getBytes();
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(arrayOfByte1);
            byte[] arrayOfByte2 = messageDigest.digest();
            char[] arrayOfChar1 = new char[arrayOfByte2.length * 2];
            int i = arrayOfByte2.length;
            byte b = 0;
            int j = 0;
            while (b < i) {
                byte b1 = arrayOfByte2[b];
                int k = j + 1;
                arrayOfChar1[j] = (char) arrayOfChar[b1 >>> 4 & 0xF];
                j = k + 1;
                arrayOfChar1[k] = (char) arrayOfChar[b1 & 0xF];
                b++;
            }
            return new String(arrayOfChar1);
        } catch (Exception exception) {
            return null;
        }
    }

    public static String createSign(String paramString1, String paramString2, String paramString3, String paramString4) throws Exception {
        StringBuilder stringBuilder4 = new StringBuilder();
        stringBuilder4.append("method:");
        stringBuilder4.append(paramString1);
        System.out.println(stringBuilder4.toString());
        stringBuilder4 = new StringBuilder();
        stringBuilder4.append("requestUrl:");
        stringBuilder4.append(paramString2);
        System.out.println(stringBuilder4.toString());
        stringBuilder4 = new StringBuilder();
        stringBuilder4.append("strPara:");
        stringBuilder4.append(paramString3);
        System.out.println(stringBuilder4.toString());
        stringBuilder4 = new StringBuilder();
        stringBuilder4.append("consumerSecret:");
        stringBuilder4.append(paramString4);
        System.out.println(stringBuilder4.toString());
        stringBuilder4 = new StringBuilder();
        stringBuilder4.append(paramString1);
        stringBuilder4.append(paramString2);
        stringBuilder4.append(paramString3);
        stringBuilder4.append(paramString4);
        paramString2 = stringBuilder4.toString();
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("stringSignTemp:");
        stringBuilder2.append(paramString2);
        System.out.println(stringBuilder2.toString());
        String str1 = URLEncoder.encode(paramString2, "UTF-8");
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append("stringSignTemp:");
        stringBuilder3.append(str1);
        System.out.println(stringBuilder3.toString());
        String str2 = MD5(str1).toLowerCase();
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("sign:");
        stringBuilder1.append(str2);
        System.out.println(stringBuilder1.toString());
        return str2;
    }
}
