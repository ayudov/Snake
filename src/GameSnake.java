import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameSnake extends JFrame {

    final String TITLE_OF_PROGRAM = "Classic Game Snake";
    final int CELL_SIZE = 20;                  // size of cell in pix
    final int CANVAS_WIDTH = 30;               // width in cells
    final int CANVAS_HEIGHT = 20;              // height in cells
    private final int START_SNAKE_SIZE = 2;            // initialization data
    final Color SNAKE_COLOR = Color.darkGray;
    final Color FOOD_COLOR = Color.green;
    static final int KEY_LEFT = 37;             // codes
    static final int KEY_UP = 38;               //   of
    static final int KEY_RIGHT = 39;            //   cursor
    static final int KEY_DOWN = 40;             //   keys

    private Canvas canvas;                   // canvas object for rendering (drawing)
    private Snake snake;                     // declare a snake object
    Food food;                       // declare a food object
    // Poison poison;                   // declare a poison object

    public static void main(String[] args) {    // starting method
        new GameSnake().game();                 // create an object and call game()
    }

    private GameSnake() {
        setTitle(TITLE_OF_PROGRAM + " : " + START_SNAKE_SIZE);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        canvas = new Canvas();
        canvas.setBackground(Color.white);
        canvas.setPreferredSize(new Dimension(
                CELL_SIZE * CANVAS_WIDTH - 10,
                CELL_SIZE * CANVAS_HEIGHT - 10));

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                snake.setDirection(e.getKeyCode());
            }
        });
        add(canvas);                 // add a panel for rendering
        pack();                      // bringing the window to the required size
        setLocationRelativeTo(null); // the window will be in the center
        setResizable(false);         // prohibit window resizing
        setVisible(true);            // make the window visible
    }

    private void game() {            // method containing game cycle
        //   for
        int START_SNAKE_X = CANVAS_WIDTH / 2;
        //   snake
        int START_SNAKE_Y = CANVAS_HEIGHT / 2;
        snake = new Snake(           // creating snake object
                START_SNAKE_X,
                START_SNAKE_Y,
                START_SNAKE_SIZE,
                KEY_RIGHT, this);
        food = new Food(this);       // food object
        //poison = new Poison(this);   // poison object

        // a sign game is over or not
        do {          // game cycle while NOT gameOver
            snake.move();            // snake move
            if (food.isEaten()) {    // if the snake ate the food
                food.appear();       //   show food in new place
                //    poison.add();        //   add new poison point
            }
            canvas.repaint();        // repaint panel/window
            sleep();      // to make delay in milliseconds
        } while (true);
    }

    private void sleep() {    // method for suspending
        try {
            Thread.sleep(150);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    boolean isCoordinatesBusy(int x, int y) {
        return snake.isInSnake(x, y);
    }

    class Canvas extends JPanel {
        @Override
        public void paint(Graphics g) {
            super.paint(g);
            Graphics2D g2D = (Graphics2D) g;
            g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
            snake.paint(g2D);
            food.paint(g2D);
            //poison.paint(g2D);
        }
    }
}