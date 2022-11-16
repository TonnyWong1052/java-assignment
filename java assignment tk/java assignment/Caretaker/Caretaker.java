package Caretaker;

import java.util.LinkedList;
import java.util.Stack;

import BuildingClass.*;
import CommandPattern.Command;

public class Caretaker {
    private LinkedList<Object> undo = new LinkedList<>();
    private LinkedList<Object> redo = new LinkedList<>();

    public void dailyUndoRecord(Command command, Building building) {
        if (building instanceof Apartment)
            undo.add(new ApartmentMemento(command, building));
        else if (building instanceof House)
            undo.add(new HouseMemento(command, building));
        else {
            System.out.println("error");
        }
    }

    public void listAll() {
        System.out.println("Undo List:");
        if (undo.size() != 0) {
            for (int x = undo.size() - 1; x >= 0; x--) {
                if (undo.get(x) instanceof ApartmentMemento)
                    // System.out.println(((ApartmentMemento) undo.get(x)).getCommand());
                    ((ApartmentMemento) undo.get(x)).getCommand().printDetail();
                else if (undo.get(x) instanceof HouseMemento)
                    // System.out.println(((HouseMemento) undo.get(x)).getCommand());
                    ((HouseMemento) undo.get(x)).getCommand().printDetail();
                else
                    System.out.println("error");
            }
        } else {
            System.out.println("Nothing to Undo.");
        }
        System.out.println("Redo List:");
        if (redo.size() != 0) {
            for (int x = redo.size() - 1; x >= 0; x--) {
                if (redo.get(x) instanceof ApartmentMemento)
                    ((ApartmentMemento) redo.get(x)).getCommand().printDetail();
                // System.out.println(((ApartmentMemento) redo.get(x)).getCommand());
                else if (redo.get(x) instanceof HouseMemento)
                    ((HouseMemento) redo.get(x)).getCommand().printDetail();
                // System.out.println(((HouseMemento) redo.get(x)).getCommand());
            }
        } else {
            System.out.println("Nothing to Redo.");
        }
    }

    public void undo() {
        if (undo.size() != 0) {
            if (undo.get(undo.size() - 1) instanceof ApartmentMemento) {
                ApartmentMemento apartmentMemento = (ApartmentMemento) undo.remove(undo.size() - 1);
                redo.addLast(apartmentMemento);
                apartmentMemento.redoData();
                undo.remove(redo.size() - 1);
            } else if (undo.get(undo.size() - 1) instanceof HouseMemento) {
                HouseMemento houseMemento = (HouseMemento) undo.remove(undo.size() - 1);
                redo.addLast(houseMemento);
                houseMemento.redoData();
            } else {
            }
        }
    }

    // public void undo() {
    // if (undoList.isEmpty()) {
    // System.out.println("Nothing to Undo!");
    // } else {
    // BuildingMemento memento = undoList.pop();
    // redoList.add(memento);
    // memento.restore();
    // }
    // }

    public void redo() {
        if (redo.size() != 0) {
            if (undo.get(undo.size() - 1) instanceof ApartmentMemento) {
                ApartmentMemento apartmentMemento = (ApartmentMemento) undo.get(undo.size() -
                        1);
                apartmentMemento.getCommand().execute();
                undo.add(apartmentMemento);
                redo.remove(redo.size() - 1);
            } else if (undo.get(undo.size() - 1) instanceof HouseMemento) {
                HouseMemento houseMemento = (HouseMemento) undo.get(undo.size() - 1);
                houseMemento.getCommand().execute();
                undo.add(houseMemento);
                redo.remove(redo.size() - 1);
            }
        }
    }
}
