package FactoryPattern;

import CommandPattern.ListUndoRedo;

public class ListUndoRedoFactory implements Factories{

    @Override
    public void create() {
        new ListUndoRedo().execute();;
    }
    
}
