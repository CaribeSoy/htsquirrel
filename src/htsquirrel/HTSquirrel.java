/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2015 Aleksandar Cvetković
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package htsquirrel;

import static htsquirrel.ConfigProperties.*;
import static htsquirrel.database.DatabaseManagement.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Aleksandar Cvetković <arcvetkovic@gmail.com>
 */
public class HTSquirrel extends javax.swing.JFrame {

    /**
     * Creates new form HTSquirrel
     */
    public HTSquirrel() {
        initComponents();
//        classPath = getClass().getProtectionDomain().getCodeSource().getLocation().toString();
//        int userId = 0;
//        try {
//            userId = getUserIdProperty();
//        } catch (IOException ex) {
//            Logger.getLogger(HTSquirrel.class.getName()).log(Level.SEVERE, null, ex); // TODO add error message
//        }
//        if (userId == 0) {
//            showAuthorization();
//        } else {
//            try {
//                Connection db = createDatabaseConnection();
//                checkTablesExist(db);
//                ArrayList<Integer> teamIds = getTeamIds(db, userId);
//                db.close();
//                if (teamIds.isEmpty()) {
//                    showDownload();
//                }
//            } catch (IOException ex) {
//                Logger.getLogger(HTSquirrel.class.getName()).log(Level.SEVERE, null, ex); // TODO add error message
//            } catch (ClassNotFoundException ex) {
//                Logger.getLogger(HTSquirrel.class.getName()).log(Level.SEVERE, null, ex); // TODO add error message
//            } catch (SQLException ex) {
//                Logger.getLogger(HTSquirrel.class.getName()).log(Level.SEVERE, null, ex); // TODO add error message
//            }
//        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        panelTop = new javax.swing.JPanel();
        panelBottom = new javax.swing.JPanel();
        panelLeft = new javax.swing.JPanel();
        panelRight = new javax.swing.JPanel();
        panelCenter = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("HT Squirrel");
        setName("frameHTSquirrel"); // NOI18N
        setPreferredSize(new java.awt.Dimension(1000, 750));

        panelTop.setBackground(new java.awt.Color(51, 51, 51));
        panelTop.setMaximumSize(new java.awt.Dimension(32767, 50));
        panelTop.setMinimumSize(new java.awt.Dimension(100, 50));
        panelTop.setPreferredSize(new java.awt.Dimension(1000, 50));

        javax.swing.GroupLayout panelTopLayout = new javax.swing.GroupLayout(panelTop);
        panelTop.setLayout(panelTopLayout);
        panelTopLayout.setHorizontalGroup(
            panelTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1000, Short.MAX_VALUE)
        );
        panelTopLayout.setVerticalGroup(
            panelTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        getContentPane().add(panelTop, java.awt.BorderLayout.PAGE_START);

        panelBottom.setBackground(new java.awt.Color(51, 51, 51));
        panelBottom.setMaximumSize(new java.awt.Dimension(32767, 5));
        panelBottom.setMinimumSize(new java.awt.Dimension(100, 5));
        panelBottom.setPreferredSize(new java.awt.Dimension(1000, 5));

        javax.swing.GroupLayout panelBottomLayout = new javax.swing.GroupLayout(panelBottom);
        panelBottom.setLayout(panelBottomLayout);
        panelBottomLayout.setHorizontalGroup(
            panelBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1000, Short.MAX_VALUE)
        );
        panelBottomLayout.setVerticalGroup(
            panelBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        getContentPane().add(panelBottom, java.awt.BorderLayout.PAGE_END);

        panelLeft.setMaximumSize(new java.awt.Dimension(400, 32767));
        panelLeft.setMinimumSize(new java.awt.Dimension(400, 100));

        javax.swing.GroupLayout panelLeftLayout = new javax.swing.GroupLayout(panelLeft);
        panelLeft.setLayout(panelLeftLayout);
        panelLeftLayout.setHorizontalGroup(
            panelLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        panelLeftLayout.setVerticalGroup(
            panelLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 695, Short.MAX_VALUE)
        );

        getContentPane().add(panelLeft, java.awt.BorderLayout.LINE_START);

        panelRight.setBackground(new java.awt.Color(204, 102, 0));
        panelRight.setMaximumSize(new java.awt.Dimension(5, 32767));
        panelRight.setMinimumSize(new java.awt.Dimension(5, 100));
        panelRight.setPreferredSize(new java.awt.Dimension(5, 695));

        javax.swing.GroupLayout panelRightLayout = new javax.swing.GroupLayout(panelRight);
        panelRight.setLayout(panelRightLayout);
        panelRightLayout.setHorizontalGroup(
            panelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        panelRightLayout.setVerticalGroup(
            panelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 695, Short.MAX_VALUE)
        );

        getContentPane().add(panelRight, java.awt.BorderLayout.LINE_END);

        javax.swing.GroupLayout panelCenterLayout = new javax.swing.GroupLayout(panelCenter);
        panelCenter.setLayout(panelCenterLayout);
        panelCenterLayout.setHorizontalGroup(
            panelCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 595, Short.MAX_VALUE)
        );
        panelCenterLayout.setVerticalGroup(
            panelCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 695, Short.MAX_VALUE)
        );

        getContentPane().add(panelCenter, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc="Darcula look and feel">
        try {
            javax.swing.UIManager.setLookAndFeel("com.bulenkov.darcula.DarculaLaf");
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HTSquirrel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HTSquirrel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HTSquirrel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HTSquirrel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HTSquirrel().setVisible(true);
            }
        });
    }
    
    public static String classPath;

    public static String getClassPath() {
        return classPath;
    }
    
//    public static void hidePanels() {
//        panelBlank.setVisible(false);
//        panelAuthorization.setVisible(false);
//        panelDownload.setVisible(false);
//    }
//    
//    public static void showAuthorization() {
//        hidePanels();
//        panelAuthorization.refreshAuthorization();
//        panelAuthorization.setVisible(true);
//    }
//    
//    public static void showDownload() {
//        hidePanels();
//        panelDownload.refreshDownload();
//        panelDownload.setVisible(true);
//    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel panelBottom;
    private javax.swing.JPanel panelCenter;
    private javax.swing.JPanel panelLeft;
    private javax.swing.JPanel panelRight;
    private javax.swing.JPanel panelTop;
    // End of variables declaration//GEN-END:variables
}
