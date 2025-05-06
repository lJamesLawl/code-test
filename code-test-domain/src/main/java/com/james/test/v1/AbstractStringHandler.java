package com.james.test.v1;

/**
 * 字符串处理抽象类，封装了输入参数的校验逻辑
 *
 * @author James
 */
public abstract class AbstractStringHandler implements StringHandler {
    /**
     * 入参校验
     * @param input
     */
    protected void validateInput(String input) {
        if (!input.matches("[a-z]*")) {
            throw new IllegalArgumentException("Input must only contain lowercase a-z letters.");
        }
    }
}