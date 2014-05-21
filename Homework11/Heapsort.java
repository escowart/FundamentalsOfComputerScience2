

//assignment 11

//pair 121
//Cowart, Edwin
//escowart
//Van Heemst, Jacob
//jjvh17
import java.util.ArrayList;
import java.util.Comparator;

// This class represents a heap sort.
public class Heapsort<T> extends SortingHeapSort<T> {

    /* Template:
     * Fields:
     * this.alist ... ArrayList<T>
     * 
     * Methods:
     * this.init(ArrayList<T> alistin) ... void
     * this.sort(Comparator<T> comp) ... void
     * this.heapsort(ArrayList<T> alist, Comparator<T> comp) ... ArrayList<T>
     * this.toString() ... String
     * this.hashCode() ... int
     */
    
    // Heap Sort the given list given the comparator
    public ArrayList<T> heapsort(ArrayList<T> alist, Comparator<T> comp) {
        PriorityQueue<T> sort = new PriorityQueue<T>(comp);
        while (!alist.isEmpty()) {
            sort.insert(alist.get(0));
            alist.remove(0);
        }
        alist = sort.list;
        alist.remove(0);
        return alist;
    }

    // Return the Class in String form.
    public String toString() {
        return "new Heapsort()";
    }

    // Return the hashCode of the Comparator
    public int hashCode() {
        return this.toString().hashCode();
    }
}