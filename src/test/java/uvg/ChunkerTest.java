package uvg;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class ChunkerTest {
    @Test
    public void getChunksTest(){
        Chunker chunker = new Chunker();

        ArrayList<String> test = chunker.getChunks("(defun factorial (n)(if (= n 0) 1 (* n (factorial (- n 1))))) (write (factorial 10)) (+ 1 23 234(* 3232 32 3 (- 333 34)) 23)");
        String[] expectedArr = new String[]{"(defun factorial (n)(if (= n 0) 1 (* n (factorial (- n 1)))))", "(write (factorial 10))", "(+ 1 23 234(* 3232 32 3 (- 333 34)) 23)"};
        for(int i = 0; i < test.size() - 1; i++){
            assertTrue(test.get(i).equals(expectedArr[i]));
        }
    }
}
