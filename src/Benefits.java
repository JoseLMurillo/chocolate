public class Benefits {

    public static Double premium(Integer monthSalary, Integer daysWorked){
        return (double) Math.round((daysWorked * (monthSalary/2)) / 180);
    }

    public static Double layoffs(Integer monthSalary, Integer daysWorked){
        monthSalary = monthSalary / 1000;
        return (double) Math.round(((daysWorked * monthSalary) / 360) * 1000);
        //return (double) (monthSalary * 8.33) * monthWorked;
    }

    public static Double interestLayoffs(Integer value, Integer daysWorked){
        return value + ((value * daysWorked * 0.12) / 360);
    }



    public static Integer daySalary(Integer monthSalary){
        return monthSalary / 30;
    }

    public static Integer vacations (Integer monthSalary, Integer daysWorked, Integer Holidays) {
        return (monthSalary * daysWorked) / 720;
    }
}
