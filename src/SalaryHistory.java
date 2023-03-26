import java.util.ArrayList;

public class SalaryHistory{
    private ArrayList<MonthHistory> salaryHistory;

  SalaryHistory(){
      this.salaryHistory = new ArrayList<>();
  }

    public ArrayList<MonthHistory> getSalaryHistory() {
        return this.salaryHistory;
    }

    public void setMonthHistorie(MonthHistory monthHistories) {
        this.salaryHistory.add(monthHistories);
    }
}