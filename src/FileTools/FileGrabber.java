package FileTools;

import javax.swing.*;
import java.io.File;

public class FileGrabber {
    private static JFileChooser fileChooser = new JFileChooser();
    private static File selectedFile;

    /**
     * gets a file from the user
     * @return the file chosen by the user
     */
    public static File GetFileFromUser(){
        boolean done = false;

        do {

            File workingDirectory = new File(System.getProperty("user.dir"));
            fileChooser.setCurrentDirectory(workingDirectory);//set the current directory for the file chooser

            if(fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){//open the chooser
                try {
                    selectedFile = fileChooser.getSelectedFile();
                    done = true;
                }catch (Exception e){
                    e.printStackTrace();
                    done = true;
                }
            }
            if(!done){
                System.out.println("No file chosen! Please choose a file before moving forward.");
            }
        }while(!done);
        return selectedFile;
    }

    /**
     * gets a file from the user
     * @return the file chosen by the user
     */
    public static File GetFileFromUser(int mode){
        boolean done = false;

        do {

            File workingDirectory = new File(System.getProperty("user.dir"));
            fileChooser.setCurrentDirectory(workingDirectory);//set the current directory for the file chooser
            fileChooser.setFileSelectionMode(mode);

            if(fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){//open the chooser
                try {
                    selectedFile = fileChooser.getSelectedFile();
                    done = true;
                }catch (Exception e){
                    e.printStackTrace();
                    done = true;
                }
            }
            if(!done){
                System.out.println("No file chosen! Please choose a file before moving forward.");
            }
        }while(!done);
        return selectedFile;
    }

}
