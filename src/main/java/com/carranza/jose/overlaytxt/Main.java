package com.carranza.jose.overlaytxt;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.util.List;

public class Main {
    private static String path;
    private static FileHandler fileHandler = new FileHandler();

    public static void readConfigFile(){
        try {
            fileHandler.readFile(path);
            path = fileHandler.readLine();
        }catch (FileNotFoundException e){
            fileHandler.createFile(path,false);
            path = "";
        }
        finally {
            if (fileHandler.getReader() != null){
                fileHandler.closeFile(fileHandler.getReader());
            }
            if (fileHandler.getWriter() != null){
                fileHandler.closeFile(fileHandler.getWriter());
            }
        }

    }

    public static void main(String[] args) {
        FileHandler.setPath("");
        path = FileNames.PATH_FILE_NAME.getValue()+".txt";
        readConfigFile();
        List<List<Integer>> a;
        if(path == null || path.isEmpty()){
            path = "";
        }else {
            path = path + '\\';
        }

        FileHandler.setPath(path);
        System.out.println(FileHandler.getPath());

        OverlayForm overlayForm = new OverlayForm();
        overlayForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        overlayForm.setLocationRelativeTo(null);
        overlayForm.setVisible(true);
    }
}
