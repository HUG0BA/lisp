package uvg;

import static org.junit.Assert.*;

import java.util.AbstractMap.SimpleEntry;

import org.junit.Test;

public class TokenizerTest {

     @Test
     public void tokenizersTest() {
          String input = "+ 2 3 7 7 7";
          SimpleEntry<String, float[]> result = Tokenizer.tokenizers(input);
          float[] tokens = result.getValue();
          String symbol = result.getKey();

          assertEquals("+", symbol);

          float[] expectedTokens = { 2f, 3f, 7f, 7f, 7f };

          assertEquals(expectedTokens.length, tokens.length);
     }
}
