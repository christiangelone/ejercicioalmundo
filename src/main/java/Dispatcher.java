import java.util.List;

public class Dispatcher {


    private final List<List<Attendant>> attendantsGroups;

    public Dispatcher(List<List<Attendant>> attendantsGroups) {
        this.attendantsGroups = attendantsGroups;
    }

    public List<List<Attendant>> getAttendantsGroups() {
        return this.attendantsGroups;
    }
}
