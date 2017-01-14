package util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.Scanner;

public class FileUtil {
    
    // instance variable: formatter
    private Formatter formatter;
    
    // instance variable: scanner;
    private Scanner scanner;   

    // to open the file
    public String openWriteFile(String path) {
        String s = "";
        try {
            formatter = new Formatter(path);
            s = "File '" + path + "' is opening.";
        } catch (FileNotFoundException e) {
            s = "Error Opening File '" + path + "' : " + e;
        }
        return s;
    }

    // to add record/data to opening file
    public String addWriteRecord(String format, Object... objs) {        
        formatter.format(format, objs);        
        return "Record added to file.";
    }

    // to close opening file
    public String closeWriteFile() {        
        formatter.close();        
        return "File closed.";
    }
    
    // to open read file
    public String openReadFile(String path) {
        String s = "";
        try {
            scanner = new Scanner(new File(path));
            s = "File '" + path + "' is opening to read.";
        } catch (FileNotFoundException e) {
            s = "Error Opening Read File '" + path + "' : " + e;
        }
        return s;
    }
    
    // to read opening file
    public Scanner getReadScanner() {
        return this.scanner;
    }
    
    // to close reading file
    public String closeReadFile() {
        scanner.close();
        return "Read file closed.";
    }
    
    public boolean deleteFile(String path){
        File file = new File ("enemybattle.txt");
        return file.delete();
    }
    
    public boolean deleteExistingFile1(String path){
        File file = new File ("enemy.txt");
        return file.delete();
    }
    
    public boolean deleteExistingFile2(String path){
        File file = new File ("hero.txt");
        return file.delete();
    }
    
}
