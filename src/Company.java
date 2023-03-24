import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;

public class Company {
    private String name;
    private Hashtable<Integer, Employee> hashtable;
    private Hashtable<Integer, Employee> chargeHastable;

    public Company(){
        this.name = "Medellin Chocolate";
        this.hashtable = new Hashtable<Integer, Employee>();
        this.chargeHastable = new Hashtable<Integer, Employee>();
    }


    public Hashtable<Integer, Employee> getEmployeeForCharge(String name){
        Enumeration<Integer> keys = this.hashtable.keys();

        System.out.println("Id list: ");
        while (keys.hasMoreElements()) {
            Integer key = keys.nextElement();

            if(this.hashtable.get(key).getCharge().getName() == name){
                System.out.println("Key: " + key);
                /*System.out.println("Key: " + key +
                        ", Name: " + this.hashtable.get(key).getName() +
                        ", Charge  " + this.hashtable.get(key).getCharge().getName());*/
            }
        }
        return chargeHastable;
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
        if(!getEmployeesHashTable().contains(employee)){
            hashtable.put(employee.getId(), employee);
            System.out.println("EMPLOYEE ADDED");
        }
        else{
            System.out.println("Employee exist, NO ADDED");
        }
    }


    public Employee getEmployee(Integer employee){
        try{
            if(hashtable.contains(getEmployeesHashTable().get(employee))){
            return hashtable.get(employee);
        }

        }catch (NullPointerException e){
            System.out.println("Employee no exist");
        }

        return null;
    }

    public void updateEmployee(Employee employee){
        if(getEmployeesHashTable().contains(employee)){
            hashtable.replace(employee.getId(), employee);
            System.out.println("Employee updated");
        }
        else{
            System.out.println("Employee no exist");
        }
    }

    public void deleteEmployee(Employee employee){
        if(getEmployeesHashTable().contains(employee)){
            hashtable.remove(employee.getId());
            System.out.println("Employee deleted");
        }
        else{
            System.out.println("Employee no exist");
        }
    }

    public void printEmployees(){
        Enumeration<Integer> keys = this.hashtable.keys();
        while (keys.hasMoreElements()) {
            Integer key = keys.nextElement();
            System.out.println("Key: " + key +
                    ", Name: " + this.hashtable.get(key).getName() +
                    ", Charge  " + this.hashtable.get(key).getCharge().getName());
        }
    }

    public void printEmployeesSocialLoan(){
        var firstPremiumDays = 0;
        var lastPremiumDays = 0;

        var firstPremium = 0.0;
        var lastPremium = 0.0;
        Enumeration<Integer> keys = this.hashtable.keys();

        while (keys.hasMoreElements()) {
            Integer key = keys.nextElement();
            var salary = 0;
            System.out.println("Key: " + key +
                    ", Name: " + this.hashtable.get(key).getName() +
                    ", Charge: " + this.hashtable.get(key).getCharge().getName() +
                    " ");

            for (MonthHistory month :
                    this.hashtable.get(key).getSalaryHistory().getMonthHistories()) {

                if (month.getMonth() <= 6) {
                    //DIAS TRABAJADOS EN EL PRIMER SEMESTRE
                    firstPremiumDays += month.getDaysWorkMonth();
                } else {
                    //DIAS TRABAJADOS EN EL SEGUNDO SEMESTRE
                    lastPremiumDays += month.getDaysWorkMonth();
                }
            }

            System.out.print(firstPremiumDays + " : " + lastPremiumDays);
            System.out.println();

            firstPremium = Benefits.premium(this.hashtable.get(key).getCharge().getSalary() ,firstPremiumDays);
            System.out.println("Firts premium: " + firstPremium);
            lastPremium = Benefits.premium(this.hashtable.get(key).getCharge().getSalary() ,lastPremiumDays);
            System.out.println("Lasts premium: " + lastPremium);

            System.out.println("Layouts: " + Benefits.layoffs(this.hashtable.get(key).getCharge().getSalary(),
                    firstPremiumDays + lastPremiumDays));

            salary += Benefits.premium(this.hashtable.get(key).getCharge().getSalary() ,firstPremiumDays) +
                    Benefits.premium(this.hashtable.get(key).getCharge().getSalary() ,lastPremiumDays);

            System.out.println("Interest layouts: " + Benefits.interestLayoffs(salary, firstPremiumDays + lastPremiumDays));
            System.out.println();
        }
    }

}
