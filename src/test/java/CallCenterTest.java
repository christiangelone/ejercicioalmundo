import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CallCenterTest {

    public String name = "CallCenter AlMundo";
    public CallCenter callCenter;

    @Before
    public void initialize(){
        this.callCenter = new CallCenter(this.name);
    }

    @Test
    public void shouldHaveName(){
        String name = this.callCenter.getName();
        assertEquals(this.name,name);
    }

    @Test
    public void shouldHaveAtLeastIOneOperator(){
        Integer numberOfOperators = this.callCenter.getOperators().size();
        assertTrue(numberOfOperators >= 1);
    }

    @Test
    public void shouldHaveAtLeastIOneSupervisor(){
        Integer numberOfSupervisors = this.callCenter.getSupervisors().size();
        assertTrue(numberOfSupervisors >= 1);
    }

    @Test
    public void shouldHaveAtLeastIOneDirector(){
        Integer numberOfDirectors = this.callCenter.getDirectors().size();
        assertTrue(numberOfDirectors >= 1);
    }

    @Test
    public void shouldHaveDispatcher(){
        assertNotNull(callCenter.getDispatcher());
    }

    @Test
    public void shouldChangeDispatcher(){
        Dispatcher otherDispatcher = new Dispatcher();
        callCenter.setDispatcher(otherDispatcher);
        assertEquals(otherDispatcher,callCenter.getDispatcher());
    }
}