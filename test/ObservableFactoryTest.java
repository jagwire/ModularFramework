/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import edu.missouri.isocial.core.DefaultObservable;
import edu.missouri.isocial.core.ObservableFactory;
import edu.missouri.isocial.core.Observer;
import edu.missouri.isocial.core.simple.SimpleObservableRunnableFactory;
import java.lang.reflect.Type;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 *
 * @author Ryan
 */
public class ObservableFactoryTest {

    public ObservableFactoryTest() {
    }

    @Test
    public void hello() {        
        //we start off with the original object we have, and we want to be observable.
        Runnable runnable = new Runnable() {
            public void run() {
                System.out.println("ORIGINAL RUNNNABLE!");
            }
        };
        
        //we retrieve a factory that can decorate our object with one which updates other classes
        ObservableFactory<Runnable> factory = new SimpleObservableRunnableFactory();
        assertNotNull(factory);
        Observer observer = mock(Observer.class);

        //we use our factory to decorate our object.
        Runnable runner = factory.getObservable(runnable);
        ((DefaultObservable) runner).addObserver(observer);

        //act
        //we use our decorated object as we normally would normal
        runner.run();

        //assert
        //we confirm that the decoration works as expected
        verify(observer).update(runner);
    }
}