import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Businessify {

    public static void main(String[] args) {
        
        loadFile();
    }

    private static void loadFile() {

        try {
            File nonBusinessifiedFile = new File("text.txt");
            //File buzzwordFile = new File("buzzwords.txt");
            Scanner fileSca = new Scanner(nonBusinessifiedFile);
            while (fileSca.hasNextLine()) {
                String word = fileSca.nextLine();
                System.out.println(word);

            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    /*
     * private void editFile(File nonBusinessifiedFile, File buzzwordFile) {
     * 
     * }
     */
}