package com.duangxt.util;

/**
 * @Author: duangxt
 * @Title:
 * @ClassName: MathUtil.java
 * @Package: com.duangxt.util
 * @Description:
 * @Date: Create in 2019/9/26 11:08:52
 * @Version: V0.0.1
 */
public class MathUtil {

    private static String del_nonum(String s){
        return s.replaceAll("[^\\d]","");
    }
    /** 删除字符串中非数字字符 */
    public static String delete_no_a_number(String s){
        return del_nonum(s);
    }
    /** 处理字符串中的小数点，使之变成可以转换自然数的字符串 */
    private static String process_point(String s){
        if(-1!=s.indexOf(".")){
            if(s.startsWith(".")) s="0"+s;
            if(s.endsWith(".")) s+="0";
            String s1=s.substring(0,s.indexOf("."));
            String s2=s.substring(s.indexOf("."),s.length());
            s2=del_nonum(s2);
            s1=del_nonum(s1);
            s=s1+"."+s2;
        }
        else s=del_nonum(s);
        return s;
    }

    // === 弱转换，一定要确定是特殊场景需要使用再用 ===
    /**
     * if string value is ( "000123" or "a1s2d3" or "123.456" or "123.456.789" or "~1@2#3..$4%5" )<br/>
     * aways return integer value: 123
     * @param s String
     * @return Integer
     */
    public static int parseInt(String s){
        s=_StringUtil.delete_space(s);
        if("".equals(s)) return 0;
        if("true".equals(s)) return 1;
        else if("false".equals(s)) return 0;
        s=process_point(s);
        if(-1!=s.indexOf(".")) s=s.substring(0,s.indexOf("."));
        return Integer.parseInt(s);
    }
    /**
     * if string value is ( "a1s2d3.f4g5h6" or "123.456" or "123.456.789" or "~1@2#3..$4%5" )<br/>
     * aways return float value: 123.456
     * @param s String
     * @return Double
     */
    public static double parseDouble(String s){
        s=_StringUtil.delete_space(s);
        if("".equals(s)) return 0D;
        if("true".equals(s)) return 1D;
        if("false".equals(s)) return 0D;
        return Double.parseDouble(process_point(s));
    }
    /**
     * if string value is ( "a1s2d3.f4g5h6" or "123.456" or "123.456.789" or "~1@2#3..$4%5" )<br/>
     * aways return float value: 123.456
     * @param s String
     * @return Float
     */
    public static float parseFloat(String s){
        s=_StringUtil.delete_space(s);
        if("".equals(s)) return 0F;
        if("true".equals(s)) return 1F;
        if("false".equals(s)) return 0F;
        return Float.parseFloat(process_point(s));
    }
    // === 弱转换end ===

}
