import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by percy on 1/18/16.
 */
public class ToDo {
    protected String description;
    protected Date dateAdded;

    public ToDo(String description, Date dateAdded){
        this.description = description;
        this.dateAdded = dateAdded;
    }

    @Override
    public String toString() {

        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

        String dateString = df.format(dateAdded);

        return description + " " + dateString;
    }

    public String getDescription() {
        return description;
    }

    public String getPlainDateString(){
        DateFormat df = new SimpleDateFormat("yyyyMMdd");
        return df.format(dateAdded);
    }
}
