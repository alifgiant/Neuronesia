/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Iris
 */
public class DatabaseManager {

    static final String USER = "root";
    static final String PASS = "";
    static Connection connection;
    static Statement statement;
    
    public void connectToDatabase(String URL){
        try {
            System.out.println("Connecting...");
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL,USER,PASS);
            System.out.println("Connection Success!");
            //return true;
        }
        catch(SQLException e) {
            e.printStackTrace();
            //return false;
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
                    
        }
    }
    
    public void saveMember(ArrayList<String []> listMember){
        try {
            System.out.println("Saving data...");
            statement = connection.createStatement();
            String sqlCommand;
            for(String [] dataMember  : listMember){
                for(int i = 0; i <= 5; i++){
                    sqlCommand = "INSERT INTO ANGGOTA VALUES ('" +
                            dataMember[0] + "','" +
                            dataMember[1] + "','" +
                            dataMember[2] + "','" +
                            dataMember[3] + "','" +
                            dataMember[4] + "','" +
                            dataMember[5] 
                            + "');";
                    statement.execute(sqlCommand);
                }    
            }
            System.out.println("Saving success!");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
                
    }
    
    public ArrayList<String[]> loadMember(){
        try {
            String sqlCommand;
            ResultSet resultSet;
            ArrayList<String []> listMember = new ArrayList<>();         
            System.out.println("Loading members data...");
            statement = connection.createStatement();
            sqlCommand = "SELECT * FROM ANGGOTA";
            resultSet = statement.executeQuery(sqlCommand);
            while(resultSet.next()){
                String value [] = new String [6];
                value[0] = resultSet.getString("No_Anggota");
                value[1] = resultSet.getString("Nama");
                value[2] = resultSet.getString("Telepon");
                value[3] = resultSet.getString("Email");
                value[4] = resultSet.getString("Tanggal_Lahir");
                value[5] = resultSet.getString("Alamat");
                listMember.add(value);
            }
            System.out.println("Loading success!");
            return listMember;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
