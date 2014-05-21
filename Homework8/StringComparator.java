import java.util.Comparator;

//A class representing an String Comparator
public class StringComparator implements Comparator<String> {
    
    /*
     * Template: 
     * Field: none 
     * 
     * Methods: 
     * this.compare(String one, String two) ... int
     * 
     * Methods for Fields: none
     */
    
    // Compare the two string and returns
    // -1 if one comes before two alphabetically
    // 0 if one comes before two alphabetically
    // 1 if one comes before two alphabetically
    public int compare(String one, String two) {
        return one.compareTo(two);
    }

}
