//assignment 6
//pair 121
//Cowart, Edwin
//escowart
//Van Heemst, Jacob
//jjvh17

// This is a class representing a Cons List of Image Files
public class ConsLoIF implements ILoIF {

    public ImageFile first;
    public ILoIF rest;

    public ConsLoIF(ImageFile first, ILoIF rest) {
        this.first = first;
        this.rest = rest;
    }
    
    /* Template:
     * Fields:
     * this.first ... ImageFile
     * this.rest ... ILoIF
     * 
     * Methods:
     * this.contains(ImageFile that) ... boolean
     * this.insert(IIFComparator comp, ImageFile img) ... ILoIF
     * this.sortImageFiles(IIFComparator comp) ... ILoIF
     * 
     * Methods for Fields:
     * this.first.size() ... int ...
     * this.first.sameImageFile(ImageFile) ... boolean
     * this.rest.contains(ImageFile that) ... boolean
     * this.rest.insert(IIFComparator comp, ImageFile img) ... ILoIF
     * this.rest.sortImageFiles(IIFComparator comp) ... ILoIF
     */

    // Does this nonempty list contain that ImageFile
    public boolean contains(ImageFile that) {
        return (this.first.sameImageFile(that) || this.rest.contains(that));
    }

    // Insert the given Image Files into this cons list
    public ILoIF insert(IIFComparator comp, ImageFile img) {
        if (comp.compareImageFiles(img, this.first) <= 0)
            return new ConsLoIF(img, this);
        return new ConsLoIF(this.first, this.rest.insert(comp, img));
    }

    // Sort the empty list of Image Files based on the given comparer
    public ILoIF sortImageFiles(IIFComparator comp) {
        return this.rest.sortImageFiles(comp).insert(comp, this.first);
    }
}
