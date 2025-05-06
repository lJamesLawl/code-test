package com.james.test;

import com.james.test.enums.StringHandlerTypeEnum;
import com.james.test.factory.StringHandlerFactory;
import com.james.test.v1.StringHandler;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * 单元测试类：测试 Basic 和 Advanced 两种 StringHandler 实现逻辑。
 *
 * @author James
 */
public class StringHandlerTest {

    private StringHandler handler;

    @BeforeEach
    void setup() {
    }

    @AfterEach
    void shutdown() {
        handler = null;
    }

    @Test
    @DisplayName("Basic: remove repeated sequences")
    void testBasicHandler() {
        handler = StringHandlerFactory.getHandler(StringHandlerTypeEnum.BASIC);

        String input1 = "aab" + "c".repeat(3) + "bbad";
        String expected1 = "d";
        assertEquals(expected1, handler.process(input1));

        String input2 = "ab" + "c".repeat(3) + "d".repeat(4) + "e".repeat(5);
        String expected2 = "ab";
        assertEquals(expected2, handler.process(input2));

        String input3 = "abc";
        String expected3 = "abc";
        assertEquals(expected3, handler.process(input3));

        String input4 = "a".repeat(3) + "b".repeat(3) + "c".repeat(3);
        String expected4 = "";
        assertEquals(expected4, handler.process(input4));
    }

    @Test
    @DisplayName("Advanced: replace repeated sequences")
    void testAdvancedHandler() {
        StringHandler handler = StringHandlerFactory.getHandler(StringHandlerTypeEnum.ADVANCED);
        String input1 = "eabcccbad";
        String expected1 = "eed";
        // input:eabcccbad
        // -> eabbbad, ccc is replaced by b
        // -> eaaad, bbb is replaced by a
        // -> eed, aaa is replaced by e
        assertEquals(expected1, handler.process(input1));

        String input2 = "abcccdddeeef";
        String expected2 = "f";
        // input:abcccdddeeef
        // -> abbdddeeef, ccc is replaced by b
        // -> abbbeeef, ddd is replaced by b
        // -> aaeeef, bbb is replaced by a
        // -> aaaf, eee is replaced by a
        // -> "f", aaa is replaced by ""
        assertEquals(expected2, handler.process(input2));

        String input3 = "eabccccba";
        String expected3 = "ee";
        // input:eabccccba
        // -> eabbba, cccc is replaced by b
        // -> eaaa, bbb is replaced by a
        // -> ee, aaa is replaced by e
        assertEquals(expected3, handler.process(input3));
    }

    @Test
    @DisplayName("Basic: invalid input with symbols should throw exception")
    void testBasic_invalidCharacters() {
        StringHandler handler = StringHandlerFactory.getHandler(StringHandlerTypeEnum.BASIC);
        assertThrows(IllegalArgumentException.class, () -> handler.process("abc$%def"));
    }

    @Test
    @DisplayName("Advanced: invalid input with symbols should throw exception")
    void testAdvanced_invalidCharacters() {
        StringHandler handler = StringHandlerFactory.getHandler(StringHandlerTypeEnum.ADVANCED);
        assertThrows(IllegalArgumentException.class, () -> handler.process("abc$%def"));
    }
}
