import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by percy on 1/18/16.
 */
public class ToDoDone extends ToDo {
    private Date dateCompleted;

    /**
     * A done to do item
     * @param description description of the item
     * @param dateAdded the date it was created
     * @param dateCompleted the date it was done
     */
    public ToDoDone(String description, Date dateAdded, Date dateCompleted){
        super(description, dateAdded);
        this.dateCompleted = dateCompleted;
    }

    /**
     * Make a string containing all information of the to do item
     * @return the string
     */
    public String toString() {

        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

        String dateAddedString = df.format(dateAdded);
        String dateCompletedString = df.format(dateCompleted);

        return description + " " + dateAddedString + " " + dateCompletedString;
    }

    /**
     * convert the date to a string containing year month and day
     * @return converted date
     */
    public String getDateCompletedString() {
        DateFormat df = new SimpleDateFormat("yyyyMMdd");
        return df.format(dateCompleted);
    }
}
