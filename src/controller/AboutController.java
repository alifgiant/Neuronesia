/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import app.MyApplication;
import view.AboutView;


/**
 *
 * @author MuhammadAlif
 */
public class AboutController extends Controller{
    /*private static AboutController controller;
    
    public static AboutController newInstance(MyApplication context){
        if (controller == null) {
            controller = new AboutController(context);
        }
        return controller;
    }*/
    
    public AboutController(MyApplication context) {
        super(context, new AboutView());        
    }        

    @Override
    public void start() {
        super.view.setVisible(true);
    }

    @Override
    public void stop() {        
        context.finish();
    }       
}
