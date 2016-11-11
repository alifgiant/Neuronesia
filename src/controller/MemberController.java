/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import app.MyApplication;
import java.awt.event.MouseAdapter;
import view.MemberView;

/**
 *
 * @author MuhammadAlif
 */
public class MemberController extends Controller{    
    private static MemberController controller;
    
    public static MemberController newInstance(MyApplication context){
        if (controller == null) {
            controller = new MemberController(context);
        }
        return controller;
    }
    
    private MemberController(MyApplication context) {
        super(context, new MemberView());        
    }        

    @Override
    public void start() {
        super.view.setVisible(true);
        
        MemberView memberView = (MemberView)super.view;
        memberView.getjExitButton().addMouseListener(new MouseAdapter() {
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
