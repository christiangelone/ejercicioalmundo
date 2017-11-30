import org.junit.Test;

import static org.junit.Assert.*;

public class CallTest {

    public Call call;

    @Test
    public void shouldHaveMinTime(){
        Integer assignedMinTime = 5;
        Integer assignedMaxTime = 10;
        call = new Call(assignedMinTime,assignedMaxTime);
        Integer time = call.getMinTime();
        assertEquals(assignedMinTime,time);
    }

    @Test
    public void shouldHaveMaxTimeDoubleThanMinTime(){
        Integer assignedMinTime = 5;
        Integer assignedMaxTime = 10;
        call = new Call(assignedMinTime,assignedMaxTime);
        Integer time = call.getMaxTime();
        assertEquals(assignedMaxTime,time);
    }

}