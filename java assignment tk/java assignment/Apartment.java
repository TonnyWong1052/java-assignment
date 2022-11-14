public class Apartment extends Building {
    private double monthlyRental;
    private String supportStaff;

    public Apartment(int id, int noOfRoom, double monthlyRental, String supportStaff){
        super(id, noOfRoom);
        this.monthlyRental=monthlyRental;
        this.supportStaff=supportStaff;
    }
    public void setMonthlyRental(double monthlyRental){
        this.monthlyRental=monthlyRental;
    }
    public double getMonthlyRental(){
        return monthlyRental;
    }
    public void setSupportStaff(String supportStaff){
        this.supportStaff=supportStaff;
    }
    public String getSupportStaff(){
        return supportStaff;
    }
    public void modifyBuilding(){

    }
    public void printBuilding(){
        
    }

    
}
