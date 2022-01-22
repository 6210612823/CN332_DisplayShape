import java.util.Scanner;

public class main {
    public static void main(String[] args) throws Exception {
        Scanner myObj = new Scanner(System.in); // Create a Scanner object
        System.out.println("How many object in shapelist.csv ? (Please type number down below)");
        int shapeNum = myObj.nextInt();
        myObj.close();

        //int shapeNum = 4;
        String[][] data = read.readShapelist(shapeNum);
        data = read.format(data, shapeNum);
        
        identify.classify(shapeNum, data);
    }
}
