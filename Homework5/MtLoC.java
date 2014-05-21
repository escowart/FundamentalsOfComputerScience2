//assignment 5
//pair 027
//Cowart, Edwin
//escowart
//Bachiri, Zacharia
//bachiri

// This is a class representing for the empty list of cells

public class MtLoC implements ILoC {

    public MtLoC() {

    }

    /*
     * Template: 
     * Fields: none 
     * Methods: 
     * this.contains(Cell cell) ... boolean
     * this.filterRepeats()     ... ILoC
     * this.append(ILoC that)   ... ILoC
     * this.length()            ... int
     */

    // Does the empty list contain the cell?
    public boolean contains(ExcelCells cell) {
        return false;
    }

    // Filter any repeats in the empty list
    public ILoC filterRepeats() {
        return this;
    }

    // Append this empty list with that list
    public ILoC append(ILoC that) {
        return that;
    }

    // Find the length of the empty list
    public int length() {
        return 0;
    }
}
