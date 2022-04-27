import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class ShakespeareFactoryTests {

    // Arrange
    String inputText = "Someday when I'm awfully low when the world is cold i will feel " +
            "a glow just thinking of you and the way you look tonight yes you're lovely " +
            "with your smile so warm";
    PoemFactory factory = new ShakespeareFactory();
    boolean verbose = true;

    private void print(String text){
        if(verbose){
            System.out.println(text);
        }
    }

    @Test
    public void ShakespeareFactory_WhenGivenText_BuildsPoem(){

        print("Testing poem composition ---------------");

        // Act
        Poem poem = factory.buildPoem(inputText);
        print("Poem created");

        // Assert
        assertNotNull("Poem is null", poem);
        String poemText = poem.getPoemText();
        assertNotNull("Poem text is null", poemText);
        print("Poem text: " + poemText);

        print("Poem composition test complete ---------");

    }

}
