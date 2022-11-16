package CommandPattern;

import java.util.ArrayList;

import BuildingClass.Building;
import BuildingClass.House;
import BuildingClass.Room;

public class AddHouse implements Command {
    private ArrayList<Building> _shape;
    private int id;
    private int noOfRoom;
    private int noOfFloors;
    private ArrayList<Room> rooms;

    public AddHouse(int i, int no, int floor, ArrayList<Room> room) {
        _shape = Main.Main._shape;
        id = i;
        noOfRoom = no;
        noOfFloors = floor;
        rooms = room;
    }

    @Override
    public void execute() {
        House apartment = new House(id, noOfRoom, noOfFloors);
        apartment.setRoom(rooms);
        _shape.add(apartment);
    }

    @Override
    public void printDetail() {
        System.out.println("Add Building: Building No.: " + id + ", No. of Floor: " + noOfFloors);
    }

}
