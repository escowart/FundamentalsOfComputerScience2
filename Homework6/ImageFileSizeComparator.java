//assignment 6
//pair 121
//Cowart, Edwin
//escowart
//Van Heemst, Jacob
//jjvh17

// This is a class representing an Comparator 
// that compares two Image File by their sizes
public class ImageFileSizeComparator implements IIFComparator {

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
    // returns -1 if the first image's size is smaller (ascending order)
    // returns 0 if the two image sizes are equal
    // returns 1 if the first image's size is larger
    public int compareImageFiles(ImageFile first, ImageFile second) {
        if (first.size() < second.size()) {
            return -1;
        } else if (first.size() == second.size()) {
            return 0;
        } else {
            return 1;
        }
    }
}
