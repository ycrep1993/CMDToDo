import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by percy on 1/18/16.
 */
public class ToDoDone extends ToDo {
    private Date dateCompleted;

    public ToDoDone(String description, Date dateAdded, Date dateCompleted){
        super(description, dateAdded);
        this.dateCompleted = dateCompleted;
    }

    public String toString() {

        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

        String dateAddedString = df.format(dateAdded);
        String dateCompletedString = df.format(dateCompleted);

        return description + " " + dateAddedString + " " + dateCompletedString;
    }

    public String getDateCompletedString() {
        DateFormat df = new SimpleDateFormat("yyyyMMdd");
        return df.format(dateCompleted);
    }
}
