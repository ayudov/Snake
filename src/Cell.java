import java.awt.Color;
import java.awt.Graphics2D;

/**
 * Java. Classic Game Snake
 *  Class Cell: minimal building element
 *
 * @author Sergey Iryupin
 * @version 0.3.1 dated Dec 28, 2018
 */

class Cell {
    int x, y;                       // object coordinates
    private int size;                       // object size in px
    private Color color;                    // object color

    Cell(int x, int y, int size, Color color) {
        set(x, y);                            // init coordinates
        this.size = size;                     // init size
        this.color = color;                   // init color
    }

    void set(int x, int y) {           // set coordinates
        this.x = x;
        this.y = y;
    }

    int getX() {                       // get the X coordinate
        return x;
    }

    int getY() {                       // get the Y coordinate
        return y;
    }

    void paint(Graphics2D g) {           // object rendering
        g.setColor(color);
        g.fillOval(x * size, y * size,        // upper left corner
                size, size);                  // width and height
    }
}