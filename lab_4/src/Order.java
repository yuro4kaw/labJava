public class Order {
    private double distance;
    private Driver driver;
    private Client client;

    public Order(double distance, Driver driver, Client client) {
        this.distance = distance;
        this.driver = driver;
        this.client = client;

        this.client.incrementOrdersCount();
        this.driver.drive(distance);
    }

    public double getDistance() {
        return distance;
    }

    public Driver getDriver() {
        return driver;
    }

    public Client getClient() {
        return client;
    }

    public String toString() {
        return "Distance: " + distance + " km\n" +
                "Driver: " + driver.getFullName() + "\n" +
                "Client: " + client.getFullName();
    }
}
