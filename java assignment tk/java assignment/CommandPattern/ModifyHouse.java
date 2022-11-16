package CommandPattern;

import BuildingClass.Building;
import BuildingClass.House;

public class ModifyHouse implements Command{
    private Building building;
    private int noOfFloors;
    private int id;

    public ModifyHouse(int floor, Building b){
        noOfFloors = floor;
        building = b;
        id = building.getId();
    }

    @Override
    public void execute() {
        ((House)building).setFloors(noOfFloors);
    }

    @Override
    public void printDetail() {
        System.out.println("Modify Building: Building No. " + id + ", No. of Floor: " + noOfFloors);   
    }
    
}
