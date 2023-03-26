public class Benefits {

    public static Double premium(Integer monthSalary, Integer daysWorked){
        return (double) Math.round((daysWorked * (monthSalary/2)) / 180);
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

    public static Integer vacationsDays(Integer daysWorked){
        return (int)((daysWorked * 15) / 360);
    }
}
