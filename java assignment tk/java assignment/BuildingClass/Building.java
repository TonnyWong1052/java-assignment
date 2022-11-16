package BuildingClass;
import java.util.ArrayList;

public abstract class Building {
    private int id;
    private ArrayList<Room> rooms;

    public Building(int id, int noOfRooms) {
        rooms = new ArrayList<Room>();
        this.id = id;
        
    }

    public int getId(){
        return this.id;
    }

    public ArrayList<Room> getRooms(){
        return this.rooms;
    }

    public void setRoom(ArrayList<Room> rooms){
        this.rooms = rooms;
    }

    public Room addRoom(double length, double width){
        Room room = new Room(length, width);
        this.rooms.add(room);
        return room;
    }

    public void modifyRoom(int roomNo, double length, double width){
        Room room = new Room(length, width);
        this.rooms.set(roomNo-1, room);
    }

    public void deleteRoom(int roomNo){
        this.rooms.remove(roomNo-1);
    }

    public void printRooms() {
        for (int a = 0; a < rooms.size(); a++){
            System.out.println("Room No.: " + (a+1) +  ", " + rooms.get(a));
        }
    }

    public int getRoomQty(){
        return this.rooms.size();
    }
    public abstract void modifyBuilding();

    public abstract void printBuilding();
    
}
