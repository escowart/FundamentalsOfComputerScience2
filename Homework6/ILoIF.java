/*
 *         +----------------------------------+
 *         |               ILoIF              |
 *         +----------------------------------+
 *         | boolean contains(ImageFile that) |
 *         +--------------+-------------------+
 *                       / \
 *                      +---+
 *                        |
 *          +-------------+-----------+
 *          |                         |
 *  +---------------+        +-------------------+
 *  |     MTLoIF    |        |     ConsLoIF      |
 *  +---------------+        +-------------------+
 *  +---------------+     +--| ImageFile  first  |
 *                        |  | ILoIF      rest   |
 *                        |  +-------------------+
 *                        v
 *               +---------------+
 *               | ImageFile     |
 *               +---------------+
 *               | String name   |
 *               | int    width  |
 *               | int    height |
 *               | String kind   |
 *               +---------------+
 */

//assignment 6
//pair 121
//Cowart, Edwin
//escowart
//Van Heemst, Jacob
//jjvh17

// This is an interface representing List of Image Files
public interface ILoIF {

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
    
    // Does this list contain that ImageFile
    public boolean contains(ImageFile that);

    // Insert the given Image Files into this list
    public ILoIF insert(IIFComparator comp, ImageFile img);

    // Sort the list of Image Files based on the given comparer
    public ILoIF sortImageFiles(IIFComparator comp);
}
