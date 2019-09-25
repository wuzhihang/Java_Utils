package com.duangxt.util.sql_string;

/**
 * @author duangxt
 * @Title: SqlStrHelper.java
 * @Package com.gmweb.util.sql_str_helper
 * @Description: SQL语句字符串处理类
 * @date 2019年9月10日
 * @version V1.0
 */
public class SqlStrHelper {

    /**
     * @Ttile 去除SQL字符串中多余的空格
     * @Author duangxt
     * @Description //TODO
     * @Date 2019/9/10 0010 10:35:
     * @Param String sql
     * @return java.lang.String
     * @throws
     **/
    public static String trim(String sql){
        return sql.trim().replaceAll("\r\n|\r|\n|  |　|\t"," ").replaceAll(" {2,}"," ");
    }
}
