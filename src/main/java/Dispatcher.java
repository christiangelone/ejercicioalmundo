import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

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

    private Boolean AllCallsAnswered(List<Call> calls){
        return calls.stream()
                .map(call -> call.isAnswered())
                .reduce((answer1,answer2) -> answer1 && answer2)
                .orElse(true);
    }

    private synchronized List<Attendant> findFirstFreeAttendantsGroup(){
        for(List<Attendant> attendants: this.attendantsGroups){
            if(!areAllAttendantsBusy(attendants))
                return attendants;
        }
        return null;
    }

    private synchronized Attendant findAnyFreeAttendant(List<Attendant> attendants){
        return attendants
                .stream()
                .filter(attendant -> !attendant.isBusy())
                .findFirst()
                .orElse(null);
    }

    private Boolean noAttendants() {
        return attendantsGroups == null || attendantsGroups.isEmpty();
    }

    private synchronized void dispatchCall(Call call){
        List<Attendant> attendants = findFirstFreeAttendantsGroup();
        if(attendants != null){
            if(verbose) System.out.println("Attendants group is free!");
            Attendant attendant = findAnyFreeAttendant(attendants);
            if(verbose) System.out.println("[Attendant " + attendant.getName() + "] will answer the call with id: " + call.getId() + "...");
            attendant.answer(call);
        }
    }

    private void dispatchThreadCalls(final List<Call> calls){
        List<Thread> thread = new LinkedList<>();
        for (int i = 0; i < calls.size(); i++) {
            final Call call = calls.get(i);
            thread.add(new Thread(() -> {
                dispatchCall(call);
            }));
        }
        for(Thread t: thread) t.start();
        for(Thread t: thread) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public Dispatcher() {
        this.numberOfCallsdDispatched = 0;
        this.verbose = false;
    }

    public List<List<Attendant>> getAttendantsGroups() {
        return this.attendantsGroups;
    }


    public Boolean dispatch(List<Call> calls) {
        if(verbose) System.out.println("Dispatching calls...");
        if(noAttendants()){
           return false;
        }else{
            while(!AllCallsAnswered(calls)) {
                List<Call> filteredCalls = calls
                        .stream()
                        .filter(c -> !c.isAnswered())
                        .collect(Collectors.toList());

                //no concurrent works!
                //filteredCalls.stream().forEach(c -> dispatchCall(c));

                //concurrent works!
                dispatchThreadCalls(filteredCalls);
            }
            return true;
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
