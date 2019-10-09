package com.duangxt.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**  
 * @Title: _StringUtil.java
 * @Description: 字符串处理类
 * @author duangxt
 * @version V1.0  
 */ 
public class _StringUtil {

	/**
	 * 去掉指定字符串的开头和结尾的指定字符
	 * @param stream  要处理的字符串
	 * @param trimstr  要去掉的字符串
	 * @return  处理后的字符串
	 */
	public static String sideTrim(String stream, String trimstr) {
		// null或者空字符串的时候不处理
		if(stream == null || stream.length() == 0 || trimstr == null || trimstr.length() == 0) {
			return stream;
		}

		// 结束位置
		int epos = 0;

		// 正规表达式
		String regpattern = "[" + trimstr + "]*+";
		Pattern pattern = Pattern.compile(regpattern, Pattern.CASE_INSENSITIVE);

		// 去掉结尾的指定字符
		StringBuffer buffer = new StringBuffer(stream).reverse();
		Matcher matcher = pattern.matcher(buffer);
		if (matcher.lookingAt()) {
			epos = matcher.end();
			stream = new StringBuffer(buffer.substring(epos)).reverse().toString();
		}

		// 去掉开头的指定字符
		matcher = pattern.matcher(stream);
		if (matcher.lookingAt()) {
			epos = matcher.end();
			stream = stream.substring(epos);
		}

		// 返回处理后的字符串
		return stream;
	}

	/**
	 * 将以逗号分隔的字符串转换成字符串数组
	 * @param valStr
	 * @return String[]
	 */
	public static String[] StrList(String valStr){
		int i = 0;
		String TempStr = valStr;
		String[] returnStr = new String[valStr.length() + 1 - TempStr.replace(",", "").length()];
		valStr = valStr + ",";
		while (valStr.indexOf(',') > 0)
		{
			returnStr[i] = valStr.substring(0, valStr.indexOf(','));
			valStr = valStr.substring(valStr.indexOf(',')+1 , valStr.length());

			i++;
		}
		return returnStr;
	}

	/**
	 * 字符串转换为字符串数组
	 * @param str 字符串
	 * @param splitRegex 分隔符
	 * @return
	 */
	public static String[] str2StrArray(String str,String splitRegex){
		if(null!=str&&!"".equals(str)){
			return null;
		}
		return str.split(splitRegex);
	}

	/**
	 * 用默认的分隔符(,)将字符串转换为字符串数组
	 * @param str	字符串
	 * @return
	 */
	public static String[] str2StrArray(String str){
		return str2StrArray(str,",\\s*");
	}

	/** 请优先使用该方法，使用StringUtils.trim()无法避免参数的空指针异常！ */
	public static String trim(StringBuffer sb){
		if(null==sb||"".equals(sb.toString())) return "";
		String s=sb.toString();
		int start=0,end=s.length()-1;
		while(start<=end&&s.charAt(start)==' '){
			start++;
		}
		while(start<=end&&s.charAt(end)==' '){
			end--;
		}
		return s.substring(start,end+1);
	}
	/** 请优先使用该方法，使用StringUtils.trim()无法避免参数的空指针异常！ */
	public static String trim(String s){
		if(null==s||s.isEmpty()||"".equals(s.trim())) return "";
		return s.trim();
	}

	/** 删掉字符串内的所有空格，只保留有效字符 */
	public static String delete_space(String s){
		if(null==s) return "";
		return s.replaceAll("\r\n|\r|\n| |　|\t","");
	}

	/**
	 * 检测字符串是否为空(null,"","null")
	 * @param s
	 * @return 为空则返回true，不否则返回false
	 */
	public static boolean isEmpty(String s){
		if(null==s) return true;
		s = _StringUtil.delete_space(s);
		return "".equals(s) || "null".equals(s);
	}
	/**
	 * 检测字符串是否不为空(null,"","null")
	 * @param s
	 * @return 不为空返回true，为空返回false
	 */
	public static boolean isNotEmpty(String s){return !isEmpty(s);}

	/** 字符串是否是纯数字（不允许有空格） */
	public static boolean isNumber(String s){
		return null==s||"".equals(s)?false:"".equals(s.replaceAll("[0-9]",""));
	}

	/** 字符串是否是纯字母（不允许有空格） */
	public static boolean isLetter(String s){
		return null==s||"".equals(s)?false:"".equals(s.replaceAll("[A-Za-z]",""));
	}

	/** 字符串是否是纯小写字母（不允许有空格） */
	public static boolean isLowerCaseLetter(String s){
		return null==s||"".equals(s)?false:"".equals(s.replaceAll("[a-z]",""));
	}

	/** 字符串是否是纯大写字母（不允许有空格） */
	public static boolean isUpperCaseLetter(String s){
		return null==s||"".equals(s)?false:"".equals(s.replaceAll("[A-Z]",""));
	}
}
