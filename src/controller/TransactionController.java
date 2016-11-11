/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import app.MyApplication;
import java.awt.event.MouseAdapter;
import view.TransactionView;

/**
 *
 * @author MuhammadAlif
 */
public class TransactionController extends Controller{
     private static TransactionController controller;
    
    public static TransactionController newInstance(MyApplication context){
        if (controller == null) {
            controller = new TransactionController(context);
        }
        return controller;
    }
    
    private TransactionController(MyApplication context) {
        super(context, new TransactionView());        
    }        

    @Override
    public void start() {
        super.view.setVisible(true);
        
        TransactionView reportView = (TransactionView)super.view;
        reportView.getjExitButton().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                context.finish();
            }
        });
    }

    @Override
    public void stop() {        
        super.view.setVisible(false);
    }     
}
