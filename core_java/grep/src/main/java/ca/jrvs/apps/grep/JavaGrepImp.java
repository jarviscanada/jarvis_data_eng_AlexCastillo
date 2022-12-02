package ca.jrvs.apps.grep;



import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class JavaGrepImp implements  JavaGrep{

    //final Logger logger = LoggerFactory.getLogger(JavaGrep.class);

    private String regex;
    private String rootPath;
    private String output;

    public static void main(String[] args) {
        if (args.length != 3){
            throw new IllegalArgumentException("USAGE: Javagrep regex rootPath outputFile");
        }

        JavaGrepImp javaGrepImp = new JavaGrepImp();
        javaGrepImp.setRegex(args[0]);
        javaGrepImp.setRootPath(args[1]);
        javaGrepImp.setOutput(args[2]);

        try {
            javaGrepImp.process();
        } catch (Exception ex) {
            //javaGrepImp.logger.error("Error: Unable to process", ex);
            JOptionPane.showMessageDialog(null, "Error: Unable to process", "JAVA GREP" , JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }

    }

    @Override
    public void process() throws IOException {
        List<String> matchLines = new ArrayList<>();
        File folder = new File(rootPath);
        List<File> listFiles = Arrays.asList(folder.listFiles());;
        for (File file : listFiles) {
            List<String> allLines = readLines(file);
            for (String line : allLines){
                if (containPattern(line)){
                    matchLines.add(line);
                }
            }
        }
        writeToFile(matchLines);
    }

    @Override
    public List<File> listfiles(String rootDir) {
        File folder = new File(rootPath);
        List<File> listOfFiles = Arrays.asList(folder.listFiles());
        return listOfFiles;
    }

    @Override
    public List<String> readLines(File inputFile) {
        List<String> linesArray = new ArrayList<>();
        if (inputFile.isFile() && inputFile.getName().endsWith(".txt")) {
            try {
                Scanner reader = new Scanner(inputFile);
                while (reader.hasNextLine()) {
                    String content = reader.nextLine();
                    linesArray.add(content);
                }
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        return linesArray;
    }

    @Override
    public boolean containPattern(String line) {
        if (Pattern.matches(regex, line)) {
          return true;
        } else {
            return false;
        }
    }

    @Override
    public void writeToFile(List<String> lines) throws IOException {
        File outputFile = new File(rootPath + "\\" + output);
        for (String line : lines) {
            try {
                FileWriter writer = new FileWriter(outputFile);
                writer.write(line);
                writer.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public String getRegex() {
        return regex;
    }

    @Override
    public void setRegex(String regex) {
        this.regex = regex;
    }

    @Override
    public String getRootPath() {
        return rootPath;
    }

    @Override
    public void setRootPath(String rootPath) {
        this.rootPath = rootPath;
    }

    @Override
    public String getOutput() {
        return output;
    }

    @Override
    public void setOutput(String output) {
        this.output = output;
    }
}
