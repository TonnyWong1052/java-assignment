package Caretaker;

import java.util.LinkedList;

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
            if (undo.getLast() instanceof ApartmentMemento) {
                ApartmentMemento apartmentMemento = (ApartmentMemento) undo.removeLast();
                apartmentMemento.redoData();
                redo.addFirst(apartmentMemento);
            } else if (undo.getLast() instanceof HouseMemento) {
                HouseMemento houseMemento = (HouseMemento) undo.removeLast();
                houseMemento.redoData();
                redo.addFirst(houseMemento);
            } else {

            }
        }
    }

    public void redo() {
        if (redo.size() != 0) {
            if (redo.getLast() instanceof ApartmentMemento) {
                ApartmentMemento apartmentMemento = (ApartmentMemento) redo.removeLast();
                apartmentMemento.getCommand().execute();
                undo.addLast(apartmentMemento);
            } else if (redo.getLast() instanceof HouseMemento) {
                HouseMemento houseMemento = (HouseMemento) redo.removeLast();
                houseMemento.getCommand().execute();
                undo.addLast(houseMemento);
            } else {
                
            }
        }
    }
}
