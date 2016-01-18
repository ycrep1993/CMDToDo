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
}
