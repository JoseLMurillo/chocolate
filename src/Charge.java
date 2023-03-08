public enum Charge {
    GENERAL_SERVICES("General services"),
    HUMAN_TALENT("Human talent"),
    SECURITY("Security"),
    FLOOR("Plant"),
    CEO("Ceo");

    private String charge;

    Charge(String charge) {
        this.charge = charge;
    }

    String getCharge(){
        return this.charge;
    }

    void setCharge(String charge){
         this.charge = charge;
    }

}
