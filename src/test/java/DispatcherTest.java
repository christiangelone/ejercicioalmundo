import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

public class DispatcherTest {

    public Dispatcher dispatcher;

    @Test
    public void shouldHaveAttendantsGroup(){
        List<List<Attendant>> attendantsGroups = new ArrayList<List<Attendant>>();
        this.dispatcher = new Dispatcher(attendantsGroups);
        List<List<Attendant>> groups = this.dispatcher.getAttendantsGroups();
        assertNotNull(groups);
    }

    @Test
    public void shouldHaveVerboseMode(){
        List<List<Attendant>> attendantsGroups = new ArrayList<List<Attendant>>();
        this.dispatcher = new Dispatcher(attendantsGroups);
        this.dispatcher.setVerbose(true);
        assertTrue(this.dispatcher.isVerbose());
    }

    @Test
    public void shouldDispatchTenConcurrentCalls(){
        List<List<Attendant>> attendantsGroups = new ArrayList<List<Attendant>>();
        List<Attendant> operators = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            operators.add(new Operator("Operator " + i ));
        }

        attendantsGroups.add(operators);
        this.dispatcher = new Dispatcher(attendantsGroups);

        List<Call> calls = new ArrayList<Call>();
        for (int i = 0; i < 10; i++) {
            calls.add(new Call(5,10));
        }

        assertTrue(this.dispatcher.dispatch(calls));
    }

    @Test
    public void shouldNotDispatchCallIfThereAreNoAttendances(){
        List<List<Attendant>> attendantsGroups = new ArrayList<List<Attendant>>();
        this.dispatcher = new Dispatcher(attendantsGroups);

        List<Call> calls = new ArrayList<Call>();
        for (int i = 0; i < 10; i++) {
            calls.add(new Call(5,10));
        }

        assertFalse(this.dispatcher.dispatch(calls));
    }

}