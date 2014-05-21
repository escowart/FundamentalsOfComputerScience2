//assignment 9
//pair 121
//Cowart, Edwin
//escowart
//Van Heemst, Jacob
//jjvh17

import tester.Tester;
import java.util.*;

public class ExamplesPermutationCode {

    PermutationCode randompc = new PermutationCode();
    ArrayList<Character> testarray = new ArrayList<Character>(Arrays.asList(
            'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p', 'a', 's', 'd',
            'f', 'g', 'h', 'j', 'k', 'l', 'z', 'x', 'c', 'v', 'b', 'n', 'm'));
    PermutationCode testpc = new PermutationCode(this.testarray);
    ArrayList<Character> alphaarray = new ArrayList<Character>(Arrays.asList(
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
            'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'));
    PermutationCode alphapc = new PermutationCode(this.alphaarray);

    public void testAll(Tester t) {
        // Empty Constructor
        t.checkExpect(this.randompc.code.size(), 26);
        for (int x = 0; x < 26; x++) {
            t.checkExpect(this.randompc.code.contains(this.randompc.alphabet
                    .get(x)));
        }

        // Encode
        t.checkExpect(this.testpc.encode("potatoe"), "hgzqzgt");
        t.checkExpect(this.alphapc.encode("potatoe"), "potatoe");
        t.checkExpect(this.testpc.decode("hgzqzgt"), "potatoe");
        t.checkExpect(this.alphapc.decode("potatoe"), "potatoe");

    }

}
