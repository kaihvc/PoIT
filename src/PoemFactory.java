import java.util.ArrayList;
import java.util.Random;

public class PoemFactory{

    public PoemFactory(){}

    // TODO: if Poems aren't too bulky, add their PoemTrees as members
    public Poem buildPoem(String text){
        Poem newPoem = new Poem(text);
        ArrayList<PoemSection> words = decomposeText(text);
        String poemText = composePoemTree(words).getText();
        newPoem.setPoemText(poemText);
        return newPoem;
    }

    // TODO: set to private
    private ArrayList<PoemSection> decomposeText(String text){

        ArrayList<PoemSection> words = new ArrayList<PoemSection>();
        String[] textWords = text.split(" "); // TODO: make it deal with newlines etc.
        for(String w : textWords){
            words.add((PoemSection) (new Word(w)));
        }

        return words;

    }

    // Might be better as a string
    // TODO: set to private
    private PoemTree composePoemTree(ArrayList<PoemSection> sections){

        // Random
        Random rand = new Random();
        ArrayList<PoemSection> poemTreeComponents = new ArrayList<PoemSection>();
        ArrayList<PoemSection> currentStanzaComponents = new ArrayList<PoemSection>();
        ArrayList<PoemSection> currentLineComponents = new ArrayList<PoemSection>();

        int avgLineLength = 5;
        int avgStanzaLength = 4;

        for(PoemSection p : sections){

            currentLineComponents.add(p);

            if(rand.nextInt(avgLineLength) == 0 && !currentLineComponents.isEmpty()){

                currentStanzaComponents.add(new Line(new ArrayList<>(currentLineComponents)));
                currentLineComponents.clear();

                if(rand.nextInt(avgStanzaLength) == 0 && !currentStanzaComponents.isEmpty()){
                    poemTreeComponents.add(new Stanza(new ArrayList<>(currentStanzaComponents)));
                    currentStanzaComponents.clear();
                }

            }

        }

        if(!currentLineComponents.isEmpty()) {
            currentStanzaComponents.add(new Line(new ArrayList<>(currentLineComponents)));
            currentLineComponents.clear();
        }
        if(!currentStanzaComponents.isEmpty()){
            poemTreeComponents.add(new Stanza(new ArrayList<>(currentStanzaComponents)));
            currentStanzaComponents.clear();
        }

        return new PoemTree(poemTreeComponents);

    }

}

class LimerickFactory extends PoemFactory{

    public LimerickFactory(){}

    // NOTE: unnecessary
    public Poem buildPoem(String text){
        Poem newPoem = new Poem(text);
        String poemText = text;
        newPoem.setPoemText(poemText);
        return newPoem;
    }

}

class ShakespeareFactory extends PoemFactory{

    public ShakespeareFactory(){}

    public Poem buildPoem(String text){
        Poem newPoem = new Poem(text);
        String poemText = text;
        newPoem.setPoemText(poemText);
        return newPoem;
    }

}

class HaikuFactory extends PoemFactory{

    public HaikuFactory(){}

    public Poem buildPoem(String text){
        Poem newPoem = new Poem(text);
        String poemText = text;
        newPoem.setPoemText(poemText);
        return newPoem;
    }

}

