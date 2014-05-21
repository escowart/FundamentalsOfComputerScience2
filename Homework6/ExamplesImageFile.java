//assignment 6
//pair 121
//Cowart, Edwin
//escowart
//Van Heemst, Jacob
//jjvh17

// This is a class is for creating Image File examples and testing them
import tester.*;

public class ExamplesImageFile {

    public ExamplesImageFile() {
    }

    // Sample data to be used for all tests
    public ImageFile img1 = new ImageFile("dog", 300, 200, "jpg");
    public ImageFile img2 = new ImageFile("cat", 200, 200, "png");
    public ImageFile img3 = new ImageFile("bird", 250, 200, "jpg");
    public ImageFile img4 = new ImageFile("horse", 300, 300, "giff");
    public ImageFile img5 = new ImageFile("goat", 100, 200, "giff");
    public ImageFile img6 = new ImageFile("cow", 150, 200, "jpg");
    public ImageFile img7 = new ImageFile("snake", 200, 300, "jpg");

    // empty list
    public ILoIF mt = new MtLoIF();

    // ImageFile list -- all Images
    public ILoIF imglistall = new ConsLoIF(this.img1, new ConsLoIF(this.img2,
            new ConsLoIF(this.img3, new ConsLoIF(this.img4, new ConsLoIF(
                    this.img5, new ConsLoIF(this.img6, new ConsLoIF(this.img7,
                            this.mt)))))));
    public ILoIF namesortlist = new ConsLoIF(this.img3, new ConsLoIF(this.img2,
            new ConsLoIF(this.img6, new ConsLoIF(this.img1, new ConsLoIF(
                    this.img5, new ConsLoIF(this.img4, new ConsLoIF(this.img7,
                            this.mt)))))));

    public ILoIF sizesortlist = new ConsLoIF(this.img5, new ConsLoIF(this.img6,
            new ConsLoIF(this.img2, new ConsLoIF(this.img3, new ConsLoIF(
                    this.img1, new ConsLoIF(this.img7, new ConsLoIF(this.img4,
                            this.mt)))))));

    // ImageFile list - short names (less than 4 characters)
    public ILoIF imglistshortnames = new ConsLoIF(this.img1, new ConsLoIF(
            this.img2, new ConsLoIF(this.img6, this.mt)));

    // ImageFile list - small size (< 40000)
    public ILoIF imglistsmall = new ConsLoIF(this.img5, new ConsLoIF(this.img6,
            this.mt));

    // ImageFile list - small size (< 40000)
    public ILoIF imglistsmall2 = new ConsLoIF(this.img5, new ConsLoIF(
            this.img6, this.mt));

    // ImageFile list -- large images
    public ILoIF imglistlarge = new ConsLoIF(this.img1, new ConsLoIF(this.img2,
            new ConsLoIF(this.img3, this.mt)));

    // A sample test method
    public boolean testSize(Tester t) {
        return (t.checkExpect(this.img1.size(), 60000) && t.checkExpect(
                this.img2.size(), 40000));
    }

    // A sample test method
    public boolean testContains(Tester t) {
        return (t.checkExpect(this.imglistsmall.contains(this.img3), false) && t
                .checkExpect(this.imglistsmall.contains(this.img6), true));
    }

    IIFComparator ifNameComp = new ImageFileNameComparator();
    IIFComparator ifSizeComp = new ImageFileSizeComparator();

    public void testSort(Tester t) {
        t.checkExpect(this.imglistall.sortImageFiles(ifNameComp), namesortlist);
        t.checkExpect(this.mt.sortImageFiles(ifNameComp), this.mt);
        t.checkExpect(this.imglistall.sortImageFiles(ifSizeComp), sizesortlist);
        t.checkExpect(this.mt.sortImageFiles(ifSizeComp), this.mt);
    }
}