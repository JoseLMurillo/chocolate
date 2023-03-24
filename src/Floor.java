public class Floor extends Charge {

    Floor(){
        name = "Floor";
        salary = 2300000;
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
