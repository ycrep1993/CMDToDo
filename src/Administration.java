import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 * Created by percy on 1/18/16.
 */
public class Administration {
    private String toDoFileName;
    private ArrayList<ToDo> toDos = new ArrayList<>();

    public Administration(){
        readSettings();
        fillToDoArrayList();
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

    /**
     * Fill the arraylist with to do items. if there is no file with to do items, call the method to make a new one
     */
    public void fillToDoArrayList(){
        try {
            Scanner toDoReader = new Scanner(new File(toDoFileName));
            while (toDoReader.hasNextLine()){
                String line = toDoReader.nextLine();
                if(!line.startsWith("#")){
                    if(line.startsWith("ToDo")){
                        String[] lineArr = line.split(";");
                        if (lineArr.length == 3){
                            toDos.add(new ToDo(lineArr[1], convertStringToDate(lineArr[2])));
                        }
                        else if(lineArr.length == 4){
                            toDos.add(new ToDoDone(lineArr[1], convertStringToDate(lineArr[2]), convertStringToDate(lineArr[3])));
                        }
                    }
                }
            }
        }catch(FileNotFoundException fnfe){
            createToDoFile();
        }catch (IndexOutOfBoundsException ioobe){
            System.out.println("Hier gaat iets goed mis...");
        }
    }

    /**
     * converting String to Date
     * @param dateString the string to be converted (format should be yyyymmdd)
     * @return the Date dateString represents
     */
    public Date convertStringToDate(String dateString){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyymmdd");

        Date d;

        try {
            d = sdf.parse(dateString);
        }catch(ParseException pe){
            System.out.println("The Date parse failed");
            d = new Date();
        }
        return d;
    }

    /**
     * Create a empty to do file
     */
    public void createToDoFile(){
        try{
            FileWriter fw = new FileWriter(new File(toDoFileName));
            fw.append("# This file was automagically generated because it didn't exist already");
            fw.close();
        }catch(IOException ioe){
            System.out.println("Ik mag niet schrijven niet");
        }

    }

    /**
     * Returns the to do arraylist
     * @return toDos
     */
    public ArrayList<ToDo> getToDos(){
        return toDos;
    }

    public void addToDoToList(String description){
        toDos.add(new ToDo(description, new Date()));
    }

}
