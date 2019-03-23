package com.carranza.jose.overlaytxt;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class OverlayForm extends JFrame {
    private JTextField p1NameField; //"Player n"
    private JTextField p1ScoreField;//"PnScore"
    private JTextField p2NameField;
    private JTextField p2ScoreField;
    private JTextField extraField1;//"EXTRA n"
    private JTextField extraField2;
    private JTextField extraField3;
    private JTextField extraField4;
    private JPanel rootPanel;
    private JButton commitButton;

    public OverlayForm(){
        add(rootPanel);
        setSize(450, 180);
        setTitle("Overlay Text Editor");
        p1NameField.setText(readFromFile(FileNames.PLAYER,1));
        p2NameField.setText(readFromFile(FileNames.PLAYER,2));
        p1ScoreField.setText(readFromFile(FileNames.SCORE,1));
        p2ScoreField.setText(readFromFile(FileNames.SCORE,2));
        extraField1.setText(readFromFile(FileNames.EXTRA,1));
        extraField2.setText(readFromFile(FileNames.EXTRA,2));
        extraField3.setText(readFromFile(FileNames.EXTRA,3));
        extraField4.setText(readFromFile(FileNames.EXTRA,4));

        commitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<String> fieldInput = new ArrayList<>();
                fieldInput.add(p1NameField.getText());
                fieldInput.add(p2NameField.getText());
                saveToFile(fieldInput,FileNames.PLAYER);
                fieldInput.clear();
                fieldInput.add(p1ScoreField.getText());
                fieldInput.add(p2ScoreField.getText());
                saveToFile(fieldInput,FileNames.SCORE);
                fieldInput.clear();
                fieldInput.add(extraField1.getText());
                fieldInput.add(extraField2.getText());
                fieldInput.add(extraField3.getText());
                fieldInput.add(extraField4.getText());
                saveToFile(fieldInput,FileNames.EXTRA);
                fieldInput.clear();
            }
        });
    }

    private String readFromFile (FileNames fileNames,int i){
        FileHandler fileHandler = new FileHandler();
        String str = null;
        try {
            fileHandler.readFile(fileNames.getValue()+" "+i+".txt");
            str = fileHandler.readLine();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }finally {
            if (fileHandler.getReader() != null){
                fileHandler.closeFile(fileHandler.getReader());
            }
        }
        return str;
    }

    private void saveToFile(ArrayList<String> input,FileNames fileNames){
        FileHandler fileHandler = new FileHandler();
        int i = 1;
        for (String string:input) {
            fileHandler.createFile(fileNames.getValue()+" "+i+".txt",false);
            fileHandler.writeLine(string);
            fileHandler.closeFile(fileHandler.getWriter());
            i++;
        }
    }
}
