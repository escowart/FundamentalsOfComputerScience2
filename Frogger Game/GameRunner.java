package other;
 

public class GameRunner {
    ExamplesGames w = new ExamplesGames();

    void run() {
        this.w.intialWorld.bigBang(400, 600);
    }

    public static void main(String[] argv) {
        GameRunner world = new GameRunner();
        world.run();
    }
}
