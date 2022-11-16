package FactoryPattern;

import CommandPattern.Undo;

public class UndoFactory implements Factories{

    @Override
    public void create() {
        new Undo().execute();;
    }
    
}
