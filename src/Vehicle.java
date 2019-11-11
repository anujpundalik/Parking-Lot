public class Vehicle {

    private String vehicleType;
    private String vehicleNumber;


    public Vehicle(String vehicleType, String vehicleNumber){

        this.vehicleType = vehicleType;
        this.vehicleNumber = vehicleNumber;
    }

    public String getVehicleType(){
        return vehicleType;
    }

    public String getVehicleNumber(){
        return vehicleNumber;
    }

    @Override
    public String toString(){
        return (
            vehicleType + " " + vehicleNumber
        );
    }
}
