import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by percy on 1/18/16.
 */
public class ToDo {
    protected String description;
    protected Date dateAdded;

    /**
     * A to do item
     * @param description description of the item
     * @param dateAdded the date it was created
     */
    public ToDo(String description, Date dateAdded){
        this.description = description;
        this.dateAdded = dateAdded;
    }

    /**
     * Make a string containing all information of the to do item
     * @return the string
     */
    @Override
    public String toString() {

        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

        String dateString = df.format(dateAdded);

        return description + " " + dateString;
    }

    /**
     * get the description
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * convert the date to a string containing year month and day
     * @return converted date
     */
    public String getPlainDateString(){
        DateFormat df = new SimpleDateFormat("yyyyMMdd");
        return df.format(dateAdded);
    }
}
