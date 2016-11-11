/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import app.MyApplication;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import view.HomeView;

/**
 *
 * @author MuhammadAlif
 */
public class HomeController extends Controller{
    
    private static HomeController controller;
    
    public static HomeController newInstance(MyApplication context){
        if (controller == null) {
            controller = new HomeController(context);
        }
        return controller;
    }

    private HomeController(MyApplication context) {        
        super(context, new HomeView());        
    }        
    
    @Override
    public void start(){        
        view.setVisible(true);
        
        // set clicked behavior
        HomeView mainView = (HomeView)super.view;
        mainView.getjMenuMember().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                context.startNextFrame(HomeController.this, MemberController.class);
            }
        }); 
        mainView.getjMenuTransaksi().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                context.startNextFrame(HomeController.this, TransactionController.class);
            }
        });
        mainView.getjMenuLaporan().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                context.startNextFrame(HomeController.this, ReportController.class);
            }
        });        
        mainView.getjMenuAbout().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                context.startNextFrame(HomeController.this, AboutController.class);
            }
        });
    }

    @Override
    public void stop() {
        super.view.setVisible(false);
    }    
}
