package it.unibo.es3;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.Serial;
import java.util.ArrayList;
import java.util.List;

/**
 * GUI for the game.
 */
public final class GUI extends JFrame {

    @Serial
    private static final long serialVersionUID = 1L;
    private final List<List<JButton>> cells;
    private final transient Logics logics;

    /**
     * Constructor.
     *
     * @param width the size of the grid
     */
    public GUI(final int width) {
        this.logics = new LogicsImpl(width);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        final JPanel external = new JPanel();
        external.setLayout(new BorderLayout());
        // Create a panel with a grid layout
        final JPanel panel = new JPanel(new GridLayout(width, width));
        //this.getContentPane().add(panel);
        // Create buttons and add them to the panel
        cells = new ArrayList<>(width);
        for (int i = 0; i < width; i++) {
            final List<JButton> temp = new ArrayList<>(width);
            for (int j = 0; j < width; j++) {
                final var pos = new Pair<>(i, j);
                final JButton button = new JButton();
                if (logics.getPair(pos)) {
                    button.setText("*");
                } else {
                    button.setText(" ");
                }
                temp.add(button);
                panel.add(button);
            }
            cells.add(temp);
        }
        external.add(panel, BorderLayout.CENTER);
        final JButton progress = new JButton(">");
        progress.addActionListener(e -> {
            logics.hit();
            for (int i = 0; i < width; i++) {
                for (int j = 0; j < width; j++) {
                    if (logics.getPair(new Pair<>(i, j))) {
                        this.cells.get(i).get(j).setText("*");
                    } else {
                        this.cells.get(i).get(j).setText(" ");
                    }
                }
            }
            if (logics.end()) {
                dispose();
            }
        });
        external.add(progress, BorderLayout.SOUTH);
        this.getContentPane().add(external);
        pack();
        this.setVisible(true);
    }
}
