package uvg;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws FileNotFoundException, IOException
    {
        /*FileManager fileManger = new FileManager();
        ArrayList<String> test = fileManger.readTXTFile("example.txt");

        for(String str : test){
            System.out.println(str);
        }*/

        Chunker chunker = new Chunker();

        ArrayList<String> test = chunker.getChunks("(defun factorial (n)(if (= n 0) 1 (* n (factorial (- n 1))))) (write (factorial 10)) (+ 1 23 234(* 3232 32 3 (- 333 34)) 23)");
        for(String str : test){
            System.out.println(str);
        }
        
        /*String str = "(+ 1 23 234(* 3232 32 3 (- 333 34)) 23)";
        Tokenizer tokenizer = new Tokenizer();
        List<String> tokens = tokenizer.tokenizer(str);
        System.out.println(tokens);
  
        ArithmeticOperations operation = new ArithmeticOperations();*/
        //int result = operation.evaluatePrefix(tokens);
        //System.out.println(result);


        System.out.println(9 % 4);
        System.out.println(-9 % 4); 

        Tokenizer.quoteFunctionTokenizer("(quote x)");
        Tokenizer.quoteSignTokenizer("'x");

        Tokenizer.setqTokenizer("(quote x)");
    }
}
