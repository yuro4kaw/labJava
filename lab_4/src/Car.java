public class Car {
    private String brand;
    private String model;
    private int graduationYear;
    private String fuelType;
    private String bodyType;
    private String color;
    private String licensePlate;
    private int passengerCapacity;
    private int cargoCapacity;
    private double totalDistance;

    public Car(String brand, String model, int graduationYear, String fuelType, String bodyType, String color, String licensePlate, int passengerCapacity, int cargoCapacity) {
        this.brand = brand;
        this.model = model;
        this.graduationYear = graduationYear;
        this.fuelType = fuelType;
        this.bodyType = bodyType;
        this.color = color;
        this.licensePlate = licensePlate;
        this.passengerCapacity = passengerCapacity;
        this.cargoCapacity = cargoCapacity;
        this.totalDistance = 0;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getGraduationYear() {
        return graduationYear;
    }

    public String getFuelType() {
        return fuelType;
    }

    public String getBodyType() {
        return bodyType;
    }

    public String getColor() {
        return color;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public int getCargoCapacity() {
        return cargoCapacity;
    }

    public double getTotalDistance() {
        return totalDistance;
    }

    public void incrementDistance(double distance){
        totalDistance += distance;
    }

    public String toString() {
        return  "Brand and model: " + brand + model + "\n" +
                "Graduation year: " + graduationYear + "\n" +
                "Fuel type: " + fuelType + "\n" +
                "Body type: " + bodyType + "\n" +
                "Color: " + color + "\n" +
                "License plate: " + licensePlate + "\n" +
                "Passenger capacity: " + passengerCapacity + "\n" +
                "Cargo capacity: " + cargoCapacity + "\n" +
                "Total distance: " + totalDistance;
    }
}