import java.util.Hashtable;

public class Ceo extends Charge {

    private Hashtable<Integer, Employee> hashtable;

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

    public Hashtable<Integer, Employee> getHashtable() {
        return hashtable;
    }

    public void setHashtable(Hashtable<Integer, Employee> hashtable) {
        this.hashtable = hashtable;
    }
}
