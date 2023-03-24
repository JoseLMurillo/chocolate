public class Floor extends Charge {

    Floor(){
        name = ChargeNames.FLOOR;
        salary = 2300000;
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
