/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import edu.missouri.isocial.core.Injectable;
import edu.missouri.isocial.core.ScannedClassLoader;
import java.util.Set;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ryan
 */
public class InjectableTest {
    
    public InjectableTest() {
    }
    

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void hello() {
         //arrange
         Set<String> name = ScannedClassLoader.INSTANCE().getClasses(Injectable.class);
         assertNotNull(name);     
     }
}