package FactoryPattern;

import java.util.ArrayList;
import java.util.Scanner;

import BuildingClass.Building;
import Caretaker.Caretaker;
import CommandPattern.AddRoom;
import CommandPattern.DeleteRoom;
import CommandPattern.DisplaySingleBuilding;
import CommandPattern.ModifyRoom;

public class EditRoomFactory implements Factories {
    private Scanner sc;
    private ArrayList<Building> _shape;
    private Building building;
    private double width;
    private double length;
    private int id;
    private int roomNo;
    private Caretaker caretaker;

    public EditRoomFactory() {
        sc = Main.Main.sc;
        _shape = Main.Main._shape;
        caretaker = Main.Main.caretaker;
    }

    @Override
    public void create() {
        System.out.print("Building No.: ");
        id = sc.nextInt();

        for (int x = 0; x < _shape.size(); x++) {
            if (_shape.get(x).getId() == id) {
                _shape.get(x).printBuilding();
                building = _shape.get(x);
                break;
            }
        }

        if (building != null) {
            System.out.println();
            System.out.println("Please enter command: [a|d|m]");
            System.out.println("a = add room, d = delete room, m = modify room");
            sc.nextLine();
            String command = sc.nextLine();
            try {
                if (command.equals("a")) {
                    askRoomSize();
                    AddRoom addRoom = new AddRoom(width, length, building);
                    caretaker.dailyUndoRecord(addRoom, building);
                    addRoom.execute();
                } else if (command.equals("d")) {
                    askRoomNo();
                    DeleteRoom deleteRoom = new DeleteRoom(roomNo, building);
                    caretaker.dailyUndoRecord(deleteRoom, building);
                    deleteRoom.execute();
                } else if (command.equals("m")) {
                    askRoomNo();
                    askRoomSize();
                    ModifyRoom modifyRoom = new ModifyRoom(width, length, roomNo, building);
                    caretaker.dailyUndoRecord(modifyRoom, building);
                    modifyRoom.execute();
                } else {
                    System.out.print("The command incorrect");
                }
                System.out.println("Updated Building:");
                DisplaySingleBuilding displaySingleBuilding = new DisplaySingleBuilding(id);
                displaySingleBuilding.execute();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("Something get error");
            }
        } else {
            System.out.print("The id not exist");
        }
    }

    private void askRoomSize() {
        System.out.print("Length: ");
        length = sc.nextDouble();
        System.out.print("Width: ");
        width = sc.nextDouble();
    }

    private void askRoomNo() {
        System.out.println("Room No.:");
        roomNo = sc.nextInt();
    }
}
