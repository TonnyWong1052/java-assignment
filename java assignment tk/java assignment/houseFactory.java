import java.util.*;
public class houseFactory extends AbstractFactory {
    
    public void house (Scanner sc){
        System.out.println("Building No.:");
        int id = sc.nextInt();
        System.out.println("No. of Floors:  ");
        int noOfFloors = sc.nextInt();
        System.out.println("Number of rooms:");
        int noOfRooms = sc.nextInt();

        House house = new House( id,  noOfRooms, noOfFloors);
        for (int i=0; i<noOfRooms; i++){
            System.out.println("Room No. "+ i);
            System.out.println("Length:");
            Double length = sc.nextDouble();
            System.out.println("Width:");
            Double width = sc.nextDouble();
            house.addRoom(length,  width);
        }
    }
}