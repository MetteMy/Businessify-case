
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;




public class Businessify {

    public static void main(String[] args) {
        ApplicationWindow appWindow = new ApplicationWindow();
        
        appWindow.browseBtn.addActionListener(e -> {

        ArrayList<String> businessWords = loadBusinesswords();
        ArrayList<String> text = loadFile(appWindow.fileChooser(appWindow.centerPanel));
        ArrayList<String> businessfiedText = replaceWords(text, businessWords);
        /*for (int i = 0; i < businessfiedText.size(); i++){
            System.out.print(businessfiedText.get(i) + " ");
            
            
        }*/
        String originalTextString = String.join(" ", text);
        String translatedTextString = String.join(" ", businessfiedText);

        appWindow.originalText.setText(originalTextString);
        appWindow.translatedText.setText(translatedTextString);
        
    }); 
    }
    private static ArrayList<String> loadBusinesswords() {
        ArrayList<String> businessWords = new ArrayList<String>();
        try {
                
                File buzzwordFile = new File("buzzwords.csv");
                Scanner fileSca = new Scanner(buzzwordFile);
                fileSca.useDelimiter(","); 
                while (fileSca.hasNextLine()) {
                        String word = fileSca.next();
                        if(word.contains("\r\n")) { // removes new line symble
                            String newWord = word.replace("\r\n", "" );
                            businessWords.add(newWord);
                        } else {
                            businessWords.add(word);
                        }
                    }
                    
                } catch (FileNotFoundException e) {
                    System.out.println("An error occurred. - buzzwordfile");
                    e.printStackTrace();
            }
            return businessWords;
        }   

    private static ArrayList<String> loadFile(String path) {
        ArrayList<String> returnText = new ArrayList<String>();
        
        try {
            File nonBusinessifiedFile = new File(path);
            Scanner fileSca = new Scanner(nonBusinessifiedFile);
            while (fileSca.hasNextLine()) {
                String word = fileSca.next();
                returnText.add(word);

            }
            
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred. - userfile");
            e.printStackTrace();
        }
        
        return returnText;
    }

    // takes an arralist of words and a arraylist of words that sould be replaced
    // for evry even index in the replacement araylist is a world that sould be replaced
    // and for evry odd index in the replacement arraylist is what the world sould be replaced with
    // return a arraylist that has replaced words
    private static ArrayList<String> replaceWords(ArrayList<String> originalText, ArrayList<String> replacementWords){
        ArrayList<String> returnText = new ArrayList<String>();
        for (int i = 0; i < originalText.size(); i++){
            boolean hasFoundMatch = false;

            for (int j = 0; j < replacementWords.size()-1; j += 2){ // Compares all the words with every word in     

                if(originalText.get(i).equals(replacementWords.get(j))){ // if the words match with one from replacement words. Then replace
                    returnText.add(replacementWords.get(j+1));
                    hasFoundMatch = true;
                    System.out.println("The word '" + originalText.get(i) + "' has been replaced with: '" + replacementWords.get(j +1) + "'");
                    break;
                }
            }
            if (hasFoundMatch == false){ // if the word has not been replaced then instert the original word
                returnText.add(originalText.get(i));
            }
        }
        return returnText;
    }
}