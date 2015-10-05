package org.vince.guava;

import org.junit.Assert;
import org.junit.Test;

public class Step2 {

    interface CustomInterface{
        int traiter(int value);
    }

    /**
     * Utiliser l'interface générique Function
     */
    @Test
    public void testCustomInterface(){
        int[] values = {
            1,2,3
        };

        CustomInterface traitement = new CustomInterface() {
            @Override
            public int traiter(int value) {
                return value * 2;
            }
        };

        for (int i = 0; i < values.length; i++) {
            values[i] = traitement.traiter(values[i]);
        }

        Assert.assertArrayEquals(new int[]{2, 4, 6}, values);
    }

}
