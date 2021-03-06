/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JMenu;
import javax.swing.JPanel;

/**
 *
 * @author MuhammadAlif
 */
public class HomeView extends javax.swing.JFrame {

    /**
     * Creates new form MainView
     */
    public HomeView() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jHomePanel = new javax.swing.JPanel();
        jTitleLabel = new javax.swing.JLabel();
        jTitleLabel1 = new javax.swing.JLabel();
        jImageView = new javax.swing.JLabel();
        jMenuBar = new javax.swing.JMenuBar();
        jMenuMember = new javax.swing.JMenu();
        jMenuTransaksi = new javax.swing.JMenu();
        jMenuLaporan = new javax.swing.JMenu();
        jMenuAbout = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jHomePanel.setBackground(new java.awt.Color(242, 146, 0));

        jTitleLabel.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jTitleLabel.setForeground(new java.awt.Color(255, 255, 255));
        jTitleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jTitleLabel.setText("SISTEM INFORMASI");
        jTitleLabel.setAlignmentX(0.5F);
        jTitleLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jTitleLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jTitleLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jTitleLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jTitleLabel1.setText("NEURONESIA");
        jTitleLabel1.setAlignmentX(0.5F);
        jTitleLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jImageView.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jImageView.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/neuronesia_logo.png"))); // NOI18N

        javax.swing.GroupLayout jHomePanelLayout = new javax.swing.GroupLayout(jHomePanel);
        jHomePanel.setLayout(jHomePanelLayout);
        jHomePanelLayout.setHorizontalGroup(
            jHomePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jHomePanelLayout.createSequentialGroup()
                .addGap(124, 124, 124)
                .addComponent(jTitleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(123, 123, 123))
            .addGroup(jHomePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jImageView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jHomePanelLayout.createSequentialGroup()
                .addGap(124, 124, 124)
                .addComponent(jTitleLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(123, 123, 123))
        );
        jHomePanelLayout.setVerticalGroup(
            jHomePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jHomePanelLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jTitleLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTitleLabel1)
                .addGap(18, 18, 18)
                .addComponent(jImageView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(76, 76, 76))
        );

        jMenuBar.setBackground(new java.awt.Color(255, 255, 255));

        jMenuMember.setText("Member");
        jMenuBar.add(jMenuMember);

        jMenuTransaksi.setText("Transaksi");
        jMenuBar.add(jMenuTransaksi);

        jMenuLaporan.setText("Laporan");
        jMenuBar.add(jMenuLaporan);

        jMenuAbout.setText("About");
        jMenuBar.add(jMenuAbout);

        setJMenuBar(jMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jHomePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jHomePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HomeView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomeView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomeView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomeView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomeView().setVisible(true);
            }
        });
    }

    public JMenu getjMenuAbout() {
        return jMenuAbout;
    }

    public JMenu getjMenuLaporan() {
        return jMenuLaporan;
    }

    public JMenu getjMenuMember() {
        return jMenuMember;
    }

    public JMenu getjMenuTransaksi() {
        return jMenuTransaksi;
    }  
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jHomePanel;
    private javax.swing.JLabel jImageView;
    private javax.swing.JMenu jMenuAbout;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JMenu jMenuLaporan;
    private javax.swing.JMenu jMenuMember;
    private javax.swing.JMenu jMenuTransaksi;
    private javax.swing.JLabel jTitleLabel;
    private javax.swing.JLabel jTitleLabel1;
    // End of variables declaration//GEN-END:variables
}
