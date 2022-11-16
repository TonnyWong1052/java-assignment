package Caretaker;

import java.util.ArrayList;

import BuildingClass.*;
import CommandPattern.Command;

public class HouseMemento {
    private ArrayList<Room> Rooms = new ArrayList<>();
    private Command Command;
    private Building building;
    private int noOfFloors;

    public HouseMemento(Command c, Building b) {
        Command = c;
        copyRoom(b);
        building = b;
        noOfFloors = ((House) b).getFloors();
        System.out.println(noOfFloors);
    }

    private void copyRoom(Building b) {
        ArrayList<Room> room = b.getRooms();
        for (int x = 0; x < room.size(); x++) {
            Rooms.add(new Room(room.get(x).getLength(), room.get(x).getWidth()));
        }
    }

    public void redoData() {
        ((House) building).setFloors(noOfFloors);
        ((House) building).setRoom(Rooms);
    }

    public Command getCommand() {
        return Command;
    }
}
