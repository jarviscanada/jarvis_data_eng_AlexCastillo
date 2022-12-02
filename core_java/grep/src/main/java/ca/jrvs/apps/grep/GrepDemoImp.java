package ca.jrvs.apps.grep;
import javax.swing.*;
import java.io.*;
import java.util.Scanner;
import java.util.regex.*;

public class GrepDemoImp implements GrepDemo{

    public static void main(String[] args) {
        if (args.length != 3){
            JOptionPane.showMessageDialog(null, "Error Missing Arguments", "GREP DEMO" , JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
        String regexPattern = args[0];
        File folder = new File(args[1]);
        File[] listOfFiles = folder.listFiles();
        File output = new File(args[1] + "\\" + args[2]);

        for (int i = 0; i < listOfFiles.length; i++) {
            File file = listOfFiles[i];
            if (file.isFile() && file.getName().endsWith(".txt")) {
                try {
                    Scanner reader = new Scanner(file);
                    while (reader.hasNextLine()){
                        String content = reader.nextLine();
                        if (Pattern.matches(regexPattern, content)){
                            try {
                                FileWriter writer = new FileWriter(output);
                                writer.write(content);
                                writer.close();
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    }
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        JOptionPane.showMessageDialog(null, "File created in " + args[2], "GREP DEMO" , JOptionPane.INFORMATION_MESSAGE);
    }
}
