import java.util.List;

public class Dispatcher {


    private final List<List<Attendants>> attendantsGroups;

    public Dispatcher(List<List<Attendants>> attendantsGroups) {
        this.attendantsGroups = attendantsGroups;
    }

    public List<List<Attendants>> getAttendantsGroups() {
        return this.attendantsGroups;
    }
}
