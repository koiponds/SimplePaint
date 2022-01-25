import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class SimplePaintRunner {
    public static void main(String[] args) {
        JFrame window = new JFrame("Simple Paint");
        ColorPanel colorPanel = new ColorPanel();
        ColorChooser colorChooser = new ColorChooser();
        SimplePaintPanel content = new SimplePaintPanel(colorPanel);
        new SimplePaintListener(content, colorPanel, colorChooser);

        JPanel container = new JPanel();
        container.setLayout(new BorderLayout());
        container.add(content, BorderLayout.CENTER);
        container.add(colorPanel, BorderLayout.EAST);

        window.setContentPane(container);
        window.setSize(700,380);
        window.setLocation(100,100);
        window.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        window.setVisible(true);

    }
}
