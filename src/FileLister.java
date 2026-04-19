import FileTools.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileLister {
    public static List<File> RecursiveListFiles(File directory){
        List<File> files = new ArrayList<>();
        Sub_RecursiveList(directory, files);
        return files;
    }
    private static void Sub_RecursiveList(File directory, List<File> files){
        for(File file : directory.listFiles()){
            if(file.isDirectory()){
                Sub_RecursiveList(file, files);
            }else{
                files.add(file);
            }
        }
    }
}
