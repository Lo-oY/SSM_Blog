/**
 * Created by cilu on 2017/11/30.
 */
public class TestGC {

    public static void main(String args[]){
        byte[] placeholder = new byte[64 * 1024 * 1024];

//        int a = 0;
        placeholder = null;
        System.gc();
    }
}
