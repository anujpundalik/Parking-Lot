
public class ParkingSpot {

    private Vehicle vehicle;
    private int levelNumber;
    private int number;
    private int sectionNumber;

    public ParkingSpot(int level, int sectionNumber, int number) {
        this.levelNumber = level;
        this.sectionNumber = sectionNumber;
        this.number = number;
        vehicle = null;
    }


    public void addVehicle(Vehicle vehicle){

        this.vehicle = vehicle;
        System.out.println("Please proceed to " + this);
    }

    public void removeVehicle(){
        this.vehicle = null;
        System.out.println(this + " is now available");
    }

    public int getSpotNumber(){
        return this.number;
    }

    public int getSectionNumber() {
        return this.sectionNumber;
    }

    @Override
    public String toString(){
        return (
                "Level " + levelNumber + ", Section " + sectionNumber + " Spot " + number
        );
    }
}
