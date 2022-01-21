import javax.swing.*;
import java.awt.*;


public class ColorPanel extends JPanel {
    private SimplePaintPanel paintPanel;

    private JButton white;
    private JButton red;
    private JButton green;
    private JButton blue;
    private JButton cyan;
    private JButton magenta;
    private JButton yellow;
    private JButton clear;
    private JButton colorSelector;

    public ColorPanel() {
        this.setLayout(new GridLayout(9,1));
        white = new JButton();
        white.setBackground(Color.WHITE);
        white.setOpaque(true);
        white.setBorderPainted(false);

        red = new JButton();
        red.setBackground(Color.RED);
        red.setOpaque(true);
        red.setBorderPainted(false);

        green = new JButton();
        green.setBackground(Color.GREEN);
        green.setOpaque(true);
        green.setBorderPainted(false);

        blue = new JButton();
        blue.setBackground(Color.BLUE);
        blue.setOpaque(true);
        blue.setBorderPainted(false);

        cyan = new JButton();
        cyan.setBackground(Color.CYAN);
        cyan.setOpaque(true);
        cyan.setBorderPainted(false);

        magenta = new JButton();
        magenta.setBackground(Color.MAGENTA);
        magenta.setOpaque(true);
        magenta.setBorderPainted(false);

        yellow = new JButton();
        yellow.setBackground(Color.YELLOW);
        yellow.setOpaque(true);
        yellow.setBorderPainted(false);

        colorSelector = new JButton("Custom Color");
        colorSelector.setBackground(Color.WHITE);

        clear = new JButton("CLEAR");
        clear.setBackground(Color.WHITE);


        this.add(white);
        this.add(red);
        this.add(green);
        this.add(blue);
        this.add(cyan);
        this.add(magenta);
        this.add(yellow);
        this.add(colorSelector);
        this.add(clear);
    }

    public JButton getWhite() {
        return white;
    }

    public JButton getRed() {
        return red;
    }

    public JButton getGreen() {
        return green;
    }

    public JButton getBlue() {
        return blue;
    }

    public JButton getCyan() {
        return cyan;
    }

    public JButton getMagenta() {
        return magenta;
    }

    public JButton getYellow() {
        return yellow;
    }

    public JButton getClear() {
        return clear;
    }

    public JButton getColorSelector() {
        return colorSelector;
    }
}
