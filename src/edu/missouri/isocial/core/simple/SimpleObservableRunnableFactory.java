/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.missouri.isocial.core.simple;

import edu.missouri.isocial.core.DefaultObservable;
import edu.missouri.isocial.core.ObservableFactory;
import edu.missouri.isocial.core.simple.SimpleObservableRunnableFactory.ObservableRunnable;

/**
 *
 * @author Ryan
 */
public class SimpleObservableRunnableFactory implements ObservableFactory<Runnable> {

    @Override
    public Runnable getObservable(Runnable implementation) {
        return new ObservableRunnable(implementation);
    }    

    class ObservableRunnable extends DefaultObservable<Runnable> implements Runnable {
        private final Runnable runnable;

        public ObservableRunnable(Runnable runnable) {
            this.runnable = runnable;
        }
        
        @Override
        public void run() {
            runnable.run();
            this.updateObservers();
        }        
    }
}
