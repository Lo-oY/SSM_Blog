/**
 * Created by cilu on 2017/12/4.
 */
public class StaticDispatch {
    
    private static  int NUM = 123;

    static abstract class Human{

    }

    static class Man extends Human{

    }

    static class Woman extends  Human{

    }


    public void sayHello(Human guy){
        System.out.println("hello,guy!");
    }

    public void sayHello(Man guy){
        System.out.println("hello,gentleman");
    }

    public void sayHello(Woman guy){
        System.out.println("Hello,lady!");
    }


    public static void main(String args[]){
        Human man = new Man();
        Human woman = new Woman();
        StaticDispatch sr = new StaticDispatch();
        sr.sayHello(man);
        sr.sayHello(woman);
        int i = NUM;
        System.out.println(i);
        int j = 123;
        System.out.println(j);
        int k = i;
        System.out.println(k);

        String a = "123";
        System.out.println(a);
        String b = "123";
        System.out.println(b);
        String c = "123";
        System.out.println(c);

        float l =  1.6f;
        int m = (int) l;
        System.out.println(l);
    }
}
