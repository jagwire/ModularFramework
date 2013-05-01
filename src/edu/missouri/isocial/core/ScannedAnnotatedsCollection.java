/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.missouri.isocial.core;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ryan
 */
public class ScannedAnnotatedsCollection implements AnnotatedsCollection<Class, Object> {

    private Map<Class, Object> annotateds;
    private final ScannedClassLoader loader;
    
    public ScannedAnnotatedsCollection(ScannedClassLoader loader, Class annotation) {
        this.loader = loader;
        
        annotateds = new HashMap<Class, Object>();
        scanForAnnotateds(annotation);
    }
    
    public ScannedClassLoader getLoader() {
        return this.loader;
    }
    protected void scanForAnnotateds(Class clazz) {
        Set<String> names = loader.getClasses(clazz);
        
        for(String name: names) {
            Object o;
            try {
                o = instantiateClass(name);
                annotateds.put(o.getClass(), o);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ScannedAnnotatedsCollection.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                Logger.getLogger(ScannedAnnotatedsCollection.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(ScannedAnnotatedsCollection.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                continue;
            }            
        }
    }

    @Override
    public Object get(Class key) {
        return annotateds.get(key);
    }

    private Object instantiateClass(String name) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        return Class.forName(name).newInstance();
    
    }

    
}
