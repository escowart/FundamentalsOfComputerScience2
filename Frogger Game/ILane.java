package other;

import javalib.worldimages.WorldImage;

public interface ILane {

    
    /** Add i to the Lane's Y Coordinate */
    public void addToY(int i);
    
    /** Set A new Velocity for the Lane */
    public void getNewVel();

    /** Get the Start Location of the Lane */
    public int start();

    /** Able to Add new NPC into the Lane */
    public boolean ableToAdd();

    /**
     * Add new NPC to the Lane and perform the On-Tick for all the NPC and
     * remove off-screen NPC
     */
    public void onTick();

    /** Remove all T in the Lane that are Off Screen */
    public void removeOS();

    /** Get the x Coordinate of the Lane */
    public int getX();

    /** Return the Image of the Lane and All Objects in it */
    public WorldImage makeImage();

    /** Add a New T to this Lane */
    public void addNew();
    
}
