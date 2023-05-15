import java.util.*;
public class Main {
    public static void main(String[] args) {

        Driver driver1 = new Driver("John Smith", new Date(1980, 1, 1), 5, "066-368-93-94");
        Driver driver2 = new Driver("Alice Johnson", new Date(1975, 5, 15), 10, "095-789-12-94");
        Driver driver3 = new Driver("Bob Brown", new Date(1990, 3, 30), 2, "099-456-78-91");

        Car car1 = new Car("Toyota", "Corolla", 2010, "gasoline", "sedan", "white", "ABC-123", 4, 2);
        Car car2 = new Car("Honda", "Civic", 2015, "gasoline", "sedan", "black", "XYZ-789", 4, 2);
        Car car3 = new Car("Nissan", "Altima", 2018, "gasoline", "sedan", "silver", "DEF-456", 4, 2);

        driver1.setCar(car1);
        driver2.setCar(car2);
        driver3.setCar(car3);

        Client client1 = new Client("Mary Johnson", new Date(2005, 6, 20), "099-368-93-94");
        Client client2 = new Client("Tom Davis", new Date(1998, 9, 10), "095-358-89-24");
        Client client3 = new Client("Amy Wilson", new Date(1995, 12, 5), "099-368-93-36");
        Client client4 = new Client("David Lee", new Date(2000, 3, 1), "099-789-41-78");
        Client client5 = new Client("Sara Lee", new Date(2003, 8, 15), "099-522-74-52");

        Order order1 = new Order(5.3, driver1, client1);
        Order order2 = new Order(2.1, driver2, client2);
        Order order3 = new Order(8.5, driver3, client3);
        Order order4 = new Order(3.7, driver1, client4);
        Order order5 = new Order(6.2, driver2, client5);
        Order order6 = new Order(1.5, driver3, client2);
        Order order7 = new Order(4.9, driver1, client3);
        Order order8 = new Order(7.8, driver2, client5);
        Order order9 = new Order(0.8, driver3, client1);
        Order order10 = new Order(2.6, driver1, client4);
        Order order11 = new Order(7.8, driver2, client5);
        Order order12= new Order(0.8, driver3, client1);
        Order order13 = new Order(2.6, driver1, client4);
        Order order14 = new Order(5.3, driver1, client1);
        Order order15= new Order(2.1, driver2, client2);
        Order order16 = new Order(8.5, driver3, client2);
        Order order17 = new Order(3.7, driver1, client2);

        List<Order> orders = new ArrayList<>(Arrays.asList(order1, order2, order3, order4, order5, order6,
                order7, order8, order9, order10, order11, order12, order13, order14, order15, order16, order17));
        List<Car> cars = new ArrayList<>(Arrays.asList(car1, car2, car3));
        List<Client> clients = new ArrayList<>(Arrays.asList(client1, client2, client3, client4, client5));

        System.out.println("\n Sorting orders by distance \n");

        orders.sort((o1, o2) -> Double.compare(o1.getDistance(), o2.getDistance()));

        for (Order order : orders){
            System.out.println(order);
            System.out.println();
        }

        System.out.println("\n Sorting cars by total distance \n");

        cars.sort((c1, c2) -> Double.compare(c1.getTotalDistance(), c2.getTotalDistance()));

        for (Car car : cars){
            System.out.println(car);
            System.out.println();
        }

        System.out.println("\n Sorting clients by the frequency of using the taxi service \n");

        clients.sort(Comparator.comparingInt(Client::getOrdersCount));

        for (Client client : clients){
            System.out.println(client);
            System.out.println();
        }


    }
}