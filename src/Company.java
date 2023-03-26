import java.util.*;

public class Company {
    private final String name;
    private Hashtable<Integer, Employee> hashtable;

    public Company() {
        this.name = "Medellin Chocolate";
        this.hashtable = new Hashtable<>();
    }

    public String getName() {
        return name;
    }

    public Boolean getEmployeeForCharge(Integer name) {
        Enumeration<Integer> keys = this.hashtable.keys();
        Charge element;
        boolean exist = false;

        switch (name) {
            case 1:
                element = new GeneralServices();
                break;

            case 2:
                element = new HumanTalent();
                break;

            case 3:
                element = new Security();
                break;

            case 4:
                element = new Floor();
                break;

            case 5:
                element = new Ceo();
                break;

            default:
                element = null;
                Messages.valueNoValid();
                break;
        }

        Messages.listIds();
        while (keys.hasMoreElements()) {
            Integer key = keys.nextElement();

            if (element.getSalary().compareTo(this.hashtable.get(key).getCharge().getSalary()) == 0) {
                Messages.printKey(key);
                exist = true;
            }
        }
        return exist;
    }

    public Hashtable<Integer, Employee> getEmployeesHashTable() {
        return hashtable;
    }

    public void setEmployeesHashTable(Hashtable<Integer, Employee> employee) {
        this.hashtable = employee;
    }

    public void addEmployee(Employee employee) {
        if (!getEmployeesHashTable().contains(employee)) {
            hashtable.put(employee.getId(), employee);
            Messages.employeeAdded();
        } else {
            Messages.employeeNoAdded();
        }
    }

    public Employee getEmployee(Integer employee) {
        try {
            if (hashtable.contains(getEmployeesHashTable().get(employee))) {
                return hashtable.get(employee);
            }
        } catch (NullPointerException e){

        }
        return null;
    }

    public void updateEmployee(Employee employee) {
        if (getEmployeesHashTable().contains(employee)) {
            hashtable.replace(employee.getId(), employee);
            Messages.employeeUpdated();
        } else {
            Messages.employeeNoExist();
        }
    }

    public void deleteEmployee(Employee employee) {
        if (getEmployeesHashTable().contains(employee)) {
            hashtable.remove(employee.getId());
            Messages.employeeDeleted();
        } else {
            Messages.employeeNoExist();
        }
    }

    public void printEmployeeSocialLoan(Employee employee){
        var firstPremiumDays = 0;
        var lastPremiumDays = 0;
        double salary;
        var monthHistory = new MonthHistory();

        if(employee.getCharge().getSalary() > 11600000){

            if(employee.History().getSalaryHistory().size() != 0) {
                monthHistory = employee.History().getSalaryHistory().get(employee.History().getSalaryHistory().size() - 1);
            }
            else {
                monthHistory.setMonth(0);
                monthHistory.setDaysWorkMonth(0);
            }

            salary = Calculations.daySalary(employee.getCharge().getSalary()) * monthHistory.getDaysWorkMonth();
            salary += salary * 0.3;
            salary = Math.round(salary);
            var socialSecurity = Calculations.socialSecurity(salary, employee.getCharge().getSalary());
            double payEmployee = (employee.getCharge().getSalary() - socialSecurity[0]);

            var payCompany = Math.round(socialSecurity[1]);
            var pension = socialSecurity[2];
            var health = Math.round(socialSecurity[3]);
            var ARL = socialSecurity[4];

            var solidarityPensionFund = Calculations.solidarityPensionFund(salary);
            var parafiscalContributions = Calculations.parafiscalContributions(salary);

            var familyCompensationFund = Math.round(parafiscalContributions[0]);
            var ICBF = Math.round(parafiscalContributions[1]);
            var sena = Math.round(parafiscalContributions[2]);

            Messages.integralSalaryLoan(this.hashtable.get(employee.getId()), salary, familyCompensationFund, ICBF, sena, payEmployee, payCompany,
                    pension, health, ARL, solidarityPensionFund);
        }
        else {
            for (MonthHistory month :
                    employee.History().getSalaryHistory()) {

                if (month.getMonth() <= 6) {
                    firstPremiumDays += month.getDaysWorkMonth();
                } else {
                    lastPremiumDays += month.getDaysWorkMonth();
                }
            }

            var firstPremium = Calculations.premium(employee.getCharge().getSalary() ,firstPremiumDays);

            var lastPremium = Calculations.premium(employee.getCharge().getSalary() ,lastPremiumDays);

            var layoffs = Calculations.layoffs(employee.getCharge().getSalary(),
                    firstPremiumDays + lastPremiumDays);

            salary = firstPremium + lastPremium;

            var interesLayoffs = Calculations.interestLayoffs(salary, firstPremiumDays + lastPremiumDays);

            double vacations = Calculations.vacations(employee.getCharge().getSalary(),
                    (firstPremiumDays + lastPremiumDays));

            var vacationsDays = Calculations.vacationsDays(firstPremiumDays + lastPremiumDays);

            var parafiscalContributions = Calculations.parafiscalContributions(salary);

            var familyCompensationFund = Math.round(parafiscalContributions[0]);
            var ICBF = Math.round(parafiscalContributions[1]);
            var sena = Math.round(parafiscalContributions[2]);

            var socialSecurity = Calculations.socialSecurity(salary, employee.getCharge().getSalary());

            salary = Math.round(socialSecurity[0]);
            var payEmployee = employee.getCharge().getSalary() - salary;

            var payCompany = socialSecurity[1];
            var pension = socialSecurity[2];
            var health = Math.round(socialSecurity[3]);
            var ARL = socialSecurity[4];

            Messages.employeeSocialLoan(this.hashtable.get(employee.getId()), firstPremiumDays,
                    lastPremiumDays, firstPremium, lastPremium, layoffs, interesLayoffs, salary, vacationsDays, vacations,
                    familyCompensationFund, ICBF, sena, payEmployee, payCompany, pension, health, ARL);
        }
    }

    public void printEmployeesSocialLoan() {
        Enumeration<Integer> keys = this.hashtable.keys();

        while (keys.hasMoreElements()) {
            Integer key = keys.nextElement();

            this.printEmployeeSocialLoan(this.hashtable.get(key));
            Messages.lineBreak();
        }
    }
}
