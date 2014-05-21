//assignment 9
//pair 121
//Cowart, Edwin
//escowart
//Van Heemst, Jacob
//jjvh17
import java.util.Comparator;

// Compares two Integers
public class IntegerComparator implements Comparator<Integer> {

    /* Template:
     * Fields: none
     * 
     * Methods:
     * this.compare(Integer one, Integer two) ... int
     * 
     * Methods for Fields: none
     */
    
    // Returns negative if one is less than two
    // Returns zero if the two fractions are equivalent
    // Returns positive if one is greater than two
    @Override
    public int compare(Integer one, Integer two) {
        return one - two;
    }
}
