package uvg;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class ArithmeticOperationsTest {
    
    /**
     * Test case for the sum method of the ArithmeticOperations class
     */
    @Test
    public void sumTest(){
        ArithmeticOperations arithmethic = new ArithmeticOperations();

        float[] test1 = new float[]{10, 2};
        assertEquals(12, arithmethic.sum(test1), 0.0f);

        float[] test2 = new float[]{1, 2, 3, 4};
        assertEquals(10, arithmethic.sum(test2), 0.0f);

        float[] test3 = new float[]{500, 29, 31, 49};
        assertEquals(609, arithmethic.sum(test3), 0.0f);
        
    }

    /**
     * Test case for the subtraction method of the ArithmeticOperations class.
     */
    @Test
    public void substractionTest(){
        
        ArithmeticOperations arithmethic = new ArithmeticOperations();

        float[] test1 = new float[]{5, 2};
        assertEquals(3, arithmethic.substraction(test1), 0.0f);

        float[] test2 = new float[]{2, 5};
        assertEquals(-3, arithmethic.substraction(test2), 0.0f);

        float[] test3 = new float[]{10, 3, 2, 1};
        assertEquals(4, arithmethic.substraction(test3), 0.0f);

        float[] test4 = new float[]{1, 2, 3, 10};
        assertEquals(-14, arithmethic.substraction(test4), 0.0f);

        float[] test5 = new float[]{500, 29, 31, 49};
        assertEquals(391, arithmethic.substraction(test5), 0.0f);

        float[] test6 = new float[]{500, 100, 200, 200};
        assertEquals(0, arithmethic.substraction(test6), 0.0f);
    }

    /**
     * Test case for the multiplication method of the ArithmeticOperations class.
     */
    @Test
    public void multiplicationTest(){
        ArithmeticOperations arithmethic = new ArithmeticOperations();

        float[] test1 = new float[]{10, 2};
        assertEquals(20, arithmethic.multiplication(test1), 0.0f);

        float[] test2 = new float[]{1, 2, 3, 4};
        assertEquals(24, arithmethic.multiplication(test2), 0.0f);

        float[] test3 = new float[]{500, 29, 31, 49};
        assertEquals(22025500, arithmethic.multiplication(test3), 0.0f);
    }

    /**
     * Test case for the division method of the ArithmeticOperations class.
     */
    @Test
    public void divisionTest(){
        ArithmeticOperations arithmethic = new ArithmeticOperations();

        float[] test1 = new float[]{5, 2};
        assertEquals(2.5, arithmethic.division(test1), 0.0f);

        float[] test2 = new float[]{2.0f, 5.0f};
        assertEquals(0.4, arithmethic.division(test2), 0.0000001f);

        float[] test3 = new float[]{10, 4, 2, 1};
        assertEquals(1.25, arithmethic.division(test3), 0.0f);

        float[] test4 = new float[]{1, 2, 4, 10};
        assertEquals(0.0125, arithmethic.division(test4), 0.0000001f);

        float[] test5 = new float[]{500, 25, 5, 1};
        assertEquals(4, arithmethic.division(test5), 0.0000001f);

        float[] test6 = new float[]{100, 10, 10};
        assertEquals(1, arithmethic.division(test6), 0.0f);
    }
}
