public enum Salary {
    GENERAL_SERVICES(1160000),
    HUMAN_TALENT(3000000),
    SECURITY(1500000),
    FLOOR(2300000),
    CEO(15700000);

    private Integer salary;

    private Salary(Integer salary) {
        this.salary = salary;
    }

    Integer getSalary(){
        return this.salary;
    }

}
