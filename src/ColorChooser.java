import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class ColorChooser {
    private final JColorChooser chooser = new JColorChooser();

    public JColorChooser getChooser() {
        return chooser;
    }

    public void create() {
        JPanel panel = new JPanel();
        panel.add(chooser);
        JOptionPane.showMessageDialog(null, panel, "ColorChooser", JOptionPane.PLAIN_MESSAGE);
    }

    public Color getColor() {
        return chooser.getColor();
    }

}
