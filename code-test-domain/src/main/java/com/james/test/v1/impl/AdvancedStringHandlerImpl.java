package com.james.test.v1.impl;

import com.james.test.config.RegexConfig;
import com.james.test.v1.AbstractStringHandler;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 进阶字符串处理实现类
 *
 * @author James
 */
public class AdvancedStringHandlerImpl extends AbstractStringHandler {
    @Override
    public String process(String input) {
        validateInput(input);
        Pattern compile = Pattern.compile(RegexConfig.REPEATED_PATTERN);
        String result = input;
        boolean changed;

        do {
            // 每轮循环开始前先假设变更为false
            changed = false;
            // 通过正则查询是否存在重复字符
            Matcher matcher = compile.matcher(result);
            if (matcher.find()) {
                // 获取重复字符段的起始index
                int start = matcher.start();
                // 获取重复字符段的结束位置后一位的index
                int end = matcher.end();
                // 取出起始index-1位置的字符串，若index<=0（为字符串开头），则取空字符串
                String before = start > 0 ? String.valueOf(result.charAt(start - 1)) : "";
                // 按index的range执行替换操作
                result = new StringBuilder(result).replace(start, end, before).toString();
                changed = true;
            }
        } while (changed);

        return result;
    }
}
