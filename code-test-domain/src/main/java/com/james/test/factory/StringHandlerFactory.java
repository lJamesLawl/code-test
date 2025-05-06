package com.james.test.factory;

import com.james.test.enums.StringHandlerTypeEnum;
import com.james.test.v1.StringHandler;
import com.james.test.v1.impl.AdvancedStringHandlerImpl;
import com.james.test.v1.impl.BasicStringHandlerImpl;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;

/**
 * 字符串处理工厂类
 *
 * @author James
 */
public class StringHandlerFactory {
    private static final Map<StringHandlerTypeEnum, Supplier<StringHandler>> registry = new EnumMap<>(StringHandlerTypeEnum.class);

    static {
        registry.put(StringHandlerTypeEnum.BASIC, BasicStringHandlerImpl::new);
        registry.put(StringHandlerTypeEnum.ADVANCED, AdvancedStringHandlerImpl::new);
    }

    /**
     * 获取处理类
     * @param type
     * @return
     */
    public static StringHandler getHandler(StringHandlerTypeEnum type) {
        return registry.getOrDefault(type, BasicStringHandlerImpl::new).get();
    }
}
