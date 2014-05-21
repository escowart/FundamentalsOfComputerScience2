package other;
import javalib.colors.Red;
import javalib.worldimages.Posn;
import javalib.worldimages.RectangleImage;
import javalib.worldimages.WorldImage;

public class Player extends GameObject{
    
    /** Initialize the Player */
    public Player(int x, int y) {
        super(x, y);
    }
    
    /** Move the Player by the Given x and y */
    public void moveBy(int a, int b, int width, int height){
        this.x += a;
        this.y += b;
        this.backOnScreen(width, height);
    }
    
    /** Move the Player back On-Screen given the width and height */
    public void backOnScreen(int width, int height){
        if(this.x - this.getWidth() / 2 < 0)
            this.x = this.getWidth() / 2;
        else if(this.y - this.getHeight() / 2 < 0)
            this.y = this.getHeight() / 2;
        else if(this.x + this.getWidth() / 2 > width)
            this.x = width - this.getWidth() / 2;
        else if(this.y + this.getHeight() / 2 > height)
            this.y = height - this.getHeight() / 2;
    }


    /** Covert the Player into an Image */
    public WorldImage makeImage() {
        return new RectangleImage(new Posn(this.x, this.y), 40, 40, new Red());
    }

}
