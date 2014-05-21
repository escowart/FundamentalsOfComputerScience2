//assignment 5
//pair 027
//Cowart, Edwin
//escowart
//Bachiri, Zacharia
//bachiri

// This is an interface for the list of cells

public interface ILoC {

    // Does the list contain the cell?
    public boolean contains(ExcelCells cell);
    
    // Filter any repeats in the list
    public ILoC filterRepeats();
    
    // Append this list with that list
    public ILoC append(ILoC that);
    
    // Find the length of the list
    public int length();
}
