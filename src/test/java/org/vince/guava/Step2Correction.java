package org.vince.guava;

import com.google.common.base.Function;
import org.junit.Assert;
import org.junit.Test;

public class Step2Correction {
    @Test
    public void testFunction(){
        int[] values = {
            1,2,3
        };

        // Utilisation de l'interface usuelle Function du Guava
        Function<Integer, Integer> doubleFunc = new Function<Integer, Integer>() {

            @Override
            public Integer apply(Integer val) {
                return val * 2;
            }
        };

        for (int i = 0; i < values.length; i++) {
            values[i] = doubleFunc.apply(values[i]);
        }

        Assert.assertArrayEquals(new int[]{2, 4, 6}, values);
    }
}
