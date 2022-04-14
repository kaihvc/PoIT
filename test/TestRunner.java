import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

class TestJUnit {

    @Test
    public void testAdd(){
        String str = "JUnit works!";
        assertEquals("JUnit works!", str);
    }

}

public class TestRunner {

    public static void main(String[] args){
        Result result = JUnitCore.runClasses(PoemSectionTests.class);
        
        for(Failure failure : result.getFailures()){
            System.out.println(failure.toString());
        }

        System.out.println(result.wasSuccessful());

    }

}
