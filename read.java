import java.io.*;
import java.util.Scanner;

public class read {
    public static String[][] readShapelist(int ShapeNumber) throws Exception {
        int countData = 0;
        int countRow = 0;
        int countTempData = 0;
        int startTempData = 0;
        String tempData = "";
        String[][] dataExtract = new String[ShapeNumber][7];
        Scanner sc = new Scanner(new File("shapelist.csv"));

        while (sc.hasNext()) {
            tempData += sc.next();
        }
        tempData = tempData.substring(62, tempData.length());
        // System.out.println(tempData);
        sc.close();

        while (countRow < ShapeNumber) {
            if (countRow == (ShapeNumber - 1) && countData == 6) {
                dataExtract[countRow][countData] = tempData.substring(startTempData, tempData.length());
                break;
            }

            if (countData == 6) {
                if (tempData.substring(startTempData, countTempData).contains("\"\"")) { // if found ""
                    dataExtract[countRow][countData] = tempData.substring(startTempData, countTempData - 1);
                    countData = countData + 1;
                    startTempData = countTempData;
                    countTempData = startTempData + 1;
                }
            }

            else if (tempData.substring(startTempData, countTempData).contains("\",")) { // if found ",
                if (countData == 7) {
                    countData = 0;
                    countRow = countRow + 1;
                    /*
                     * for (int i = 0; i < 7; i++) {
                     * System.out.println(dataExtract[countRow - 1][i]);
                     * }
                     * System.out.println("======finish======");
                     */

                }

                if ((countData == 0) && (countRow != 0)) {
                    dataExtract[countRow][countData] = tempData.substring(startTempData - 1, countTempData - 1);
                }

                else {
                    dataExtract[countRow][countData] = tempData.substring(startTempData, countTempData - 1);
                }

                // System.out.println(tempData.substring(startTempData, countTempData - 1));
                // System.out.println(countRow);
                // System.out.println(countData);
                countData = countData + 1;
                startTempData = countTempData;
                countTempData = startTempData + 1;
            }
            countTempData = countTempData + 1;
        }
        return dataExtract;
    }

    public static String[][] format(String[][] data, int ShapeNumber) {
        int count = 0;
        while (count < ShapeNumber) {
            for (int i = 0; i < 7; i++) {
                data[count][i] = data[count][i].substring(1, data[count][i].length() - 1);
            }
            count = count + 1;
        }
        return data;
    }
}