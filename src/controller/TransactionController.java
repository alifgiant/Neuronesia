/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import app.MyApplication;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import view.TransactionView;

/**
 *
 * @author MuhammadAlif
 */
public class TransactionController extends Controller{

    public TransactionController(MyApplication context) {
        super(context, new TransactionView());        
    }        

    @Override
    public void start() {
        /* Init view */
        super.view.setVisible(true);
        TransactionView transactionView = (TransactionView)super.view;
        
        /* Set Date format */
        DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");
        /* Set default date */
        Date date = new Date();
        transactionView.getDate().setDate(date);

        /* Set table data */
        DefaultTableModel tableModel = (DefaultTableModel) transactionView.getTransactionTable().getModel();
        ArrayList<String []> oldListTransaction = context.getExtras("transaction");
        ArrayList<String []> listMember = context.getExtras("member");
        ArrayList<String> listNoMember = new ArrayList<>();
        for(String [] member : listMember){
            listNoMember.add(member[0].substring(4,8));
            transactionView.getNoAnggota().addItem(member[0].substring(4,8));
        }
       
        setTableContent(oldListTransaction, tableModel);
        
        
        /* Set generated id */
        transactionView.setNoTransaksi(generateNoTransaksi(dateFormat.format(transactionView.getDate().getDate()),tableModel));
        
        /* set default nama layanan */
        String kode = (String) transactionView.getKodeLayanan().getSelectedItem();
        transactionView.setNamaLayanan(kode);
        
        /* set listener */
        transactionView.getKodeLayanan().addActionListener(new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {
                String kode = (String) transactionView.getKodeLayanan().getSelectedItem();
                transactionView.setNamaLayanan(kode);
            }
        });
        transactionView.getjAddButton().addMouseListener(new MouseAdapter() {
           @Override
           public void mouseClicked(java.awt.event.MouseEvent evt){
                if(checkMember(listNoMember, transactionView.getNoAnggota().getSelectedItem().toString())){
                    Object newTransaction [] = new Object [] {
                        generateNoTransaksi(dateFormat.format(transactionView.getDate().getDate()),tableModel),
                        "NNC-" + transactionView.getNoAnggota().getSelectedItem().toString(),
                        dateFormat.format(transactionView.getDate().getDate()),
                        (String) transactionView.getKodeLayanan().getSelectedItem(),
                        transactionView.getNamaLayanan().getText(),
                        transactionView.getTotalBiaya().getText(),
                    };
                    tableModel.addRow(newTransaction);
                    transactionView.setNoTransaksi(generateNoTransaksi(dateFormat.format(transactionView.getDate().getDate()),tableModel));
                }
                else {
                    JOptionPane.showMessageDialog(transactionView, "No Anggota tidak terdapat pada Anggota manapun!");
                }
           }
        });
        transactionView.getjExitButton().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                context.finish();
            }
        });
        transactionView.getjChangeButton().addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt){
                int row = transactionView.getTransactionTable().getSelectedRow();
                if(row != -1){
                    if(checkMember(listNoMember,transactionView.getNoAnggota().getSelectedItem().toString())){
                        transactionView.getTransactionTable().setValueAt("NNC-" + transactionView.getNoAnggota().getSelectedItem().toString(), row, 1);
                        transactionView.getTransactionTable().setValueAt(dateFormat.format(transactionView.getDate().getDate()), row, 2);
                        transactionView.getTransactionTable().setValueAt((String)transactionView.getKodeLayanan().getSelectedItem(), row, 3);
                        transactionView.getTransactionTable().setValueAt(transactionView.getNamaLayanan().getText(), row, 4);
                        transactionView.getTransactionTable().setValueAt(transactionView.getTotalBiaya().getText(), row ,5);
                    }
                    else{
                        JOptionPane.showMessageDialog(transactionView, "No Anggota tidak terdapat pada Anggota manapun!");
                    }
                }
                else {
                    JOptionPane.showMessageDialog(transactionView, "Pilih data di tabel!");
                }
            }
        });
        transactionView.getjDeleteButton().addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt){
                int selectedRow = transactionView.getTransactionTable().getSelectedRow();
                if(selectedRow != -1)
                    tableModel.removeRow(transactionView.getTransactionTable().getSelectedRow());
            }
        });
        transactionView.getjSaveButton().addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt){
                ArrayList<String []> listTransaction = new ArrayList<>();
                for(int i = 0; i < tableModel.getRowCount(); i++){
                    listTransaction.add(new String[]{
                        String.valueOf(tableModel.getValueAt(i, 0)),
                        String.valueOf(tableModel.getValueAt(i, 1)),
                        String.valueOf(tableModel.getValueAt(i, 2)),
                        String.valueOf(tableModel.getValueAt(i, 3)),
                        String.valueOf(tableModel.getValueAt(i, 4)),
                        String.valueOf(tableModel.getValueAt(i, 5))
                    });
                }
                context.putExtra("transaction", listTransaction);
                JOptionPane.showMessageDialog(transactionView, "Data Transaksi berhasil disimpan!");
            }    
        });
        transactionView.getTransactionTable().addMouseListener(new MouseAdapter(){
           @Override
           public void mouseClicked(java.awt.event.MouseEvent event){
               System.out.println("Table clicked");
               int row = transactionView.getTransactionTable().rowAtPoint(event.getPoint());
               transactionView.setNoTransaksi(String.valueOf(transactionView.getTransactionTable().getValueAt(row, 0)));
               transactionView.setNoAnggota(String.valueOf(transactionView.getTransactionTable().getValueAt(row, 1)).substring(4, 8));
               try {
                   transactionView.setDate(String.valueOf(transactionView.getTransactionTable().getValueAt(row, 2)));
               } catch (ParseException ex) {
                   Logger.getLogger(TransactionController.class.getName()).log(Level.SEVERE, null, ex);
               }
               transactionView.setKodeLayanan(String.valueOf(transactionView.getTransactionTable().getValueAt(row, 3)));
               transactionView.setNamaLayanan(String.valueOf(transactionView.getTransactionTable().getValueAt(row, 3)));
               transactionView.setTotalBiaya(String.valueOf(transactionView.getTransactionTable().getValueAt(row, 5)));
           } 
        });
    }

    @Override
    public void stop() {        
        super.view.setVisible(false);
    }
    
    public void setTableContent(ArrayList<String []> listTransaksi, DefaultTableModel tableModel){
        tableModel.setRowCount(0); //clearing all row before
        if(listTransaksi.size() > 0){
            for(String [] member : listTransaksi){
                tableModel.addRow(new Object[]{
                    String.valueOf(member[0]),
                    String.valueOf(member[1]),
                    String.valueOf(member[2]),
                    String.valueOf(member[3]),
                    String.valueOf(member[4]),
                    String.valueOf(member[5]),
                });
            }
        }
    }
    
    public String generateNoTransaksi(String date, DefaultTableModel model){
        String nnc = "NNC/" + date + "/";
        int transactionQty;
        if(model.getRowCount() == 0) transactionQty = 1;
        else transactionQty = model.getRowCount() + 1;
        if(transactionQty < 10) nnc += "000" + transactionQty;
        else if(transactionQty < 100) nnc += "00" + transactionQty;
        else if(transactionQty < 1000) nnc += "0" + transactionQty;
        else nnc += transactionQty;
        return nnc; 
    }
    
    public boolean checkMember(ArrayList<String> listNoMember, String noMember){
        boolean exist = false;
        for(String number : listNoMember){
            if(number.equals(noMember))
                exist = true;
        }
        return exist;
    }   
}
