package ca.jrvs.apps.grep;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface JavaGrep {
    /**
     * Top Level search workflow
     * @throws IOException
     */
    void process() throws IOException;

    /**
     *Traverse a given directory and return all the files
     * @param rootDir input directory
     * @return file under the rootDir
     */
    List<File> listfiles(String rootDir);

    /**
     * Read a file and return all lines
     * @param inputFile file to be read
     * @return lines
     */
    List<String> readLines(File inputFile);

    /**
     * Check if a line contain the regex pattern (passed by user)
     * @param line
     * @return true if there's a match
     */
    boolean containPattern(String line);

    /**
     * Write lines to a file
     * @param lines matched line
     * @throws IOException if write failed
     */
    void writeToFile(List<String> lines) throws IOException;

    String getRootPath();

    void setRootPath(String rootPath);

    String getRegex();

    void setRegex(String regex);

    String getOutput();

    void setOutput(String outfile);
}
