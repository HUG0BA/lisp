package uvg;

import static org.junit.Assert.*;

import java.util.AbstractMap.SimpleEntry;

import org.junit.Test;

public class TokenizerTest {

     @Test
     public void tokenizersTest() {
          String input = "+ 2 3 7 7 7";
          SimpleEntry<String, float[]> result = Tokenizer.numberTokenizer(input);
          String symbol = result.getKey();
          float[] tokens = result.getValue();

          //assertEquals("+", symbol);

          float[] expectedTokens = { 2, 3, 7, 7, 7 };

          assertEquals(expectedTokens, tokens);
     }
}
