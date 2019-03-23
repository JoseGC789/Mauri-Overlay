package com.carranza.jose.overlaytxt;

import java.io.*;

public class FileHandler {
    private BufferedReader reader;
    private BufferedWriter writer;
    private static String path;


    public void readFile(String fileName) throws FileNotFoundException{
        reader = new BufferedReader(new FileReader(path+fileName));
    }

    public void createFile(String fileName, boolean append){
        try {
            writer = new BufferedWriter(new FileWriter(path+fileName, append));
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public String readLine(){
        String str = null;
        try {
            str = reader.readLine();
        }catch (IOException e){
            e.printStackTrace();
        }
        return str;
    }

    public void writeLine(String input){
        try {
            writer.write(input);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void writeLine(){
        try {
            writer.newLine();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void closeFile(Closeable file){
        try {
            file.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public BufferedReader getReader() {
        return reader;
    }

    public BufferedWriter getWriter() {
        return writer;
    }

    public static String getPath() {
        return FileHandler.path;
    }

    public static void setPath(String path) {
        FileHandler.path = path;
    }
}
