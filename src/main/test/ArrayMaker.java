import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by cilu on 2017/11/20.
 */
public class ArrayMaker<T> {

    private Class<T> kind;

    public ArrayMaker(Class<T> kind) {
        this.kind = kind;
    }

    T[] create(int size) {
//        Array.newInstance(int.class,10);
        return (T[]) Array.newInstance(kind, size);
    }

    public static void main(String[] args) {

        List<String> list = new ArrayList<String>();
//        list.add(1);

        ArrayMaker<String> stringMaker = new ArrayMaker<String>(String.class);
        String[] stringArray = stringMaker.create(9);
        System.out.println(Arrays.toString(stringArray));

    }
}
