import java.util.Enumeration;
import java.util.Hashtable;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Company company = new Company();

        company.setEmployeesHashTable(Default.chargeDefault());

        company.printEmployees();

        Employee employee = new Employee(98765444, "CABRA", Charge.HUMAN_TALENT.getCharge(), Salary.HUMAN_TALENT.getSalary());
        company.addEmployee(employee);

        System.out.println();

        company.printEmployees();

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