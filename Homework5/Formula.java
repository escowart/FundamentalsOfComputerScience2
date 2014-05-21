//assignment 5
//pair 027
//Cowart, Edwin
//escowart
//Bachiri, Zacharia
//bachiri

// This is a class representing a formula inside an Excel cell

public class Formula implements IData {

    IOp op;
    ExcelCells first;
    ExcelCells second;

    public Formula(IOp op, ExcelCells first, ExcelCells second) {
        this.op = op;
        this.first = first;
        this.second = second;
    }

    /* Template:
     * Fields:
     * this.op    ... IOp
     * this.first ... ExcelCells
     * this.rest  ... ExcelCells
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
    
    // Compute the value of the cell
    public int value() {
        return this.op.operate(this.first.value(), 
                this.second.value());
    }

    // Creates a list of all cell involved in computing
    // the value of the formula
    public ILoC findAllArgs() {
        ILoC fa;
        ILoC fb;
        if (this.first.info.isNumber()) {
            fa = new ConsLoC(this.first, new MtLoC());
        } else {
            fa = this.first.findAllArgs();
        }
        if (this.second.info.isNumber()) {
            fb = new ConsLoC(this.second, new MtLoC());
        } else {
            fb = this.second.findAllArgs();
        }
        return fa.append(fb);
    }

    // Is the cell call and the given data the same
    public boolean same(IData that) {
        return that.sameFormula(this);
    }

    // Is the cell call an empty data
    public boolean sameEmptyData() {
        return false;
    }

    // Is the cell call and the given number the same
    public boolean sameNumber(Number that) {
        return false;
    }

    // Is the cell call and the given formula the same
    public boolean sameFormula(Formula that) {
        return this.op.equals(that.op) && this.first.same(that.first)
                && this.second.same(that.second);
    }

    // Is the Formula a Number
    public boolean isNumber() {
        return false;
    }
}
