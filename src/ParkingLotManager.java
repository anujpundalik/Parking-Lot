import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;

public class ParkingLotManager {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private final ParkingLot p;
    private final String name;

    public ParkingLotManager(String name, String[] levels){
        this.name = name;
        p = new ParkingLot(levels);
    }

    public static void main(String[] args) throws Exception {

        System.out.println("Enter the number of Parking levels ");

        int numberOfLevels = Integer.parseInt(br.readLine());

        String[] levels = new String[numberOfLevels];

        String metaData;
        StringBuilder sectionData = new StringBuilder();
        int numberOfSections;

        for (int i = 0; i < numberOfLevels; i++){

            System.out.println("Please Enter LevelNumber NumberOfSections VehiclesSeperatedByComma");

            metaData = br.readLine().toUpperCase();
            numberOfSections = Integer.parseInt((String) Array.get(metaData.split(" "), 1));

            System.out.println("Enter the section sizes");

            for (int j = 0; j < numberOfSections; j++) {
                System.out.println("Section " + (j + 1) + ":  ");
                sectionData.append(br.readLine()).append(" ");

            }

            levels[i] = metaData + ":" + sectionData;

        }

        new ParkingLotManager("Carl Fredickson", levels).startWork();
    }

    public void startWork() throws Exception {

        String[] input;

        while (true) {

            System.out.println("Please Provide an input for entry,exit or quit");
            input = br.readLine().toUpperCase().split(" ");

            switch (input[0]) {

                case "QUIT": {
                    System.exit(0);
                }

                case "EXIT": {
                    p.exitVehicle(input[1]);
                    break;
                }
                case "ENTRY": {
                    p.enterVehicle(new Vehicle(input[1], input[2]));
                    break;
                }
            }

        }
    }
}
