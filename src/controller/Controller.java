/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import app.MyApplication;
import javax.swing.JFrame;

/**
 *
 * @author MuhammadAlif
 */
public abstract class Controller {
    public JFrame view;
    protected MyApplication context;       

    protected Controller(MyApplication context, JFrame view) {
        this.context = context;
        this.view = view;
    }   
    
    public abstract void start();
    public abstract void stop();
}
