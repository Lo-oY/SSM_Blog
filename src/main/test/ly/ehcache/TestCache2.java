package ly.ehcache;


import net.sf.ehcache.*;
import net.sf.ehcache.event.CacheEventListener;
import net.sf.ehcache.management.ManagementService;

import javax.management.MBeanServer;
import java.lang.management.ManagementFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Supplier;

/**
 * Created by cilu on 2018/1/24.
 */
public class TestCache2 {

    public static void main(String args[]) {
        Supplier<String> supplier = () -> "hello world";

        CacheManager cm = CacheManager.getInstance();
//        CacheManager cm = CacheManager.create("./ehcache.xml");
        Cache cache = cm.getCache("HelloWorldCache");
        Cache cache2 = cm.getCache("HelloWorldCache2");
        cache.getCacheEventNotificationService().registerListener(
                new CacheEventListener() {
                    @Override
                    public void notifyElementRemoved(Ehcache cache, Element element) throws CacheException {
                        System.out.println("Remove" + element);
                    }

                    @Override
                    public void notifyElementPut(Ehcache cache, Element element) throws CacheException {
//                        System.out.println("Put" + element);

                    }

                    @Override
                    public void notifyElementUpdated(Ehcache cache, Element element) throws CacheException {

                    }

                    @Override
                    public void notifyElementExpired(Ehcache cache, Element element) {
//                        System.out.println("Expired" + element);
                        if (element.getHitCount() > 2)
                            System.out.println("Expired" + element);

                    }

                    @Override
                    public void notifyElementEvicted(Ehcache cache, Element element) {
//                        System.out.println("Evicted" + element);

//                        if (element.getHitCount() > 2) {
//                            System.out.println("Evicted" + element);
//                            System.out.println(System.currentTimeMillis());
//                        }
                        if (((People)element.getObjectValue()).getId() == 0) {
                            System.out.println("Evicted" + element);
                            System.out.println(System.currentTimeMillis());
                        }

                    }

                    @Override
                    public void notifyRemoveAll(Ehcache cache) {

                    }

                    @Override
                    public void dispose() {

                    }

                    @Override
                    public Object clone() throws CloneNotSupportedException {
                        return super.clone();
                    }
                }
        );

        MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
        ManagementService.registerMBeans(cm, mBeanServer, false, false, false, true);

        System.out.println(cache);
        System.out.println(cache2);
        for (int i = 0; i < 20000; i++) {
            People people = new People();
            people.setId(i);
            people.setName("people" + i);
            people.setPassword("password" + i);
            cache.put(new Element(i, people));
            if (i < 10) {
                System.out.println(cache.get(0) + "---------" + i);
                System.out.println(cache.getQuiet(1) + "-------jk--" + i);

            }
        }

        List keys = cache.getKeys();
        List<People> result = new ArrayList<People>();
        for (Object key : keys) {
            Element element = cache.get(key);
            if (element != null) {
                result.add((People) element.getObjectValue());
            }
        }
        System.out.println(cache.get(1));
        result.forEach(System.out::println);
        new Scanner(System.in).next();

        System.out.println(cache.getStatistics().getCacheHits());
        System.out.println(cache.getStatistics().getCacheMisses());
    }
}
