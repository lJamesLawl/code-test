package com.james.test.v1.impl;

import com.james.test.config.RegexConfig;
import com.james.test.v1.AbstractStringHandler;

/**
 * 基础字符串处理实现类
 *
 * @author James
 */
public class BasicStringHandlerImpl extends AbstractStringHandler {

    @Override
    public String process(String input) {
        validateInput(input);
        // 根据正则表达式捕获当前字符串，连续出现3次或更多次的字符
        String result = input;
        while (result.matches(RegexConfig.CONTAINS_PATTERN)) {
            result = result.replaceAll(RegexConfig.REPEATED_PATTERN, "");
        }
        return result;

    }
}
