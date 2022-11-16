package CommandPattern;

import BuildingClass.Building;
import BuildingClass.House;

public class ModifyHouse implements Command{
    private Building building;
    private int noOfFloors;

    public ModifyHouse(int floor, Building b){
        noOfFloors = floor;
        building = b;
    }

    @Override
    public void execute() {
        ((House)building).setFloors(noOfFloors);
    }

    @Override
    public void printDetail() {
        // TODO Auto-generated method stub
        
    }
    
}
