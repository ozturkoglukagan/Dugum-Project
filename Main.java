import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static ArrayList < Dugum > dugumler = new ArrayList < Dugum > ();

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        readData1TxtFile();
        readData2TxtFile();
        calculateValues();
        dugumleriGoster();
    }

    //	This method sets data.txt file 
    public static void setDataTxtFile(String fileName) {
        File file = new File(fileName);
        try {
            FileWriter fw = new FileWriter(file);
            fw.write("0 0 0 0 0 0 0 0 0 0 0 0\n" +
                "1 0 0 0 0 0 0 0 0 0 0 0\n" +
                "0 1 0 0 0 0 0 0 0 0 0 0\n" +
                "1 0 0 0 0 0 0 0 0 0 0 0\n" +
                "0 0 0 1 0 0 0 0 0 0 0 0\n" +
                "0 0 1 0 1 0 0 0 0 0 0 0\n" +
                "0 0 0 0 0 1 0 0 0 0 0 0\n" +
                "0 0 0 0 0 0 1 0 0 0 0 0\n" +
                "0 0 0 0 0 1 0 0 0 0 0 0\n" +
                "0 0 0 0 0 1 0 0 0 0 0 0\n" +
                "0 0 0 0 0 0 0 0 0 1 0 0\n" +
                "0 0 0 0 0 0 0 1 1 0 1 0\n" +
                "");

            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    //	this method  reads values from a txt file 
    public static void readData1TxtFile() {
        File f = new File("data1.txt");
        try {
            Scanner scanFile = new Scanner(f);
            String dataline = scanFile.nextLine();
            String[] data = dataline.split(" ");
            // by doing this we create Dugum's and add them to an arraylist
            for (int i = 0; i < data.length; i++) {
                Dugum tempDugum = new Dugum(i);
                tempDugum.setValue(Integer.parseInt(data[i]));
                dugumler.add(tempDugum);
            }

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    // This method reads  data from data2.txt file 

    public static void readData2TxtFile() {
        File f = new File("data2.txt");
        String[][] dataLines = new String[dugumler.size()][dugumler.size()];

        try {
            // by doing this we use the txt file as a grid and use coordinates to find what we want
            Scanner scanFile = new Scanner(f);
            for (int i = 0; i < dataLines.length; i++) {
                for (int j = 0; j < dataLines.length; j++) {
                    dataLines[i][j] = scanFile.next();

                }
            }

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // with this we use the grid system and find the connected Dugum's and add them to previousdugum arraylist
        for (int i = 0; i < dataLines.length; i++) {
            Dugum idugum = dugumler.get(i);
            for (int j = 0; j < dataLines.length; j++) {
                if (dataLines[i][j].equals("1")) {
                    Dugum jdugum = dugumler.get(j);
                    idugum.addPreviousDugum(jdugum);
                }
            }
        }

    }
    // this method is forcalculating the points of dugums by their values
    public static void calculateValues() {
        for (Dugum d: dugumler) {
            d.setPoint();

        }
    }
    //	 this method is for checking & debugging the arraylist during the coding part
    public static void dugumleriGoster() {
        for (Dugum d: dugumler) {
            d.dugumGoster();

        }
    }
}