import java.util.ArrayList;

public class Employee {
    private Integer id;
    private String name;
    private Charge charge;

  private SalaryHistory salaryHistory;

	Employee(){}
  
    public Employee(final Integer id, final String name, final Charge charge){
        this.id = id;
        this.name = name;
        this.charge = charge;
    }

    public Integer getId() {
        return id;
    }
    public void setId(final Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(final String name) {
        this.name = name;
    }

    public Charge getCharge() {
        return charge;
    }

    public void setCharge(final Charge charge) {
        this.charge = charge;
    }

    public void setSalaryHistory(final SalaryHistory salary) {
        this.salaryHistory = salary;
    }

    public SalaryHistory getSalaryHistory(){
        return this.salaryHistory;
    }

}