/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import app.MyApplication;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
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
        DefaultTableModel tableModel = (DefaultTableModel) memberView.getjMemberTable().getModel();
        ArrayList<String []> listMember = context.getExtras("member");
        setTableContent(listMember, tableModel);
        
        memberView.getjExitButton().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                context.finish();
            }
        });
        
        memberView.getjAddButton().addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt){
                tableModel.addRow(new Object[]{
                    memberView.getjKodeText().getText(),
                    memberView.getjNameText().getText(),
                    memberView.getjAlamatText().getText(),
                    "Dummy",
                    memberView.getjEmailText().getText(),
                    memberView.getjTeleponText().getText()
                });
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
    
}
