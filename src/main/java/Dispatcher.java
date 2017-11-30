import java.util.List;

public class Dispatcher {


    private List<List<Attendant>> attendantsGroups;

    private Boolean verbose;
    private Integer numberOfCallsdDispatched;

    private Boolean areAllAttendantsBusy(List<Attendant> attendants){
        return attendants.stream()
                .map(a -> a.isBusy())
                .reduce((busy1,busy2) -> busy1 && busy2)
                .orElse(true);
    }

    private Boolean callsAnswered(List<Call> calls){
        return calls.stream()
                .map(call -> call.isAswered())
                .reduce((answer1,answer2) -> answer1 && answer2)
                .orElse(true);
    }

    private List<Attendant> findFirstFreeAttendantsGroup(){
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

    private Boolean noAttendants() {
        return attendantsGroups == null || attendantsGroups.isEmpty();
    }

    private void dispatchCall(Call call){
        List<Attendant> attendants = findFirstFreeAttendantsGroup();
        if(attendants != null){
            Attendant attendant = findAnyFreeAttendant(attendants);
            attendant.answer(call);
            numberOfCallsdDispatched++;
        }
    }

    public Dispatcher() {
        this.numberOfCallsdDispatched = 0;
        this.verbose = false;
    }

    public List<List<Attendant>> getAttendantsGroups() {
        return this.attendantsGroups;
    }


    public Integer dispatch(List<Call> calls) {
        if(verbose) System.out.println("Dispatching calls...");
        if(noAttendants()){
           return 0;
        }else{
            while(!callsAnswered(calls)){
                calls.stream().forEach(call -> dispatchCall(call));
            }
            return numberOfCallsdDispatched;
        }
    }

    public void setAttendantsGroups(List<List<Attendant>> attendantsGroups) {
        this.attendantsGroups = attendantsGroups;
    }

    public void setVerbose(Boolean verbose) {
        this.verbose = verbose;
    }

    public Boolean isVerbose() {
        return verbose;
    }
}
