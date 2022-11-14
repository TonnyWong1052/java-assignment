import java.util.*;

public class Main {
    public static void main(String[] args){
        Stack commandStack = new Stack();

        Command[] com = new Command[8];



    
        
    }
    public static void input(){
        Scanner sc = new Scanner(System.in);
        
        String option = sc.nextLine();
        if(option.equals("a")){
            System.out.println("Enter Building Type (a=Apartment/h=House):");
            String option2 = sc.nextLine();
            if (option2.equals("a")){
                
            }
            else if(option2.equals("h")){
                
            }
        } 

    }
    public static void printing(){
        System.out.println("Building Management System (BMS)");
        System.out.println("Please enter command: [a|d|m|e|u|r|l|x]");
        System.out.println("a = add building, d = display buildings, m = modify building, e = edit rooms u = undo, r = redo, l = list undo/redo, x = exit system");
        
        
    } 
}
