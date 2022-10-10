import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.ArrayList;

public class Businessify {

    public static void main(String[] args) {
        
        loadFile();
    }

    private static void loadFile() {

        ArrayList<String> testList = new ArrayList<String>();
        testList.add("ord1");
        testList.add("ord2");
        testList.add("ord3");
        testList.add("ord4");

        ArrayList<String> testReplace = new ArrayList<String>();
        testReplace.add("ord1");
        testReplace.add("ThisOrd1");
        testReplace.add("ord4");
        testReplace.add("ThisOrd4");
        replaceWords(testList, testReplace); 

        try {
            File nonBusinessifiedFile = new File("text.txt");
            //File buzzwordFile = new File("buzzwords.txt");
            Scanner fileSca = new Scanner(nonBusinessifiedFile);
            while (fileSca.hasNextLine()) {
                String word = fileSca.nextLine();
                //System.out.println(word);

            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    // takes an arralist of words and a arraylist of words that sould be replaced
    // for evry odd index in the replacement araylist is a world that sould be replaced
    // and for evry even index in the replacement arraylist is what the world sould be replaced with
    // return a arraylist that has replaced words
    private static ArrayList<String> replaceWords(ArrayList<String> originalText, ArrayList<String> replacementWords){
        ArrayList<String> returnText = new ArrayList<String>();
        for (int i = 0; i < originalText.size(); i++){
            boolean hasFoundMatch = false;

            for (int j = 0; j < replacementWords.size(); j += 2){

                if(originalText.get(i).equals(replacementWords.get(j))){ // if the words match with one from replacement words. Then replace
                    returnText.add(replacementWords.get(j+1));
                    hasFoundMatch = true;
                    break;
                }
            }
            if (hasFoundMatch == false){ // if the word has not been replaced then instert the original word
                returnText.add(originalText.get(i));
            }
        }

        for (int i = 0; i < returnText.size(); i++){
            System.out.println(returnText.get(i));
        }
        return returnText;
    }
    /*
     * private void editFile(File nonBusinessifiedFile, File buzzwordFile) {
     * 
     * }
     */
}