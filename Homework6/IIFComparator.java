//assignment 6
//pair 121
//Cowart, Edwin
//escowart
//Van Heemst, Jacob
//jjvh17

// This is an interface representing Image File Comparator
public interface IIFComparator {

    /* Template:
     * Fields: none
     * 
     * Methods:
     * this.compareImageFiles(ImageFile first, ImageFile second) ... int
     * 
     * Methods for Fields: none
     * 
     */
    
    // Compare two image files.
    // returns -1 if the two image files are in order
    // returns 0 if the two image files are equal in the way
    // they are being tested
    // returns 1 if the two image files are not in order
    public int compareImageFiles(ImageFile first, ImageFile second);
}
