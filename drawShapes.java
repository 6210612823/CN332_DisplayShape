import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class drawShapes {
    public static JPanel square(int param1, Color color, int[] locations) {
        JPanel square = new JPanel() {
            @Override
            public void paint(Graphics g) {
                g.setColor(color);
                g.fillRect(locations[0], locations[1], param1, param1);
            }
        };
        return square;
    }

    public static JPanel circle(int param1, Color color, int[] locations) {
        JPanel circle = new JPanel() {
            @Override
            public void paint(Graphics g) {
                g.setColor(color);
                g.fillOval(locations[0], locations[1], param1, param1);
            }
        };
        return circle;
    }

    public static JPanel rect(int param1, int param2, Color color, int[] locations) {
        JPanel rect = new JPanel() {
            @Override
            public void paint(Graphics g) {
                g.setColor(color);
                g.fillRect(locations[0], locations[1], param1, param2);
            }
        };
        return rect;
    }

    public static JPanel triangle(int[] triangleCoordinates, Color color, int[] locations) {
        JPanel triangle = new JPanel() {
            @Override
            public void paint(Graphics g) {
                g.setColor(color);
                g.fillPolygon(new int[] {triangleCoordinates[0], triangleCoordinates[2], triangleCoordinates[4]}, new int[] {triangleCoordinates[1], triangleCoordinates[3], triangleCoordinates[5]}, 3);
            }
        };
        return triangle;
    }
}
