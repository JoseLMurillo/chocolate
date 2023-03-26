public class Ceo extends Charge {

    Ceo(){
        name = ChargeNames.CEO;
        salary = 15700000;
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
