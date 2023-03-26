public class Messages {
  public static void menuMensaje(String companyName){
      System.out.println("MENU OF COMPANY: " + companyName);
      System.out.println("-----------------");
      System.out.println("1) Add new Employee.");
      System.out.println("2) Update charge.");
      System.out.println("3) Search employee.");
      System.out.println("4) Search for charge.");
      System.out.println("5) Social benefits.");
      System.out.println("Insert any other number to exit.");
      System.out.println("-----------------");
      System.out.print("Insert option ->: ");
  }

  public static void chargeMensaje(){
    System.out.println("Insert charge: ");
    System.out.println("1) General services.");
    System.out.println("2) Human talent.");System.out.println("3) Security.");
    System.out.println("4) Floor.");
    System.out.println("5) Ceo.");
    System.out.println("--------------");
    System.out.print("Insert number of charge ->: ");
  }

  public static void insertId(){
      System.out.print("Insert id: ");
  }

  public static void insertName(){
      System.out.print("Insert name: ");
  }

  public static void errorInsertPositiveNumber(){
      System.out.println("ERROR: Insert a positive number.");
  }

  public static void employeeNoAdded(){
      System.out.println("Employee NO ADDED");
  }

  public static void errorNumberInsert(){
      System.out.println("\nERROR: Insert a number\n");
  }

  public static void employeeNoUpdated(){
      System.out.println("Employee NO UPDATED");
  }

  public static void valueNoValid(){
      System.out.println("ERROR: Value no valid.");
  }

  public static void insertIdOrExit(){
      System.out.print("Insert id to search, -1 to exit: ");
  }

  public static void workedDays(Integer month){
      System.out.print("Insert worked days of month " + month + ": ");
  }

  public static void noFound(){
      System.out.println("No found.");
  }

  public static void lineBreak(){
      System.out.println("\n");
  }

  public static void monthsWorked(){
      System.out.print("Insert mounths worked: ");
  }

  public static void employeeNoExist(){
      System.out.println("Employee no exist");
  }

  public static void employeeAdded(){
      System.out.println("EMPLOYEE ADDED");
  }

  public static void employeeUpdated(){
      System.out.println("Employee updated");
  }

    public static void integralSalaryLoan(Employee employee, double salary, double familyCompensationFund, double ICBF,
                                          double sena, double payEmployee, double salaryCompany, double pension, double health,
                                          double ARL, double solidarityPensionFund){
        if(employee != null){
            System.out.println("Key: " + employee.getId() +
                    ", Name: " + employee.getName() +
                    ", Charge: " + employee.getCharge().getName() +
                    "\n" +
                    "Salary: " + salary +
                    "\n" + "\n" +
                    "PARAFISCAL CONTRIBUTIONS (Month): " + "\n" +
                    "Family compensation fund: " + familyCompensationFund +
                    ", ICBF: " + ICBF +
                    ", Sena: " + sena +
                    "\n" + "\n" +
                    "SOCIAL SECURITY: " + "\n" +
                    "Pay the company: " + salaryCompany +
                    ", Pay the employee: " + payEmployee +
                    ", Pension: " + pension +
                    ", Health: " + health +
                    ", ARL: " + ARL +
                    ", Solidarity pension fund: " + solidarityPensionFund + ".");

        }else {
            Messages.employeeNoExist();
        }
    }
    public static void employeeSocialLoan(Employee employee, Integer firstPremiumDays, Integer lastPremiumDays,
                                          double firstPremium, double lastPremium, double layoffs,
                                          double interesLayoffs, double salary, Integer vacationsDays,
                                          double vacations, double familyCompensationFund, double ICBF, double sena,
                                          double payEmployee, double salaryCompany, double pension, double health,
                                          double ARL){
      if(employee != null){
          System.out.println("Key: " + employee.getId() +
                  ", Name: " + employee.getName() +
                  ", Charge: " + employee.getCharge().getName() +
                  "\n" +
                  "Salary: " + salary +
                  "\n" +
                  "First days worked: " + firstPremiumDays + ", Last days worked : " + lastPremiumDays +
                  "\n" +
                  "Firts premium: " + firstPremium + " Lasts premium: " + lastPremium +
                  "\n" +
                  "Layouts: " + layoffs + ", Interest layouts: " + interesLayoffs +
                  "\n" +
                  "Days of vacations: " + vacationsDays + ", Vacations: " + vacations +
                  "\n" + "\n" +
                  "PARAFISCAL CONTRIBUTIONS (Month): " + "\n" +
                  "Family compensation fund: " + familyCompensationFund +
                  ", ICBF: " + ICBF +
                  ", Sena: " + sena +
                  "\n" + "\n" +
                  "SOCIAL SECURITY: " + "\n" +
                  "Pay the company: " + salaryCompany +
                  ", Pay the employee: " + payEmployee +
                  ", Pension: " + pension +
                  ", Health: " + health +
                  ", ARL: " + ARL + ".");


      }else {
          Messages.employeeNoExist();
      }
    }

    public static void employeeExist() {
        System.out.println("Exployee no added because exist.");
    }

    public static void employeeDeleted(){
        System.out.println("Employee deleted");
    }

    public static void printKey(Integer key){
        System.out.println("Key: " + key);
    }

    public static void listIds(){
        System.out.println("List Ids: ");
    }
}