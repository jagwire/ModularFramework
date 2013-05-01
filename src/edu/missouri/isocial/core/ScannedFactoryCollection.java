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
public class ScannedFactoryCollection {

    private Map<Class, Map<Class, GenericFactory>> factories = new HashMap<Class, Map<Class, GenericFactory>>();;
    private final ScannedClassLoader loader;
    public ScannedFactoryCollection(ScannedClassLoader loader, Class<AbstractFactory> annotation) {
        this.loader = loader;
        
        scanForAnnotateds(annotation);

    }

    protected void scanForAnnotateds(Class clazz) {

        Set<String> names = loader.getClasses(clazz);

        for (String name : names) {
            try {
                //get class
                Class classFromName = Class.forName(name);

                AbstractFactory annotation = (AbstractFactory) classFromName.getAnnotation(AbstractFactory.class);
                if (annotation != null) {
                    //get interface from annotation
                    Class interfase = annotation.interfaceType();
                    //get distinguisher type from annotation
                    Class distinguisher = annotation.distinguisherType();
                    
                    //create object
                    Object obj = classFromName.newInstance();
                    
                    //create ClassMap 
                    Map implementations = new HashMap<Class, GenericFactory>();
                    //map distinguisher to object from class
                    implementations.put(distinguisher, obj);
                    
                    //map interface class to <distinguisher, object> map.
                    factories.put(interfase, implementations);
                }

            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ScannedFactoryCollection.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                continue;
            }

        }
    }
    
    public <T, D>GenericFactory<T, D> getFactoryWith(Class<T> interfase, Class<D> distinguisher) {
        if(factories.containsKey(interfase)) {
            return factories.get(interfase).get(distinguisher);
        } else {
            return null;
        }
    }
}
