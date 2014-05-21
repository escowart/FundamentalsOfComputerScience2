package other;

import java.util.HashMap;
import java.util.Iterator;

import javalib.colors.Green;
import javalib.impworld.World;
import javalib.worldimages.Posn;
import javalib.worldimages.RectangleImage;
import javalib.worldimages.WorldImage;

public class Game extends World {

    /** The Width of the Game */
    static int WIDTH = 500;

    /** The Height of the Game */
    static int LANEHEIGHT = 50;

    /** The Speed with Whcih the Player Moves */
    static int PLYSPEED = 10;

    /** The Player Object */
    Player player;
    /** A HashMap of the a Lanes y Coordinate and the Top Lane */
    /** Integer must be LANEHEIGHT / 2 + i * LANEHEIGHT */
    HashMap<Integer, ILane> lanes;

    public Game() {
        this.lanes = new HashMap<Integer, ILane>();
    }

    /** Get the Middle Empty Lanes Y Coordinate */
    public int getMidY() {
        int i = Game.LANEHEIGHT / 2;
        while (this.lanes.containsKey(i)) {
            i += Game.LANEHEIGHT;
        }
        return i;
    }

    /** Get the Last Empty Area's Y Coordinate */
    public int getMaxY() {
        return (int) (this.lanes.size() - .5) * Game.LANEHEIGHT;
    }

    /** Get the Width of the Game */
    public int getWidth() {
        return Game.WIDTH;
    }

    /** Get the Height of the Game */
    public int getHeight() {
        return this.lanes.size() * Game.LANEHEIGHT;
    }

    /** Add a new Car Lane to the Hash Map */
    public void addCarLane() {
        for (int i = this.getMaxY() - Game.LANEHEIGHT; i > this.getMidY(); i += Game.LANEHEIGHT) {
            this.lanes.get(i).addToY(Game.LANEHEIGHT);
        }
        int k = this.getMidY();
        this.lanes.put(new Integer(k), new CarLane(Game.WIDTH, Game.LANEHEIGHT,
                k));
    }

    /** Add a new Turtle Lane to the Hash Map */
    public void addTurtleLane() {
        int k = this.getMidY();
        this.lanes.put(new Integer(k), new TurtleLane(Game.WIDTH,
                Game.LANEHEIGHT, k));
    }

    /** Add a new Log Lane to the Hash Map */
    public void addLogLane() {
        int k = this.getMidY();
        this.lanes.put(new Integer(k), new LogLane(Game.WIDTH, Game.LANEHEIGHT,
                k));
    }

    /** Operate the On-Tick for all Lanes */
    public void onTick() {
        Iterator<Integer> it = this.lanes.keySet().iterator();
        while (it.hasNext()) {
            this.lanes.get(it.next()).onTick();
        }
    }

    /** Move the Player According to the Given Key Press */
    public void onKeyEvent(String ke) {
        if (ke.equals("up"))
            this.player.moveBy(0, -Game.PLYSPEED, Game.WIDTH, this.getHeight());
        else if (ke.equals("down"))
            this.player.moveBy(0, Game.PLYSPEED, Game.WIDTH, this.getHeight());
        else if (ke.equals("left"))
            this.player.moveBy(-Game.PLYSPEED, 0, Game.WIDTH, this.getHeight());
        else if (ke.equals("right"))
            this.player.moveBy(Game.PLYSPEED, 0, Game.WIDTH, this.getHeight());
    }

    /** Return the Image of the Game */
    public WorldImage makeImage() {
        int height = this.getMaxY() + Game.LANEHEIGHT / 2;
        WorldImage img = new RectangleImage(new Posn(Game.WIDTH, height),
                Game.WIDTH, height, new Green());
        Iterator<Integer> it = this.lanes.keySet().iterator();
        while (it.hasNext()) {
            img.overlayImages(this.lanes.get(it.next()).makeImage());
        }
        return img;
    }

    /** Return the Game Class a String */
    public String toString() {
        return "new Game(" + this.player + ", " + this.lanes.toString() + ")";
    }

}
