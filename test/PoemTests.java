import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class PoemTests {

    String originalText = "Once upon a midnight dreary";
    String poemText = "Once upon\na midnight dreary";
    boolean verbose = false;

    private void print(String text){
        if(verbose){
            System.out.println(text);
        }
    }

    @Test
    public void Poem_OnInit_SetsText(){

        print("Testing Poem text ---------");
        Poem poem = new Poem(originalText);
        poem.setPoemText(poemText);
        print(poem.getPoemText() + " : \n" + poemText);
        print(poem.getOriginalText() + " : " + originalText);
        assertEquals(poem.getOriginalText(), originalText);
        assertEquals(poem.getPoemText(), poemText);
        print("Poem text test complete ---");

    }

}
