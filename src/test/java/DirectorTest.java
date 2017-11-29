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

}