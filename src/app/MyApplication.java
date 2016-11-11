package app;



import controller.AboutController;
import controller.HomeController;
import controller.MemberController;
import controller.ReportController;
import controller.TransactionController;
import controller.Controller;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MuhammadAlif
 */
public class MyApplication {
          
    private Controller currentController;    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {        
        MyApplication main = new MyApplication();
        
        // start application
        main.startNextFrame(null, HomeController.class);               
    }
    
    public void startNextFrame(Controller from, Class to){
        if (from != null) {
            from.stop();
        }        
        if (to == HomeController.class) {
            currentController = HomeController.newInstance(this);            
        }else if (to == MemberController.class) {
            currentController = MemberController.newInstance(this);            
        }else if (to == TransactionController.class) {
            currentController = TransactionController.newInstance(this);            
        }else if (to == ReportController.class) {
            currentController = ReportController.newInstance(this);            
        }else{
            currentController = AboutController.newInstance(this);            
        }
        currentController.start();
    }
    
    public void finish(){        
        if (!(currentController instanceof HomeController)){
            // re start application            
            startNextFrame(currentController, HomeController.class); 
        }
    }
}
