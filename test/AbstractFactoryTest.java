/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import edu.missouri.isocial.core.Framework;
import edu.missouri.isocial.core.GenericFactory;
import edu.missouri.isocial.core.ScannedFactoryCollection;
import edu.missouri.isocial.core.simple.SimpleHisOrHerRunnable;
import edu.missouri.isocial.core.simple.SimpleMyRunnable;
import edu.missouri.isocial.core.simple.SimpleYourRunnable;
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
public class AbstractFactoryTest {
    
    public AbstractFactoryTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void hello() {
         ScannedFactoryCollection factories = Framework.INSTANCE.getFactories();
         
         assertNotNull(factories);
         GenericFactory<Runnable, String> factory = factories.getFactoryWith(Runnable.class, String.class);
         assertNotNull(factory);
         
         Runnable r = factory.getNew("My");
         assertTrue(r instanceof SimpleMyRunnable);
         
         r = factory.getNew("Your");
         assertTrue(r instanceof SimpleYourRunnable);
         
         r = factory.getNew("His");
         assertTrue(r instanceof SimpleHisOrHerRunnable);
         
         Runnable r2 = factory.getNew("Hers");
         assertTrue(r2 instanceof SimpleHisOrHerRunnable);
         assertFalse(r2.equals(r));
     
     }
}