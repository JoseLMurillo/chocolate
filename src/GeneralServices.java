public class GeneralServices extends Charge {

    GeneralServices(){
        name = ChargeNames.GENERAL_SERVICES;
        salary = 1160000;
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
