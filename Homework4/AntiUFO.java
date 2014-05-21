//assignment 4
//pair 027
//Cowart, Edwin
//escowart
//Bachiri, Zacharia
//bachiri

import javalib.worldimages.FromFileImage;
import javalib.worldimages.Posn;
import javalib.worldimages.WorldImage;

public class AntiUFO {

    int xloc;

    // Constants
    int speed = 7;

    public AntiUFO(int xloc) {
        this.xloc = xloc;
    }

    /*
     * Template Fields:
     * 
     * this.xloc ... int
     * 
     * Methods:
     * 
     * this.onKeyEvent(String ke) ... AntiUFO 
     * this.moveLeft() ... AntiUFO
     * this.moveRight() ... AntiUFO 
     * this.antiUFOImage() ... WorldImage
     */

    // Moves the Anti UFO speed to the left
    public AntiUFO moveLeft() {
        if (this.xloc > (this.speed + this.drawImage().getHeight() / 2))
            return new AntiUFO(this.xloc - this.speed);
        return this;
    }

    // Moves the Anti UFO speed to the right
    public AntiUFO moveRight() {
        if (this.xloc < (400 - this.speed - this.drawImage().getHeight() / 2))
            return new AntiUFO(this.xloc + this.speed);
        return this;
    }

    // Sets the image for Anti UFO
    public WorldImage drawImage() {
        return new FromFileImage(new Posn(this.xloc, 374), "p027-au.png");
    }

}
