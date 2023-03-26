public class Calculations {

    public static Double premium(Integer monthSalary, Integer daysWorked){
        return (double) Math.round((daysWorked * ((double)(monthSalary/2)) / 180));
    }

    public static Double layoffs(Integer monthSalary, Integer daysWorked){
        var temp = ((monthSalary / 1000) * daysWorked);
        temp = (temp / 360);
        temp = (temp * 1000);
        return (double) Math.round(temp);
    }

    public static Double interestLayoffs(double value, Integer daysWorked){
        return value + ((value * daysWorked * 0.12) / 360);
    }

    public static Integer daySalary(Integer monthSalary){
        return monthSalary / 30;
    }

    public static Double vacations (Integer monthSalary, Integer daysWorked) {
        var temp = ((monthSalary / 1000) * daysWorked);
        temp = temp / 720;
        temp = temp * 1000;
        return (double) (temp);
    }

    public static Double vacationsDays(Integer daysWorked){
        return (double) ((daysWorked * 15) / 360);
    }

    public static Double solidarityPensionFund(Double mounthSalary){
        if(mounthSalary > 11600000){
            return mounthSalary * 0.01;
        }
        else return 0.0;
    }
    public static Double[] socialSecurity(Double mounthSalary, Integer charge){

        if(mounthSalary > 11600000){
            double salaryEmployee = (mounthSalary / 1000);
            salaryEmployee = (salaryEmployee * 0.7);
            double salaryCompany = 0.0;
            double totalEmployee = 0.0;
            double pension = mounthSalary * 0.04;
            double health = mounthSalary * 0.04;
            var ARL = 0.0;

            ARL = salaryEmployee * RiskLevel.CEO.getRiskLevel();

            totalEmployee += salaryEmployee * 0.04;
            totalEmployee += salaryEmployee * 0.04;

            salaryCompany += ARL;

            return (new Double[]{totalEmployee, salaryCompany, pension, health, ARL});
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


            return (new Double[]{salaryEmployee, salaryCompany, pension, health, ARL});
        }
    }

    public static Double[] parafiscalContributions(Double mounthSalary) {
        if (mounthSalary > 11600000) {
            double salary = mounthSalary * 0.3;
            var ICBF = salary * 0.04;
            var familyCompensationFund = salary * 0.03;
            var sena = salary * 0.02;
            return (new Double[]{familyCompensationFund, ICBF, sena});

        } else {
            var ICBF = mounthSalary * 0.04;
            var familyCompensationFund = mounthSalary * 0.03;
            var sena = mounthSalary * 0.02;
            return (new Double[]{familyCompensationFund, ICBF, sena});
        }
    }
}
