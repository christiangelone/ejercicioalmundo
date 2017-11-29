import java.util.ArrayList;
import java.util.List;

public class CallCenter {

    public CallCenter(){
        this.operators = new ArrayList<Operator>();
        this.operators.add(new Operator());
    }

    private List<Operator> operators;

    public List<Operator> getOperators() {
        return operators;
    }
}
