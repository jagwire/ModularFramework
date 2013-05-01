/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import edu.missouri.isocial.core.simple.SimpleIFO;
import java.util.Observable;
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
public class IFOTest {
    
    public IFOTest() {
    }

     @Test
     public void hello() {
         SimpleIFO ifo = new SimpleIFO();
         
         //check injected value
         assertNotNull(ifo.getS());
         
         //check helper alias for "instance of"
         assertFalse(ifo.isA(Runnable.class));
         
         //check helper alias for "instance of"
         assertFalse(ifo.isAn(Observable.class));
         
         //check helper alias for "equals"
         assertFalse(ifo.is(new Object()));
         
         ifo.log("String!");
         
         //check properties
         int health = 100;
         ifo.setProperty("Health", health);         
         assertEquals(ifo.getPropertyByName("Health"), health);
         
     }
}