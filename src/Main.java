import java.util.Hashtable;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Company company = new Company();
        company.setEmployeesHashTable(Default.chargeDefault());

        Boolean ctrl = true;
        Boolean correct;
        Scanner scannerTemp = new Scanner(System.in);
        Employee employee = new Employee();
        MonthHistory monthHistory = new MonthHistory();

        while(ctrl) {
            Scanner scanner = scannerTemp;
            Mensajes.menuMensaje(company.getName());

            try {
                switch (Integer.parseInt(scanner.nextLine())) {
                    case 1:
                        correct = true;
                        Mensajes.insertId();
                    try {
                            Integer temp = Integer.parseInt(scanner.nextLine());
                            if (temp < 0) {
                                correct = false;
                                Mensajes.errorInsertPositiveNumber();
                            }

                            employee.setId(temp);

                        } catch (NumberFormatException e) {
                            correct = false;
                            Mensajes.errorNumberInsert();
                        }

                        if (correct) {
                            Mensajes.insertName();
                            try {
                                employee.setName(scanner.nextLine());
                            } catch (NumberFormatException e) {
                                correct = false;
                                Mensajes.errorNumberInsert();
                            }
                        }

                        if (correct) {
                            Mensajes.chargeMensaje();

                            try {
                                switch (Integer.parseInt(scanner.nextLine())) {
                                    case 1:
                                        employee.setCharge(new GeneralServices());
                                        break;

                                    case 2:
                                        employee.setCharge(new HumanTalent());
                                        break;

                                    case 3:
                                        employee.setCharge(new Security());
                                        break;

                                    case 4:
                                        employee.setCharge(new Floor());
                                        break;

                                    case 5:
                                        employee.setCharge(new Ceo());
                                        break;

                                    default:
                                        correct = false;
                                        Mensajes.employeeNoAdded();
                                        break;
                                }

                            } catch (NumberFormatException e) {
                                correct = false;

                                Mensajes.errorNumberInsert();
                            }
                        }

                        if(correct){
                            try {
                                System.out.print("Insert month of admission: ");
                                Integer temp = Integer.parseInt(scanner.nextLine());

                                if (temp < 0) {
                                    correct = false;
                                    Mensajes.errorInsertPositiveNumber();
                                } else {
                                    monthHistory.setMonth(temp);
                                }


                            } catch (NumberFormatException e) {
                                correct = false;
                                Mensajes.errorNumberInsert();
                            }
                        }

                        /*if(correct) {

                            try {
                                System.out.print("Insert worked days: ");
                                monthHistory.setDaysWorkMonth(scanner.nextInt());
                            } catch (NumberFormatException e) {
                                correct = false;
                                Mensajes.errorNumberInsert();
                            }
                        }

                        if(correct){
                            try {
                                employee.setSalaryHistory(new SalaryHistory(2023));
                                employee.getSalaryHistory().setMonthHistorie(monthHistory);
                            }
                            catch (NumberFormatException e) {
                                correct = false;

                                Mensajes.errorNumberInsert();
                            }
                        }*/

                        if (correct) {
                            company.addEmployee(employee);
                        }

                        break;

                    case 2:
                        try {
                            Mensajes.insertId();

                            employee = company.getEmployee(Integer.parseInt(scanner.nextLine()));

                            if (employee != null) {
                                Mensajes.chargeMensaje();

                                switch (Integer.parseInt(scanner.nextLine())) {
                                    case 1:
                                        employee.setCharge(new GeneralServices());
                                        break;

                                    case 2:
                                        employee.setCharge(new HumanTalent());
                                        break;

                                    case 3:
                                        employee.setCharge(new Security());
                                        break;

                                    case 4:
                                        employee.setCharge(new Floor());
                                        break;

                                    case 5:
                                        employee.setCharge(new Ceo());
                                        break;

                                    default:
                                        Mensajes.employeeNoUpdated();
                                        break;
                                }

                                company.updateEmployee(employee);
                            }


                        } catch (NumberFormatException e) {

                            Mensajes.errorNumberInsert();
                        }

                        break;

                    case 3:
                        try {
                            Mensajes.insertId();
                            employee = company.getEmployee(Integer.parseInt(scanner.nextLine()));

                            //Mensajes.infoEmployee(employee.getName(), employee.getCharge().getName(), employee.getCharge().getSalary() );
                            Mensajes.infoEmployee2(employee.getName(), employee.getCharge().getName(),
                                    employee.getCharge().getSalary());

                        } catch (NumberFormatException e) {
                            Mensajes.errorNumberInsert();
                        }

                        break;

                    /*case 4:
                        corect = true;
                        Hashtable<Integer, Employee> element = null;

                        try {
                            Mensajes.chargeMensaje();

                            switch (Integer.parseInt(scanner.nextLine())) {
                                case 1:
                                    element = company.getEmployeeForCharge(ChargeNames.GENERAL_SERVICES.getName());
                                    break;

                                case 2:
                                    element = company.getEmployeeForCharge(ChargeNames.HUMAN_TALENT.getName());
                                    break;

                                case 3:
                                    element = company.getEmployeeForCharge(ChargeNames.SECURITY.getName());
                                    break;

                                case 4:
                                    element = company.getEmployeeForCharge(ChargeNames.FLOOR.getName());
                                    break;

                                case 5:
                                    element = company.getEmployeeForCharge(ChargeNames.CEO.getName());
                                    break;

                                default:
                                    corect = false;
                                    Mensajes.valueNoValid();
                                    break;
                            }

                            if (corect && element != null) {
                                try {
                                    Mensajes.insertIdOrExit();
                                    Integer temp = Integer.parseInt(scanner.nextLine());
                                    if (temp != -1) {
                                        Mensajes.infoEmployee(employee.getName(), employee.getCharge().getName(), employee.getCharge().getSalary());
                                        employee = company.getEmployee(temp);
                                    }

                                } catch (NumberFormatException e) {
                                    Mensajes.errorNumberInsert();

                                }
                            }


                        } catch (NumberFormatException e) {

                            Mensajes.errorNumberInsert();
                        }

                        break;

                    case 5:
                        company.printEmployeesSocialLoan();

                        break;*/


                    default:
                        ctrl = false;
                        break;
                }

            } catch (NumberFormatException e) {
                Mensajes.errorNumberInsert();
            }

            System.out.println("\n");
        }
    }
}