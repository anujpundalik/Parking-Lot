import java.util.*;

public class ParkingLevel {
    private int number;
    private int sections;
    private int sectionSize;
    private int capacity;

    private final Collection<String> allowedVehicles;
    private final Collection<ParkingSpot> freeSpots = new HashSet<>();
    private final Map<Vehicle, ParkingSpot> occupiedSpots = new HashMap<>();

    private final int getLevelCapacity(){

        return (sections * sectionSize);
    }

    public ParkingLevel(int number, int sections, int sectionSize, String vehicleList){
        this.number = number;
        this.sections = sections;
        this.sectionSize = sectionSize;
        this.capacity = getLevelCapacity();

        allowedVehicles = new HashSet<>(Arrays.asList(vehicleList.split(",")));

        for (int i = 0; i < capacity; i++){

            freeSpots.add(new ParkingSpot(number, i + 1));
        }


    }

    public boolean canPark(Vehicle vehicle){

        return (allowedVehicles.contains(vehicle.getVehicleType()) && (!this.freeSpots.isEmpty()));

    }

    public void parkVehicle(Vehicle vehicle){

        ParkingSpot targetSpot = freeSpots.stream()
                .filter(spot -> spot.isFree())
                .min(Comparator.comparing(ParkingSpot::getSpotNumber))
                .orElseThrow(() -> new RuntimeException("No free Slot for " + vehicle));

        targetSpot.addVehicle(vehicle);
        freeSpots.remove(vehicle);
        occupiedSpots.put(vehicle,targetSpot);
    }

    public void unParkVehicle(Vehicle vehicle){

        ParkingSpot targetSpot = occupiedSpots.remove(vehicle);
        targetSpot.removeVehicle();
        freeSpots.add(targetSpot);
    }

    public int getLevelNumber(){
        return this.number;
    }
    @Override
    public String toString(){

        return (
            "Level " + number + " has " + sections + " sections and a total capacity of " + capacity
        );
    }
}
