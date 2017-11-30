import java.util.List;

public class Dispatcher {


    private final List<List<Attendant>> attendantsGroups;

    private boolean verbose;

    public Dispatcher(List<List<Attendant>> attendantsGroups) {

        this.attendantsGroups = attendantsGroups;
        this.verbose = false;
    }

    public List<List<Attendant>> getAttendantsGroups() {
        return this.attendantsGroups;
    }

    private boolean areAllAttendantsBusy(List<Attendant> attendants){
        return attendants.stream()
                .map(a -> a.isBusy())
                .reduce((busy1,busy2) -> busy1 && busy2)
                .orElse(true);
    }

    private boolean callsAnswered(List<Call> calls){
        return calls.stream()
                .map(call -> call.isAswered())
                .reduce((answer1,answer2) -> answer1 && answer2)
                .orElse(true);
    }

    private List<Attendant> findFirstFreeAttendants(){
        for(List<Attendant> attendants: this.attendantsGroups){
            if(!areAllAttendantsBusy(attendants))
                return attendants;
        }
        return null;
    }

    private Attendant findAnyFreeAttendant(List<Attendant> attendants){
        return attendants
                .stream()
                .filter(attendant -> !attendant.isBusy())
                .findFirst()
                .orElse(null);
    }

    private void dispatchCall(Call call){
        List<Attendant> attendants = findFirstFreeAttendants();
        if(attendants != null){
            Attendant attendant = findAnyFreeAttendant(attendants);
            attendant.answer(call);
        }
    }

    public boolean dispatch(List<Call> calls) {
        if(verbose) System.out.println("Dispatching calls...");
        while(!callsAnswered(calls)){
            calls.stream().forEach(call -> dispatchCall(call));
        }
        return true;
    }

    public void setVerbose(boolean verbose) {
        this.verbose = verbose;
    }
}
