//assignment 4
//pair 027
//Cowart, Edwin
//escowart
//Bachiri, Zacharia
//bachiri

import java.util.Random;

import javalib.worldimages.FromFileImage;
import javalib.worldimages.Posn;
import javalib.worldimages.WorldImage;

public class UFO {

    Posn loc;

    // Constants
    int speed = 5;
    int height = 17;
    int width = 55;

    public UFO(Posn loc) {
        this.loc = loc;
    }

    public UFO(int w) {
        Random randomGen = new Random();
        int randomInt = randomGen.nextInt((int) (w - this.width)) + width / 2;
        this.loc = new Posn(randomInt, -10);
    }

    /*
     * Template Fields:
     * 
     * this.loc ... Posn
     * 
     * Methods:
     * 
     * this.countCollided(ILoB bull) ... int 
     * this.hasCollided(ILoB bull) ... boolean 
     * this.hasCollided(Bullet b) ... boolean 
     * this.hitGround() ... boolean 
     * this.drawImage() ... WorldImage
     */

    public UFO move() {
        return new UFO(new Posn(this.loc.x, this.loc.y + speed));
    }

    // Counts how many times the UFO collides with the given bullet
    public int countCollided(ILoB bull) {
        return bull.countCollided(this);
    }

    // Has the UFO collided with the given list of bullets
    public boolean hasCollided(ILoB bull) {
        return bull.hasCollided(this);
    }

    // Has the UFO collided with the given bullet
    public boolean hasCollided(Bullet b) {
        return b.hasCollided(this);
    }

    // Has the UFO hit the ground
    public boolean hitGround() {
        return (this.loc.y + height / 2) > 400;
    }

    // Returns the Image
    public WorldImage drawImage() {
        return new FromFileImage(this.loc, "p027-ufo.png");
    }
}
