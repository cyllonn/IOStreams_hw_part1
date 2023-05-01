import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class Main {
    public static String ROOT = "D://IO_Games";

    public static void main(String[] args) throws IOException {
        String[] dirPathsArray = new String[]{ROOT, ROOT + "/src", ROOT + "/res", ROOT + "/savegames", ROOT + "/temp",
                ROOT + "/src/main", ROOT + "/src/test", ROOT + "/res/drawables", ROOT + "/res/vectors", ROOT + "/res/icons"};
        String[] filePathsArray = new String[]{ROOT + "/src/main/Main.java", ROOT + "/src/main/Utils.java",
                ROOT + "/temp/temp.txt"};
        String temp = dirAdd(dirPathsArray) + fileAdd(filePathsArray);
        FileWriter fw = new FileWriter(ROOT + "/temp/temp.txt", true);
        fw.write(temp);
        fw.close();
    }

    public static String dirAdd(String[] dirPaths) {
        StringBuilder result = new StringBuilder();
        for (String dirPath : dirPaths) {
            File dir = new File(dirPath);
            if (dir.mkdir()) {
                result.append("At " + new Date() + " was created dir " + dir + "\n");
            } else {
                result.append(new Date() + " Cannot create directory " + dir + "  – File exists \n");
            }
        }
        return result.toString();
    }

    public static String fileAdd(String[] filePaths) {
        StringBuilder result = new StringBuilder();
        for (String filePath : filePaths) {
            File myFile = new File(filePath);
            try {
                if (myFile.createNewFile()) {
                    result.append("At " + new Date() + " was created file " + myFile + "\n");
                } else {
                    result.append (new Date() + " Cannot create directory " + myFile + "  – File exists \n");
                }
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
                result.append(new Date() + ex.getMessage() + "\n");
            }
        }
        return result.toString();
    }
}


