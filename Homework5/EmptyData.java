//assignment 5
//pair 027
//Cowart, Edwin
//escowart
//Bachiri, Zacharia
//bachiri

// This is a class representing the data in an excel cell when it is empty

public class EmptyData implements IData {

    public EmptyData() {

    }

    /*
     * Template: 
     * Fields: none 
     * Methods: 
     * this.value(ILoC list) ... int
     * this.findAllArgs(ILoC list) ... ILoC 
     * this.same(IData that) ... boolean
     * this.sameEmptyData() ... boolean 
     * this.sameNumber(Number that) ... boolean
     * this.sameFormula(Formula that) ... boolean 
     * this.sameCellCall(CellCall that) ... boolean
     */

    // Compute the value of the empty data
    public int value() {
        return 0;
    }

    // Creates a list of all cell involved in computing
    // the value of the empty data
    public ILoC findAllArgs() {
        return new MtLoC();
    }

    // Is the cell call and the given data the same
    public boolean same(IData that) {
        return that.sameEmptyData();
    }

    // Is the cell call an empty data
    public boolean sameEmptyData() {
        return true;
    }

    // Is the cell call and the given number the same
    public boolean sameNumber(Number that) {
        return false;
    }

    // Is the cell call and the given formula the same
    public boolean sameFormula(Formula that) {
        return false;
    }

    // Is the EmptyData a Number
    public boolean isNumber() {
        return false;
    }
}
