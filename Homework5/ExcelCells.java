//assignment 5
//pair 027
//Cowart, Edwin
//escowart
//Bachiri, Zacharia
//bachiri

// This is a class representing a cell in an Excel spread sheet

public class ExcelCells {

    String column;
    int row;
    IData info;

    public ExcelCells(String column, int row, IData info) {
        this.column = column;
        this.row = row;
        this.info = info;
    }

    /* Template:
     * Fields:
     * this.column ... String
     * this.row    ... int
     * this.info   ... IData
     * 
     * Methods:
     * this.value()         ... int
     * this.same(Cell that) ... boolean
     * this.findAllArgs()   ... ILoC
     * this.countArgs()     ... int
     */
    
    // Compute the value of the cell
    public int value() {
        return this.info.value();
    }

    // Are the two Cells the same?
    public boolean same(ExcelCells that) {
        return this.column.equals(that.column) && (this.row == that.row)
                && this.info.same(that.info);
    }

    // Creates a list of all cell involved in computing the value of the cell
    public ILoC findAllArgs() {
        return  this.info.findAllArgs();
    }

    // Compute the number of cells involved in computing the value of the cell
    public int countArgs() {
        return this.findAllArgs().filterRepeats().length();
    }
}
