package CommandPattern;

import Caretaker.Caretaker;

public class Undo implements Command {
    private Caretaker caretaker;

    public Undo() {
        caretaker = Main.Main.caretaker;
    }

    @Override
    public void execute() {
        caretaker.undo();
    }

    @Override
    public void printDetail() {
        // TODO Auto-generated method stub
        
    }

}
