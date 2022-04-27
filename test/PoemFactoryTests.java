import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class PoemFactoryTests {

    // Arrange
    String inputText = "Once upon a <> midnight dreary while I pondered weak and weary";
    PoemFactory factory = new PoemFactory();
    boolean verbose = false;

    private void print(String text){
        if(verbose){
            System.out.println(text);
        }
    }

    @Test
    public void PoemFactory_WhenGivenText_BuildsPoem(){

        print("Testing poem composition ---------------");

        // Act
        Poem poem = factory.buildPoem(inputText);

        // Assert
        assertNotNull("Poem is null", poem);
        String poemText = poem.getPoemText();
        assertNotNull("Poem text is null", poemText);

        print("Poem composition test complete ---------");


    }

}