import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ParkingLot {

    private final List<ParkingLevel> levels = new ArrayList<>();
    private final Map<Vehicle,Integer> allParkedVehicles = new HashMap<>();

    public ParkingLot(String[] levels){

        for (String level: levels){
            this.addLevel(level);
        }
    }

    private final void addLevel(String level){

        String[] levelData = level.split(" ");

        this.levels.add(new ParkingLevel(
                Integer.parseInt(levelData[0]),
                Integer.parseInt(levelData[1]),
                Integer.parseInt(levelData[2]),
                levelData[3]
        ));

    }
    public void enterVehicle(Vehicle vehicle){

        List<ParkingLevel> targetLevels = levels.stream().filter(level -> level.canPark(vehicle)).collect(Collectors.toList());


        for (ParkingLevel targetLevel : targetLevels){

            try{
                targetLevel.parkVehicle(vehicle);
                allParkedVehicles.put(vehicle, targetLevel.getLevelNumber());
                break;

            } catch (Exception e){
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

