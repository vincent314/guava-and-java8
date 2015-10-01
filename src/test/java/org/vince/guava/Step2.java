package org.vince.guava;

import com.google.common.base.Function;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by vincent on 01/10/15.
 */
public class Step2 {

    @Test
    public void testFunction(){
        int[] values = {
            1,2,3
        };

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
