import java.util.*;
public class addbuilding implements Command{
    Room room;
    double width, length;
 
    Apartment apartment;
    int id;
    int noOfRoom;
    double monthlyRental; 
    String supportStaff;
   
    Vector record;

    public addbuilding (Vector record, double width, double length, int id, int noOfRoom, double monthlyRental, String supportStaff){
        

        this.width=width;
        this.length=length;
        
        this.id = id;
        this.noOfRoom=noOfRoom;
        this.monthlyRental=monthlyRental;
        this.supportStaff=supportStaff;

        this.record = null;
        
    }
    @Override
    public void execute(){
        apartment =new Apartment(id, noOfRoom, monthlyRental, supportStaff);
        room = new Room(length, width);
        record.add(apartment);
        record.add(room);
    }

}
