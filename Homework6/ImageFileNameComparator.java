//assignment 6
//pair 121
//Cowart, Edwin
//escowart
//Van Heemst, Jacob
//jjvh17

// This is a class representing an Comparator 
// that compares two Image File by their names
public class ImageFileNameComparator implements IIFComparator {

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
    // returns -1 if the first image's name comes first in alphabetical order
    // returns 0 if the two image names are equal
    // returns 1 if the second image's name comes first in alphabetical order
    public int compareImageFiles(ImageFile first, ImageFile second) {
        return first.name.compareTo(second.name);
    }

}
