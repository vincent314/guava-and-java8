package org.vince.guava;

import com.google.common.collect.Iterables;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Step3 {
    /**
     * Test du filtre les nombres pairs
     */
    @Test
    public void testFilter() {
        // ------------- GIVEN ---------------
        List<Integer> values = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // --------------- THEN --------------
        // Conserver les nombres pairs
        List<Integer> result = new ArrayList<Integer>();
        for (Integer value : values) {
            if (value % 2 == 0) {
                result.add(value);
            }
        }

        // ------------- EXPECT ----------------
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
     * Convertir une classe en une autre (String -> User)
     */
    @Test
    public void testTransform() {
        // ------------- GIVEN ---------------
        List<String> values = Arrays.asList("Ghislaine", "Catherine");

        // --------------- THEN --------------
        List<User> result = new ArrayList<User>();
        for (String value : values) {
            result.add(new User(value));
        }

        // ------------- EXPECT ----------------
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
        // ------------- GIVEN ---------------
        Integer[] values = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        // --------------- THEN --------------
        // Conserver les nombres pairs
        List<Integer> step1 = new ArrayList<Integer>();
        for (Integer value : values) {
            if (value % 2 == 0) {
                step1.add(value);
            }
        }

        // ------------- EXPECT ----------------
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
