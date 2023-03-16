import java.util.Hashtable;

public class Default {

    static Hashtable<Integer, Employee> hashtable = new Hashtable<Integer, Employee>();

    public static Hashtable<Integer, Employee> chargeDefault (){

        /* SERVICIOS GENERALES*/
        Employee generalService1 = new Employee(123,"Jose", Charge.GENERAL_SERVICES.getCharge(), Salary.GENERAL_SERVICES.getSalary());
        Employee generalService2 = new Employee(234,"Luis", Charge.GENERAL_SERVICES.getCharge(), Salary.GENERAL_SERVICES.getSalary());

        /* COORDINADOR TH*/
        Employee coordinator = new Employee(345, "Andres", Charge.HUMAN_TALENT.getCharge(), Salary.HUMAN_TALENT.getSalary());

        /* SEGURIDAD*/
        Employee security1 = new Employee(456, "Kevin", Charge.SECURITY.getCharge(), Salary.SECURITY.getSalary());
        Employee security2 = new Employee(567, "Karen", Charge.SECURITY.getCharge(), Salary.SECURITY.getSalary());

        /* PLANTA*/
        Employee floor1 = new Employee(678, "Ector", Charge.FLOOR.getCharge(), Salary.FLOOR.getSalary());
        Employee floor2 = new Employee(789, "Sebastian", Charge.FLOOR.getCharge(), Salary.FLOOR.getSalary());
        Employee floor3 = new Employee(890, "Rut", Charge.FLOOR.getCharge(), Salary.FLOOR.getSalary());
        Employee floor4 = new Employee(111, "Camila", Charge.FLOOR.getCharge(), Salary.FLOOR.getSalary());

        /* CEO*/
        Employee ceo = new Employee(666, "Julian", Charge.CEO.getCharge(), Salary.CEO.getSalary());

        hashtable.put(generalService1.getId(), generalService1);
        hashtable.put(generalService2.getId(), generalService2);
        hashtable.put(coordinator.getId(), coordinator);
        hashtable.put(security1.getId(), security1);
        hashtable.put(security2.getId(), security2);
        hashtable.put(floor1.getId(), floor1);
        hashtable.put(floor2.getId(), floor2);
        hashtable.put(floor3.getSalary(), floor3);
        hashtable.put(floor4.getId(), floor4);
        hashtable.put(ceo.getId(), ceo);

        return hashtable;
    }

}
