package ly.convert;

import java.nio.ByteBuffer;

public class Test {

    public static void main(String args[]){

        int i = Integer.MIN_VALUE;
        long l = i;
        ByteBuffer byteBuffer = ByteBuffer.allocate(100);
        byteBuffer.putInt(-10);
        System.out.println(byteBuffer.getInt(0) & 0xffffffffL);
    }
}
