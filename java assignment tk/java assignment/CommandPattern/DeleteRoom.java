package CommandPattern;

import java.util.ArrayList;

import BuildingClass.Building;

public class DeleteRoom implements Command{
    private int roomNo;
    private Building building;
    private ArrayList<Building> _shape;
    private int id;
    private double length;
    private double width;

    public DeleteRoom(int n, Building b){
        roomNo = n;
        building = b;
        _shape = Main.Main._shape;
        for(int x=0;x<_shape.size();x++){
            if(_shape.get(x).getId() == building.getId()){
                id = _shape.get(x).getId();
                length = _shape.get(x).getRooms().get(roomNo-1).getLength();
                width = _shape.get(x).getRooms().get(roomNo-1).getWidth();
            }
        }
    }

    @Override
    public void execute() {
        building.deleteRoom(roomNo);
    }

    @Override
    public void printDetail() {
        System.out.println("Delete Room: Building No. " + id + ", Room No. " + roomNo + ", Length: " + length + ", Width: " + width);
    }
    
}
