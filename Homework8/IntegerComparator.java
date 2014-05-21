import java.util.Comparator;

// A class representing an Integer Comparator
public class IntegerComparator implements Comparator<Integer> {

    /*
     * Template: 
     * Field: none 
     * 
     * Methods: 
     * this.compare(Integer one, Integer two) ... int
     * 
     * Methods for Fields: none
     */
    
    // Compare the two integer and return the difference between the two
    public int compare(Integer one, Integer two) {
        return one - two;
    }

}
