package ly;

import java.util.*;

public class TestLinkMap {
    public static void main(String[] args) {
        LinkedHashMap<String, String> linkedHashMap =
                new LinkedHashMap<String, String>(16, 0.75f, true);
        linkedHashMap.put("111", "111");
        linkedHashMap.put("222", "222");
        linkedHashMap.put("333", "333");
        linkedHashMap.put("444", "444");
//        loopLinkedHashMap(linkedHashMap);
//        linkedHashMap.get("111");
        loopLinkedHashMap(linkedHashMap);
//        linkedHashMap.put("222", "2222");
//        loopLinkedHashMap(linkedHashMap);

        HashMap<String,Object> map = new HashMap<>();





        map.put("123",123);
        map.put("123",456);
        System.out.println(map.get("123"));

    }

    public static void loopLinkedHashMap(LinkedHashMap<String, String> linkedHashMap) {
        Set<Map.Entry<String, String>> set = linkedHashMap.entrySet();
        Iterator<Map.Entry<String, String>> iterator = set.iterator();

        while (iterator.hasNext()) {
            if (iterator.next().getValue().equals("333")) {
                iterator.remove();
                System.out.print(iterator.next() + "\t");
            }
        }
        System.out.println(linkedHashMap.get("333"));
        System.out.println();
    }
}
