import java.awt.Color;
import java.util.Arrays;
import java.lang.reflect.Field;

public class extract {

    public static int[] location(String strLocation) {
        String[] arrayStrLocation = strLocation.split(",", 2);
        int[] intLocation = new int[2];
        intLocation[0] = Integer.parseInt(arrayStrLocation[0]);
        intLocation[1] = Integer.parseInt(arrayStrLocation[1]);
        //System.out.println(intLocation[0]);
        //System.out.println(intLocation[1]);
        return intLocation;
    }

    public static int[] triangleCoordinates(String param1, String param2, String param3) {
        int[] intTriangleCoordinates = new int[6];
        String[] strTriangleCoordinates = new String[2];

        //cut ()
        param1 = param1.substring(1, param1.length() - 1);
        param2 = param2.substring(1, param2.length() - 1);
        param3 = param3.substring(1, param3.length() - 1);

        //split(,) and add to array
        strTriangleCoordinates = param1.split(",", 2);
        intTriangleCoordinates[0] = Integer.valueOf(strTriangleCoordinates[0]);
        intTriangleCoordinates[1] = Integer.valueOf(strTriangleCoordinates[1]);

        strTriangleCoordinates = param2.split(",", 2);
        intTriangleCoordinates[2] = Integer.valueOf(strTriangleCoordinates[0]);
        intTriangleCoordinates[3] = Integer.valueOf(strTriangleCoordinates[1]);

        strTriangleCoordinates = param3.split(",", 2);
        intTriangleCoordinates[4] = Integer.valueOf(strTriangleCoordinates[0]);
        intTriangleCoordinates[5] = Integer.valueOf(strTriangleCoordinates[1]);

        //System.out.println(Arrays.toString(intTriangleCoordinates));
        
        return intTriangleCoordinates;
    }

    public static Color stringToColor(final String value) {
        if (value == null) {
            return Color.black;
        }
        try {
            // get color by hex or octal value
            return Color.decode(value);
        } catch (NumberFormatException nfe) {
            // if we can't decode lets try to get it by name
            try {
                // try to get a color by name using reflection
                final Field f = Color.class.getField(value);

                return (Color) f.get(null);
            } catch (Exception ce) {
                // if we can't get any color return black
                return Color.black;
            }
        }
    }
}
