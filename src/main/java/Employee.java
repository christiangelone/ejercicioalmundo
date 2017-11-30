public abstract class Employee {

    public static final String TYPE_OPERATOR = "OPERATOR";
    public static final String TYPE_SUPERVISOR = "SUPERVISOR" ;
    public static final String TYPE_DIRECTOR = "DIRECTOR";
    private final String name;
    private final String type;
    private Call call;
    private boolean busy;

    public Employee(String name, String type){
        this.name = name;
        this.type = type;
        this.busy = false;
    }

    public String getType() {
        return this.type;
    }

    public String getName() {
        return this.name;
    }

    public boolean isBusy() {
        return this.busy;
    }

    public void answer(Call call) {
        if(!isBusy()){
            this.call = call;
            this.call.answer();
            this.busy = true;
        }
    }
}
