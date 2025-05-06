package com.james.test.enums;


import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 字符串处理类型枚举
 *
 * @author James
 */
@AllArgsConstructor
@Getter
public enum StringHandlerTypeEnum {
    /**
     * 基础处理
     */
    BASIC,

    /**
     * 进阶处理
     */
    ADVANCED
    ;
}
