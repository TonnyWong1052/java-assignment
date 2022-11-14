import java.util.*;
public class apartmentFactory extends AbstractFactory {
    
    public void apartment (Scanner sc){
        System.out.println("Building No.:");
        int id = sc.nextInt();
        System.out.println("Monthly Rental: ");
        Double MR = sc.nextDouble();
        System.out.println("Support Staff");
        String name = sc.nextLine();
        System.out.println("Number of rooms:");
        int NoOfRoom = sc.nextInt();

        Apartment apartment = new Apartment(id, NoOfRoom, MR, name);
        for (int i=0; i<NoOfRoom; i++){
            System.out.println("Room No. "+ i);
            System.out.println("Length:");
            Double length = sc.nextDouble();
            System.out.println("Width:");
            Double width = sc.nextDouble();
            apartment.addRoom(length,  width);
        }
    
    }
}
