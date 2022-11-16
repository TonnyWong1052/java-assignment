package CommandPattern;

import BuildingClass.Apartment;
import BuildingClass.Building;

public class ModifyApartment implements Command{
    private Building building;
    private String name;
    private double mr;
    private int id;

    public ModifyApartment(String n, int m, Building b){
        name = n;
        mr = m;
        building = b;
        id = building.getId();
    }

    @Override
    public void execute() {
        ((Apartment)building).setMonthlyRental(mr);
        ((Apartment)building).setSupportStaff(name);

    }

    @Override
    public void printDetail() {
        System.out.println("Modify Building: Building No. " + id + ", Support Staff: " + name + ", Monthly Rental: " + mr);
    }
    
}
