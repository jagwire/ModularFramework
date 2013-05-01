/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import edu.missouri.isocial.core.CompositionRoot;
import edu.missouri.isocial.core.Main;
import edu.missouri.isocial.core.ScannedClassLoader;
import java.util.Iterator;
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
public class MainClassTest {
    
    public MainClassTest() {
    }
    
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void hello() {
         //arrange
         Iterator<Main> i = ScannedClassLoader.INSTANCE().getInstances(CompositionRoot.class, Main.class);
         
         //act
         Main m = i.next();
         
         //assert
         assertTrue(!i.hasNext());
     }

}