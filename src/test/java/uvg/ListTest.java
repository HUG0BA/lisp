package uvg;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ListTest {
     /**
     * Tests the evaluateList method of the List class.
     */
     @SuppressWarnings("deprecation")
     @Test
     public void evaluateListTest(){
          List list = new List();

          String input = "e a s";
          String[] expected = {"e", "a", "s"};

          assertEquals(input, list.evaluateList(expected));

     }
}
