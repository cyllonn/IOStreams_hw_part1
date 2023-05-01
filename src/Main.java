import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class Main {
    public static String ROOT = "D://IO_Games";

    public static void main(String[] args) throws IOException {
        StringBuilder temp = new StringBuilder();
        String[] dirPathsArray = new String[]{ROOT, ROOT + "/src", ROOT + "/res", ROOT + "/savegames", ROOT + "/temp",
                ROOT + "/src/main", ROOT + "/src/test", ROOT + "/res/drawables", ROOT + "/res/vectors", ROOT + "/res/icons"};
        String[] filePathsArray = new String[]{ROOT + "/src/main/Main.java", ROOT + "/src/main/Utils.java",
                ROOT + "/temp/temp.txt"};
        for (int i = 0; i < dirPathsArray.length; i++) {
            File dir = new File(dirPathsArray[i]);
            if (dir.mkdir()) {
               
                temp.append("At " + new Date() + " was created dir " + dir + "\n");
            } else {
                temp.append(new Date() + " Cannot create directory " + dir + "  – File exists \n");
            }
        }
        for (int i = 0; i < filePathsArray.length; i++) {
            File myFile = new File(filePathsArray[i]);
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
        FileWriter fw = new FileWriter(ROOT + "/temp/temp.txt", true);
        fw.write(temp.toString());
        fw.close();

    }
}
