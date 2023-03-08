import java.util.ArrayList;

public class Company {
    private String name;
    private ArrayList<Employee> Employees;

    public Company(){
        this.name = "Medellin Chocolate";
        this.Employees = new ArrayList<Employee>();
    }

    public String getName(){
        return name;
    }

    public ArrayList<Employee> getEmployees() {
        return Employees;
    }

    public void setEmployees(ArrayList<Employee> employees) {
        Employees = employees;
    }

    public void addEmployee(Employee employee){
        Employees.add(employee);
    }
}
