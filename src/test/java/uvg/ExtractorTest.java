package uvg;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Map;

public class ExtractorTest {
    
    /**
     * Tests the getSimpleExtraction method.
     */
    @Test
    public void testGetSimpleExtraction() {
        String inputString = "(+ 3 7)";
        ArrayList<SimpleExtractionPair> result = Extractor.getSimpleExtraction(inputString);
        assertNotNull(result);
        assertEquals(1, result.size());
        SimpleExtractionPair pair = result.get(0);
        assertEquals(SimpleExtraction.ADDITION, pair.getKeyword());
        assertEquals("1 2", pair.getCommand());
    }

    /**
     * Tests the getCompoundExtractionGroups method.
     */
    @Test
    public void testGetCompoundExtractionGroups() {
        String inputString = "(if (> x 0) (* x 2) (* x -1))";
        ArrayList<String> result = Extractor.getCompoundExtractionGroups(inputString);
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("(> x 0) (* x 2) (* x -1)", result.get(0));
    }

    /**
     * Tests the getCompoundExtractionType method.
     */
    @Test
    public void testGetCompoundExtractionType() {
        String inputString = "(if (> x 0) (* x 2) (* x -1))";
        CompoundExtraction result = Extractor.getCompoundExtractionType(inputString);
        assertEquals(CompoundExtraction.IF, result);
    }

    /**
     * Tests the getCompoundExtractionPairs method.
     */
    @Test
    public void testGetCompoundExtractionPairs() {
        ArrayList<String> groupsArr = new ArrayList<>();
        groupsArr.add("(> x 0)");
        groupsArr.add("(* x 2)");
        groupsArr.add("(* x -1)");

        Map<String, String[]> result = Extractor.getCompoundExtractionPairs(groupsArr);
        
        assertNotNull(result);
        assertEquals(3, result.size());

        assertTrue(result.containsKey("(> x 0)"));
        assertTrue(result.containsKey("(* x 2)"));
        assertTrue(result.containsKey("(* x -1)"));

        assertArrayEquals(new String[0], result.get("(> x 0)"));
        assertArrayEquals(new String[0], result.get("(* x 2)"));
        assertArrayEquals(new String[0], result.get("(* x -1)"));
    }
}
