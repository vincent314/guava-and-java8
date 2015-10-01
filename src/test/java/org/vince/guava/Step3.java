package org.vince.guava;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by vincent on 01/10/15.
 */
public class Step3 {

    @Test
    public void testCollection() {
        List<Integer> values = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        Iterable<Integer> result = Iterables.filter(values, new Predicate<Integer>() {
            @Override
            public boolean apply(Integer value) {
                return value % 2 == 0;
            }
        });

        Assert.assertTrue(
            Iterables.elementsEqual(
                Arrays.asList(2,4,6,8,10),
                result
            ));
    }
}
