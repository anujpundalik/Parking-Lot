
public class ParkingSpot {

    private Vehicle vehicle;
    private int level;
    private int number;

    public ParkingSpot(int level, int number){
        this.level = level;
        this.number = number;
        vehicle = null;
    }

    public boolean isFree() {
        return vehicle == null;
    }

    public void addVehicle(Vehicle vehicle){

        this.vehicle = vehicle;
        System.out.println("Please proceed to " + this);
    }

    public Vehicle getParkedVehicle(){
        return this.vehicle;
    }

    public void removeVehicle(){
        this.vehicle = null;
        System.out.println(this + " is now available");
    }

    public int getSpotNumber(){
        return this.number;
    }
    @Override
    public String toString(){
        return (
            "Level " + level + ",Spot " + number
        );
    }
}
