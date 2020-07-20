package gui;

import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel {

    public Panel() {
        super();
        setSize(800, 600);
        setLocation(0, 0);
        setBackground(Color.GRAY);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        paintGraph(g2d);
    }

    public void paintGraph(Graphics2D g) {

        Stroke s_1 = new BasicStroke(1, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
        Stroke s_2 = new BasicStroke(2, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);

        // Y axis
        g.setStroke(s_2);
        g.drawLine(100, 50, 100, 500);

        // Y axis arrow
        g.setStroke(s_2);
        g.drawLine(100, 50, 90, 60);
        g.drawLine(100, 50, 110, 60);

        // y axis scale
        g.setStroke(s_1);
        for (int i = 100, j = 100; i < 500; i += 40, j -= 10) {
            g.drawLine(90, i, 110, i);
            g.drawString(j + "%", 60, i - 5);
        }

        //X axis
        g.setStroke(s_2);
        g.drawLine(100, 500, 700, 500);

        // X axis arrow
        g.setStroke(s_2);
        g.drawLine(700, 500, 690, 490);
        g.drawLine(700, 500, 690, 510);

        // X axis scale
        g.setStroke(s_1);
        for (int i = 150, j = 1; i <= 600; i += 50, j++) {
            g.drawLine(i, 490, i, 510);
            g.drawString(j + "", (i + i + 40) / 2, 520);
        }
    }
}
