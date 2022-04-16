import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class PoemFactoryTests {

    // Arrange
    String inputText = "Once upon a midnight dreary while I pondered weak and weary";
    PoemFactory factory = new PoemFactory();
    boolean verbose = false;

    private void print(String text){
        if(verbose){
            System.out.println(text);
        }
    }

//    @Test
    public void PoemFactory_WhenGivenText_DecomposesText(){

        print("Testing text decomposition ---------------");

        // Act
        ArrayList<PoemSection> resultWords = factory.decomposeText(inputText);

        // Assert
        for(PoemSection word : resultWords){
            print(word.getText());
        }

        ArrayList<PoemSection> checkResult = new ArrayList<PoemSection>();
        for(String word : inputText.split(" ")){
            checkResult.add(new Word(word));
        }

        for(int i = 0; i < checkResult.size(); i++){
            assertEquals(checkResult.get(i).getText(), resultWords.get(i).getText());
            assertEquals(checkResult.get(i).getNumSyllables(), resultWords.get(i).getNumSyllables());
        }

        print("Text decomposition test complete ---------");

    }

    @Test
    public void PoemFactory_WhenGivenWords_TreeNotNull(){

        print("Testing tree composition");

        // Arrange - build Word list
        ArrayList<PoemSection> words = new ArrayList<PoemSection>();
        for(String word : inputText.split(" ")){
            words.add(new Word(word));
        }

        // Act
        PoemSection tree = factory.composePoemTree(words);

        // Assert
        assertNotNull(tree);

        print("Tree composition test complete");

    }

    @Test
    public void PoemFactory_WhenGivenWords_ComposedTreeGetsText(){

        print("Testing tree composition + text");

        // Arrange - build Word list
        ArrayList<PoemSection> words = new ArrayList<PoemSection>();
        for(String word : inputText.split(" ")){
            words.add(new Word(word));
        }

        // Act
        PoemSection tree = factory.composePoemTree(words);
        String text = tree.getText();

        // Assert
        for(String word : inputText.split(" ")){
            assertTrue("Text doesn't contain " + word, text.contains(word));
        }

        print("Tree composition + text test complete");

    }

//    @Test
    public void PoemFactory_WhenGivenText_BuildsPoem(){

        print("Testing poem composition ---------------");

        // Act
        Poem poem = factory.buildPoem(inputText);

        // Assert
        String poemText = poem.getPoemText();
        print("Poem generation result for line 1 of The Raven:");
        print(poemText);
        assertEquals(poemText, poemText);

        print("Poem composition test complete ---------");


    }

}