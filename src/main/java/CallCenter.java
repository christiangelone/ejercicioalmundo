import java.util.ArrayList;
import java.util.List;

public class CallCenter {

    private List<Operator> operators;
    private List<Supervisor> supervisors;

    public CallCenter() {
        this.operators = new ArrayList<Operator>();
        this.operators.add(new Operator());
        this.supervisors = new ArrayList<Supervisor>();
        this.supervisors.add(new Supervisor());
    }

    public List<Operator> getOperators() {
        return operators;
    }

    public List<Supervisor> getSupervisors() {
        return supervisors;
    }
}
