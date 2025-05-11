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
            changed = false;
            Matcher matcher = compile.matcher(result);
            if (matcher.find()) {
                int start = matcher.start();
                int end = matcher.end();

                // 获取第一个重复字符
                char firstChar = result.charAt(start);

                // 计算前一个字母（按字母表顺序）
                char replacementChar;
                if (firstChar > 'a') {
                    replacementChar = (char) (firstChar - 1);
                } else {
                    // 如果是 'a'，则无法再往前退，直接移除重复项即可
                    replacementChar = ' ';
                }

                // 替换重复字符段为前一个字母
                result = new StringBuilder(result).replace(start, end, String.valueOf(replacementChar)).toString();

                // 如果替换的是空格（即原为 'a' 的重复），则去掉该字符
                if (replacementChar == ' ') {
                    result = result.replace(" ", "");
                }

                changed = true;
            }
        } while (changed);

        return result;
    }
}
