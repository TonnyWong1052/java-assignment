package FactoryPattern;

import java.util.Scanner;

import CommandPattern.DisplayAllBuilding;
import CommandPattern.DisplaySingleBuilding;

public class DisplayBuildingFactory implements Factories{
    private String id;
    private Scanner sc;

    public DisplayBuildingFactory(){
        sc = Main.Main.sc;
    }

    @Override
    public void create() {
        sc.nextLine();
        System.out.println("Enter Building No.(* to display all):");
        id = sc.nextLine();

        if(id.equals("*")){
            DisplayAllBuilding displayAllBuilding = new DisplayAllBuilding();
            displayAllBuilding.execute();
        }else {
            // displau single building
            try{
                DisplaySingleBuilding displaySingleBuilding = new DisplaySingleBuilding(Integer.parseInt(id));
                displaySingleBuilding.execute();
            }catch(Exception e){
                System.out.println(e.getMessage());
                System.out.println("Something get error");
            }
        }
    }
    
}
