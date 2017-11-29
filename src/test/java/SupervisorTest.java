import org.junit.Test;

import static org.junit.Assert.*;

public class SupervisorTest {

    public Employee supervisor;

    @Test
    public void shouldHaveTypeSupervisor(){
        supervisor = new Supervisor("default");
        String type = supervisor.getType();
        assertEquals(Employee.TYPE_SUPERVISOR,type);
    }

}