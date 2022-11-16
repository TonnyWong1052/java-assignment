package CommandPattern;

import java.util.ArrayList;

import BuildingClass.Building;

public class AddRoom implements Command{
    private double width;
    private double length;
    private Building building;
    private ArrayList<Building> _shape;
    private int id;
    private int roomNo;

    public AddRoom(double w, double l, Building b){
        width = w;
        length = l;
        building = b;
        _shape = Main.Main._shape;

        for(int x=0;x<_shape.size();x++){
            if(_shape.get(x).getId() == building.getId()){
                id = _shape.get(x).getId();
                roomNo = _shape.get(x).getRoomQty()-1;
            }
        }
    }

    @Override
    public void execute(){
        building.addRoom(length, width);
    }

    @Override
    public void printDetail() {
        System.out.println("Add Room: Building No. " + id +", Room No. " + roomNo + ", Length: " + length + ", Width: " + width);
    }

}
