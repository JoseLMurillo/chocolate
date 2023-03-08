public class Position {
    private String charge;
    private Integer salary;

    Position(String charge, Integer salary) {
        this.charge = charge;
        this.salary = salary;
    }

    public String getCharge() {
        return charge;
    }

    public void setCharge(String charge) {
        this.charge = charge;
    }

    public Integer getSalary(){
        return salary;
    }

}
