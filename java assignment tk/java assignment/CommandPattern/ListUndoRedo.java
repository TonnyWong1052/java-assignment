package CommandPattern;

import Caretaker.Caretaker;

public class ListUndoRedo implements Command{
    private Caretaker caretaker;

    public ListUndoRedo(){
        caretaker = Main.Main.caretaker;
    }
    @Override
    public void execute() {
        caretaker.listAll();
    }
    @Override
    public void printDetail() {
        // TODO Auto-generated method stub
        
    }
    
}
