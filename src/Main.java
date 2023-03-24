import java.util.Hashtable;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

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
                            String name = scanner.nextLine();
                            try {
                                if(name != ""){
                                    employee.setName(scanner.nextLine());
                                }
                                else {
                                    Mensajes.valueNoValid();
                                }

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
                                Mensajes.monthAdmission();
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

                        if(correct) {
                            try {

                                Mensajes.workedDays();
                                Integer temp = Integer.parseInt(scanner.nextLine());

                                if (temp < 0) {
                                    correct = false;
                                    Mensajes.errorInsertPositiveNumber();
                                } else {
                                    monthHistory.setDaysWorkMonth(temp);
                                }


                            } catch (NumberFormatException e) {
                                correct = false;
                                Mensajes.errorNumberInsert();
                            }

                        }

                        if(correct) {
                            try {
                                employee.setSalaryHistory(new SalaryHistory(2023));
                                employee.getSalaryHistory().setMonthHistorie(monthHistory);

                            } catch (NumberFormatException e) {
                                correct = false;
                                Mensajes.errorNumberInsert();
                            }

                        }


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

                    case 4:

                        try {
                            Mensajes.chargeMensaje();

                            correct = company.getEmployeeForCharge(Integer.parseInt(scanner.nextLine()));

                            if (correct) {
                                try {
                                    Mensajes.insertIdOrExit();
                                    Integer temp = Integer.parseInt(scanner.nextLine());
                                    if (temp != -1) {
                                        employee = company.getEmployee(temp);
                                        Mensajes.infoEmployee(employee.getName(), employee.getCharge().getName(), employee.getCharge().getSalary());
                                    }

                                } catch (NumberFormatException e) {
                                    Mensajes.errorNumberInsert();
                                }
                            }
                            else {
                                Mensajes.noFound();
                            }


                        } catch (NumberFormatException e) {

                            Mensajes.errorNumberInsert();
                        }

                        break;

                    case 5:
                        company.printEmployeesSocialLoan();

                        break;


                    default:
                        ctrl = false;
                        break;
                }

            } catch (NumberFormatException e) {
                Mensajes.errorNumberInsert();
            }

            Mensajes.lineBreak();
        }
    }
}