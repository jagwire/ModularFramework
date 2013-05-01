package edu.missouri.isocial.core.simple;

import edu.missouri.isocial.core.Injectable;
import edu.missouri.isocial.core.InjectionFriendlyObject;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ryan
 */
@Injectable
public class SimpleSingleton extends InjectionFriendlyObject {
    public SimpleSingleton() {
        System.out.println("INSTANTIATED!");
    }
    
    public void print() {
        System.out.println("single!");
    }
}
