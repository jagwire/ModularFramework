/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.missouri.isocial.core.simple;

import edu.missouri.isocial.core.AbstractFactory;
import edu.missouri.isocial.core.GenericFactory;

/**
 *
 * @author Ryan
 */
@AbstractFactory(interfaceType=Runnable.class, distinguisherType=String.class)
public class SimpleRunnableFactory implements GenericFactory<Runnable, String> {

    public SimpleRunnableFactory() {
        
        int x = 0;
    }
    
    @Override
    public Runnable getNew(String distinguisher) {
        if(distinguisher.equals("My")) {
            return new SimpleMyRunnable();
        }
        
        if(distinguisher.equals("Your")) {
            return new SimpleYourRunnable();
        }
        
        if(distinguisher.equals("His") ||
                distinguisher.equals("Hers")) {
            return new SimpleHisOrHerRunnable();
        }
        return null;
    }

    
}
