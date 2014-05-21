package other;

import javalib.worldimages.WorldImage;

public abstract class GameObject {

    /** (this.x, this.y) is the Pixel Location of the Object */ 
    /** (this.x = 0, this.y = 0) is the top left corner */
    int x;
    int y;

    public GameObject(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    /** Get the x Coordinate of the Game Object */
    public int getX() {
        return this.x;
    }

    /** Get the y Coordinate of the Game Object */
    public int getY() {
        return this.y;
    }
    
    /** Returns the Width of the Game Object */
    public int getWidth() {
        return this.makeImage().getWidth();
    }

    /** Returns the Height of the Game Object */
    public int getHeight() {
        return this.makeImage().getHeight();
    }

    /** Return the Image of the Object */
    public abstract WorldImage makeImage();

}
