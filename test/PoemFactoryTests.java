import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class PoemFactoryTests {

    @Test
    public void PoemFactory_WhenGivenText_DecomposesText(){
        // Arrange
        String inputText = "Once upon a midnight dreary while I pondered weak and weary";
        PoemFactory factory = new PoemFactory();

        // Act
        ArrayList<PoemSection> resultWords = factory.decomposeText(inputText);

        // Assert
        System.out.println("Results:");
        for(PoemSection word : resultWords){
            System.out.print(word.getText());
        }
        System.out.print("\n");
        ArrayList<PoemSection> checkResult = new ArrayList<PoemSection>();
        for(String word : inputText.split(" ")){
            checkResult.add(new Word(word));
        }
        assertEquals(checkResult, resultWords);
    }

    @Test
    public void PoemFactory_WhenGivenText_BuildsPoem(){
        // Arrange
        String inputText = "Once upon a midnight dreary while I pondered weak and weary";
        PoemFactory factory = new PoemFactory();

        // Act
        Poem result = factory.buildPoem(inputText);

        // Assert
        String poemText = result.getPoemText();
        System.out.println("Poem generation result for line 1 of The Raven:");
        System.out.println(poemText);
        assertEquals(poemText, poemText);

    }

}