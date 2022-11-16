package FactoryPattern;

import java.util.*;

import BuildingClass.Apartment;
import BuildingClass.Building;
import BuildingClass.House;
import BuildingClass.Room;
import Caretaker.Caretaker;
import CommandPattern.AddApartment;
import CommandPattern.AddHouse;
import CommandPattern.DisplaySingleBuilding;

public class AddBuildingFactory implements Factories {
    private Scanner sc;
    private ArrayList<Building> _shape;
    private int id;
    private int NoOfRoom;
    private double width;
    private double length;
    private ArrayList<Room> rooms;
    private Caretaker caretaker;

    public AddBuildingFactory() {
        sc = Main.Main.sc;
        _shape = Main.Main._shape;
        caretaker = Main.Main.caretaker;
        rooms = new ArrayList<>();
    }

    public void create() {
        sc.nextLine();
        System.out.println("Enter Building Type (a=Apartment/h=House):");
        String BuildingType = sc.nextLine();
        System.out.print("Building No.:");
        id = sc.nextInt();

        if (BuildingType.equals("a")) {
            System.out.print("Monthly Rental: ");
            double mr = sc.nextDouble();
            sc.nextLine();
            System.out.print("Support Staff: ");
            String name = sc.nextLine();
            System.out.print("Number of rooms: ");
            NoOfRoom = sc.nextInt();
            createRoom();
            AddApartment addApartment = new AddApartment(id, rooms, mr, name, NoOfRoom);
            addApartment.execute();
            Apartment apartment = null;
            for(int x=0;x<_shape.size();x++){
                if(_shape.get(x).getId() == id)
                apartment = (Apartment)_shape.get(x);
            }
            caretaker.dailyUndoRecord(addApartment, apartment);
                
        } else if (BuildingType.equals("h")) {
            System.out.print("No. of Floors: ");
            int noOfFloors = sc.nextInt();
            System.out.print("Number of rooms: ");
            NoOfRoom = sc.nextInt();
            createRoom();
            AddHouse addHouse =  new AddHouse(id, NoOfRoom, noOfFloors, rooms);
            addHouse.execute();
            House house = null;
            for(int x=0;x<_shape.size();x++){
                if(_shape.get(x).getId() == id)
                house = (House)_shape.get(x);
            }
            if(house != null) 
                caretaker.dailyUndoRecord(addHouse, house);
        } else {
            System.out.print("input incorrect");
            return;
        }
        System.out.println("New Building Added:");
        DisplaySingleBuilding displaySingleBuilding = new DisplaySingleBuilding(id);
        displaySingleBuilding.execute();
    }

    private void createRoom() {
        for (int i = 1; i <= NoOfRoom; i++) {
            System.out.println("Room No. " + i);
            System.out.print("Length: ");
            length = sc.nextDouble();
            System.out.print("Width: ");
            width = sc.nextDouble();
            rooms.add(new Room(length, width));
        }
    }
}
