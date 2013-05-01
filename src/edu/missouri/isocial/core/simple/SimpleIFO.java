package edu.missouri.isocial.core.simple;


import edu.missouri.isocial.core.Inject;
import edu.missouri.isocial.core.InjectionFriendlyObject;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ryan
 */
public class SimpleIFO extends InjectionFriendlyObject {
    
    @Inject
    private SimpleSingleton single;
    
    public SimpleIFO() {
        
    }
    
    public SimpleSingleton getS() {
        return single;
    }
        
    //this is needed only by IFO to get 
    public void setSingle(SimpleSingleton s) {
        this.single = s;
    }
    
}
