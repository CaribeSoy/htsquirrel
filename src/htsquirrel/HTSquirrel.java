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
import htsquirrel.game.Team;
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
        classPath = getClass().getProtectionDomain().getCodeSource().getLocation().toString();
        int userId = 0;
        try {
            userId = getUserIdProperty();
        } catch (IOException ex) {
            Logger.getLogger(HTSquirrel.class.getName()).log(Level.SEVERE, null, ex); // TODO add error message
        }
        if (userId == 0) {
            showAuthorization();
        } else {
            try {
                Connection db = createDatabaseConnection();
                checkTablesExist(db);
                teams = getTeams(db, userId);
                db.close();
                if (teams.isEmpty()) {
                    showDownload();
                } else {
                    currentTeam = teams.get(0);
                }
            } catch (IOException ex) {
                Logger.getLogger(HTSquirrel.class.getName()).log(Level.SEVERE, null, ex); // TODO add error message
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(HTSquirrel.class.getName()).log(Level.SEVERE, null, ex); // TODO add error message
            } catch (SQLException ex) {
                Logger.getLogger(HTSquirrel.class.getName()).log(Level.SEVERE, null, ex); // TODO add error message
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelTop = new javax.swing.JPanel();
        panelTopTop = new javax.swing.JPanel();
        panelTopBottom = new javax.swing.JPanel();
        panelTopLeft = new javax.swing.JPanel();
        panelTopRight = new javax.swing.JPanel();
        panelTopCenter = new javax.swing.JPanel();
        labelHome = new javax.swing.JLabel();
        labelRecords = new javax.swing.JLabel();
        labelDownload = new javax.swing.JLabel();
        labelSettings = new javax.swing.JLabel();
        panelBottom = new javax.swing.JPanel();
        panelLeft = new javax.swing.JPanel();
        blankFilter = new htsquirrel.gui.filters.BlankFilter();
        homeFilter = new htsquirrel.gui.filters.HomeFilter();
        matchFilter = new htsquirrel.gui.filters.MatchFilter();
        panelRight = new javax.swing.JPanel();
        panelCenter = new javax.swing.JPanel();
        panelBlank = new htsquirrel.gui.pages.BlankPage();
        panelDownload = new htsquirrel.gui.pages.Download();
        panelAuthorization = new htsquirrel.gui.pages.Authorization();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("HT Squirrel");
        setMinimumSize(new java.awt.Dimension(1000, 750));
        setName("frameHTSquirrel"); // NOI18N
        setPreferredSize(new java.awt.Dimension(1000, 750));

        panelTop.setBackground(new java.awt.Color(51, 51, 51));
        panelTop.setMaximumSize(new java.awt.Dimension(32767, 50));
        panelTop.setMinimumSize(new java.awt.Dimension(100, 50));
        panelTop.setPreferredSize(new java.awt.Dimension(1000, 50));
        panelTop.setLayout(new java.awt.BorderLayout());

        panelTopTop.setBackground(new java.awt.Color(51, 51, 51));
        panelTopTop.setPreferredSize(new java.awt.Dimension(1000, 1));

        javax.swing.GroupLayout panelTopTopLayout = new javax.swing.GroupLayout(panelTopTop);
        panelTopTop.setLayout(panelTopTopLayout);
        panelTopTopLayout.setHorizontalGroup(
            panelTopTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1000, Short.MAX_VALUE)
        );
        panelTopTopLayout.setVerticalGroup(
            panelTopTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );

        panelTop.add(panelTopTop, java.awt.BorderLayout.PAGE_START);

        panelTopBottom.setBackground(new java.awt.Color(204, 102, 0));
        panelTopBottom.setPreferredSize(new java.awt.Dimension(1000, 1));

        javax.swing.GroupLayout panelTopBottomLayout = new javax.swing.GroupLayout(panelTopBottom);
        panelTopBottom.setLayout(panelTopBottomLayout);
        panelTopBottomLayout.setHorizontalGroup(
            panelTopBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1000, Short.MAX_VALUE)
        );
        panelTopBottomLayout.setVerticalGroup(
            panelTopBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );

        panelTop.add(panelTopBottom, java.awt.BorderLayout.PAGE_END);

        panelTopLeft.setBackground(new java.awt.Color(51, 51, 51));
        panelTopLeft.setMaximumSize(new java.awt.Dimension(420, 32767));
        panelTopLeft.setMinimumSize(new java.awt.Dimension(420, 100));
        panelTopLeft.setPreferredSize(new java.awt.Dimension(420, 48));

        javax.swing.GroupLayout panelTopLeftLayout = new javax.swing.GroupLayout(panelTopLeft);
        panelTopLeft.setLayout(panelTopLeftLayout);
        panelTopLeftLayout.setHorizontalGroup(
            panelTopLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 420, Short.MAX_VALUE)
        );
        panelTopLeftLayout.setVerticalGroup(
            panelTopLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        panelTop.add(panelTopLeft, java.awt.BorderLayout.LINE_START);

        panelTopRight.setBackground(new java.awt.Color(51, 51, 51));
        panelTopRight.setMaximumSize(new java.awt.Dimension(5, 32767));
        panelTopRight.setMinimumSize(new java.awt.Dimension(5, 100));
        panelTopRight.setPreferredSize(new java.awt.Dimension(5, 48));

        javax.swing.GroupLayout panelTopRightLayout = new javax.swing.GroupLayout(panelTopRight);
        panelTopRight.setLayout(panelTopRightLayout);
        panelTopRightLayout.setHorizontalGroup(
            panelTopRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        panelTopRightLayout.setVerticalGroup(
            panelTopRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        panelTop.add(panelTopRight, java.awt.BorderLayout.LINE_END);

        panelTopCenter.setBackground(new java.awt.Color(51, 51, 51));

        labelHome.setFont(new java.awt.Font("DejaVu Sans", 0, 18)); // NOI18N
        labelHome.setForeground(new java.awt.Color(60, 63, 65));
        labelHome.setText("HOME");
        labelHome.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        labelRecords.setFont(new java.awt.Font("DejaVu Sans", 0, 18)); // NOI18N
        labelRecords.setForeground(new java.awt.Color(60, 63, 65));
        labelRecords.setText("RECORDS");
        labelRecords.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        labelDownload.setFont(new java.awt.Font("DejaVu Sans", 0, 18)); // NOI18N
        labelDownload.setForeground(new java.awt.Color(60, 63, 65));
        labelDownload.setText("DOWNLOAD");
        labelDownload.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        labelSettings.setFont(new java.awt.Font("DejaVu Sans", 0, 18)); // NOI18N
        labelSettings.setForeground(new java.awt.Color(60, 63, 65));
        labelSettings.setText("SETTINGS");
        labelSettings.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout panelTopCenterLayout = new javax.swing.GroupLayout(panelTopCenter);
        panelTopCenter.setLayout(panelTopCenterLayout);
        panelTopCenterLayout.setHorizontalGroup(
            panelTopCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTopCenterLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(labelHome)
                .addGap(18, 18, 18)
                .addComponent(labelRecords)
                .addGap(18, 18, 18)
                .addComponent(labelDownload)
                .addGap(18, 18, 18)
                .addComponent(labelSettings)
                .addContainerGap(125, Short.MAX_VALUE))
        );
        panelTopCenterLayout.setVerticalGroup(
            panelTopCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTopCenterLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(panelTopCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelHome)
                    .addComponent(labelRecords)
                    .addComponent(labelDownload)
                    .addComponent(labelSettings))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        panelTop.add(panelTopCenter, java.awt.BorderLayout.CENTER);

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

        panelLeft.setMaximumSize(new java.awt.Dimension(420, 32767));
        panelLeft.setMinimumSize(new java.awt.Dimension(420, 100));
        panelLeft.setPreferredSize(new java.awt.Dimension(420, 740));
        panelLeft.setLayout(new java.awt.CardLayout());
        panelLeft.add(blankFilter, "card2");
        panelLeft.add(homeFilter, "card4");
        panelLeft.add(matchFilter, "card3");

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

        panelCenter.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout panelBlankLayout = new javax.swing.GroupLayout(panelBlank);
        panelBlank.setLayout(panelBlankLayout);
        panelBlankLayout.setHorizontalGroup(
            panelBlankLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 575, Short.MAX_VALUE)
        );
        panelBlankLayout.setVerticalGroup(
            panelBlankLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 695, Short.MAX_VALUE)
        );

        panelCenter.add(panelBlank, "card4");
        panelCenter.add(panelDownload, "card3");
        panelCenter.add(panelAuthorization, "card2");

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
    public static ArrayList<Team> teams;
    public static Team currentTeam;

    public static String getClassPath() {
        return classPath;
    }
    
    public static void hidePanels() {
        panelBlank.setVisible(false);
        panelAuthorization.setVisible(false);
        panelDownload.setVisible(false);
        blankFilter.setVisible(false);
        homeFilter.setVisible(false);
        matchFilter.setVisible(false);
    }
    
    public static void hideLabels() {
        labelHome.setVisible(false);
        labelRecords.setVisible(false);
        labelDownload.setVisible(false);
        labelSettings.setVisible(false);
    }
    
    public static void showLabels() {
        labelHome.setVisible(true);
        labelRecords.setVisible(true);
        labelDownload.setVisible(true);
        labelSettings.setVisible(true);
    }
    
    public static void showAuthorization() {
        hidePanels();
        hideLabels();
        blankFilter.setVisible(true);
        panelAuthorization.refreshAuthorization();
        panelAuthorization.setVisible(true);
    }
    
    public static void showDownload() {
        hidePanels();
        blankFilter.setVisible(true);
        panelDownload.refreshDownload();
        panelDownload.setVisible(true);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static htsquirrel.gui.filters.BlankFilter blankFilter;
    private static htsquirrel.gui.filters.HomeFilter homeFilter;
    private static javax.swing.JLabel labelDownload;
    private static javax.swing.JLabel labelHome;
    private static javax.swing.JLabel labelRecords;
    private static javax.swing.JLabel labelSettings;
    private static htsquirrel.gui.filters.MatchFilter matchFilter;
    private static htsquirrel.gui.pages.Authorization panelAuthorization;
    private static htsquirrel.gui.pages.BlankPage panelBlank;
    private javax.swing.JPanel panelBottom;
    private javax.swing.JPanel panelCenter;
    private static htsquirrel.gui.pages.Download panelDownload;
    private javax.swing.JPanel panelLeft;
    private javax.swing.JPanel panelRight;
    private javax.swing.JPanel panelTop;
    private javax.swing.JPanel panelTopBottom;
    private javax.swing.JPanel panelTopCenter;
    private javax.swing.JPanel panelTopLeft;
    private javax.swing.JPanel panelTopRight;
    private javax.swing.JPanel panelTopTop;
    // End of variables declaration//GEN-END:variables
}
