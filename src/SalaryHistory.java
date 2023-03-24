import java.util.ArrayList;

public class SalaryHistory{
    private Integer yearAdmission;
    private ArrayList<MonthHistory> monthHistories;

  //TENER EN CUENTA SI ES POSIBLE AGREGAR LOS DIAS EXTRA

SalaryHistory(){
  
}
  
  SalaryHistory(Integer yearAdmission){
      this.yearAdmission = yearAdmission;
      this.monthHistories = new ArrayList<>();
  }

    public Integer getYearAdmission() {
        return yearAdmission;
    }

    public void setYearAdmission(Integer yearAdmission) {
        this.yearAdmission = yearAdmission;
    }

    public ArrayList<MonthHistory> getMonthHistories() {
        return this.monthHistories;
    }

    public void setMonthHistorie(MonthHistory monthHistories) {
        this.monthHistories.add(monthHistories);
    }
}