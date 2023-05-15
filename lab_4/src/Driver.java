import java.util.Date;

public class Driver {
    private String fullName;
    private Date dateOfBirth;
    private int drivingExperience;
    private String phoneNumber;
    private Car car;

    public Driver(String fullName, Date dateOfBirth, int drivingExperience, String phoneNumber) {
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.drivingExperience = drivingExperience;
        this.phoneNumber = phoneNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public int getDrivingExperience() {
        return drivingExperience;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void drive(double distance) {
        if (car != null) {
            car.incrementDistance(distance);
        } else {
            System.out.println(fullName + " does not have a car.");
        }
    }

    public String toString() {
        return "Full name: " + fullName + "\n" +
                "Date of birth: " + dateOfBirth + "\n" +
                "Driving experience: " + drivingExperience + "\n" +
                "Phone number: " + phoneNumber + "\n" +
                "\t Car: \n" + car;
    }
}
