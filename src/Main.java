import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class Main {
    public static String ROOT = "D://IO_Games";
    public static StringBuilder temp = new StringBuilder();

    public static void main(String[] args) throws IOException {
        String[] dirPathsArray = new String[]{ROOT, ROOT + "/src", ROOT + "/res", ROOT + "/savegames", ROOT + "/temp",
                ROOT + "/src/main", ROOT + "/src/test", ROOT + "/res/drawables", ROOT + "/res/vectors", ROOT + "/res/icons"};
        String[] filePathsArray = new String[]{ROOT + "/src/main/Main.java", ROOT + "/src/main/Utils.java",
                ROOT + "/temp/temp.txt"};
        dirAdd(dirPathsArray);
        fileAdd(filePathsArray);
        FileWriter fw = new FileWriter(ROOT + "/temp/temp.txt", true);
        fw.write(temp.toString());
        fw.close();

    }
    public static void dirAdd(String[] dirPaths){
        for (int i = 0; i < dirPaths.length; i++) {
            File dir = new File(dirPaths[i]);
            if (dir.mkdir()) {

                temp.append("At " + new Date() + " was created dir " + dir + "\n");
            } else {
                temp.append(new Date() + " Cannot create directory " + dir + "  – File exists \n");
            }
        }

    }
    public static void fileAdd(String[] filePaths){
         for (int i = 0; i < filePaths.length; i++) {
            File myFile = new File(filePaths[i]);
            try {
                if (myFile.createNewFile()) {
                    temp.append("At " + new Date() + " was created file " + myFile + "\n");
                } else {
                    temp.append(new Date() + " Cannot create directory " + myFile + "  – File exists \n");
                }
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
                temp = temp.append(new Date() + ex.getMessage() + "\n");
            }
        }

    }
}


