import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class SimplePaintRunner {
    public static void main(String[] args) {
        JFrame window = new JFrame("Simple Paint");
        ColorPanel colorPanel = new ColorPanel();
        ColorChooser colorChooser = new ColorChooser();
        SimplePaintPanel content = new SimplePaintPanel(colorPanel);
        SimplePaintListener listener = new SimplePaintListener(content, colorPanel, colorChooser);

        JMenuBar menuBar = new JMenuBar();
        JMenu simplePaintMenu = new JMenu("Simple Paint");
        JMenu editMenu = new JMenu("Menu");

        JMenuItem quit = new JMenuItem("Quit");
        simplePaintMenu.add(quit);
        quit.addActionListener(listener);

        JMenuItem undo = new JMenuItem("Undo");
        editMenu.add(undo);
        undo.addActionListener(listener);

        menuBar.add(simplePaintMenu);
        menuBar.add(editMenu);
        window.setJMenuBar(menuBar);


        JPanel container = new JPanel();
        container.setLayout(new BorderLayout());
        container.add(content, BorderLayout.CENTER);
        container.add(colorPanel, BorderLayout.EAST);

        window.setContentPane(container);
        window.setSize(700,380);
        window.setLocation(100,100);
        window.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        window.setVisible(true);

        content.requestFocus();
    }
}
