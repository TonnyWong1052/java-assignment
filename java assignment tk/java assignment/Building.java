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

    public void printRooms(){
        for (int x = 0; x < this.rooms.size(); x++) {
            double currentRoom_length = this.rooms.get(x).getLength();
            double currentRoom_width = this.rooms.get(x).getWidth();
            System.out.println("Room " + x + ": Length = " + currentRoom_length + ", Width = " + currentRoom_width);
        }
    }

    public int getRoomQty(){
        return this.rooms.size();
    }
    public abstract void modifyBuilding();

    public abstract void printBuilding();
    
}
