/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.missouri.isocial.core;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ryan
 */
public abstract class InjectionFriendlyObject {

    
    private Map<String, Object> properties;
    
    public InjectionFriendlyObject() {
        
        properties = new HashMap<String, Object>();
        
        //get all fields for this class.
        Field[] fields = getClass().getDeclaredFields();

        for (Field field : fields) {
            if (field.getAnnotation(Inject.class) != null) {
                try {
//                    field.set(this, injectables().get(field.getType()));



                    String methodName = getMethodNameFromField(field);
                    System.out.println("INVOKING: " + methodName);
                    getClass().getMethod(methodName, field.getType())
                            .invoke(this, injectables().get(field.getType()));
                } catch (IllegalArgumentException ex) {
                    Logger.getLogger(InjectionFriendlyObject.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(InjectionFriendlyObject.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception e) {
                }
            }
        }

//        factories().getFactoryWith(Runnable.class, String.class).getNew("meh");
    }

    private String getMethodNameFromField(Field field) {

        String fieldName = field.getName();
        String firstLetter = fieldName.toUpperCase().substring(0, 1);
        if (fieldName.length() == 1) {
            
            String substring = "";
            return "set" + firstLetter + substring;
        } else {
            String substring = fieldName.substring(1, fieldName.length());
            return "set"+firstLetter+substring;
        }


    }

    private AnnotatedsCollection<Class, Object> injectables() {
        return Framework.INSTANCE.getInjectables();
    }

    protected <I, D> I getNew(Class<I> interfase, Class<D> dist, D value) {
        GenericFactory<I, D> f = factories().getFactoryWith(interfase, dist);

        return f.getNew(value);
    }

    protected ScannedFactoryCollection factories() {
        return Framework.INSTANCE.getFactories();
    }

    protected AnnotatedsCollection<Class, Object> strategies() {
        return Framework.INSTANCE.getStrategies();
    }

    public boolean isA(Class object) {
        return getClass().isAssignableFrom(object);
    }

    public boolean isAn(Class object) {
        return isA(object);
    }

    public boolean is(Object obj) {
        return this.equals(obj);
    }

    public void log(String message) {
        Logger.getLogger(getClass().getName()).warning(message);
    }
    
    public Object getPropertyByName(String key) {
        
        return properties.get(key);
    }
    
    public void setProperty(String name, Object value) {
        properties.put(name, value);
    }
}
