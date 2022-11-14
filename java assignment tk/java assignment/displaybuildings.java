
import java.util.*;

public class displaybuildings implements Command {
    Vector record;

    public displaybuildings ( Vector record){
        this.record = record;
    }

    public void execute() {
        for (int i = 0; i < record.size(); i++)
			( (Building) record.elementAt(i)).printRooms();
}

}
