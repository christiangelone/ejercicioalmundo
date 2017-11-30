import java.util.ArrayList;
import java.util.List;

public class App {

    public static List<Call> CallGenerator(Integer numOfCalls){
        List<Call> calls = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            calls.add(new Call(i,5,10));
        }
        return calls;
    }

    public static void main(String[] args) {
        CallCenter callCenter = new CallCenter("AlMundo",4,3,3);

        List<Call> calls = CallGenerator(25);

        callCenter.work(calls);
        System.out.println("El callcenter a terminado de responder las llamadas.");
    }
}
