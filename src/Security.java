public class Security extends Charge {

    Security(){
        name = "Security";
        salary = 1500000;
    }

    @Override
    String getName() {
        return name;
    }

    @Override
    Integer getSalary() {
        return salary;
    }
}
