package other;

import java.util.ArrayList;
import java.util.Random;

import javalib.colors.IColor;
import javalib.worldimages.Posn;
import javalib.worldimages.RectangleImage;
import javalib.worldimages.WorldImage;

public abstract class Lane<T extends NPC> implements ILane {
    /** this.width is the Width of the Lane */
    /** this.height is the Height of the Lane */
    /** this.y is the Y Coordinate in Pixels of the Lane */

    int width;
    int height;
    int y;
    int vel;
    IColor color;
    ArrayList<T> alist;
    
    /** Random Number Generator */
    static Random GEN = new Random();
    
    /** Off Screen Constant */
    static int OFFSCREEN = 100;

    public Lane(int width, int height, int y, IColor color) {
        this.width = width;
        this.height = height;
        this.y = y;
        this.color = color;
        this.alist = new ArrayList<T>();
        this.getNewVel();
    }
    
    /** Add i to the Lane's Y Coordinate */
    public void addToY(int i){
        this.y += i;
    }
    
    /** Set A new Velocity for the Lane */
    public void getNewVel(){
        this.vel = 10 + Lane.GEN.nextInt(10);
    }

    /** Get the Start Location of the Lane */
    public int start() {
        if(this.vel > 0)
            return -Lane.OFFSCREEN;
        return this.width + Lane.OFFSCREEN;
    }

    /** Able to Add new NPC into the Lane */
    public boolean ableToAdd() {
        if(Lane.GEN.nextInt(10) == 0){
            if (this.alist.isEmpty() || this.alist.get(0).y > Lane.OFFSCREEN)
                return true;
        }
        return false;
    }

    /**
     * Add new NPC to the Lane and perform the On-Tick for all the NPC and
     * remove off-screen NPC
     */
    public void onTick() {
        if (this.ableToAdd())
            this.addNew();
        this.removeOS();
        for (T t : this.alist) {
            t.onTick();
        }
    }

    /** Remove all T in the Lane that are Off Screen */
    public void removeOS() {
        ArrayList<T> blist = new ArrayList<T>();
        for (T t : this.alist) {
            if (!t.isOffScreen(this.width))
                blist.add(t);
        }
        this.alist = blist;
    }

    /** Get the x Coordinate of the Lane */
    public int getX() {
        return this.width / 2;
    }

    /** Return the Image of the Lane and All Objects in it */
    public WorldImage makeImage() {
        WorldImage img = new RectangleImage(new Posn(this.getX(), this.y),
                this.width, this.height, this.color);
        for (T t : this.alist) {
            img = img.overlayImages(t.makeImage());
        }
        return img;
    }

    /** Add a New T to this Lane */
    public abstract void addNew();
}
