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

    @Test
    public void shouldHaveName(){
        final String assignedName = "default";
        operator = new Operator(assignedName);
        String name = operator.getName();
        assertEquals(assignedName,name);
    }

    @Test
    public void shouldAnswerCallIfNotBusy(){
        operator = new Operator("default");
        Call call = new Call(1,5,10);
        assertFalse(operator.isBusy());
        operator.answer(call);
        assertTrue(call.isAnswered());
    }

    @Test
    public void shouldNotAnswerCallIfBusy(){
        operator = new Operator("default");
        Call callA = new Call(1,5,10);
        operator.answer(callA);

        Call callB = new Call(1,5,10);
        operator.answer(callB);

        assertTrue(operator.isBusy());
        assertFalse(callB.isAnswered());
    }
}