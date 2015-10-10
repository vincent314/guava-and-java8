package org.vince.guava;

import org.junit.Test;

import java.util.function.UnaryOperator;

import static org.junit.Assert.assertEquals;

public class LambdaTest {

    @Test
    public void testLamda() {
        UnaryOperator<String> toUpper1 = new UnaryOperator<String>() {
            @Override
            public String apply(String source) {
                return source.toUpperCase();
            }
        };

        UnaryOperator<String> toUpper2 = (source) -> source.toUpperCase();

        UnaryOperator<String> toUpper3 = String::toUpperCase;

        assertEquals("HELLO WORLD", toUpper1.apply("hello world"));
        assertEquals("HELLO WORLD", toUpper2.apply("hello world"));
        assertEquals("HELLO WORLD", toUpper3.apply("hello world"));
    }

}
