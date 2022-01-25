import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.*;

public class SimplePaintListener implements MouseListener, MouseMotionListener, ActionListener, ChangeListener, KeyListener {
    private ColorPanel colorPanel;
    private SimplePaintPanel paintPanel;
    private ColorChooser colorChooser;

    public SimplePaintListener(SimplePaintPanel paintPanel, ColorPanel colorPanel, ColorChooser colorChooser) {
        this.paintPanel = paintPanel;
        this.colorPanel = colorPanel;
        this.colorChooser = colorChooser;

        colorChooser.getChooser().getSelectionModel().addChangeListener(this);

        colorPanel.getWhite().addActionListener(this);
        colorPanel.getRed().addActionListener(this);
        colorPanel.getYellow().addActionListener(this);
        colorPanel.getBlue().addActionListener(this);
        colorPanel.getCyan().addActionListener(this);
        colorPanel.getMagenta().addActionListener(this);
        colorPanel.getGreen().addActionListener(this);
        colorPanel.getColorSelector().addActionListener(this);
        colorPanel.getClear().addActionListener(this);

        paintPanel.addMouseListener(this);
        paintPanel.addMouseMotionListener(this);
        paintPanel.addKeyListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        paintPanel.requestFocus();
        paintPanel.setDragging(true);
        paintPanel.setPrevX(e.getX());
        paintPanel.setPrevY(e.getY());

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (paintPanel.isDragging())
            return; // Nothing to do because the user isn't drawing.
        paintPanel.setDragging(false);

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent evt) {
        if (paintPanel.isDragging()) {
            return;  // Nothing to do because the user isn't drawing.
        }

        int x = 2147483647, y = 2147483647;
        if (paintPanel.contains(evt.getX(), evt.getY())) {
            x = evt.getX();   // x-coordinate of mouse.
            y = evt.getY();   // y-coordinate of mouse.
        }

        if (x != 2147483647 && y != 2147483647) {
            paintPanel.addLine(new Line(paintPanel.getPrevX(), paintPanel.getPrevY(), x, y, paintPanel.getCurrentColor()));
            paintPanel.setPrevX(x);
            paintPanel.setPrevY(y);
            paintPanel.repaint();
        }

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();

        if (e.getSource() == colorPanel.getRed()) {
            paintPanel.setCurrentColor(Color.RED);
        }
        if (e.getSource() == colorPanel.getGreen()) {
            paintPanel.setCurrentColor(Color.GREEN);
        }
        if (e.getSource() == colorPanel.getWhite()) {
            paintPanel.setCurrentColor(Color.WHITE);
        }
        if (e.getSource() == colorPanel.getCyan()) {
            paintPanel.setCurrentColor(Color.CYAN);
        }
        if (e.getSource() == colorPanel.getBlue()) {
            paintPanel.setCurrentColor(Color.BLUE);
        }
        if (e.getSource() == colorPanel.getMagenta()) {
            paintPanel.setCurrentColor(Color.MAGENTA);
        }
        if (e.getSource() == colorPanel.getYellow()) {
            paintPanel.setCurrentColor(Color.YELLOW);
        }
        if (e.getSource() == colorPanel.getColorSelector()) {
            colorChooser.create();
        }
        if (e.getSource() == colorPanel.getClear()) {
            paintPanel.clear();
        }

        if (s.equals("Quit")) {
            System.exit(0);
        }
        if (s.equals("Undo")) {
            paintPanel.removeLine();
        }
    }

    public void stateChanged(ChangeEvent e) {
        Color color = colorChooser.getColor();
        paintPanel.setCurrentColor(color);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_Z && ((e.getModifiersEx() & KeyEvent.CTRL_DOWN_MASK) != 0)) {
            paintPanel.removeLine();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
