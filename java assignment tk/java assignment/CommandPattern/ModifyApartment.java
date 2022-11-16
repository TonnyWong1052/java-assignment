package CommandPattern;

import BuildingClass.Apartment;
import BuildingClass.Building;

public class ModifyApartment implements Command{
    private Building building;
    private String name;
    private int mr;

    public ModifyApartment(String n, int m, Building b){
        name = n;
        mr = m;
        building = b;
    }

    @Override
    public void execute() {
        ((Apartment)building).setMonthlyRental(mr);
        ((Apartment)building).setSupportStaff(name);
    }

    @Override
    public void printDetail() {
        // TODO Auto-generated method stub
        
    }
    
}
