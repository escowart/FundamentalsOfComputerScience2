//assignment 5
//pair 027
//Cowart, Edwin
//escowart
//Bachiri, Zacharia
//bachiri

// This is a interface for the data in an Excel cell

public interface IData {

    // Compute the value of the data
    public int value();
    
    // Creates a list of all cell involved in computing the value of the data
    public ILoC findAllArgs();
    
    // Is the data and the given data the same
    public boolean same(IData that);
    
    // Is the data an empty data
    public boolean sameEmptyData();
    
    // Is the data and the given number the same 
    public boolean sameNumber(Number that);
    
    // Is the data and the given formula the same 
    public boolean sameFormula(Formula that);
    
    // Is the IData a Number
    public boolean isNumber();
}
