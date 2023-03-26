public enum ChargeNames {
    GENERAL_SERVICES("General services"),
    HUMAN_TALENT("Human talent"),
    SECURITY("Security"),
    CEO("Ceo"),
    FLOOR("Floor");

    private String name;

    ChargeNames(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
