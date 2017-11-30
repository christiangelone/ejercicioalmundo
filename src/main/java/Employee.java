public abstract class Employee implements Attendant {

    public static final String TYPE_OPERATOR = "OPERATOR";
    public static final String TYPE_SUPERVISOR = "SUPERVISOR" ;
    public static final String TYPE_DIRECTOR = "DIRECTOR";
    private final String name;
    private final String type;
    private Call call;
    private Boolean busy;

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

    @Override
    public Boolean isBusy() {
        return this.busy;
    }

    @Override
    public void answer(Call call) {
        if(!isBusy()){
            call.setAttendant(this);
            call.answer();
            this.busy = true;
        }
    }

    @Override
    public void free() {
        this.busy = false;
    }
}
