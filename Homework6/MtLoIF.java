//assignment 6
//pair 121
//Cowart, Edwin
//escowart
//Van Heemst, Jacob
//jjvh17

// This is a class representing an Empty List of Image Files
class MtLoIF implements ILoIF {

    MtLoIF() {
    }

    /* Template:
     * Fields: none
     * 
     * Methods:
     * this.contains(ImageFile that) ... boolean
     * this.insert(IIFComparator comp, ImageFile img) ... ILoIF
     * this.sortImageFiles(IIFComparator comp) ... ILoIF
     * 
     * Methods for Fields: none
     */
    
    // Does this empty list contain that ImageFile
    public boolean contains(ImageFile that) {
        return false;
    }

    // Insert the given Image Files into this cons list
    public ILoIF insert(IIFComparator comp, ImageFile img) {
        return new ConsLoIF(img, this);
    }

    // Sort the empty list of Image Files based on the given comparer
    public ILoIF sortImageFiles(IIFComparator comp) {
        return this;
    }

}
