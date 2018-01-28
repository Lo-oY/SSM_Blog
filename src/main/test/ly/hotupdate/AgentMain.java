package ly.hotupdate;

/**
 * Created by cilu on 2018/1/26.
 */
import java.lang.instrument.Instrumentation;
import java.lang.instrument.UnmodifiableClassException;

public class AgentMain {
    public static void agentmain(String agentArgs, Instrumentation inst) {
        System.out.println("loadagent after main run.args=" + agentArgs);
        Transformer transformer = new Transformer();
        inst.addTransformer(transformer, true);
        try {
            inst.retransformClasses(TransClass.class);
        } catch (UnmodifiableClassException e) {
            System.out.println(e);
        }

//        getBytesFromFile("D:\\Work\\Java\\SSM_Blog\\target\\test-classes\\ly\\hotupdate\\TransClass.class");
        System.out.println("Agent Main Done");
    }

    public static void main(String args[]){
        System.out.println(TransClass.class.getName());
    }
}