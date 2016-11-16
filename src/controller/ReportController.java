/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import app.MyApplication;
import java.awt.event.MouseAdapter;
import view.ReportView;

/**
 *
 * @author MuhammadAlif
 */
public class ReportController extends Controller{
    /*private static ReportController controller;
    
    public static ReportController newInstance(MyApplication context){
        if (controller == null) {
            controller = new ReportController(context);
        }
        return controller;
    }*/
    
    public ReportController(MyApplication context) {
        super(context, new ReportView());        
    }        

    @Override
    public void start() {
        super.view.setVisible(true);
        
        ReportView reportView = (ReportView)super.view;
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
