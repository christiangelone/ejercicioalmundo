import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CallCenterTest {

    public CallCenter callCenter;

    @Before
    public void initialize(){
        this.callCenter = new CallCenter();
    }

    @Test
    public void shouldHaveAtLeastIOneOperator(){
        Integer numberOfOperators = this.callCenter.getOperators().size();
        assertTrue(numberOfOperators >= 1);
    }
}