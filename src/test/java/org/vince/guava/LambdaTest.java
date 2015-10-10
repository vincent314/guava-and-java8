package org.vince.guava;

import org.junit.Test;

import java.util.function.Function;

import static org.junit.Assert.assertEquals;

public class LambdaTest {

    @Test
    public void testLamda(){
        Function<String,String> toUpper1 = new Function<String,String>(){
            @Override
            public String apply(String source) {
                return source.toUpperCase();
            }
        };

        Function<String, String> toUpper2 = (source) -> source.toUpperCase();

        Function<String, String> toUpper3 = String::toUpperCase;

        assertEquals("HELLO WORLD", toUpper1.apply("hello world"));
        assertEquals("HELLO WORLD", toUpper2.apply("hello world"));
        assertEquals("HELLO WORLD", toUpper3.apply("hello world"));
    }

}
