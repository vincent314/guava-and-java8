package org.vince.guava;

import org.junit.Assert;
import org.junit.Test;

public class Step2 {

    interface CustomInterface{
        int traiter(int value);
    }

    /**
     * Créer et utiliser une interface pour customiser un traitement
     */
    @Test
    public void testCustomInterface(){
        // -------------------- GIVEN -------------------------------
        int[] values = {
            1,2,3
        };

        // --------------------- THEN --------------------------
        // Implémentation du traitement personnalisé
        CustomInterface traitement = new CustomInterface() {
            @Override
            public int traiter(int value) {
                return value * 2;
            }
        };

        for (int i = 0; i < values.length; i++) {
            values[i] = traitement.traiter(values[i]);
        }

        // -------------- EXPECT -------------------
        Assert.assertArrayEquals(new int[]{2, 4, 6}, values);
    }

}
