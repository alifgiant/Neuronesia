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
    
    public void createAnggota(ArrayList<String []> listMember){
        try {
            System.out.println("Inserting data...");
            statement = connection.createStatement();
            String sqlCommand;
            for(String [] dataMember  : listMember){
                for(int i = 0; i <= 5; i++){
                    sqlCommand = "UPDATE ANGGOTA SET " +
                            "Nama='" + dataMember[1] + "'," +
                            "Telepon='" + dataMember[5] + "'," +
                            "Email='" + dataMember[4] + "'," +
                            "Tanggal_Lahir='" + dataMember[3] + "'," +
                            "Alamat='" + dataMember[2] + "'" 
                            + " WHERE No_Anggota='" + dataMember[0] + "'";
                    statement.execute(sqlCommand);
                }
                
            }
            System.out.println("Insert success!");
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Insert failed!");
        }
    }
    
    public ArrayList<String[]> readAnggota(){
        try {
            System.out.println("Loading data ...");
            statement = connection.createStatement();
            String sqlCommand = "SELECT * FROM ANGGOTA";
            ResultSet resultSet;
            ArrayList<String []> listMember = new ArrayList<>();                     
            resultSet = statement.executeQuery(sqlCommand);
            while(resultSet.next()){
                String value [] = new String [6];
                value[0] = resultSet.getString("No_Anggota");
                value[1] = resultSet.getString("Nama");
                value[2] = resultSet.getString("Alamat");
                value[3] = resultSet.getString("Tanggal_Lahir");
                value[4] = resultSet.getString("Email");
                value[5] = resultSet.getString("Telepon");
                listMember.add(value);
            }
            System.out.println("Loading success!");
            return listMember;
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Loading failed!");
            return null;
        }
    }
    
    public void updateMember(ArrayList<String []> listMember){
        try {
            System.out.println("Updating data...");
            statement = connection.createStatement();
            String sqlCommand;
            for(String [] dataMember  : listMember){
                for(int i = 0; i <= 5; i++){
                    sqlCommand = "UPDATE ANGGOTA SET " +
                            "Nama='" + dataMember[1] + "'," +
                            "Telepon='" + dataMember[5] + "'," +
                            "Email='" + dataMember[4] + "'," +
                            "Tanggal_Lahir='" + dataMember[3] + "'," +
                            "Alamat='" + dataMember[2] + "'" 
                            + " WHERE No_Anggota='" + dataMember[0] + "'";
                    statement.execute(sqlCommand);
                }
                
            }
            System.out.println("Update success!");
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Update failed!");
        }        
    }
    
    public void deleteMember(ArrayList<String []> listMember){
        try {
            System.out.println("Deleting data...");
            statement = connection.createStatement();
            String sqlCommand;
            for(String [] dataMember  : listMember){
                for(int i = 0; i <= 5; i++){
                    sqlCommand = "DELETE FROM ANGGOTA WHERE" +
                            "Nama='" + dataMember[1] + "'," +
                            "Telepon='" + dataMember[5] + "'," +
                            "Email='" + dataMember[4] + "'," +
                            "Tanggal_Lahir='" + dataMember[3] + "'," +
                            "Alamat='" + dataMember[2] + "'" 
                            + " WHERE No_Anggota='" + dataMember[0] + "'";
                    statement.execute(sqlCommand);
                }
                
            }
            System.out.println("Delete success!");
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Delete failed!");
        }        
    }
    
    public void saveAnggota(ArrayList<String []> listMember){
        try {
            System.out.println("Truncate table...");
            statement = connection.createStatement();
            statement.executeUpdate("TRUNCATE TABLE ANGGOTA");
            System.out.println("Truncate table success!");
            String sqlCommand;
            for(String [] dataMember  : listMember){
                sqlCommand = "INSERT INTO ANGGOTA VALUES ('" +
                        dataMember[0] + "','" +
                        dataMember[1] + "','" +
                        dataMember[5] + "','" +
                        dataMember[4] + "','" +
                        dataMember[3] + "','" +
                        dataMember[2] + "')";
                statement.executeUpdate(sqlCommand);
            }
            System.out.println("Reinsert success!");
        } catch (SQLException ex) {
            System.out.println("Reinsert failed!");
            ex.printStackTrace();
        }        
    }
}
