

//assignment 11
//pair 121
//Cowart, Edwin
//escowart
//Van Heemst, Jacob
//jjvh17
import java.util.Comparator;

// This class represents an Integer Comparator.
public class IntegerComparator implements Comparator<Integer> {

    /* Template:
     * Fields: none     
     * 
     * Methods:
     * this.compare(Integer o1, Integer o2) ... int
     * this.toString() ... String
     * this.hashCode() ... int
     */
    
    // Returns the comparator of the two integers by subtracting them
    public int compare(Integer o1, Integer o2) {
        return o1 - o2;
    }

    // Return the Class in String form.
    public String toString() {
        return "new IntegerComparator()";
    }

    // Return the hashCode of the Comparator
    public int hashCode() {
        return this.toString().hashCode() + 1;
    }
}
