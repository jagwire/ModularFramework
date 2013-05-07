/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.missouri.isocial.core;

/**
 *
 * @author Ryan
 */
public interface Observer<I> {
    public void update(I observable);
}
