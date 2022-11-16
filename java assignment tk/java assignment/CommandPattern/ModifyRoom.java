package CommandPattern;

import BuildingClass.Building;

public class ModifyRoom implements Command{
    private double width;
    private double length;
    private int RoomNo;
    private Building building;

    public ModifyRoom(double w, double l, int r, Building b){
        width = w;
        length = l;
        RoomNo = r;
        building = b;
    }

    @Override
    public void execute() {
        building.modifyRoom(RoomNo, length, width);
    }

    @Override
    public void printDetail() {
        System.out.println("Modify Room: Building No. 1001, Room No. 2, Length: 9.0, Width: 18.0");
    }
    
}
