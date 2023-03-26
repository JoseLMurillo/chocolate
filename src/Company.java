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

        } catch (NullPointerException e) {
            Messages.employeeNoExist();
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

    public Double[] parafiscalContributions(Double mounthSalary) {
        if (mounthSalary > 11600000) {
            double salary = mounthSalary * 0.3;
            var ICBF = salary * 0.04;
            var familyCompensationFund = salary * 0.03;
            var sena = salary * 0.02;
            Double array[] = {familyCompensationFund, ICBF, sena};
            return (array);

        } else {
            var ICBF = mounthSalary * 0.04;
            var familyCompensationFund = mounthSalary * 0.03;
            var sena = mounthSalary * 0.02;
            Double array[] = {familyCompensationFund, ICBF, sena};
            return (array);
        }
    }

    public Double[] socialSecurity(Double mounthSalary, Integer charge){

        if(mounthSalary > 11600000){
            double salaryEmployee = (mounthSalary * 0.7);
            double salaryCompany = 0.0;
            double pension = mounthSalary * 0.04;
            double health = mounthSalary * 0.04;
            var ARL = 0.0;

            ARL = salaryEmployee * RiskLevel.CEO.getRiskLevel();

            salaryEmployee -= mounthSalary * 0.04;

            salaryEmployee -= mounthSalary * 0.04;

            salaryCompany += ARL;

            Double array[] = {salaryCompany, pension, health, ARL};
            return (array);
        }
        else {
            double salaryEmployee = mounthSalary;
            double salaryCompany = 0.0;

            var pension = mounthSalary * 0.12;
            salaryCompany += pension;
            salaryEmployee -= mounthSalary * 0.04;

            var health = mounthSalary * 0.085;
            salaryCompany += health;
            salaryEmployee -= mounthSalary * 0.04;

            var ARL = 0.0;


            switch (charge){
                case 1160000:
                    ARL = mounthSalary * RiskLevel.GENERAL_SERVICES.getRiskLevel();
                    break;

                case 3000000:
                    ARL = mounthSalary * RiskLevel.HUMAN_TALENT.getRiskLevel();
                    break;

                case 1500000:
                    ARL = mounthSalary * RiskLevel.SECURITY.getRiskLevel();
                    break;

                case 15700000:
                    ARL = mounthSalary * RiskLevel.CEO.getRiskLevel();
                    break;

                case 2300000:
                    ARL = mounthSalary * RiskLevel.FLOOR.getRiskLevel();
                    break;

                default:
                    break;
            }

            salaryCompany += ARL;


            Double array[] = {salaryEmployee, salaryCompany, pension, health, ARL};
            return (array);
        }
    }

    public Double solidarityPensionFund(Double mounthSalary){
        if(mounthSalary > 11600000){
            return mounthSalary * 0.01;
        }
        else return 0.0;
    }

    public void printEmployeeSocialLoan(Employee employee){
        var firstPremiumDays = 0;
        var lastPremiumDays = 0;
        double salary = 0.0;

        if(employee.getCharge().getSalary() > 11600000){

            //NO PUEDE EXISTIR UN SALARIO SI ES NEGATIVO
            for (MonthHistory monthHistory : employee.History().getSalaryHistory()) {
                salary = 0.0;
                salary = Benefits.daySalary(employee.getCharge().getSalary()) * monthHistory.getDaysWorkMonth();
                salary += salary * 0.3;
                var socialSecurity = socialSecurity(salary, employee.getCharge().getSalary());
                var payEmployee = employee.getCharge().getSalary() - salary;

                if(salary <= 0){
                    payEmployee = 0;
                }

                var payCompany = socialSecurity[0];
                var pension = socialSecurity[1];
                var health = socialSecurity[2];
                var ARL = socialSecurity[3];

                var solidarityPensionFund = solidarityPensionFund(salary);
                var parafiscalContributions = parafiscalContributions(salary);

                var familyCompensationFund = parafiscalContributions[0];
                var ICBF = parafiscalContributions[1];
                var sena = parafiscalContributions[2];
            }

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

            var firstPremium = Benefits.premium(employee.getCharge().getSalary() ,firstPremiumDays);

            var lastPremium = Benefits.premium(employee.getCharge().getSalary() ,lastPremiumDays);

            var layoffs = Benefits.layoffs(employee.getCharge().getSalary(),
                    firstPremiumDays + lastPremiumDays);

            double salary = firstPremium + lastPremium;

            var interesLayoffs = Benefits.interestLayoffs(salary, firstPremiumDays + lastPremiumDays);

            double vacations = Benefits.vacations(employee.getCharge().getSalary(),
                    (firstPremiumDays + lastPremiumDays));
            if(employee.getCharge().getSalary() > 11600000){
                vacations = 0;
            }

            var vacationsDays = Benefits.vacationsDays(firstPremiumDays + lastPremiumDays);

            var parafiscalContributions = parafiscalContributions(employee.getCharge().getSalary());

            var familyCompensationFund = parafiscalContributions[0];
            var ICBF = parafiscalContributions[1];
            var sena = parafiscalContributions[2];

            var socialSecurity = socialSecurity(employee.getCharge().getSalary(), employee.getCharge().getSalary());

            salary = socialSecurity[0];
            var payEmployee = employee.getCharge().getSalary() - salary;

            var payCompany = socialSecurity[1];
            var pension = socialSecurity[2];
            var health = socialSecurity[3];
            var ARL = socialSecurity[4];

            var solidarityPensionFund = solidarityPensionFund(employee.getCharge().getSalary());

            Messages.employeeSocialLoan(this.hashtable.get(employee.getId()), firstPremiumDays,
                    lastPremiumDays, firstPremium, lastPremium, layoffs, interesLayoffs, salary, vacationsDays, vacations,
                    familyCompensationFund, ICBF, sena, payEmployee, payCompany, pension, health, ARL, solidarityPensionFund);

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
