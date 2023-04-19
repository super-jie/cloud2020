import org.junit.Test;

import java.util.PrimitiveIterator;
import java.util.concurrent.atomic.AtomicInteger;

public class JavaTest {

    @Test
    public void t(){
        AtomicInteger atomicInteger = new AtomicInteger(0);
        System.out.println(atomicInteger.compareAndSet(0,2));
        System.out.println("atomicInteger="+atomicInteger);
    }
}
