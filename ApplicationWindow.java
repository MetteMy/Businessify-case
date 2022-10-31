

import javax.swing.*;
import java.awt.*;
import java.io.File;




class ApplicationWindow {

    JFrame frame = new JFrame("Businessify"); 
    BorderLayout BorderLayout = new BorderLayout();
    Color white = new Color(70, 143, 175);
    Color lightBlue = new Color(137, 194, 217);
    Color darkBlue = new Color(44, 125, 160);

    JPanel northPanel = new JPanel();
    JPanel southPanel = new JPanel();
    JPanel westPanel = new JPanel();
    JPanel eastPanel = new JPanel();
    JPanel centerPanel = new JPanel();
    
    JLabel title = new JLabel("BusinessifyInator 2000");
    JButton browseBtn = new JButton("Browse");
   
    JLabel fileName = new JLabel();
    JLabel originalTextlabel = new JLabel("Original tekst                                          ");
    JLabel translatedTextLabel = new JLabel("                                          Oversat tekst");
    JTextArea originalText = new JTextArea();
    JTextArea translatedText = new JTextArea();


    public ApplicationWindow() {
       

        
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);       
        frame.setVisible(true);

        frame.setLayout(BorderLayout);


        frame.add(northPanel, BorderLayout.NORTH);
        frame.add(southPanel, BorderLayout.SOUTH);
        frame.add(westPanel, BorderLayout.WEST);
        frame.add(eastPanel, BorderLayout.EAST);
        frame.add(centerPanel, BorderLayout.CENTER);
    
        
        northPanel.setBackground(white);
        westPanel.setBackground(darkBlue);
        centerPanel.setBackground(lightBlue);
        eastPanel.setBackground(darkBlue);
        southPanel.setBackground(lightBlue);
        
        
        translatedText.setEditable(false);
        translatedText.setColumns(50);
        translatedText.setRows(30);
        translatedText.setLineWrap(true);

        originalText.setEditable(false);
        originalText.setColumns(50);
        originalText.setRows(30);
        originalText.setLineWrap(true);
        
        northPanel.add(originalTextlabel);
        northPanel.add(title);
        northPanel.add(translatedTextLabel);
        centerPanel.add(browseBtn);
       
        centerPanel.add(fileName);
        
        westPanel.add(originalText);
        
        eastPanel.add(translatedText);

        frame.pack();
        
    } 
    
    public String fileChooser(JPanel panel) {
        File selectedFile = new File("");
        String filePath = "";
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home"))); //choooses the start directory
        int result = fileChooser.showOpenDialog(panel); //opens a dialog windoe, with the filechooser
        if (result == JFileChooser.APPROVE_OPTION) { //If 'Open' is clicked, and a file has been chosen
        selectedFile = fileChooser.getSelectedFile();
        
        fileName.setText(selectedFile.getName()); // Writes the file name, under the browse button. 
        filePath = selectedFile.getAbsolutePath(); 
        }
         
		return filePath; 

        
        
        

    
    }
}


