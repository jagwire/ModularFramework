/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import edu.missouri.isocial.core.simple.SimpleSingleton;
import edu.missouri.isocial.core.simple.SimpleIFO;
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
public class InjectTest {
    
    public InjectTest() {
    }

     @Test
     public void hello() {
         //arrange
         SimpleIFO ifo = new SimpleIFO();
         
         //act
         SimpleSingleton s = ifo.getS();
         
         //assert
         assertNotNull(s);
     
     }
}