package CommandPattern;

import Caretaker.Caretaker;

public class Redo implements Command{
    private Caretaker caretaker;

    public Redo(){
        caretaker = Main.Main.caretaker;
    }

    @Override
    public void execute() {
        caretaker.redo();
    }
    
}
