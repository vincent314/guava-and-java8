package org.vince.guava;

import org.hamcrest.CoreMatchers;
import org.hamcrest.Matcher;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class TestComparator {

    class User {
        String nom;
        int age;

        public User(String nom, int age) {
            this.nom = nom;
            this.age = age;
        }

        @Override
        public boolean equals(Object other) {
            return nom.equals(((User)other).nom);
        }
    }

    @Test
    public void testComparator() {
        List<User> users = Arrays.asList(
            new User("Alain", 35),
            new User("Roger", 31),
            new User("Janine", 55),
            new User("Rebecca", 22)
        );

        Collections.sort(users, new Comparator<User>() {
            @Override
            public int compare(User user1, User user2) {
                return user1.age - user2.age;
            }
        });

        User[] expected = {
            new User("Rebecca",22),
            new User("Roger", 31),
            new User("Alain", 35),
            new User("Janine", 55)};

        assertArrayEquals(expected, users.toArray(new User[]{}));
    }
}
