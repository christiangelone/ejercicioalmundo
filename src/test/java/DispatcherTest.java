import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class DispatcherTest {

    public Dispatcher dispatcher;

    @Before
    public void initialize(){
        List<List<Attendant>> attendantsGroups = new ArrayList<List<Attendant>>();
        this.dispatcher = new Dispatcher(attendantsGroups);
    }

    @Test
    public void shouldHaveAttendantsGroup(){
        List<List<Attendant>> groups = this.dispatcher.getAttendantsGroups();
        assertNotNull(groups);
    }

}