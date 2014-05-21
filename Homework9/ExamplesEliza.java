//assignment 9
//pair 121
//Cowart, Edwin
//escowart
//Van Heemst, Jacob
//jjvh17
import java.util.ArrayList;

import tester.Tester;

public class ExamplesEliza {
    Eliza eliza = new Eliza();

    public void testAll(Tester t) {
        ArrayList<String> arraylist = new ArrayList<String>();
        arraylist.add("Because");
        arraylist.add("Because Its time");
        arraylist.add("'Cause");

        t.checkExpect(arraylist.contains(eliza.firstWord("Why are you here?")));
        t.checkExpect(eliza.firstWord("Hmm"),
                "I do not know or Why do you want to know?");
    }
}
