/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.missouri.isocial.core;

/**
 *
 * @author Ryan
 */
public enum Framework {
    INSTANCE;
    
    private AnnotatedsCollection injectables;
    private ScannedClassLoader loader = ScannedClassLoader.INSTANCE();
    private ScannedFactoryCollection factories;
    private AnnotatedsCollection strategies;
    private Framework() {
        injectables = new ScannedAnnotatedsCollection(loader, Injectable.class);
        factories = new ScannedFactoryCollection(loader, AbstractFactory.class);
        strategies = new ScannedAnnotatedsCollection(loader, Strategy.class);        
    }
    
    
    public AnnotatedsCollection getInjectables() {
        return injectables;
    }
    
    public ScannedFactoryCollection getFactories() {
        return factories;
    }
        
    public AnnotatedsCollection getStrategies() {
        return strategies;
    }
}
