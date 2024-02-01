package pkg3drender;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JFrame;

public class Main {

    static ArrayList<Triangle> triangulos = new ArrayList<>();

    public static void main(String[] args) {

        triangulos.add(new Triangle(new Vertex(100, 100, 100), new Vertex(-100, -100, 100), new Vertex(-100, 100, -100), Color.WHITE));
        triangulos.add(new Triangle(new Vertex(100, 100, 100), new Vertex(-100, -100, 100), new Vertex(100, -100, -100), Color.RED));
        triangulos.add(new Triangle(new Vertex(-100, 100, -100), new Vertex(100, -100, -100), new Vertex(100, 100, 100), Color.GREEN));
        triangulos.add(new Triangle(new Vertex(-100, 100, -100), new Vertex(100, -100, -100), new Vertex(-100, -100, 100), Color.BLUE));
        triangulos.add(new Triangle(new Vertex(0, 100, 0), new Vertex(100, -50, 0), new Vertex(-100, -50, 0), Color.YELLOW));
        
        
        //triangulos.add(new Triangle(new Vertex(-50, 50, 50), new Vertex(-50, -50, 50), new Vertex(50, 50, 50), Color.WHITE));
        //triangulos.add(new Triangle(new Vertex(50, -50, 50), new Vertex(-50, -50, 50), new Vertex(50, 50, 50), Color.WHITE));
        //triangulos.add(new Triangle(new Vertex(-50, 50, -50), new Vertex(-50, -50, -50), new Vertex(50, 50, -50), Color.WHITE));
        //triangulos.add(new Triangle(new Vertex(50, -50, -50), new Vertex(-50, -50, -50), new Vertex(50, 50, -50), Color.WHITE));
        //triangulos.add(new Triangle(new Vertex(-50, 50, 50), new Vertex(-50, -50, 50), new Vertex(-50, -50, -50), Color.WHITE));
        //triangulos.add(new Triangle(new Vertex(-50, 50, 50), new Vertex(-50, 50, -50), new Vertex(-50, -50, -50), Color.WHITE));
        //triangulos.add(new Triangle(new Vertex(50, 50, 50), new Vertex(50, -50, 50), new Vertex(50, -50, -50), Color.WHITE));
        //triangulos.add(new Triangle(new Vertex(50, 50, 50), new Vertex(50, 50, -50), new Vertex(50, -50, -50), Color.WHITE));
        //triangulos.add(new Triangle(new Vertex(-50, -50, 50), new Vertex(-50, -50, -50), new Vertex(50, -50, 50), Color.WHITE));
        //triangulos.add(new Triangle(new Vertex(-50, 50, 50), new Vertex(-50, 50, -50), new Vertex(50, 50, 50), Color.WHITE));


        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("3D");
        frame.setSize(1200, 700);
        frame.setResizable(false);

        U panel = new U(triangulos);

        frame.add(panel);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

}
