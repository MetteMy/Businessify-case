

import javax.swing.*;
import java.awt.*;
import java.io.File;



class ApplicationWindow {


    public static void main(String[] args) {
       


        BorderLayout BorderLayout = new BorderLayout();
        
        Color lightBlue = new Color(169, 214, 229);
        Color darkBlue = new Color(42, 111, 151);

        JFrame frame = new JFrame("Businessify"); 
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //frame.setBounds(200, 200, 600, 400);
        //frame.setSize(400, 400);
        
        frame.setVisible(true);
        frame.setLayout(BorderLayout);

        JPanel northPanel = new JPanel();
        JPanel southPanel = new JPanel();
        JPanel westPanel = new JPanel();
        JPanel eastPanel = new JPanel();
        JPanel centerPanel = new JPanel();


        frame.add(northPanel, BorderLayout.NORTH);
        frame.add(southPanel, BorderLayout.SOUTH);
        frame.add(westPanel, BorderLayout.WEST);
        frame.add(eastPanel, BorderLayout.EAST);
        frame.add(centerPanel, BorderLayout.CENTER);
    
        
        northPanel.setBackground(darkBlue);
        westPanel.setBackground(darkBlue);
        centerPanel.setBackground(lightBlue);
        eastPanel.setBackground(lightBlue);
        southPanel.setBackground(lightBlue);
        
        
        JLabel title = new JLabel("BusinessifyInator 2000");
        JButton browseBtn = new JButton("Browse");
        JButton businessifyBtn = new JButton("Businessify");
        JTextArea translatedText = new JTextArea();
        
        translatedText.setEditable(false);
        translatedText.setColumns(80);
        translatedText.setRows(30);
        

        
        
        northPanel.add(title);

        centerPanel.add(browseBtn);
        centerPanel.add(businessifyBtn);
        westPanel.add(translatedText);

        
        browseBtn.addActionListener(e -> {
            fileChooser(centerPanel);
        });
        businessifyBtn.addActionListener(e -> {
            // kode som businessificerer 
            
        });
        
        
        
        frame.pack();
        
    } 
    
    private static void fileChooser(JPanel panel) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        int result = fileChooser.showOpenDialog(panel);
        if (result == JFileChooser.APPROVE_OPTION) {
        File selectedFile = fileChooser.getSelectedFile();
        System.out.println("Selected file: " + selectedFile.getAbsolutePath());
        

        

    }
    }
}


