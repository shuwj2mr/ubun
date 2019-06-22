package com.example.ubun.config.encrypt;

public class HexUtils {
    /**
     * 二进制转(16进制)字符串
     */
    //  shwj   s ==对应ascall表 中的 115 转化为16进制为73
    static String parseByte2HexStr(byte buf[]) {
        StringBuffer sb = new StringBuffer ();
        for (int i = 0; i < buf.length; i++) {
            String hex = Integer.toHexString (buf[i] & 0xFF);       //E88892
            if (hex.length () == 1) hex = '0' + hex;
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
        byte[] result = new byte[hexStr.length () / 2];          //连续2个字符表示1个字符  1211AAAA
        for (int i = 0; i < hexStr.length () / 2; i++) {
            /*比如12*/
            int high = Integer.parseInt (hexStr.substring (i * 2, i * 2 + 1), 16);  //1
            int low = Integer.parseInt (hexStr.substring (i * 2 + 1, i * 2 + 2), 16);   //2
            result[i] = (byte) ((high<<4) + low);       //0000 0000    0000 0000  1
        }
        return result;
    }

    public static void main(String[] args) {
        String a = parseByte2HexStr ("A".getBytes ());
        System.out.println (a);
        byte[] bytes = parseHexStr2Byte (a);
        System.out.println (new String(bytes));
    }
}