package Main;

import java.util.*;

import BuildingClass.*;
import Caretaker.Caretaker;
import FactoryPattern.*;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static ArrayList<Building> _shape = new ArrayList<>();
    public static Caretaker caretaker = new Caretaker();

    public static void main(String[] args) {
        while (true) {
            System.out.println();
            System.out.println("Building Management System (BMS)");
            System.out.println("Please enter command: [a|d|m|e|u|r|l|x]");
            System.out.println(
                    "a = add building, d = display buildings, m = modify building, e = edit rooms");
            System.out.println("u = undo, r = redo, l = list undo/redo, x = exit system");
            String option = sc.next();
            if (option.equals("a")) {
                new AddBuildingFactory().create();
            } else if (option.equals("d")) {
                new DisplayBuildingFactory().create();
            } else if (option.equals("m")) {
                new ModifyBuildingFactory().create();
            } else if (option.equals("e")) {
                new EditRoomFactory().create();
            } else if (option.equals("u")) {
                new UndoFactory().create();
            } else if (option.equals("r")) {
                new RedoFactory().create();
            } else if (option.equals("l")) {
                new ListUndoRedoFactory().create();
            } else if (option.equals("x")) {
                new ExitSystemFactory().create();
            } else {
                System.out.println("Command incorrect!");
            }
        }

    }
}
