public class Employee extends Position {
    private Integer id;
    private String name;

    public Employee(Integer id, String name, String charge, Integer salary){
        super(charge, salary);
        this.id = id;
        this.name = name;

    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}