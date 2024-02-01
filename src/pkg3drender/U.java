package pkg3drender;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import javax.swing.JPanel;

public class U extends JPanel implements MouseMotionListener, KeyListener {

    ArrayList<Triangle> triangulos;

    double angle = 0;
    double angle2 = 0;
    //double angle3 = 0;

    public U(ArrayList<Triangle> tri) {
        this.triangulos = tri;
        this.addMouseMotionListener(this);
        this.addKeyListener(this);
        this.setFocusable(true);
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.BLACK);
        g2.fillRect(0, 0, getWidth(), getHeight());

        g2.translate(getWidth() / 2, getHeight() / 2);
        g2.setColor(Color.white);

        double heading = Math.toRadians(angle);
        double[][] headingTransform = {{Math.cos(heading), 0, -Math.sin(heading)},
        {0, 1, 0},
        {Math.sin(heading), 0, Math.cos(heading)}};
        double pitch = Math.toRadians(angle2);
        double[][] pitchTransform = {{1, 0, 0},
        {0, Math.cos(pitch), Math.sin(pitch)},
        {0, -Math.sin(pitch), Math.cos(pitch)}};
        //double z = Math.toRadians(angle3);
        //double[][] ztransform = {{Math.cos(z), -Math.sin(z), 0},
        //{Math.sin(z), Math.cos(z), 0},
        //{0, 0, 1}};

        Algebra matM = new Algebra();

        double[][] transform = matM.matmul(headingTransform, pitchTransform);
        //transform = matM.matmul(transform, ztransform);

        for (int i = 0; i < triangulos.size(); i++) {
            Vertex v1 = matM.transform(triangulos.get(i).v1, transform);
            Vertex v2 = matM.transform(triangulos.get(i).v2, transform);
            Vertex v3 = matM.transform(triangulos.get(i).v3, transform);
            g2.drawLine((int) v1.x, (int) v1.y, (int) v2.x, (int) v2.y);
            g2.drawLine((int) v1.x, (int) v1.y, (int) v3.x, (int) v3.y);
            g2.drawLine((int) v2.x, (int) v2.y, (int) v3.x, (int) v3.y);
        }
        g2.dispose();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        double yi = 360.0 / getHeight();
        double xi = 360.0 / getWidth();
        angle = (int) (e.getX() * xi);
        angle2 = -(int) (e.getY() * yi);
        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {
        // angle3 += 3;
        // repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}
