public class HumanTalent extends Charge {

    HumanTalent(){
        name = ChargeNames.HUMAN_TALENT;
        salary = 3000000;
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
