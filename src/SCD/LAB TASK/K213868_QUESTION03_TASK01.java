public class K213868_QUESTION03_TASK01 {
    public static void main(String[] args) {
        manager m = new manager("Khizar","3868",10000);
        programmer p = new programmer("XYZ","ABC3868",10000);

        System.out.println("======");
        m.calculateSalary();
        m.displayInfo();

        System.out.println("======");
        p.calculateSalary();
        p.displayInfo();
    }
}
abstract class Employee{

    String employeeName;
    String id;

    public Employee(String employeeName, String id) {
        this.employeeName = employeeName;
        this.id = id;
    }

    abstract void calculateSalary();
    abstract void displayInfo();

}

class manager extends Employee{

    int empSalary;
    public manager(String employeeName, String id,int empSalary) {
        super(employeeName, id);
        this.empSalary = empSalary;
    }

    @Override
    void calculateSalary() {
        System.out.println("Salary = "+ empSalary);
    }

    @Override
    void displayInfo() {
        System.out.println("Manager DISPLAY:");
        System.out.println("Name: " + employeeName);
        System.out.println("Employee ID: " + id);
        System.out.println("Monthly Salary: $" + empSalary);
    }
}

class programmer extends Employee{
    int empSalary;
    public programmer(String employeeName, String id,int empSalary) {
        super(employeeName, id);
        this.empSalary = empSalary;
    }

    @Override
    void calculateSalary() {
        System.out.println("Salary = "+ empSalary);
    }

    @Override
    void displayInfo() {
        System.out.println("Programmer DISPLAY:");
        System.out.println("Name: " + employeeName);
        System.out.println("Employee ID: " + id);
        System.out.println("Monthly Salary: $" + empSalary);
    }
}