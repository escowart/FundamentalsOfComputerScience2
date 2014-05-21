//assignment 3
//pair 027
//Cowart, Edwin
//escowart
//Bachiri, Zacharia
//bachiri

public class WP {
    String url;
    String title;
    ILoI items;

    public WP(String url, String title, ILoI items) {
        this.url = url;
        this.title = title;
        this.items = items;
    }

    /*
     * Template 
     * this.url 
     * this.title 
     * this.items
     */

    // totalImageSize : Compute the total size of all images on a web page and
    // all the linked web pages
    public int totalImageSize() {
        return this.items.totalImageSize();
    }

    // textLength : What is the total length of all the text on the web page and
    // the titles of linked web pages
    public int textLength() {
        return this.title.length() + this.items.textLength();
    }

    // images: List all images on the web page with a " ," at the end
    public String imagesHelper() {
        return this.items.imagesHelper();
    }

    // images: List all images on the web page
    public String images() {
        String str = imagesHelper();
        if (str.length() < 2)
            return str;
        return str.substring(0, (str.length() - 2));
    }
}

interface ILoI {
    // totalImageSize : Finds the image size of the list of items
    public int totalImageSize();

    // textLength : What is the total length of all the text files on the web
    // page and
    // the titles of linked web pages
    public int textLength();

    // images: List all images in the list with a " ," at the end unless it is
    // empty
    public String imagesHelper();
    
    // images: List all images in the list
    public String images();
}

class MtLoI implements ILoI {
    MtLoI() {
    }

    // totalImageSize : Finds the image size of the empty list
    public int totalImageSize() {
        return 0;
    }

    // textLength : What is the total length of all the text in the empty list.
    public int textLength() {
        return 0;
    }
    
    // imagesHelper: List all images in the empty list
    public String imagesHelper() {
        return "";
    }

    // images: List all images in the empty list
    public String images() {
        return "";
    }
}

class ConsLoI implements ILoI {
    Item item;
    ILoI list;

    public ConsLoI(Item item, ILoI list) {
        this.item = item;
        this.list = list;
    }

    /*
     * Template 
     * this.item 
     * this.list
     */

    // totalImageSize : Finds the image size of the list
    public int totalImageSize() {
        return this.item.totalImageSize() + this.list.totalImageSize();
    }

    // textLength : What is the total length of all the text in the list
    public int textLength() {
        return this.item.textLength() + this.list.textLength();
    }
    
    // image: List all images in the list of text with a " ," at the end
    public String imagesHelper() {
        String str = this.item.imagesHelper() + this.list.imagesHelper();
        return str;
    }

    // image: List all images in the list of text
    public String images() {
        String str = imagesHelper();
        return str.substring(0, str.length() - 2);
    }
}

interface Item {
    // totalImageSize : Finds the image size of the item
    public int totalImageSize();

    // textLength : What is the total length of all the text of all the items in
    // the list
    public int textLength();

    // images: It prints all images contained within the item
    public String images();
    
    // images: It prints all images contained within the item 
    //with a " ," at the end
    public String imagesHelper();
}

class Link implements Item {
    String name;
    WP page;

    public Link(String name, WP page) {
        this.name = name;
        this.page = page;
    }

    /*
     * Template 
     * this.name 
     * this.page
     */

    // totalImageSize : Finds the image size of the link
    public int totalImageSize() {
        return this.page.totalImageSize();
    }

    // textLength : What is the total length of the link's text and
    // the name of the linked web page
    public int textLength() {
        return this.name.length() + this.page.textLength();
    }
    
    // images: List all images in the linked WP with a " ," at the end
    public String imagesHelper() {
        return this.page.imagesHelper();
    }

    // images: List all images in the linked WP
    public String images() {
        return this.page.images();
    }
}

class Image implements Item {
    String name;
    int size;
    String type;

    public Image(String name, int size, String type) {
        this.name = name;
        this.size = size;
        this.type = type;
    }

    /*
     * Template 
     * this.name 
     * this.size 
     * this.type
     */

    // totalImageSize : Finds the size of the image
    public int totalImageSize() {
        return this.size;
    }

    // textLength : What is the total length of the name of the image
    public int textLength() {
        return this.name.length() + this.type.length();
    }

    // imagesHelper: List all images in the text 
    public String imagesHelper() {
        return this.name + "." + this.type + ", ";
    }
    
    // images: Gives the name of the image
    public String images() {
        String str = imagesHelper();
        return str.substring(0, str.length() - 2);
    }
}

class Text implements Item {
    String text;

    public Text(String text) {
        this.text = text;
    }

    // totalImageSize : Finds the image size of the text file
    public int totalImageSize() {
        return 0;
    }

    // textLength : What is the length the text
    public int textLength() {
        return this.text.length();
    }

    // imagesHelper: List all images in the text 
    public String imagesHelper() {
        return "";
    }
    
    // images: List all images in the text
    public String images() {
        return "";
    }
}
