package controller;

import app.MyApplication;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.table.DefaultTableModel;
import view.ReportView;

/**
 *
 * @author MuhammadAlif
 */
public class ReportController extends Controller{
    
    final JFileChooser fc = new JFileChooser();
    
    public ReportController(MyApplication context) {
        super(context, new ReportView());        
    }        
    
    @Override
    public void start() {
        /*Init View*/
        super.view.setVisible(true);
        ReportView reportView = (ReportView)super.view;
        
        /* init selected radio button */
        reportView.getjRadioAnggota().setSelected(true);
        
        /* load member and transaction to array*/
        ArrayList<String []> memberList = context.getExtras("member");
        ArrayList<String []> transactionList = context.getExtras("transaction");
        
        /*set table model and content */
        DefaultTableModel tableModel = (DefaultTableModel) reportView.getjTable().getModel();
        setTableContent(memberList, tableModel);
        
        reportView.getjExitButton().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                context.finish();
            }
        });
        
        reportView.getjRadioAnggota().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                reportView.getjTable().getColumnModel().getColumn(0).setHeaderValue("Kode Anggota");
                reportView.getjTable().getColumnModel().getColumn(1).setHeaderValue("Nama");
                reportView.getjTable().getColumnModel().getColumn(2).setHeaderValue("Alamat");
                reportView.getjTable().getColumnModel().getColumn(3).setHeaderValue("Tanggal Lahir");
                reportView.getjTable().getColumnModel().getColumn(4).setHeaderValue("Email");
                reportView.getjTable().getColumnModel().getColumn(5).setHeaderValue("Telepon");
                reportView.getjTable().getTableHeader().repaint();
                setTableContent(memberList, tableModel);
            }
        });
        //reportView.getjRadioTransaction().
        reportView.getjRadioTransaction().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                reportView.getjTable().getColumnModel().getColumn(0).setHeaderValue("No Transaksi");
                reportView.getjTable().getColumnModel().getColumn(1).setHeaderValue("No Anggota");
                reportView.getjTable().getColumnModel().getColumn(2).setHeaderValue("Tgl Transaksi");
                reportView.getjTable().getColumnModel().getColumn(3).setHeaderValue("Kode Layanan");
                reportView.getjTable().getColumnModel().getColumn(4).setHeaderValue("Nama Layanan");
                reportView.getjTable().getColumnModel().getColumn(5).setHeaderValue("Total Biaya");
                reportView.getjTable().getTableHeader().repaint();
                setTableContent(transactionList, tableModel);
            }
        });
        
        reportView.getjPrintButton().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {               
                int open = fc.showSaveDialog(reportView);
                if(open == JFileChooser.APPROVE_OPTION){
                    PrintWriter pw = null;
                    ArrayList<String []> list;
                    String columnName [] = new String [6];
                    if(reportView.getjRadioAnggota().isSelected()){
                        list = memberList;
                        columnName[0] = "Nomor Anggota";
                        columnName[1] = "Nama"; 
                        columnName[2] = "Alamat";
                        columnName[3] = "Tangal Lahir";
                        columnName[4] = "Email";
                        columnName[5] = "Telepon";
                    }
                    else {
                        list = transactionList;
                        columnName[0] = "Nomor Transaksi";
                        columnName[1] = "Nomor Anggota";
                        columnName[2] = "Tanggal Transaski";
                        columnName[3] = "Kode Layanan";
                        columnName[4] = "Nama Layanan";
                        columnName[5] = "Total Biaya";
                    }
                    try {                    
                        pw = new PrintWriter(new File(fc.getSelectedFile().getPath() + ".csv"));
                        StringBuilder sb = new StringBuilder();
                        sb.append(columnName[0]);
                        sb.append(',');
                        sb.append(columnName[1]);
                        sb.append(',');
                        sb.append(columnName[2]);
                        sb.append(',');
                        sb.append(columnName[3]);
                        sb.append(',');
                        sb.append(columnName[4]);
                        sb.append(',');
                        sb.append(columnName[5]);
                        sb.append('\n');
                        for(String [] listObject :  list){
                            sb.append(listObject[0]);
                            sb.append(',');
                            sb.append(listObject[1]);
                            sb.append(',');
                            sb.append(listObject[2]);
                            sb.append(',');
                            sb.append(listObject[3]);
                            sb.append(',');
                            sb.append(listObject[4]);
                            sb.append(',');
                            sb.append(listObject[5]);
                            sb.append('\n');
                        }
                        pw.write(sb.toString());
                        pw.close();
                    } catch (FileNotFoundException ex) {
                        System.out.println("FileNotFound");
                    } finally {
                        pw.close();
                    }
                }
            }    
        });
    }
   
    @Override
    public void stop() {        
        super.view.setVisible(false);
    }
    
    public void setTableContent(ArrayList<String []> list, DefaultTableModel tableModel){
        tableModel.setRowCount(0); //clearing all row before
        if(list.size() > 0){
            for(String [] member : list){
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
}
