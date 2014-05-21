
//assignment 11
//pair 121
//Cowart, Edwin
//escowart
//Van Heemst, Jacob
//jjvh17
import java.util.ArrayList;
import java.util.Comparator;

// This class represents a Heap Sorted Tree
public class PriorityQueue<T> {
    ArrayList<T> list;
    Comparator<T> comp;

    public PriorityQueue(Comparator<T> comp) {
        this.list = new ArrayList<T>();
        this.list.add(null);
        this.comp = comp;
    }
    
    /* Template:
     * Fields:
     * this.list ... ArrayList<T>
     * this.comp ... Comparator<T>
     * 
     * Methods:
     * this.isLeaf(int index) ... boolean
     * this.higherPriorityChild(int index) ... T
     * this.isOrdered() ... boolean
     * this.insert(T obj) ... void
     * this.remove() ... void
     * this.toString() ... String
     * this.hashCode() ... int
     */

    // Protected because someone could declare an invalid Priority Queue
    protected PriorityQueue(ArrayList<T> list, Comparator<T> comp) {
        this.list = list;
        this.comp = comp;
    }

    // Is the given node index's corresponding node is a Leaf
    public boolean isLeaf(int index) {
        int size = this.list.size();
        if (index <= 0 || index >= size)
            throw new RuntimeException("The node " + index
                    + " does not exist in the Heap");
        return 2 * index > size;
    }

    // Find the greater of the two children of the given node index
    public T higherPriorityChild(int index) {
        int size = this.list.size();
        if (index <= 0 || index >= size)
            throw new RuntimeException("The node " + index
                    + " does not exist in the Heap");
        if (this.isLeaf(index)) {
            throw new RuntimeException(
                    "The given index corresponds to a Leaf " +
                    "and does not have children");
        }
        T arg0 = list.get(2 * index);
        T arg1 = list.get(2 * index + 1);
        if (2 * index + 2 == size || comp.compare(arg0, arg1) >= 0)
            return arg0;
        return arg1;
    }

    // Is the Heap Ordered?
    public boolean isOrdered() {
        for (int i = 1; i < this.list.size(); i++) {
            if (i / 2 >= 1) {
                if (this.comp.compare(this.list.get(i), 
                        this.list.get(i / 2)) > 0) {
                    return false;
                }
            }
        }
        return true;
    }

    // Insert the given element into the Heap ArrayList
    public void insert(T obj) {
        int i = this.list.size();
        this.list.add(obj);
        while (!this.isOrdered()) {
            int j = i / 2;
            T temp = this.list.get(j);
            list.remove(i);
            list.add(i, temp);
            list.remove(j);
            list.add(j, obj);
            i = j;
        }
    }

    // Remove the first element of the Heap ArrayList
    public void remove() {
        this.list.remove(1);
        this.list.add(1, this.list.get(this.list.size() - 1));
        this.list.remove(this.list.size() - 1);
        int i = 1;
        T rep;
        while (!this.isOrdered()) {
            int j = i * 2;
            int k = i * 2 + 1;
            T temp = this.list.get(i);
            if (k < this.list.size()
                    && (this.comp.compare(this.list.get(j), 
                            this.list.get(k)) < 0)) {
                rep = this.list.get(k);
                list.remove(i);
                list.add(i, rep);
                list.remove(k);
                list.add(k, temp);
                i = k;
            } else {
                rep = this.list.get(j);
                list.remove(i);
                list.add(i, rep);
                list.remove(j);
                list.add(j, temp);
                i = j;
            }
        }
    }

    // Return the Class in String form.
    public String toString() {
        return "new PriorityQueue<T>(" + this.list.toString() + ", "
                + this.comp.toString() + ")";
    }

    // Return the hashCode of the Comparator
    public int hashCode() {
        return this.list.hashCode() + this.comp.hashCode();
    }
}
