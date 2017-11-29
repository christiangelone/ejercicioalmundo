public abstract class Employee {

    public static final String TYPE_OPERATOR = "OPERATOR";
    private final String name;
    private final String type;

    public Employee(String name, String type){
        this.name = name;
        this.type = type;
    }

    public String getType() {
        return this.type;
    }

    public String getName() {
        return this.name;
    }
}
