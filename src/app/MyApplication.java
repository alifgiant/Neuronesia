package app;
import controller.AboutController;
import controller.HomeController;
import controller.MemberController;
import controller.ReportController;
import controller.TransactionController;
import controller.Controller;
import database.DatabaseManager;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

/**
 *
 * @author MuhammadAlif
 */
public class MyApplication {
          
    private Controller currentController;   
    private static DatabaseManager extras;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {        
        MyApplication main = new MyApplication();
        extras = new DatabaseManager();
        extras.connectToDatabase("jdbc:mysql://localhost:3306/neuronesia");
        main.startNextFrame(null, HomeController.class);
    }
    
    public void startNextFrame(Controller from, Class to){
        if (from != null) {
            from.stop();
        }        
        if (to == HomeController.class) {
            currentController = new HomeController(this);          
        }else if (to == MemberController.class) {
            currentController = new MemberController(this);            
        }else if (to == TransactionController.class) {
            currentController = new TransactionController(this);            
        }else if (to == ReportController.class) {
            currentController = new ReportController(this);            
        }else{
            currentController = new AboutController(this);            
        }
        currentController.start();
    }
    
    public void finish(){        
        if (!(currentController instanceof HomeController)){
            // re start application            
            startNextFrame(currentController, HomeController.class); 
        }
    }
    
    public ArrayList<String []> getExtras(String key){
        if(key.equals("member")){
            return extras.loadAnggota();
        }
        else if(key.equals("transaction")){ 
            return extras.loadTransaksi();
            
        }
        //else if(key.equals(""))
        return null;
    }
    
    public void putExtra(String key, ArrayList<String []> value){
        if(key.equals("member")){
            extras.saveAnggota(value);
        }
        else if(key.equals("transaction")){
            extras.saveTransaksi(value);
        }
    }
}
