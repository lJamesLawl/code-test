package com.james.test;


import com.james.test.enums.StringHandlerTypeEnum;
import com.james.test.factory.StringHandlerFactory;
import com.james.test.v1.StringHandler;

/**
 * 启动类
 *
 * @author James
 */
public class Application {
    public static void main(String[] args) {
        StringHandler handler = StringHandlerFactory.getHandler(StringHandlerTypeEnum.ADVANCED);
        String input = "sbbbsc";
        String result = handler.process(input);
        System.out.println("Result: " + result);
    }
}
