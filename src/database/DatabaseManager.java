/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;
import java.sql.*;
import java.util.ArrayList;
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
    
    public ArrayList<String[]> loadAnggota(){
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
    
    public void saveTransaksi(ArrayList<String []> listTransaksi){
        try {
            System.out.println("Truncate table...");
            statement = connection.createStatement();
            statement.executeUpdate("TRUNCATE TABLE LAYANAN");
            System.out.println("Truncate table success!");
            String sqlCommand;
            for(String [] dataMember  : listTransaksi){
                sqlCommand = "INSERT INTO LAYANAN VALUES ('" +
                        dataMember[0] + "','" +
                        dataMember[1] + "','" +
                        dataMember[2] + "','" +
                        dataMember[3] + "','" +
                        dataMember[4] + "','" +
                        dataMember[5] + "')";
                statement.executeUpdate(sqlCommand);
            }
            System.out.println("Reinsert success!");
        } catch (SQLException ex) {
            System.out.println("Reinsert failed!");
            ex.printStackTrace();
        }        
    }
    
    public ArrayList<String[]> loadTransaksi(){
        try {
            System.out.println("Loading data ...");
            statement = connection.createStatement();
            String sqlCommand = "SELECT * FROM LAYANAN";
            ResultSet resultSet;
            ArrayList<String []> listTransaksi = new ArrayList<>();                     
            resultSet = statement.executeQuery(sqlCommand);
            while(resultSet.next()){
                String value [] = new String [6];
                value[0] = resultSet.getString("No_Transaksi");
                value[1] = resultSet.getString("No_Anggota");
                value[2] = resultSet.getString("tgl_transaksi");
                value[3] = resultSet.getString("Kode_Layanan");
                value[4] = resultSet.getString("nm_layanan");
                value[5] = resultSet.getString("total");
                listTransaksi.add(value);
            }
            System.out.println("Loading success!");
            return listTransaksi;
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Loading failed!");
            return null;
        }
    }
    
    public void saveAnggota(ArrayList<String []> listTransaksi){
        try {
            System.out.println("Truncate table...");
            statement = connection.createStatement();
            statement.executeUpdate("TRUNCATE TABLE LAYANAN");
            System.out.println("Truncate table success!");
            String sqlCommand;
            for(String [] dataMember  : listTransaksi){
                sqlCommand = "INSERT INTO LAYANAN VALUES ('" +
                        dataMember[0] + "','" +
                        dataMember[1] + "','" +
                        dataMember[2] + "','" +
                        dataMember[3] + "','" +
                        dataMember[4] + "','" +
                        dataMember[5] + "')";
                statement.executeUpdate(sqlCommand);
            }
            System.out.println("Reinsert success!");
        } catch (SQLException ex) {
            System.out.println("Reinsert failed!");
            ex.printStackTrace();
        }        
    }
}
