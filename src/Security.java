public class Security extends Charge {

    Security(){
        name = ChargeNames.SECURITY;
        salary = 1500000;
    }

    @Override
    String getName() {
        return name.getName();
    }

    @Override
    Integer getSalary() {
        return salary;
    }
}
