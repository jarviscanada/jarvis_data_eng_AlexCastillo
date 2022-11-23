package ca.jrvs.apps.grep;
import javax.swing.*;


public class GrepDemoImp implements GrepDemo{
    public static void main(String[] args) {
        if (args.length < 2){
            JOptionPane.showMessageDialog(null, "Error Missing Arguments", "GREP DEMO" , JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
        JOptionPane.showMessageDialog(null, "Nothing to report", "GREP DEMO" , JOptionPane.INFORMATION_MESSAGE);
    }
}
