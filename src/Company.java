import java.util.Enumeration;
import java.util.Hashtable;

public class Company {
    private String name;
    private Hashtable<Integer, Employee> hashtable;

    public Company(){
        this.name = "Medellin Chocolate";
        this.hashtable = new Hashtable<Integer, Employee>();
    }

    public String getName(){
        return name;
    }

    public Hashtable<Integer, Employee> getEmployeesHashTable(){
        return hashtable;
    }

    public void setEmployeesHashTable(Hashtable<Integer, Employee> employee){
        this.hashtable = employee;
    }

    public void addEmployee(Employee employee){
        hashtable.put(employee.getId(), employee);
    }

    public void printEmployees(){
        Enumeration<Integer> keys = this.hashtable.keys();
        while (keys.hasMoreElements()) {
            Integer key = keys.nextElement();
            System.out.println("Key: " + key + ", Value: " + this.hashtable.get(key).getName());
        }
    }
}
