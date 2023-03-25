import java.util.ArrayList;

public class SalaryHistory{
    private ArrayList<MonthHistory> monthHistories;

  SalaryHistory(){
      this.monthHistories = new ArrayList<>();
  }

    public ArrayList<MonthHistory> getMonthHistories() {
        return this.monthHistories;
    }

    public void setMonthHistorie(MonthHistory monthHistories) {
        this.monthHistories.add(monthHistories);
    }
}