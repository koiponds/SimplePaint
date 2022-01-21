import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;


public class SimplePaintPanel extends JPanel {
    private ColorPanel colorPanel;

    private Color currentColor = Color.WHITE;  // The currently selected drawing color,

    /* The following variables are used when the user is sketching a
         curve while dragging a mouse. */

    private int prevX, prevY;     // The previous location of the mouse.
    private boolean dragging;      // This is set to true while the user is drawing.

    private ArrayList<Line> lines = new ArrayList<Line>();


    SimplePaintPanel(ColorPanel colorPanel) {
        this.colorPanel = colorPanel;
        this.setBackground(Color.BLACK);
        //*** Since the SimplePaint JPanel is also a Listener, register appropriately

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);  // Fill with background color (white).

        // Draw 3 pixel wide Gray border
        this.setBorder(BorderFactory.createLineBorder(Color.GRAY, 3));
 
        
        // *** Re-draw all of the information, based on the state of our data structure
        for (Line line : lines) {
            if (Color.WHITE.equals(line.getColor())) {
                g.setColor(Color.WHITE);
            } else if (Color.RED.equals(line.getColor())) {
                g.setColor(Color.RED);
            } else if (Color.GREEN.equals(line.getColor())) {
                g.setColor(Color.GREEN);
            } else if (Color.BLUE.equals(line.getColor())) {
                g.setColor(Color.BLUE);
            } else if (Color.CYAN.equals(line.getColor())) {
                g.setColor(Color.CYAN);
            } else if (Color.MAGENTA.equals(line.getColor())) {
                g.setColor(Color.MAGENTA);
            } else if (Color.YELLOW.equals(line.getColor())) {
                g.setColor(Color.YELLOW);
            }
            g.drawLine(line.getX1(), line.getY1(),
                    line.getX2(), line.getY2());

        }
        
    } // end paintComponent()

    public Color getCurrentColor() {
        return currentColor;
    }

    public void setCurrentColor(Color currentColor) {
        this.currentColor = currentColor;
    }

    public void addLine (Line line) {
        lines.add(line);
    }

    public int getPrevX() {
        return prevX;
    }

    public void setPrevX(int prevX) {
        this.prevX = prevX;
    }

    public int getPrevY() {
        return prevY;
    }

    public void setPrevY(int prevY) {
        this.prevY = prevY;
    }

    public boolean isDragging() {
        return dragging;
    }

    public void setDragging(boolean dragging) {
        this.dragging = dragging;
    }

    public void clear() {
        lines.clear();
    }
} // end class SimplePaint
