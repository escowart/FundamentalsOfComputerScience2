//assignment 5
//pair 027
//Cowart, Edwin
//escowart
//Bachiri, Zacharia
//bachiri

// This is a interface for lists of cells

public class ConsLoC implements ILoC {

    ExcelCells first;
    ILoC rest;

    public ConsLoC(ExcelCells first, ILoC rest) {
        this.first = first;
        this.rest = rest;
    }

    /* Template:
     * Fields:
     * this.column ... String
     * this.row    ... int
     * 
     * Methods:
     * this.contains(Cell cell) ... boolean
     * this.filterRepeats()     ... ILoC
     * this.append(ILoC that)   ... ILoC
     * this.length()            ... int
     */

    // Does the cons list contains the Cell
    public boolean contains(ExcelCells cell) {
        if (this.first.same(cell))
            return true;
        return this.rest.contains(cell);
    }

    // Filter any repeats in the cons list
    public ILoC filterRepeats() {
        if (this.rest.contains(this.first))
            return this.rest.filterRepeats();
        return new ConsLoC(this.first, this.rest.filterRepeats());
    }

    // Append this cons list with that list
    public ILoC append(ILoC that) {
        return new ConsLoC(this.first, this.rest.append(that));
    }

    // Find the length of the cons list
    public int length() {
        return 1 + this.rest.length();
    }
}
