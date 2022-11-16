package CommandPattern;

import java.util.ArrayList;

import BuildingClass.Building;

public class DisplayAllBuilding implements Command{
    private ArrayList<Building> _shape;

    public DisplayAllBuilding(){
        _shape = Main.Main._shape;
    }

    @Override
    public void execute() {
        for(int x=0;x<_shape.size();x++)
            System.out.println( _shape.get(x).toString());
    }

    @Override
    public void printDetail() {
        // TODO Auto-generated method stub
        
    }
    
}
