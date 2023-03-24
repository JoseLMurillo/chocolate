public class MonthHistory {
    private Integer month;
    private Integer daysWorkMonth;

    MonthHistory(){

    }

    MonthHistory(Integer month, Integer daysWorkMonth){
        this.month = month;
        this.daysWorkMonth = daysWorkMonth;
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
}
