package controller;

import app.MyApplication;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import view.MemberView;

/**
 *
 * @author MuhammadAlif
 */
public class MemberController extends Controller{
    
    public MemberController(MyApplication context) {
        super(context, new MemberView());        
    }        

    @Override
    public void start() {
        /* Init View */
        super.view.setVisible(true);
        MemberView memberView = (MemberView)super.view;
        
        /* Set date format */
        DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");
        
        /* Set table data */
        DefaultTableModel tableModel = (DefaultTableModel) memberView.getjMemberTable().getModel();
        ArrayList<String []> oldListMember = context.getExtras("member");
        setTableContent(oldListMember, tableModel);
        
        /* Set default date */
        try {
            memberView.getjDateChooser().setDate(dateFormat.parse("01-01-1995"));
        } catch (ParseException ex) {
            Logger.getLogger(MemberController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        /* Set generated id */
        memberView.setjKodeText(generateKodeAnggota(tableModel));
        
        /* Set Listener */
        memberView.getjExitButton().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                context.finish();
            }
        });
        memberView.getjAddButton().addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt){
                Object [] newMember = new Object[]{
                    generateKodeAnggota(tableModel),
                    memberView.getjNameText().getText(),
                    memberView.getjAlamatText().getText(),
                    dateFormat.format(memberView.getjDateChooser().getDate()),
                    memberView.getjEmailText().getText(),
                    memberView.getjTeleponText().getText()
                };
                tableModel.addRow(newMember);
                memberView.setjKodeText(generateKodeAnggota(tableModel));
            }
        });
        memberView.getjChangeButton().addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt){
                int row = memberView.getjMemberTable().getSelectedRow();
                if(row != -1){
                    memberView.getjMemberTable().setValueAt(memberView.getjNameText().getText(), row, 1);
                    memberView.getjMemberTable().setValueAt(memberView.getjAlamatText().getText(), row, 2);
                    memberView.getjMemberTable().setValueAt(dateFormat.format(memberView.getjDateChooser().getDate()), row, 3);
                    memberView.getjMemberTable().setValueAt(memberView.getjEmailText().getText(), row, 4);
                    memberView.getjMemberTable().setValueAt(memberView.getjTeleponText().getText(), row, 5);
                }
            }
        });
        memberView.getjDeleteButton().addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt){
                int selectedRow = memberView.getjMemberTable().getSelectedRow();
                if(selectedRow != -1)
                    tableModel.removeRow(memberView.getjMemberTable().getSelectedRow());
            }
        });
        memberView.getjSaveButton().addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt){
                ArrayList<String []> listMember = new ArrayList<>();
                for(int i = 0; i < tableModel.getRowCount(); i++){
                    listMember.add(new String[]{
                        String.valueOf(tableModel.getValueAt(i, 0)),
                        String.valueOf(tableModel.getValueAt(i, 1)),
                        String.valueOf(tableModel.getValueAt(i, 2)),
                        String.valueOf(tableModel.getValueAt(i, 3)),
                        String.valueOf(tableModel.getValueAt(i, 4)),
                        String.valueOf(tableModel.getValueAt(i, 5))
                    });
                }
                context.putExtra("member", listMember);
                JOptionPane.showMessageDialog(memberView, "Data Anggota berhasil disimpan!");
            }    
        });
        memberView.getjMemberTable().addMouseListener(new MouseAdapter(){
           @Override
           public void mouseClicked(java.awt.event.MouseEvent event){
               System.out.println("Table clicked");
               int row = memberView.getjMemberTable().rowAtPoint(event.getPoint());
               memberView.setjKodeText(String.valueOf(memberView.getjMemberTable().getValueAt(row, 0)));
               memberView.setjNameText(String.valueOf(memberView.getjMemberTable().getValueAt(row, 1)));
               memberView.setjAlamatText(String.valueOf(memberView.getjMemberTable().getValueAt(row, 2)));
               try {
                   memberView.setjTangalLahir(String.valueOf(memberView.getjMemberTable().getValueAt(row, 3)));
               } catch (ParseException ex) {}
               memberView.setjEmailText(String.valueOf(memberView.getjMemberTable().getValueAt(row, 4)));
               memberView.setjTeleponText(String.valueOf(memberView.getjMemberTable().getValueAt(row, 5)));
           } 
        });
    }

    @Override
    public void stop() {
        super.view.dispose();
    }
    
    public void setTableContent(ArrayList<String []> listMember, DefaultTableModel tableModel){
        tableModel.setRowCount(0); //clearing all row before
        if(listMember.size() > 0){
            for(String [] member : listMember){
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
    
    public String generateKodeAnggota(DefaultTableModel model){
        String nnc = "NNC-";
        int memberQty = Integer.valueOf(String.valueOf(model.getValueAt(model.getRowCount()-1, 0)).substring(5, 8)) + 1;
        if(memberQty < 10) nnc += "000" + memberQty;
        else if(memberQty < 100) nnc += "00" + memberQty;
        else if(memberQty < 1000) nnc += "0" + memberQty;
        else nnc += memberQty;
        return nnc; 
    }
}
