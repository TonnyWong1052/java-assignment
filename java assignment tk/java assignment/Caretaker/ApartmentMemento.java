package Caretaker;

import java.util.ArrayList;

import BuildingClass.*;
import CommandPattern.*;

public class ApartmentMemento {
    private ArrayList<Room> Rooms = new ArrayList<>();
    private Command Command;
    private Building building;
    private String staff;
    private double mr;
    
    public ApartmentMemento(Command c, Building b){
        Command = c;
        copyRoom(b);
        building = b;
        mr = ((Apartment)b).getMonthlyRental();
        staff = ((Apartment)b).getSupportStaff();
    }

    private void copyRoom(Building b) {
        ArrayList<Room> room = b.getRooms();
        for (int x = 0; x < room.size(); x++) {
            Rooms.add(new Room(room.get(x).getLength(), room.get(x).getWidth()));
        }
    }

    public void redoData(){
        ((Apartment)building).setMonthlyRental(mr);
        ((Apartment)building).setSupportStaff(staff);
        ((Apartment)building).setRoom(Rooms);
    }

    public Command getCommand(){
        return Command;
    }
    
}
