package uvg;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class VerifyExpresionTest {
    /**
     * Tests the higherThan method of the VerifyExpresion class.
     */
    @Test
    public void higherThanTest(){
        VerifyExpresion verify = new VerifyExpresion();

        float[] test1 = new float[]{10, 2};
        assertEquals(true, verify.higherThan(test1));

        float[] test2 = new float[]{5, 7};
        assertEquals(false, verify.higherThan(test2));

        float[] test3 = new float[]{777, 499};
        assertEquals(true, verify.higherThan(test3));
        
    }

    /**
     * Tests the lowerThan method of the VerifyExpresion class.
     */
    @Test
    public void lowerThanTest(){
     VerifyExpresion verify = new VerifyExpresion();

        float[] test1 = new float[]{0, 2};
        assertEquals(true, verify.lowerThan(test1));

        float[] test2 = new float[]{0, 0};
        assertEquals(false, verify.lowerThan(test2));

        float[] test3 = new float[]{699, 777};
        assertEquals(true, verify.lowerThan(test3));
        
    }

    /**
     * Tests the equalsTo method of the VerifyExpresion class.
     */
    @Test
    public void equalsTest(){
          VerifyExpresion verify = new VerifyExpresion();

        float[] test1 = new float[]{10, 10};
        assertEquals(true, verify.equalsTo(test1));

        float[] test2 = new float[]{7, 3};
        assertEquals(false, verify.equalsTo(test2));

        float[] test3 = new float[]{777, 777};
        assertEquals(true, verify.equalsTo(test3));
        
    }
}
