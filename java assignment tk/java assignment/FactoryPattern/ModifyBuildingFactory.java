package FactoryPattern;

import java.util.ArrayList;
import java.util.Scanner;

import BuildingClass.Apartment;
import BuildingClass.Building;
import BuildingClass.House;
import Caretaker.Caretaker;
import CommandPattern.DisplaySingleBuilding;
import CommandPattern.ModifyApartment;
import CommandPattern.ModifyHouse;

public class ModifyBuildingFactory implements Factories {
    private Scanner sc;
    private int id;
    private ArrayList<Building> _shape;
    private Building building;
    private Caretaker caretaker;

    public ModifyBuildingFactory() {
        sc = Main.Main.sc;
        _shape = Main.Main._shape;
        caretaker = Main.Main.caretaker;
    }

    @Override
    public void create() {
        // sc.nextLine();
        System.out.print("Building No.: ");
        id = sc.nextInt();

        for (int x = 0; x < _shape.size(); x++) {
            if (_shape.get(x).getId() == id) {
                System.out.println(_shape.get(x).toString());
                building = _shape.get(x);
                break;
            }
        }

        if (building != null) {
            if (building instanceof Apartment) {
                System.out.print("Modify Monthly Rental: ");
                int mr = sc.nextInt();
                sc.nextLine();
                System.out.print("Modify Support Staff: ");
                String name = sc.nextLine();
                ModifyApartment modifyApartment = new ModifyApartment(name, mr, building);
                caretaker.dailyUndoRecord(modifyApartment, building);
                modifyApartment.execute();  
            } else if (building instanceof House) {
                System.out.print("No. of Floors: ");
                int floor = sc.nextInt();
                ModifyHouse modifyHouse = new ModifyHouse(floor, building);
                caretaker.dailyUndoRecord(modifyHouse, building);
                modifyHouse.execute();
            }
            System.out.println();
            System.out.println("Building is modified:");
            DisplaySingleBuilding displaySingleBuilding = new DisplaySingleBuilding(id);
            displaySingleBuilding.execute();
        }

    }

}
