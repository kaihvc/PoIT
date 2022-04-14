import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

public class PoemSectionTests {

    private void print(String text){
        System.out.println(text);
    }

    // Mass arrange
    String[] wordTexts = new String[]{"Once", "upon", "a", "midnight"};
    int[] syllableCounts = new int[]{1, 2, 1, 2};
    Word[] words = new Word[wordTexts.length];
    Line[] lines = new Line[2];
    Stanza stanza;
    PoemTree poemTree;

    public PoemSectionTests(){
        for(int i = 0; i < wordTexts.length; i++){
            words[i] = new Word(wordTexts[i]);
        }
        lines[0] = new Line(new ArrayList<PoemSection>(Arrays.asList(words[0], words[1])));
        lines[1] = new Line(new ArrayList<PoemSection>(Arrays.asList(words[2], words[3])));
        stanza = new Stanza(new ArrayList<PoemSection>(Arrays.asList(lines[0], lines[1])));
        poemTree = new PoemTree(new ArrayList<PoemSection>(Arrays.asList(stanza, stanza)));
    }

    @Test
    public void PoemSection_WordInitialized_CorrectTextNumSyllables(){

        print("Testing word initialization ----------------");
        for(int i = 0; i < words.length; i++){
            print(words[i].getText() + ", " + words[i].getNumSyllables());
            assertEquals(words[i].getText(), wordTexts[i]);
            assertEquals(words[i].getNumSyllables(), syllableCounts[i]);
        }
        print("Word init testing complete -----------------");

    }

    @Test
    public void PoemSection_LineInitialized_CorrectTextNumSyllables(){

        print("Testing line initialization ----------------");

        String[] checkTexts = new String[]{"Once upon", "a midnight"};
        int[] checkSyllableCounts = new int[]{3, 3};

        for(int i = 0; i < lines.length; i++){
            print(lines[i].getText() + ", " + lines[i].getNumSyllables());
            assertEquals(lines[i].getText(), checkTexts[i]);
            assertEquals(lines[i].getNumSyllables(), checkSyllableCounts[i]);
        }

        print("Line init testing complete -----------------");

    }

    @Test
    public void PoemSection_StanzaInitialized_CorrectTextNumSyllables(){

        print("Testing stanza initialization ----------------");

        print(stanza.getText() + ", " + stanza.getNumSyllables());
        assertEquals(stanza.getText(), "Once upon\na midnight");
        assertEquals(stanza.getNumSyllables(), 6);

        print("Stanza init testing complete -----------------");

    }

    @Test
    public void PoemSection_TreeInitialized_CorrectTextNumSyllables(){

        print("Testing tree initialization ----------------");

        print(poemTree.getText() + ", " + poemTree.getNumSyllables());
        assertEquals(poemTree.getText(), "Once upon\na midnight\n\nOnce upon\na midnight");
        assertEquals(poemTree.getNumSyllables(), 12);

        print("Tree init testing complete -----------------");

    }

}
