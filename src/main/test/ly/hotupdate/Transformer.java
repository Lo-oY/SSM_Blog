package ly.hotupdate;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

/**
 * Created by cilu on 2018/1/26.
 */
public class Transformer implements ClassFileTransformer {
    @Override
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
        if (!className.equals("ly/hotupdate/TransClass")) {
            System.out.println("!equal");
            System.out.println(className);
            return null;
        }
        return getBytesFromFile(classNumberReturns2);
//        System.out.println("transform");
//        return null;
    }

    public static final String classNumberReturns2 = "D:\\Work\\Java\\SSM_Blog\\target\\test-classes\\ly\\hotupdate\\TransClass.class";

    public static byte[] getBytesFromFile(String fileName) {
        try {
            // precondition
            System.out.println(fileName);
            File file = new File(fileName);
            InputStream is = new FileInputStream(file);
            long length = file.length();
            byte[] bytes = new byte[(int) length];

            // Read in the bytes
            int offset = 0;
            int numRead = 0;
            while (offset <bytes.length
                    && (numRead = is.read(bytes, offset, bytes.length - offset)) >= 0) {
                offset += numRead;
            }

            if (offset < bytes.length) {
                throw new IOException("Could not completely read file "
                        + file.getName());
            }
            is.close();
            System.out.println(bytes);
            return bytes;
        } catch (Exception e) {
            System.out.println("error occurs in _ClassTransformer!"
                    + e.getClass().getName());
            return null;
        }
    }
}
