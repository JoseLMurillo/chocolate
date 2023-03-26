import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Company company = new Company();
        company.setEmployeesHashTable(Preload.chargeDefault());

        boolean ctrl = true;
        Boolean correct;
        Scanner scannerTemp = new Scanner(System.in);
        Employee employee = new Employee();
        MonthHistory monthHistoryTemp = new MonthHistory();

        while(ctrl) {
            Scanner scanner = scannerTemp;
            MonthHistory monthHistory = monthHistoryTemp;
            correct = true;

            Messages.menuMensaje(company.getName());

            try {
                switch (Integer.parseInt(scanner.nextLine())) {
                    case 1:
                        Messages.insertId();
                    try {
                            Integer temp = Integer.parseInt(scanner.nextLine());
                            if (temp < 0) {
                                correct = false;
                                Messages.errorInsertPositiveNumber();
                            }
                            else if (company.getEmployee(temp) != null) {
                                Messages.employeeExist();
                            }
                            else {
                                employee.setId(temp);
                            }

                        } catch (NumberFormatException e) {
                            correct = false;
                            Messages.errorNumberInsert();
                            Messages.valueNoValid();
                        }

                        if (correct) {
                            Messages.insertName();
                            try {
                                String name = scanner.nextLine();
                                if(name != ""){
                                    employee.setName(name);
                                }
                                else {
                                    correct = false;
                                    Messages.valueNoValid();
                                }

                            } catch (NumberFormatException e) {
                                correct = false;
                                Messages.errorNumberInsert();
                            }
                        }

                        if (correct) {
                            Messages.chargeMensaje();
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
                                            Messages.employeeNoAdded();
                                            break;
                                    }
                                }

                            } catch (NumberFormatException e) {
                                correct = false;

                                Messages.errorNumberInsert();
                            }
                        }

                        if(correct) {
                            Messages.monthsWorked();
                            employee.setSalaryHistory(new SalaryHistory());

                            int i = 0;

                            try {
                                Integer monthsWorked = Integer.parseInt(scanner.nextLine());

                                if (monthsWorked > 12 || monthsWorked < 0) {
                                    correct = false;
                                    Messages.valueNoValid();

                                } else {
                                    while (i < monthsWorked && correct) {
                                        try {
                                            i += 1;
                                            Messages.workedDays(i);
                                            Integer temp = Integer.parseInt(scanner.nextLine());

                                            if (temp < 0 || temp > 32) {
                                                correct = false;
                                                Messages.valueNoValid();

                                            } else {
                                                monthHistory.setMonth(monthsWorked);
                                                monthHistory.setDaysWorkMonth(temp);

                                                employee.History().setMonthHistorie(monthHistory);
                                            }

                                        } catch(NumberFormatException e){
                                        correct = false;
                                        Messages.errorNumberInsert();
                                        }
                                    }
                                }
                                } catch(NumberFormatException e){
                                    correct = false;
                                    Messages.errorNumberInsert();
                                }
                        }

                        if (correct) {
                            company.addEmployee(employee);
                        }

                        break;

                    case 2:
                        try {
                            Messages.insertId();

                            employee = company.getEmployee(Integer.parseInt(scanner.nextLine()));

                            if (employee != null) {
                                Messages.chargeMensaje();

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
                                        Messages.employeeNoUpdated();
                                        correct = false;
                                        break;
                                }

                                if(correct) {
                                    Messages.monthsWorked();
                                    employee.setSalaryHistory(new SalaryHistory());

                                    int i = 0;

                                    try {
                                        Integer monthsWorked = Integer.parseInt(scanner.nextLine());

                                        if (monthsWorked > 12 || monthsWorked < 0) {
                                            correct = false;
                                            Messages.valueNoValid();

                                        } else {
                                            while (i < monthsWorked) {
                                                try {
                                                    i += 1;
                                                    Messages.workedDays(i);
                                                    Integer temp = Integer.parseInt(scanner.nextLine());

                                                    if (temp < 0 || temp > 32) {
                                                        correct = false;
                                                        Messages.valueNoValid();

                                                    } else {
                                                        monthHistory.setMonth(monthsWorked);
                                                        monthHistory.setDaysWorkMonth(temp);

                                                        employee.History().setMonthHistorie(monthHistory);
                                                    }

                                                } catch(NumberFormatException e){
                                                    correct = false;
                                                    Messages.errorNumberInsert();
                                                }
                                            }
                                        }
                                    } catch(NumberFormatException e){
                                        correct = false;
                                        Messages.errorNumberInsert();
                                    }
                                }

                                if (correct) {
                                    company.updateEmployee(employee);
                                }
                            }
                        } catch (NumberFormatException e) {

                            Messages.errorNumberInsert();
                        }

                        break;

                    case 3:
                        try {
                            Messages.insertId();
                            employee = company.getEmployee(Integer.parseInt(scanner.nextLine()));

                            if(employee != null){
                                company.printEmployeeSocialLoan(employee);
                            }
                            else {
                                employee = new Employee();
                            }

                        } catch (NumberFormatException e) {
                            Messages.errorNumberInsert();
                            Messages.valueNoValid();
                        }

                        break;

                    case 4:

                        try {
                            Messages.chargeMensaje();
                            Integer temp = Integer.parseInt(scanner.nextLine());
                            if(temp < 0 || temp > 6){
                                correct = false;
                                Messages.valueNoValid();
                            }
                            else {
                                correct = company.getEmployeeForCharge(temp);
                                try {
                                    Messages.insertIdOrExit();
                                    temp = Integer.parseInt(scanner.nextLine());
                                    if (temp != -1) {
                                        employee = company.getEmployee(temp);
                                        company.printEmployeeSocialLoan(employee);
                                    } else {
                                        Messages.noFound();
                                    }

                                } catch (NumberFormatException e) {
                                    Messages.errorNumberInsert();
                                }
                            }

                        } catch (NumberFormatException e) {

                            Messages.errorNumberInsert();
                            Messages.valueNoValid();
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
                Messages.errorNumberInsert();
            }

            Messages.lineBreak();
        }
    }
}