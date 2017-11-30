import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CallCenter {

    private List<Operator> operators;
    private List<Supervisor> supervisors;
    private List<Director> directors;
    private String name;
    private Dispatcher dispatcher;


    public CallCenter(String name) {
        this.name = name;
        this.operators = new ArrayList<Operator>();
        this.operators.add(new Operator("DefaultOperator"));
        this.supervisors = new ArrayList<Supervisor>();
        this.supervisors.add(new Supervisor("DefaultSupervisor"));
        this.directors = new ArrayList<Director>();
        this.directors.add(new Director("DefaultDirector"));
        this.dispatcher = new Dispatcher();
        this.dispatcher.setAttendantsGroups(Arrays.<List<Attendant>>asList(
                operatorsToAttendants(this.operators),
                supervisorsToAttendants(this.supervisors),
                directorsToAttendants(this.directors)
        ));
    }

    private List<Attendant> operatorsToAttendants(List<Operator> ops){
        List<Attendant> attendants = new ArrayList<Attendant>();
        for(Operator op: ops){
            attendants.add((Attendant) op);
        }
        return attendants;
    }

    private List<Attendant> supervisorsToAttendants(List<Supervisor> sups){
        List<Attendant> attendants = new ArrayList<Attendant>();
        for(Supervisor sup: sups){
            attendants.add((Attendant) sup);
        }
        return attendants;
    }

    private List<Attendant> directorsToAttendants(List<Director> dirs){
        List<Attendant> attendants = new ArrayList<Attendant>();
        for(Director dir: dirs){
            attendants.add((Attendant) dir);
        }
        return attendants;
    }

    public List<Operator> getOperators() {
        return operators;
    }

    public List<Supervisor> getSupervisors() {
        return supervisors;
    }

    public List<Director> getDirectors() {
        return directors;
    }

    public String getName() {
        return this.name;
    }

    public Dispatcher getDispatcher() {
        return this.dispatcher;
    }

    public void setDispatcher(Dispatcher dispatcher) {
        this.dispatcher = dispatcher;
        this.dispatcher.setAttendantsGroups(Arrays.<List<Attendant>>asList(
                operatorsToAttendants(this.operators),
                supervisorsToAttendants(this.supervisors),
                directorsToAttendants(this.directors)
        ));
    }
}
