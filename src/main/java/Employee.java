public class Employee {
    private String name;
    private Long id;
    private Integer age;
    private Integer salary;
    private String department;
    private String Gender ;

    public Employee(String name, Long id, Integer age, Integer salary, String department, String gender) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.salary = salary;
        this.department = department;
        Gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", age=" + age +
                ", salary=" + salary +
                ", department='" + department + '\'' +
                ", Gender='" + Gender + '\'' +
                '}';
    }
}
