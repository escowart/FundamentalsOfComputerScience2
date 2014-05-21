package other;

import java.util.Random;

/** A Class Representing non-ArrayList Game Object */
public abstract class NPC extends GameObject{
    /** this.vel is the Velocity of the Object */
    
    int vel;

    /** Random Number Generator */
    static Random GEN = new Random();

    public NPC(int x, int y, int vel) {
        super(x, y);
        this.vel = vel;
    }
    
    /** Move the x Coordinate by the Velocity */
    public void move(){
        this.x += this.vel;
    }
    
    
    /** Performs the On-Tick depending on the Object */
    public abstract void onTick();

    /** Is the Game Object OffScreen */
    public boolean isOffScreen(int width) {
        return (this.vel > 0 && this.x > width + this.getWidth())
                || (this.vel == 0)
                || (this.vel < 0 && this.x < -this.getWidth());
    }
    
    /** Has the NPC Collided with the Given Player */
    public boolean gameOver(Player ply) {
        int xdis = Math.abs(ply.x - this.x);
        int ydis = Math.abs(ply.y - this.y);
        int xsize = (ply.getWidth() + this.getWidth()) / 2;
        int ysize = (ply.getHeight() + this.getHeight()) / 2;
        return xdis <= xsize && ydis <= ysize;
    }
    
    /** Is the NPC Below the Given Player */
    public boolean isBelow(Player ply) {
        int xdis = Math.abs(ply.x - this.x);
        int ydis = Math.abs(ply.y - this.y);
        return xdis <= this.getWidth() && ydis <= this.getHeight();
    }
}
