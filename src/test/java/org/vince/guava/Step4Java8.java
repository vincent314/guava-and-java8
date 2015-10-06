package org.vince.guava;

import org.junit.Test;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.Assert.assertNull;

public class Step4Java8 {

    public Optional<Object> getValue() {
        return Optional.empty();
    }

    /**
     * Crash test
     */
    @Test(expected = NoSuchElementException.class)
    public void testGetValue() {
        getValue().get();
    }

    /**
     * Gestion des valeurs null
     *
     * @return
     */
    public String process() {
        Optional<Object> value = getValue();

        if(!value.isPresent()) {
            return null;
        }
        return value.get().toString();
    }

    @Test
    public void testNull() {
        String result = process();

        assertNull(result);
    }
}
