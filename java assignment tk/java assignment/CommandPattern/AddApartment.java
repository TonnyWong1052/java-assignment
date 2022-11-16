package CommandPattern;

import java.util.ArrayList;

import BuildingClass.Apartment;
import BuildingClass.Building;
import BuildingClass.Room;

public class AddApartment implements Command{
    private ArrayList<Building> _shape;
    private int id;
    private ArrayList<Room> rooms;
    private double monthlyRental;
    private String supportStaff;
    private int noOfRoom;
    

    public AddApartment(int i, ArrayList<Room> r, double m, String s, int noOfRoom){
        _shape = Main.Main._shape;
        id = i;
        rooms = r;
        monthlyRental = m;
        supportStaff = s;
    }

    @Override
    public void execute() {
        Apartment apartment = new Apartment(id, noOfRoom, monthlyRental, supportStaff);
        apartment.setRoom(rooms);
        _shape.add(apartment);
    }

    @Override
    public void printDetail() {
       System.out.println("Add Building: Building No.: " + id +", Support Staff: " + supportStaff + ", Monthly Rental: " + monthlyRental);
    }
    
}
