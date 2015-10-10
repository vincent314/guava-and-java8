package org.vince.guava;

import org.junit.Assert;
import org.junit.Test;

import java.util.function.Function;

public class Step2Java8 {
    @Test
    public void testFunction() {
        int[] values = {
            1, 2, 3
        };

//        Function<Integer, Integer> doubleFunc = new Function<Integer, Integer>() {
//
//            @Override
//            public Integer apply(Integer val) {
//                return val * 2;
//            }
//        };

        Function<Integer, Integer> doubleFunc = (val) -> val * 2;

        for (int i = 0; i < values.length; i++) {
            values[i] = doubleFunc.apply(values[i]);
        }

        Assert.assertArrayEquals(new int[]{2, 4, 6}, values);
    }
}
