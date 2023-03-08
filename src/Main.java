public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Company company = new Company();

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

        company.addEmployee(generalService1);
        company.addEmployee(generalService2);
        company.addEmployee(coordinator);
        company.addEmployee(security1);
        company.addEmployee(security2);
        company.addEmployee(floor1);
        company.addEmployee(floor2);
        company.addEmployee(floor3);
        company.addEmployee(floor4);
        company.addEmployee(ceo);

        for (Employee employee :
                company.getEmployees()) {
            System.out.println(employee.getName());
        }
    }

    /*
     *Actualmente la empresa tiene 10 empleados, los cuales
tienen la siguiente distribución:

2 empleados de Servicios generales con un sueldo
de 1 Salario mínimo.

1 coordinador de Talento Humano con un sueldo de
3 millones de pesos.

2 empleados de Seguridad con un salario de 1 millón
y medio de Pesos.

4 empleados en la planta encargados de la producción
y empaque del chocolate, con un salario de 2 millones 300 mil pesos.

1 CEO encargado de la administración y representación
legal con un salario integral de 15 millones 700 mil pesos.


Actualmente el sistema viene realizando nuevas  contrataciones en
todos los puestos antes mencionados, de modo que el sistema debe permitir
ingresar nuevos empleados en los puestos laborales mencionados.


Requerimientos:


1.
El sistema debe permitir ingresar nuevos
empleados (5%).


2.
El sistema debe permitir calcular todas las
prestaciones sociales de los empleados actuales y si hay una nueva contratación,
debe permitir repetir el proceso con el nuevo empleado contratado (10%).


3.
El sistema debe permitir cambiar de puesto
laboral a los empleados actuales. Es decir, el sistema debe permitir cambiar de
puesto a un empleado de seguridad a ser un empleado de Planta (10%).


4.
Debe tener una opción de búsqueda por
Identificación y listar su información personal con su rol especifico, y su información
financiera (Sueldo y prestaciones sociales) (10%).


5.
El sistema debe tener una opción que permita
buscar empleados por Rol y luego mostrar la información personal y financiera de
cualquier empleado que seleccione (15%).
     */
}