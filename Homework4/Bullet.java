//assignment 4
//pair 027
//Cowart, Edwin
//escowart
//Bachiri, Zacharia
//bachiri

import javalib.colors.Black;
import javalib.worldimages.LineImage;
import javalib.worldimages.Posn;
import javalib.worldimages.WorldImage;

public class Bullet {

    Posn loc;

    // Constant
    int speed = 10;

    // distance from center to either top or bottom
    int height = 5;

    public Bullet(Posn loc) {
        this.loc = loc;
    }

    /*
     * Template Fields:
     * 
     * this.speed ... Posn
     * 
     * Methods:
     * 
     * this.move() ... Bullet 
     * this.hasCollided(UFO ufo) ... boolean
     * this.hasCollided(ILoU ufos) ... boolean 
     * this.countCollided(UFO ufo) ... int 
     * this.isOffScreen() ... boolean 
     * this.drawImage() ... WorldImage
     */

    // Second constructor that takes in the x location and
    // the base of the screen
    public Bullet(int xloc, int bot) {
        this.loc = new Posn(xloc, bot - height / 2);
    }

    // Moves the Bullet downwards
    public Bullet move() {
        return new Bullet(new Posn(this.loc.x, this.loc.y - speed));
    }

    // Tests whether the bullet has collided with the given UFO
    public boolean hasCollided(UFO ufo) {
        int rightbound = ufo.loc.x + ufo.width / 2;
        int leftbound = ufo.loc.x - ufo.width / 2;
        boolean xwithin = (leftbound <= this.loc.x)
                && (this.loc.x <= rightbound);
        int upperbound = ufo.loc.y - ufo.width / 2 - height;
        int lowerbound = ufo.loc.y + ufo.width / 2 + height;
        boolean ywithin = (upperbound <= this.loc.y)
                && (this.loc.y <= lowerbound);
        return xwithin && ywithin;
    }

    // Test whether the bullet collides with the given UFO list
    public boolean hasCollided(ILoU ufos) {
        return ufos.hasCollided(this);
    }

    // Counts the number of collisions the bullet does with the given UFO
    public int countCollided(UFO ufo) {
        if (this.hasCollided(ufo))
            return 1;
        return 0;
    }

    // Is the Bullet off screen?
    public boolean isOffScreen() {
        return (-height) > this.loc.y;
    }

    // Draws the Bullet as a World Image
    public WorldImage drawImage() {
        return new LineImage(new Posn(this.loc.x, this.loc.y + height),
                new Posn(this.loc.x, this.loc.y - height), new Black());
    }

}
