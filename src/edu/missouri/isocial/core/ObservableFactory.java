/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.missouri.isocial.core;

/**
 *
 * @author Ryan
 */
public interface ObservableFactory<I> {
    public I getObservable(I implementation);
}
