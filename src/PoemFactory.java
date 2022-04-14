import java.util.ArrayList;
import java.util.Random;

public class PoemFactory{

    protected Poem poem; // necessary?

    public PoemFactory(){}

    // TODO: if Poems aren't too bulky, add their PoemTrees as members
    protected Poem buildPoem(String text){
        Poem newPoem = new Poem(text);
        ArrayList<PoemSection> words = decomposeText(text);
        String poemText = composePoemTree(words).getText();
        newPoem.setPoemText(poemText);
        return newPoem;
    }

    public ArrayList<PoemSection> decomposeText(String text){

        ArrayList<PoemSection> words = new ArrayList<PoemSection>();
        String[] textWords = text.split(" ");
        for(String w : textWords){
            words.add((PoemSection) (new Word(w)));
        }

        return words;

    }

    protected Line endLine(ArrayList<PoemSection> currentLine){

        currentLine.add(new Word("\n"));
        Line returnLine = new Line(currentLine);
        currentLine.clear();
        return returnLine;

    }

    protected Stanza endStanza(ArrayList<PoemSection> currentStanza){

        // Add empty line with newline character
        Line lastLine = endLine(new ArrayList<PoemSection>());
        currentStanza.add(lastLine);
        Stanza returnStanza = new Stanza(currentStanza);
        currentStanza.clear();
        return returnStanza;

    }

    // Might be better as a string
    protected PoemTree composePoemTree(ArrayList<PoemSection> sections){

        // Random
        Random rand = new Random();
        ArrayList<PoemSection> poemTree = new ArrayList<PoemSection>();
        ArrayList<PoemSection> currentStanza = new ArrayList<PoemSection>();
        ArrayList<PoemSection> currentLine = new ArrayList<PoemSection>();

        int avgLineLength = 5;
        int avgStanzaLength = 4;

        for(PoemSection p : sections){

            currentLine.add(p);


            if(rand.nextInt(avgLineLength) == 1){
                currentStanza.add(endLine(currentLine));

                if(rand.nextInt(avgStanzaLength) == 1){
                    poemTree.add(endStanza(currentStanza));
                }

            }

        }

        return new PoemTree(poemTree);

    }

}

class LimerickFactory extends PoemFactory{

    protected Poem poem; // necessary?

    public LimerickFactory(){}

    // NOTE: unnecessary
    protected Poem buildPoem(String text){
        Poem newPoem = new Poem(text);
        String poemText = text;
        newPoem.setPoemText(poemText);
        return newPoem;
    }

}

class ShakespeareFactory extends PoemFactory{

    protected Poem poem; // necessary?

    public ShakespeareFactory(){}

    protected Poem buildPoem(String text){
        Poem newPoem = new Poem(text);
        String poemText = text;
        newPoem.setPoemText(poemText);
        return newPoem;
    }

}

class HaikuFactory extends PoemFactory{

    protected Poem poem; // necessary?

    public HaikuFactory(){}

    protected Poem buildPoem(String text){
        Poem newPoem = new Poem(text);
        String poemText = text;
        newPoem.setPoemText(poemText);
        return newPoem;
    }

}

