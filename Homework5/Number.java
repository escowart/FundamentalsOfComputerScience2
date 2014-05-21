//assignment 5
//pair 027
//Cowart, Edwin
//escowart
//Bachiri, Zacharia
//bachiri

// This is a class representing a number data for the Excel cells

public class Number implements IData {

    int num;

    public Number(int num) {
        this.num = num;
    }

    /*
     * Template: 
     * Fields: 
     * this.num ... int
     * 
     * Methods: 
     * this.value()                     ... int 
     * this.findAllArgs()               ... ILoC 
     * this.same(IData that)            ... boolean 
     * this.sameEmptyData()             ... boolean
     * this.sameNumber(Number that)     ... boolean 
     * this.sameFormula(Formula that)   ... boolean 
     * this.sameCellCall(CellCall that) ... boolean
     */

    // Compute the number
    public int value() {
        return this.num;
    }

    // Creates a list of all cell involved in computing the value of the number
    public ILoC findAllArgs() {
        return new MtLoC();
    }

    // Is the cell call and the given data the same
    public boolean same(IData that) {
        return that.sameNumber(this);
    }

    // Is the cell call an empty data
    public boolean sameEmptyData() {
        return false;
    }

    // Is the cell call and the given number the same
    public boolean sameNumber(Number that) {
        return this.num == that.num;
    }

    // Is the cell call and the given formula the same
    public boolean sameFormula(Formula that) {
        return false;
    }

    // Is the Number a Number
    public boolean isNumber() {
        return true;
    }
}
