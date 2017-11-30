import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CallCenter {

    private List<Operator> operators;
    private List<Supervisor> supervisors;
    private List<Director> directors;
    private String name;
    private Dispatcher dispatcher;


    public CallCenter(String name,Integer numOfOperators,Integer numOfSupervisor,Integer numOfDirectors) {
        this.name = name;

        if (numOfOperators == null || numOfOperators <= 0) numOfOperators = 1;
        if (numOfSupervisor == null || numOfSupervisor <= 0) numOfSupervisor = 1;
        if (numOfDirectors == null || numOfDirectors <= 0) numOfDirectors = 1;

        this.operators = new ArrayList<Operator>();
        for (int i = 0; i < numOfOperators; i++) {
            this.operators.add(new Operator("Operator " + i));
        }

        this.supervisors = new ArrayList<Supervisor>();
        for (int i = 0; i < numOfOperators; i++) {
            this.supervisors.add(new Supervisor("Supervisor " + i));
        }

        this.directors = new ArrayList<Director>();
        for (int i = 0; i < numOfOperators; i++) {
            this.directors.add(new Director("Director " + i));
        }

        this.dispatcher = new Dispatcher();
        this.dispatcher.setAttendantsGroups(Arrays.<List<Attendant>>asList(
                operatorsToAttendants(this.operators),
                supervisorsToAttendants(this.supervisors),
                directorsToAttendants(this.directors)
        ));
        this.dispatcher.setVerbose(true);
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

    public void work(List<Call> calls) {
        this.dispatcher.dispatch(calls);
    }
}
