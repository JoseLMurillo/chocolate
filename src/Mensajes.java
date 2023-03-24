public class Mensajes{
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

  public static void infoEmployee2(String name, String charge, Integer salary){
        System.out.println("Name: " + name + ", Charge: " + charge + ", Salary: " + salary);
    }

  public static void infoEmployee (String name, String charge, Integer salary){
      System.out.println("Name: " + name + ", " +
              "Charge: " + charge + ", " +
              "Salary: " + salary + ".");
  }

  public static void valueNoValid(){
      System.out.println("ERROR: Value no valid");
  }

  public static void insertIdOrExit(){
      System.out.print("Insert id to search, -1 to exit: ");
  }

  public static void monthAdmission(){
      System.out.print("Insert month of admission: ");
  }

  public static void workedDays(Integer month){
      System.out.print("Insert worked days of month " + month + ": ");
  }

  public static void noFound(){
      System.out.println("No found");
  }

  public static void lineBreak(){
      System.out.println("\n");
  }

  public static void monthsWorked(){
      System.out.print("Insert mounths worked: ");
  }

}