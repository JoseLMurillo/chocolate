public class HumanTalent extends Charge {

    HumanTalent(){
        name = "Human Talent";
        salary = 3000000;
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
