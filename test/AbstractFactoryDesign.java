/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import edu.missouri.isocial.core.Framework;
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
public class AbstractFactoryDesign {

    public AbstractFactoryDesign() {
        
        //we have our factory for making different kinds of factories;
        AbstractFactory af = new AbstractFactory();
        
        //make a factory for creating Runnables from our abstract factory.
        //this says we want to make a factory that in turn, produces new Runnable objects.
        // (abstract factory) -> Factory<Runnable>
        GenericFactory<Grrr, String> grrrFactory = af.makeFactory(Grrr.class, String.class);
       Grrr grrr = grrrFactory.makeObject("Grrreen");
        //now use our runnable Factory to create a runnable.
       
       grrr.getClass();
    }
 
    
    interface GenericFactory<T, D> {

        public T makeObject(D distinguisher);
        
        public T makeDefaultObject();
    }
 
    class AbstractFactory {

        public <T,D>GenericFactory<T, D> makeFactory(Class<T> clazzT, Class<D> clazzD) {
            return new GenericFactory<T, D>() {

                @Override
                public T makeObject(D distinguisher) {
                    distinguisher.getClass();
                    
                    return  (T) new Object();
                }

                @Override
                public T makeDefaultObject() {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
                
            };
        }        
    }
    
    interface IBlah {
        
    }
    
    interface Grrr {
        
    }
    
    class Blah implements IBlah {
        
    }
    
    class Meh implements IBlah {
        
    }
    
    class Bleh implements IBlah {
        
    }
    
    class Grrrowl implements Grrr {
        
    }
    
    class Grrreat implements Grrr {
        
    }
    
    class Grrreen implements Grrr {
        
    }
    
    class BlahFactory implements GenericFactory<IBlah, String> {

        @Override
        public IBlah makeObject(String distinguisher) {
            if(distinguisher.equals("Blah")) {
                return new Blah();
            }
            
            if(distinguisher.equals("Meh")) {
                return new Meh();
            }
            
            if(distinguisher.equals("Bleh")) {
                return new Bleh();
            }
            return null;
        }        

        @Override
        public IBlah makeDefaultObject() {
            return new Blah();
        }
    }
    
    class GrrrFactory implements GenericFactory<Grrr, String> {

        @Override
        public Grrr makeObject(String distinguisher) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public Grrr makeDefaultObject() {
            return new Grrrowl();
        }
        
    }
}