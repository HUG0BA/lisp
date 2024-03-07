package uvg;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

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

        ArrayList<String> test = chunker.getChunks("(defun factorial (n)(if (= n 0) 1 (* n (factorial (- n 1))))) (write (factorial 10))");
        for(String str : test){
            System.out.println(str);
        }


    }
}
