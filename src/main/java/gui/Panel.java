package gui;

import core.Database;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
        paintBars(g2d);
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
        for (int i = 100, j = 50; i < 500; i += 80, j -= 10) {
            g.drawLine(90, i, 110, i);
            g.drawString(j + "%", 60, i - 5);
        }

        // y axis half scale
        for (int i = 140; i < 500; i += 40)
            g.drawLine(95, i, 105, i);

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

    public void paintBars(Graphics2D g) {
        Database database = null;
        try {
            database = new Database();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (database != null) {
            int numberOfRecords = database.getNumberOfRecords();
            int[] arrayOfNumbers = database.getArrayOfNumbers();

            //convert numbers into percents
            for (int i = 0; i < arrayOfNumbers.length; i++)
                arrayOfNumbers[i] = round((arrayOfNumbers[i] / (double) numberOfRecords) * 100);

            int[] tabX = new int[4];
            int[] tabY = new int[4];

            List<Point> barCenterPoints = new ArrayList<>();

            for (int i = 0, j = 152; i < arrayOfNumbers.length; i++, j += 50) {
                tabX[0] = j;
                tabY[0] = 500;
                tabX[1] = j + 46;
                tabY[1] = 500;
                tabX[2] = j + 46;
                tabY[2] = 500 - 8 * arrayOfNumbers[i];
                tabX[3] = j;
                tabY[3] = 500 - 8 * arrayOfNumbers[i];
                g.drawPolygon(tabX, tabY, tabX.length);
                g.fillPolygon(tabX, tabY, tabX.length);
                g.drawString(arrayOfNumbers[i] + "%", j + 12, 470 - 8 * arrayOfNumbers[i]);
                barCenterPoints.add(new Point((j + j + 46) / 2, 500 - 8 * arrayOfNumbers[i]));
            }

            g.setColor(Color.BLUE);
            g.setStroke(new BasicStroke(2, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
            int[] tabXS = new int[barCenterPoints.size()];
            int[] tabYS = new int[barCenterPoints.size()];

            for (int i = 0; i < barCenterPoints.size(); i++) {
                tabXS[i] = (int) barCenterPoints.get(i).getX();
                tabYS[i] = (int) barCenterPoints.get(i).getY();
            }

            g.drawPolyline(tabXS, tabYS, tabXS.length);

            for (int i = 0; i < barCenterPoints.size(); i++) {

            }
            g.drawString("Sample size: " + database.getNumberOfRecords(), 15, 545);
        }
    }

    private int round(double d) {
        double dAbs = Math.abs(d);
        int i = (int) dAbs;
        double result = dAbs - (double) i;
        if (result < 0.5) {
            return d < 0 ? -i : i;
        } else {
            return d < 0 ? -(i + 1) : i + 1;
        }
    }
}
