//assignment 9
//pair 121
//Cowart, Edwin
//escowart
//Van Heemst, Jacob
//jjvh17

import java.util.*;

/**
 * A class that defines a new permutation code, as well as methods for encoding
 * and decoding of the messages that use this code.
 */
public class PermutationCode {
    /** The original list of characters to be encoded */
    ArrayList<Character> alphabet = new ArrayList<Character>(Arrays.asList('a',
            'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n',
            'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'));

    ArrayList<Character> code = new ArrayList<Character>(26);

    /** A random number generator */
    Random rand = new Random();

    /**
     * Create a new instance of the encoder/decoder with a new permutation code
     */
    PermutationCode() {
        this.code = this.initEncoder();
    }

    /* Template:
     * Fields:
     * this.alphabet
     * this.code
     * this.rand
     * 
     * Methods:
     * this.initEcoder() ... ArrayList<Character>
     * this.encode(String source) ... String
     * this.decode(String source) ... String
     * 
     */
    /**
     * Create a new instance of the encoder/decoder with the given code
     */
    PermutationCode(ArrayList<Character> code) {
        this.code = code;
    }

    /** Initialize the encoding permutation of the characters */
    ArrayList<Character> initEncoder() {
        ArrayList<Character> arraylist = new ArrayList<Character>();
        ArrayList<Character> tempab = (ArrayList<Character>) this.alphabet
                .clone();
        for (int i = 0; i < 26; i++) {
            int randint = this.rand.nextInt(tempab.size());
            arraylist.add(tempab.get(randint));
            tempab.remove(randint);
        }
        return arraylist;
    }

    /**
     * produce an encoded <code>String</code> from the given <code>String</code>
     * 
     * @param source
     *            the <code>String</code> to encode
     * @return the secretly encoded <String>
     */
    public String encode(String source) {
        String str;
        for (str = ""; source.length() > 0; source = source.substring(1)) {
            str = str.concat(this.code.get(
                    this.alphabet.indexOf((source.charAt(0)))).toString());
        }
        return str;
    }

    /**
     * produce an decoded <code>String</code> from the given <code>String</code>
     * 
     * @param source
     *            the <code>String</code> to decode
     * @return the revealed <String>
     */
    public String decode(String source) {
        String str;
        for (str = ""; source.length() > 0; source = source.substring(1)) {
            str = str.concat(this.alphabet.get(
                    this.code.indexOf(source.charAt(0))).toString());
        }
        return str;
    }
}