package gui;

import javax.swing.*;

public class Frame extends JFrame {

    public Frame(Panel panel) {
        super();
        setTitle("Benford's Law");
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setSize(800, 600);
        setLocation(100, 100);
        add(panel);
        setVisible(true);
    }
}
