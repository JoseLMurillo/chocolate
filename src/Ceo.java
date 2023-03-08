public class Ceo {

    private static Integer cosa = 123;
    private static Charge nombre = Charge.CEO;

    public static Integer getCosa() {
        return cosa;
    }

    public static void setCosa(Integer cosa) {
        Ceo.cosa = cosa;
    }

    public static String getCharge() {
        return nombre.getCharge();
    }

    public static void setNombre(Charge nombre) {
        Ceo.nombre = nombre;
    }
}
