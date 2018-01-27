import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by cilu on 2017/12/5.
 */
public class TestUUID {

    private static final Map<String,String> map = new ConcurrentHashMap<>();
    public static void main(String args[]){

        for(int i = 0 ; i< 10 ; i++){
            System.out.println(UUID.randomUUID().toString());
        }

        map.put("123","123");
        map.computeIfAbsent("123",(key)->{
            System.out.println(key);
            return "test";
        });
        System.out.println(map.get("123"));
    }
}
