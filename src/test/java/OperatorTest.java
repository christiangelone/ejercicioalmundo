import org.junit.Test;

import static org.junit.Assert.*;

public class OperatorTest {

    public Employee operator;

    @Test
    public void shouldHaveTypeOperator(){
        operator = new Operator("default");
        String type = operator.getType();
        assertEquals(Employee.TYPE_OPERATOR,type);
    }

}