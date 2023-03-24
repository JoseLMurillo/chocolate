import java.util.Enumeration;
import java.util.Hashtable;

public class Default {

    static Hashtable<Integer, Employee> hashtable = new Hashtable<Integer, Employee>();

    public static void generateMonthInfo(){
        Enumeration<Integer> keys = hashtable.keys();
        while (keys.hasMoreElements()) {
            Integer key = keys.nextElement();

            for (int i=1; i<=12; i++){
                if(i == 2){
                    hashtable.get(key).getSalaryHistory().setMonthHistorie(new MonthHistory(i,28));

                }
                else {
                    hashtable.get(key).getSalaryHistory().setMonthHistorie(new MonthHistory(i,30));
                }
            }
        }
    }

    public static Hashtable<Integer, Employee> chargeDefault (){

        /* SERVICIOS GENERALES*/
        Employee generalService1 = new Employee(123,"Jose", new GeneralServices());
        generalService1.setSalaryHistory(new SalaryHistory(2022));
        hashtable.put(generalService1.getId(), generalService1);

        Employee generalService2 = new Employee(234,"Luis", new GeneralServices());
        generalService2.setSalaryHistory(new SalaryHistory(2022));
        hashtable.put(generalService2.getId(), generalService2);

        /* COORDINADOR TH*/
        Employee coordinator = new Employee(345, "Andres", new HumanTalent());
        coordinator.setSalaryHistory(new SalaryHistory(2022));
        hashtable.put(coordinator.getId(), coordinator);

        /* SEGURIDAD*/
        Employee security1 = new Employee(456, "Kevin", new Security());
        security1.setSalaryHistory(new SalaryHistory(2022));
        hashtable.put(security1.getId(), security1);

        Employee security2 = new Employee(567, "Karen", new Security());
        security2.setSalaryHistory(new SalaryHistory(2022));
        hashtable.put(security2.getId(), security2);

        /* PLANTA
        Employee floor1 = new Employee(678, "Ector", new Floor());
        floor1.setSalaryHistory(new SalaryHistory(2022));
        hashtable.put(floor1.getId(), floor1);

        Employee floor2 = new Employee(789, "Sebastian", new Floor());
        floor2.setSalaryHistory(new SalaryHistory(2022));
        hashtable.put(floor2.getId(), floor2);

        Employee floor3 = new Employee(890, "Rut", new Floor());
        floor3.setSalaryHistory(new SalaryHistory(2022));
        hashtable.put(floor3.getId(), floor3);

        Employee floor4 = new Employee(111, "Camila", new Floor());
        floor4.setSalaryHistory(new SalaryHistory(2022));
        hashtable.put(floor4.getId(), floor4);

        /* CEO
        Employee ceo = new Employee(666, "Julian", new Ceo());
        ceo.setSalaryHistory(new SalaryHistory(2022));
        hashtable.put(ceo.getId(), ceo);*/

        generateMonthInfo();

        return hashtable;
    }
}
