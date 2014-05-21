import java.util.ArrayList;
import java.util.Comparator;

// A class representing Algorithms that may be called upon
public class Algorithms {

    public Algorithms() {

    }

    /*
     * Template: 
     * Field: none 
     * 
     * Methods: 
     * this.binarySearch(int low, int high,ArrayList<T> list,
     *                   Comparator<T> comp, T obj) ... int
     *                   
     * Methods for Fields: none
     */

    // Binary Search for the given object in the given list and return the index
    // it is located in and -1 otherwise
    public <T> int binarySearch(int low, int high, ArrayList<T> list,
            Comparator<T> comp, T obj) {
        int mid = (low + high) / 2;
        if (high < low)
            return -1;
        else if (comp.compare(list.get(mid), obj) == 0)
            return mid;
        else if (comp.compare(list.get(mid), obj) < 0)
            return binarySearch(mid + 1, high, list, comp, obj);
        else
            return binarySearch(low, mid - 1, list, comp, obj);
    }
}
