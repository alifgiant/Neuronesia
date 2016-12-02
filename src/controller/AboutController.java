/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import app.MyApplication;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        AboutView aboutView = (AboutView) super.view;
        aboutView.getExitButton().addActionListener(new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {
                context.finish();
            }        
        });
    }

    @Override
    public void stop() {        
        super.view.setVisible(false);
    }       
}
