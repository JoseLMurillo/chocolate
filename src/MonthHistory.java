public class MonthHistory {
    private Integer year;
    private Integer month;
    private Integer daysWorkMonth;

    MonthHistory(){

    }

    MonthHistory(Integer month, Integer daysWorkMonth, Integer year){
        this.month = month;
        this.daysWorkMonth = daysWorkMonth;
        this.year = year;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getDaysWorkMonth() {
        return daysWorkMonth;
    }

    public void setDaysWorkMonth(Integer daysWorkMonth) {
        this.daysWorkMonth = daysWorkMonth;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
}
