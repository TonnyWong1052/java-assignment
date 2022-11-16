package CommandPattern;

import java.util.ArrayList;

import BuildingClass.Building;


public class DisplaySingleBuilding implements Command{
    private ArrayList<Building> _shape;
    private int id;

    public DisplaySingleBuilding(int i){
        _shape = Main.Main._shape;
        id = i;
    }

    @Override
    public void execute() {
        for(int x=0;x<_shape.size();x++){
            if(_shape.get(x).getId() == id){
                _shape.get(x).printBuilding();
                return;
            }
        }
        System.out.println("The id is not exist");
    }

    @Override
    public void printDetail() {
        // TODO Auto-generated method stub
        
    }

}
