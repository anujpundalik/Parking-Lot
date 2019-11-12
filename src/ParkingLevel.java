import java.util.*;

public class ParkingLevel {
    private int number;
    private final int[] sectionSizes;

    private final Collection<String> allowedVehicles;
    private final Collection<ParkingSpot> freeSpots = new HashSet<>();
    private final Map<Vehicle, ParkingSpot> occupiedSpots = new HashMap<>();
    private int numberOfSections;


    public ParkingLevel(int number, int numberOfSections, String vehicleList, int[] sectionSizes) {
        this.number = number;
        this.numberOfSections = numberOfSections;
        this.sectionSizes = sectionSizes;

        allowedVehicles = new HashSet<>(Arrays.asList(vehicleList.split(",")));

        for (int i = 0; i < numberOfSections; i++) {

            for (int j = 0; j < sectionSizes[i]; j++)
                freeSpots.add(new ParkingSpot(number, i + 1, j + 1));
        }

    }

    public boolean canPark(Vehicle vehicle){

        return (allowedVehicles.contains(vehicle.getVehicleType()) && (!this.freeSpots.isEmpty()));

    }

    private ParkingSpot findTargetSpot(Vehicle vehicle) {

        return freeSpots.stream()
                .min(Comparator.comparing(ParkingSpot::getSpotNumber)
                        .thenComparing(ParkingSpot::getSectionNumber))
                .orElseThrow(() -> new RuntimeException("No free Slot for " + vehicle));

    }

    public void parkVehicle(Vehicle vehicle) {

        ParkingSpot targetSpot = findTargetSpot(vehicle);

        targetSpot.addVehicle(vehicle);
        freeSpots.remove(targetSpot);
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
                "Level " + number + " has " + numberOfSections + " sections"
        );
    }
}
