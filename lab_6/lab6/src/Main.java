import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static class Student{
         static String lastName;
         double averageMark;

        public Student(String lastName, double averageMark) {
            this.lastName = lastName;
            this.averageMark = averageMark;
        }

        public String getLastName() {
            return lastName;
        }

        public double getAverageMark() {
            return averageMark;
        }
    }

    public static class Group{
        String name;
        List<Student> students = new ArrayList<>();

        public Group(String name, List<Student> students) {
            this.name = name;
            this.students = students;
        }

        public String getName() {
            return name;
        }

        public List<Student> getStudents() {
            return students;
        }
    }
    public static class Employee{
        private String firstName;
        private String lastName;
        private double salary;



        public Employee(String firstName, String lastName, double salary) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.salary = salary;
        }

        public String getFirstName() {
            return firstName;
        }
        public double getSalary() {
            return salary;
        }

        @Override
        public String toString() {
            return "First name: " + firstName
                    + "\nLast name: " + lastName
                    + "\nSalary: " + salary + "\n";
        }
    }

    public static Optional<Employee> salaryGreaterThan(List<Employee> employees, double otherSalary){
        return employees.stream()
                .filter( e -> e.salary > otherSalary)
                .findFirst();
    }

    /*public static Optional<String> longestTitle(List<String> titles){
        return titles.stream()
                .max(Comparator.comparingInt(String::length));
    }*/

    public static Optional<String> longestTitle(List<String> titles) {
        Optional<Integer> maxlength = titles.stream()
                                        .map(String::length)
                                        .max(Comparator.naturalOrder());

        return titles.stream()
                .filter( title -> title.length() == maxlength.get())
                .findFirst();
    }

    public static void findStudentHighestMark(List<Group> groups) {
        Optional<Student> student = groups.stream()
                .flatMap(group -> group.getStudents().stream())
                .max(Comparator.comparingDouble(Student::getAverageMark));
        if (student.isPresent()){
            Optional<Group> group = groups.stream()
                    .filter(g -> g.getStudents().contains(student.get()))
                    .findFirst();

            System.out.println(student.get().getLastName() + " - " + group.get().getName());
        }
    }


    public static void firstEmployee(List<Employee> employees){
        employees.stream()
                .peek( e -> System.out.println(e.getFirstName()))
                .findFirst();
    }

    public static <T extends Number> void multiplyList(List<? extends Number> list, T number){
        list.stream()
                .map( n -> n.doubleValue() * number.doubleValue())
                .forEach( n -> System.out.println(n));
    }

    public static Integer sumOfEven(List<Integer> list){
        return list.stream()
                .filter(n -> n % 2 == 0)
                .reduce(0, (sum, number) -> sum + number);
    }

    public static String[] toArray(List<String> list){

        return list.stream()
                .toArray(String[]::new);
    }

    public static List<Employee> sameSalary(List<Employee> employees){
        Map<Double, List<Employee>> grouped = employees.stream()
                .collect(Collectors.groupingBy(Employee::getSalary));
        return grouped.values().stream()
                .filter( l -> l.size() > 1)
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Kateryna", "Grinchenko", 15650));
        employees.add(new Employee("Andrii", "Dub", 14400));
        employees.add(new Employee("Taras", "Gryb", 16730));
        employees.add(new Employee("Inessa", "Topolya", 16730));

        //1
        Optional<Employee> employee = salaryGreaterThan(employees, 15000);
        if(employee.isPresent()){
            System.out.println("Employee with greater salary:\n" + employee.get());
        }else {
            System.out.println("No results");
        }



        List<String> bookTitles = Arrays.asList("Harry Potter and the Philosopher's Stone",
                                                        "Maze Runner", "The Lord of the Rings");
        //2
        Optional<String> title = longestTitle(bookTitles);
        if(title.isPresent()){
            System.out.println("The longest book title:\n" + title.get());
        }else {
            System.out.println("No results");
        }


        //3
        Student student1 = new Student("Burtnyk", 88.5);
        Student student2 = new Student("Ipatiy", 65.25);
        Student student3 = new Student("Klen", 86.75);
        Student student4 = new Student("Savchuk", 93.5);

        Group group1 = new Group("215", new ArrayList<>(Arrays.asList(student1, student2)));
        Group group2 = new Group("156", new ArrayList<>(Arrays.asList(student3, student4)));
        List<Group> groups = new ArrayList<>(Arrays.asList(group1, group2));
        System.out.println("\nStudent with highest mark:");
        findStudentHighestMark(groups);



        //4
        System.out.println("\nThe name of the first employee: ");
        firstEmployee(employees);


        //5
        System.out.println("\nMultiplied list:");
        List<Integer> numbers = Arrays.asList(1,4,5,6);
        multiplyList(numbers, 2);


        //6
        System.out.println("\nArray: ");
        String[] array = toArray(bookTitles);
        System.out.println(Arrays.toString(array));


        //7
        System.out.println("\nSum of even numbers:\n" + sumOfEven(numbers));


        //8
        System.out.println("\nEmployees with the same salary: \n" + sameSalary(employees));
    }
}