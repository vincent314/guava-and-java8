package org.vince.guava;

import com.google.common.base.Optional;
import org.junit.Test;

import static org.junit.Assert.assertNull;

public class Step4Correction {

    public Optional<Object> getValue() {
        return Optional.absent();
    }

    /**
     * Crash test
     */
    @Test(expected = IllegalStateException.class)
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
