import java.util.Date;

public class Client {
    private String fullName;
    private Date dateOfBirth;
    private String phoneNumber;
    private int ordersCount;

    public Client(String fullName, Date dateOfBirth, String phoneNumber) {
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.ordersCount = 0;
    }

    public String getFullName() {
        return fullName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getOrdersCount() {
        return ordersCount;
    }

    public void incrementOrdersCount() {
        ordersCount++;
    }

    public String toString() {
        return "Full name: " + fullName + "\n" +
                "Date of birth: " + dateOfBirth + "\n" +
                "Phone number: " + phoneNumber + "\n" +
                "Orders count: " + ordersCount;
    }
}
