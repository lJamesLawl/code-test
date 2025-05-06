package com.james.test.config;


public class RegexConfig {
    /**
     * 可被替换的字符串 正则表达式
     */
    public static final String REPEATED_PATTERN = "(.)\\1{2,}";

    /**
     * 查询是否包含字符串的 正则表达式
     */
    public static final String CONTAINS_PATTERN = ".*(.)\\1{2,}.*";
}
