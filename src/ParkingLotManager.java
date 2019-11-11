import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ParkingLotManager {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private final ParkingLot p;
    private final String name;

    public ParkingLotManager(String name, String[] levels){
        this.name = name;
        p = new ParkingLot(levels);
    }

    public void startWork() throws Exception{

        String[] input;

        while (true){

            System.out.println("Please Provide an input for entry,exit or quit");
            input = br.readLine().split(" ");

            switch (input.length){

                case 1:{
                    System.exit(0);
                }

                case 2:{
                    p.exitVehicle(input[1]);
                    break;
                }
                case 3: {
                    Vehicle vehicle = new Vehicle(input[1], input[2]);
                    p.enterVehicle(vehicle);
                    break;
                }
            }

        }
    }

    public static void main(String[] args) throws Exception {

        System.out.println("Enter the number of levels to the parking lot");
        int numberOfLevels = Integer.parseInt(br.readLine());

        String[] levels = new String[numberOfLevels];
        System.out.println("Enter the parking levels information in the format : " +
                "LevelNumber NumberOfSections SectionSize VehiclesAllowedSeperatedByCommas");
        for (int i = 0; i < numberOfLevels; i++){
            levels[i] = br.readLine();
        }

        new ParkingLotManager("Carl Fredickson", levels).startWork();
    }
}
