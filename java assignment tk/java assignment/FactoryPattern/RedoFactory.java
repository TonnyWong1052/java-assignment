package FactoryPattern;

import CommandPattern.Redo;

public class RedoFactory implements Factories{

    @Override
    public void create() {
        new Redo().execute();
    }
    
}
