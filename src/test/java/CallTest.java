import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class CallTest {

    public Call call;

    @Test
    public void shouldHaveMinTime(){
        Integer assignedMinTime = 5;
        Integer assignedMaxTime = 10;
        call = new Call(1,assignedMinTime,assignedMaxTime);
        Integer time = call.getMinTime();
        assertEquals(assignedMinTime,time);
    }

    @Test
    public void shouldHaveMaxTimeDoubleThanMinTime(){
        Integer assignedMinTime = 5;
        Integer assignedMaxTime = 10;
        call = new Call(1,assignedMinTime,assignedMaxTime);
        Integer time = call.getMaxTime();
        assertEquals(assignedMaxTime,time);
    }

    @Test
    public void shouldFreeOperatorWhenItEnd(){
        Integer assignedMinTime = 5;
        Integer assignedMaxTime = 10;
        call = new Call(1,assignedMinTime,assignedMaxTime);

        Attendant attendant = new Operator("Op");
        attendant.answer(call);

        call.end();
        assertFalse(attendant.isBusy());
    }

    @Test
    public void shouldFreeSupervisorWhenItEnd(){
        Integer assignedMinTime = 5;
        Integer assignedMaxTime = 10;
        call = new Call(1,assignedMinTime,assignedMaxTime);

        Attendant attendant = new Supervisor("Sup");
        attendant.answer(call);

        call.end();
        assertFalse(attendant.isBusy());
    }

    @Test
    public void shouldFreeDirectorWhenItEnd(){
        Integer assignedMinTime = 5;
        Integer assignedMaxTime = 10;
        call = new Call(1,assignedMinTime,assignedMaxTime);

        Attendant attendant = new Director("Dir");
        attendant.answer(call);

        call.end();
        assertFalse(attendant.isBusy());
    }

}