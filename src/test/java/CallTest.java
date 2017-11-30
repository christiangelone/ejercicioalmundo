import org.junit.Test;

import static org.junit.Assert.*;

public class CallTest {

    public Call call;

    @Test
    public void shouldHaveMinTime(){
        Integer assignedMinTime = 5;
        call = new Call(assignedMinTime);
        Integer time = call.getMinTime();
        assertEquals(assignedMinTime,time);
    }

}