package FactoryPattern;

public class ExitSystemFactory implements Factories{

    @Override
    public void create() {
        System.exit(1);
    }

    
}
