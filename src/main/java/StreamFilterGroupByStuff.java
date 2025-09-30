import java.util.*;
import java.util.stream.Collectors;

public class StreamFilterGroupByStuff {

     Employee employee;
    public static void main(String[] args) {

        List<Employee> employeeList = Arrays.asList(new Employee("Rana", 1L, 30, 15000,"IT","Male"),
                new Employee("Waqas", 2L, 29, 18000,"HR","Female"),
                new Employee("Bob", 2L, 29, 18000,"Finance","Male"),
                new Employee("Bob", 2L, 29, 22000,"Finance","Male"),
                new Employee("Alice", 2L, 29, 25000,"IT","Male"),
                new Employee("kamran", 3L, 31, 20000,"HealthCare","Female"));


        getEmployeesSalaryMoreThanSixteenThousand(employeeList);
        System.out.println("sorting by name");
        employeeList.sort(new NameComparator());
        employeeList.forEach(System.out::println);
        employeeList.sort((a,b) -> b.getSalary().compareTo(a.getSalary()));
        System.out.println("sorting descending salary..");
        employeeList.forEach(System.out::println);
        getNoOfGenderByDepartment(employeeList);
        getAverageSalaryByDepartment(employeeList);
        getMaxSalary(employeeList);
        findSumUsingStream();

    }

    private static void findSumUsingStream() {
        int[] numbers= {1,2,3,4};
       int sum = Arrays.stream(numbers)
               .reduce(0, Integer::sum);
       System.out.println("findSumUsingStream ..." +  sum);
    }

    private static void getEmployeesSalaryMoreThanSixteenThousand(List<Employee> employeeList) {
        List<Employee> empList = employeeList.stream().filter(emp -> emp.getSalary() > 16000)
                .collect(Collectors.toList());
        System.out.println("More than salary");
        empList.forEach(System.out::println);

    }

    private static void getNoOfGenderByDepartment(List<Employee> employeeList){

        Map<String, Map<String, Long>> employessInDepartment = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.groupingBy(Employee::getGender, Collectors.counting())));

        for (Map.Entry<String, Map<String, Long>> deptEntry : employessInDepartment.entrySet()) {
            System.out.println("Department: " + deptEntry.getKey());
            for (Map.Entry<String, Long> genderEntry : deptEntry.getValue().entrySet()) {
                System.out.println("  Gender: " + genderEntry.getKey() + ", Count: " + genderEntry.getValue());
            }
        }

        System.out.println("Test");

    }

    public static void getAverageSalaryByDepartment(List<Employee> employeeList){
        Map<String, List<Employee>> employeeListByDepartment = employeeList.stream()
                .collect(Collectors.groupingBy(e -> e.getDepartment()));


        Map<String, Double> averageSalary = employeeList.stream()
                .collect(Collectors.groupingBy(employee1 -> employee1.getDepartment(),
                        Collectors.averagingDouble(Employee::getSalary)));

        averageSalary.forEach((dept,salary) -> System.out.println("dept.." +  dept + "salary" +  salary));
    }

    public static void getMaxSalary(List<Employee> employeeList){
        Map<String, Optional<Employee>> maxSalary = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.maxBy(Comparator.comparing(x -> x.getSalary()))));
        maxSalary.forEach((dept,salary) -> {
            System.out.println("getMaxSalary :: department....: " + dept + "salary" +  salary);
        });
    }


}
