public class GeneralServices extends Charge {

    GeneralServices(){
        name = "General Services";
        salary = 1160000;
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
