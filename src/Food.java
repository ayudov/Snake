import java.util.Random;

class Food extends Cell {
    //protected int x, y;                   // fields that are inherited
    //protected int size;                   //   from the Cell class
    //protected Color color;
    private GameSnake gameSnake;
    private Random random;


    //public void set(int x, int y)         // methods that are inherited
    //public int getX()                     //   from the Cell class
    //public int getY()
    //public void paint(Graphics g)

    Food(GameSnake gameSnake) {      // constructor
        super(-1, -1, gameSnake.CELL_SIZE, gameSnake.FOOD_COLOR);
        this.gameSnake = gameSnake;
        random = new Random();
    }

    boolean isFood(int x, int y) {
        return (this.x == x) && (this.y == y);
    }

    boolean isEaten() {
        return getX() == -1;
    }

    void eat() {
        set(-1, -1);
    }

    void appear() {
        int x, y;
        do {
            x = random.nextInt(gameSnake.CANVAS_WIDTH);
            y = random.nextInt(gameSnake.CANVAS_HEIGHT);
        } while (gameSnake.isCoordinatesBusy(x, y));
        set(x, y);
    }
}