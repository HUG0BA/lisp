package uvg;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AtomTest {

     /**
     * Test case for the evaluateAtom method of the Atom class.
     */
     @Test
     public void getValueTest() {
          Atom atom = new Atom();
          assertEquals(true, atom.evaluateAtom("'123"));
          assertEquals(false, atom.evaluateAtom("(1 2 3 4)"));
          assertEquals(true, atom.evaluateAtom("+ 1 2 3"));
     }
}
