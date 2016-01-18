import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by percy on 1/18/16.
 */
public class Administration {
    private String toDoFileName;
    private ArrayList<ToDo> toDos = new ArrayList<>();

    public Administration(){
        readSettings();
    }

    /**
     * Read the settingsfile
     */
    public void readSettings(){
        try{
            Scanner settingsReader = new Scanner(new File("settings"));
            while (settingsReader.hasNextLine()){
                String line = settingsReader.nextLine();
                if(!line.startsWith("#")){
                    if(line.startsWith("toDoFileName")){
                        String[] lineArr = line.split(";");
                        toDoFileName = lineArr[1];
                        break;
                    }
                }
            }
            settingsReader.close();
        }catch(FileNotFoundException fnfe){
            createSettingsFile();
        }
    }

    /**
     * If there is no settingsfile, a new default settingsfile should be created
     */
    public void createSettingsFile(){
        try{
            FileWriter fw = new FileWriter(new File("settings"));
            fw.append("# Main settings file for Simple To Do program\n" +
                    "# Commented lines start with a hash\n" +
                    "\n" +
                    "#filename for todos\n" +
                    "toDoFileName;defaultToDos\n" +
                    "\n");
            fw.close();
        }catch(IOException ioe){
            System.out.println("There is something wrong... i can't write. Try giving me some more permissions in my own folder");
        }

    }

    public void fillToDoArrayList(){

    }


}
