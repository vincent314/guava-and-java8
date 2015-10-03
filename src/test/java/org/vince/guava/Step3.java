package org.vince.guava;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by vincent on 03/10/15.
 */
public class Step3 {
    /**
     * Filtrer les nombres pairs
     */
    @Test
    public void testFilter() {
        List<Integer> values = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Conserver les nombres pairs
        List<Integer> result = new ArrayList<Integer>();
        for (Integer value : values) {
            if (value % 2 == 0) {
                result.add(value);
            }
        }

        Assert.assertTrue(
            Iterables.elementsEqual(
                Arrays.asList(2, 4, 6, 8, 10),
                result
            ));
    }

    class User {
        String prenom;

        public User(String prenom) {
            this.prenom = prenom;
        }

        @Override
        public boolean equals(Object obj) {
            return prenom.equals(((User) obj).prenom);
        }
    }

    /**
     * Convertir une classe en une autre
     */
    @Test
    public void testTransform() {
        List<String> values = Arrays.asList("Ghislaine", "Catherine");

        List<User> result = new ArrayList<User>();
        for (String value : values) {
            result.add(new User(value));
        }

        Assert.assertTrue(
            Iterables.elementsEqual(
                Arrays.asList(
                    new User("Ghislaine"),
                    new User("Catherine")
                ),
                result
            ));
    }

    /**
     * Construire une chaine des nombres paires entre 1 et 10
     */
    @Test
    public void testChain(){
        Integer[] values = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        // Conserver les nombres pairs
        List<Integer> step1 = new ArrayList<Integer>();
        for (Integer value : values) {
            if (value % 2 == 0) {
                step1.add(value);
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        boolean isFirst = true;
        for (Integer integer : step1) {
            if(!isFirst){
                stringBuilder.append(";");
            }
            stringBuilder.append(integer);
            isFirst = false;
        }
        String result = stringBuilder.toString();

        Assert.assertEquals(
            "2;4;6;8;10",
            result
        );
    }
}
