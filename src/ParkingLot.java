import java.util.*;
import java.util.stream.Collectors;

public class ParkingLot {

    private final List<ParkingLevel> levels = new ArrayList<>();
    private final Map<Vehicle,Integer> allParkedVehicles = new HashMap<>();

    public ParkingLot(String[] levels){

        for (String level: levels){
            this.addLevel(level);
        }
    }

    private void addLevel(String level) {


        String[] levelData = level.split(":");
        String[] metaData = levelData[0].split(" ");
        int[] sectionData = Arrays.stream(levelData[1].split(" ")).mapToInt(Integer::parseInt).toArray();

        this.levels.add(new ParkingLevel(
                Integer.parseInt(metaData[0]),
                Integer.parseInt(metaData[1]),
                metaData[2],
                sectionData
        ));

    }
    public void enterVehicle(Vehicle vehicle){

        List<ParkingLevel> targetLevels = levels.stream().filter(level -> level.canPark(vehicle)).collect(Collectors.toList());

        if (targetLevels.isEmpty()) {
            System.out.println("Parking Lot is Full");
            return;
        }
        for (ParkingLevel targetLevel : targetLevels) {

            try {
                targetLevel.parkVehicle(vehicle);
                allParkedVehicles.put(vehicle, targetLevel.getLevelNumber());
                break;

            } catch (Exception e) {
                System.out.println(" Vehicle not parked " + e.getMessage());
            }
        }

    }

    public void exitVehicle(String vehicleNumber){

        Vehicle targetVehicle = allParkedVehicles.keySet()
                                .stream()
                                .filter(vehicle -> vehicle.getVehicleNumber().equals(vehicleNumber))
                                .findFirst().get();

        int targetLevelNumber = allParkedVehicles.get(targetVehicle);

        ParkingLevel targetLevel = levels.stream()
                .filter(level -> level.getLevelNumber() == targetLevelNumber)
                .findFirst().get();

        targetLevel.unParkVehicle(targetVehicle);
        allParkedVehicles.remove(targetVehicle);

    }
}

