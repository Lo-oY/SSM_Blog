package ly.ehcache;

import com.ly.EntityCache;

import java.util.List;

/**
 * Created by cilu on 2018/1/23.
 */
public class TestCache {

    public static void main(String args[]){

        EntityCache<People> entityCache = new EntityCache<>(People.class);
        for(int i = 0 ; i < 100000 ; i++){
            People people = new People();
            people.setId(i);
            people.setName("people" + i);
            people.setPassword("password" + i);
            entityCache.set(people);
            entityCache.get(1);
        }
        System.out.println(entityCache.get(1));
        List<People> list = entityCache.all();
        System.out.println(list.size());
        for(People people : list){
            if (people.id().equals(1))
                System.out.println("----------------------------------");
            System.out.println(people.id());
        }
    }
}
