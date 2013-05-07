/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.missouri.isocial.core;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Ryan
 */
public class DefaultObservable<T> extends InjectionFriendlyObject implements Observable {

    private Set<Observer> observers;

    public DefaultObservable() {
        observers = new HashSet<Observer>();
    }

    @Override
    public void addObserver(Observer observer) {
        this.observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        this.observers.remove(observer);
    }

    @Override
    public void updateObservers() {
        for (Observer observer : observers) {
            observer.update((T) this);
        }
    }

}
