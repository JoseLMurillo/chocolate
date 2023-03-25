import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Company company = new Company();
        company.setEmployeesHashTable(Default.chargeDefault());

        Boolean ctrl = true;
        Boolean correct;
        Scanner scannerTemp = new Scanner(System.in);
        Employee employee = new Employee();
        MonthHistory monthHistoryTemp = new MonthHistory();

        while(ctrl) {
            Scanner scanner = scannerTemp;
            MonthHistory monthHistory = monthHistoryTemp;
            correct = true;

            Mensajes.menuMensaje(company.getName());

            try {
                switch (Integer.parseInt(scanner.nextLine())) {
                    case 1:
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
                            Mensajes.valueNoValid();
                        }

                        if (correct) {
                            Mensajes.insertName();
                            try {
                                String name = scanner.nextLine();
                                if(name != ""){
                                    employee.setName(name);
                                }
                                else {
                                    correct = false;
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
                                Integer temp = Integer.parseInt(scanner.nextLine());

                                if(temp > 0){
                                    switch (temp) {
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
                                }

                            } catch (NumberFormatException e) {
                                correct = false;

                                Mensajes.errorNumberInsert();
                            }
                        }

                        if(correct) {
                            Mensajes.monthsWorked();
                            employee.setSalaryHistory(new SalaryHistory());

                            int i = 0;

                            try {
                                Integer monthsWorked = Integer.parseInt(scanner.nextLine());

                                if (monthsWorked > 12 || monthsWorked < 0) {
                                    correct = false;
                                    Mensajes.valueNoValid();

                                } else {
                                    while (i < monthsWorked && correct) {
                                        try {
                                            i += 1;
                                            Mensajes.workedDays(i);
                                            Integer temp = Integer.parseInt(scanner.nextLine());

                                            if (temp < 0 || temp > 32) {
                                                correct = false;
                                                Mensajes.valueNoValid();

                                            } else {
                                                monthHistory.setMonth(monthsWorked);
                                                monthHistory.setDaysWorkMonth(temp);

                                                employee.getSalaryHistory().setMonthHistorie(monthHistory);
                                            }

                                        } catch(NumberFormatException e){
                                        correct = false;
                                        Mensajes.errorNumberInsert();
                                        }
                                    }
                                }
                                } catch(NumberFormatException e){
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
                                        correct = false;
                                        break;
                                }

                                if(correct) {
                                    Mensajes.monthsWorked();
                                    employee.setSalaryHistory(new SalaryHistory());

                                    int i = 0;

                                    try {
                                        Integer monthsWorked = Integer.parseInt(scanner.nextLine());

                                        if (monthsWorked > 12 || monthsWorked < 0) {
                                            correct = false;
                                            Mensajes.valueNoValid();

                                        } else {
                                            while (i < monthsWorked) {
                                                try {
                                                    i += 1;
                                                    Mensajes.workedDays(i);
                                                    Integer temp = Integer.parseInt(scanner.nextLine());

                                                    if (temp < 0 || temp > 32) {
                                                        correct = false;
                                                        Mensajes.valueNoValid();

                                                    } else {
                                                        monthHistory.setMonth(monthsWorked);
                                                        monthHistory.setDaysWorkMonth(temp);

                                                        employee.getSalaryHistory().setMonthHistorie(monthHistory);
                                                    }

                                                } catch(NumberFormatException e){
                                                    correct = false;
                                                    Mensajes.errorNumberInsert();
                                                }
                                            }
                                        }
                                    } catch(NumberFormatException e){
                                        correct = false;
                                        Mensajes.errorNumberInsert();
                                    }
                                }

                                if (correct) {
                                    company.updateEmployee(employee);
                                }
                            }
                        } catch (NumberFormatException e) {

                            Mensajes.errorNumberInsert();
                        }

                        break;

                    case 3:
                        try {
                            Mensajes.insertId();
                            employee = company.getEmployee(Integer.parseInt(scanner.nextLine()));

                            if(employee != null){
                                Mensajes.infoEmployee2(employee.getName(), employee.getCharge().getName(),
                                        employee.getCharge().getSalary());

                                company.printEmployeeSocialLoan(employee);
                            }
                            else {
                                employee = new Employee();
                            }

                        } catch (NumberFormatException e) {
                            Mensajes.errorNumberInsert();
                            Mensajes.valueNoValid();
                        }

                        break;

                    case 4:

                        try {
                            Mensajes.chargeMensaje();
                            Integer temp = Integer.parseInt(scanner.nextLine());
                            if(temp < 0 || temp > 6){
                                correct = false;
                                Mensajes.valueNoValid();
                            }
                            else {
                                correct = company.getEmployeeForCharge(temp);
                                try {
                                    Mensajes.insertIdOrExit();
                                    temp = Integer.parseInt(scanner.nextLine());
                                    if (temp != -1) {
                                        employee = company.getEmployee(temp);
                                        Mensajes.infoEmployee(employee.getName(), employee.getCharge().getName(), employee.getCharge().getSalary());
                                    } else {
                                        Mensajes.noFound();
                                    }

                                } catch (NumberFormatException e) {
                                    Mensajes.errorNumberInsert();
                                }
                            }

                        } catch (NumberFormatException e) {

                            Mensajes.errorNumberInsert();
                            Mensajes.valueNoValid();
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