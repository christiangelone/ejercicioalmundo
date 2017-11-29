import org.junit.Test;

import static org.junit.Assert.*;

public class DirectorTest {

    public Employee director;

    @Test
    public void shouldHaveTypeDirector(){
        director = new Director("default");
        String type = director.getType();
        assertEquals(Employee.TYPE_DIRECTOR,type);
    }

    @Test
    public void shouldHaveName(){
        final String assignedName = "default";
        director = new Operator(assignedName);
        String name = director.getName();
        assertEquals(assignedName,name);
    }

}