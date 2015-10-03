package org.vince.guava;

import org.junit.Test;

import static org.junit.Assert.assertNull;

public class Step4 {

    public Object getValue() {
        return null;
    }

    /**
     * Crash test
     */
    @Test(expected = NullPointerException.class)
    public void testGetValue() {
        getValue().toString();
    }

    /**
     * Gestion des valeurs null
     *
     * @return
     */
    public String process() {
        Object value = getValue();

        if(value == null) {
            return null;
        }
        return value.toString();
    }

    @Test
    public void testNull() {
        String result = process();

        assertNull(result);
    }
}
