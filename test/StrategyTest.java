/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import edu.missouri.isocial.core.AnnotatedsCollection;
import edu.missouri.isocial.core.Framework;
import edu.missouri.isocial.core.ScannedAnnotatedsCollection;
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
public class StrategyTest {
    
     @Test
     public void hello() {
         AnnotatedsCollection strategies = Framework.INSTANCE.getStrategies();
         assertNotNull(strategies);
     
     }
}