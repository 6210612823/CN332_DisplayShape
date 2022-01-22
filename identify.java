import java.awt.Color;
import javax.swing.JFrame;

public class identify {
    public static void classify(int ShapeNumber, String[][] data) {
        // Setup
        String strParam1;
        String strParam2;
        String strParam3;
        int intParam1;
        int intParam2;
        String colorString;
        int[] locations = new int[2];
        int[] triangleCoordinates;
        JFrame fr = new JFrame();
        fr.setBounds(10, 10, 500, 500);
        fr.setDefaultCloseOperation(3);

        // Start Drawing
        for (int i = 0; i < ShapeNumber; i++) {
            //reading variables
            locations = extract.location(data[i][1]);
            data[i][2] = data[i][2].toLowerCase();
            strParam1 = data[i][3];
            strParam2 = data[i][4];
            strParam3 = data[i][5];
            colorString = data[i][6].toLowerCase();
            Color color = extract.stringToColor(colorString);

            if (data[i][2].contains("square")) {
                intParam1 = Integer.valueOf(strParam1);
                fr.add(drawShapes.square(intParam1, color, locations));
                fr.setVisible(true);
            }

            else if (data[i][2].contains("circle")) {
                intParam1 = Integer.valueOf(strParam1);
                fr.add(drawShapes.circle(intParam1, color, locations));
                fr.setVisible(true);
            }

            else if (data[i][2].contains("rect")) {
                intParam1 = Integer.valueOf(strParam1);
                intParam2 = Integer.valueOf(strParam2);
                fr.add(drawShapes.rect(intParam1, intParam2, color, locations));
                fr.setVisible(true);
            }

            else if (data[i][2].contains("triangle")) {
                triangleCoordinates = extract.triangleCoordinates(strParam1, strParam2, strParam3);
                fr.add(drawShapes.triangle(triangleCoordinates, color, locations));
                fr.setVisible(true);
            }
        }
    }
}