/*
 The MIT License (MIT)

 Copyright (c) 2015 Aleksandar Cvetković

 Permission is hereby granted, free of charge, to any person obtaining a copy
 of this software and associated documentation files (the "Software"), to deal
 in the Software without restriction, including without limitation the rights
 to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 copies of the Software, and to permit persons to whom the Software is
 furnished to do so, subject to the following conditions:

 The above copyright notice and this permission notice shall be included in all
 copies or substantial portions of the Software.

 THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 SOFTWARE.
 */
package htsquirrel;

import static htsquirrel.database.DatabaseManagement.createDatabaseConnection;
import static htsquirrel.database.DatabaseManagement.ensureTablesExist;
import static htsquirrel.database.GetInfo.getTeamsFromDb;
import htsquirrel.game.Team;
import static htsquirrel.utilities.ConfigProperties.getAccessTokenProperty;
import static htsquirrel.utilities.ConfigProperties.getLanguageProperty;
import static htsquirrel.utilities.ConfigProperties.getThemeProperty;
import static htsquirrel.utilities.ConfigProperties.getUserIdProperty;
import static htsquirrel.utilities.ConfigProperties.saveConfigProperties;
import java.awt.Color;
import java.awt.Component;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;
import org.scribe.model.Token;

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
        menu.setVisible(false);
        menu.getLabelSwitchTeam().setVisible(false);
        hideBigPages();
        try {
            setTheme(getThemeProperty());
            setLanguage(getLanguageProperty());
            setAccessToken(getAccessTokenProperty());
            setUserId(getUserIdProperty());
            saveConfigProperties();
            applyTheme();
            if ("".equals(getLanguage())) {
                showLanguage();
            } else {
                if (getUserId() == 0) {
                    showAuthorization();
                } else {
                    Connection db = createDatabaseConnection();
                    ensureTablesExist(db);
                    setTeams(getTeamsFromDb(db, getUserId()));
                    if (teams.isEmpty()) {
                        showDownload();
                    } else {
                        System.out.println("ok");
                        setCurrentTeam(getTeams().get(0));
                        menu.refreshMenu();
                    }
                    db.close();
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(HTSquirrel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(HTSquirrel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(HTSquirrel.class.getName()).log(Level.SEVERE, null, ex);
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
        panelHorizontalLine = new javax.swing.JPanel();
        menu = new htsquirrel.gui.menu.Menu();
        panelBottom = new javax.swing.JPanel();
        panelLeft = new javax.swing.JPanel();
        panelLeftTop = new javax.swing.JPanel();
        panelLeftBottom = new javax.swing.JPanel();
        panelLeftLeft = new javax.swing.JPanel();
        panelLeftRight = new javax.swing.JPanel();
        panelSmallPage = new javax.swing.JPanel();
        panelRight = new javax.swing.JPanel();
        panelCenter = new javax.swing.JPanel();
        panelVerticalSeparator = new javax.swing.JPanel();
        panelVerticalLine = new javax.swing.JPanel();
        panelMain = new javax.swing.JPanel();
        panelHorizontalSeparator = new javax.swing.JPanel();
        panelBigPage = new javax.swing.JPanel();
        pageLanguage = new htsquirrel.gui.pages.language.Language();
        pageAuthorization = new htsquirrel.gui.pages.authorization.Authorization();
        pageDownload = new htsquirrel.gui.pages.download.Download();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelTop.setBackground(new java.awt.Color(51, 51, 51));
        panelTop.setMaximumSize(new java.awt.Dimension(32767, 52));
        panelTop.setMinimumSize(new java.awt.Dimension(100, 52));
        panelTop.setPreferredSize(new java.awt.Dimension(1000, 52));
        panelTop.setLayout(new java.awt.BorderLayout());

        panelHorizontalLine.setBackground(new java.awt.Color(255, 102, 0));
        panelHorizontalLine.setMaximumSize(new java.awt.Dimension(32767, 2));
        panelHorizontalLine.setMinimumSize(new java.awt.Dimension(100, 2));
        panelHorizontalLine.setPreferredSize(new java.awt.Dimension(1000, 2));

        javax.swing.GroupLayout panelHorizontalLineLayout = new javax.swing.GroupLayout(panelHorizontalLine);
        panelHorizontalLine.setLayout(panelHorizontalLineLayout);
        panelHorizontalLineLayout.setHorizontalGroup(
            panelHorizontalLineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1000, Short.MAX_VALUE)
        );
        panelHorizontalLineLayout.setVerticalGroup(
            panelHorizontalLineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        panelTop.add(panelHorizontalLine, java.awt.BorderLayout.PAGE_END);
        panelTop.add(menu, java.awt.BorderLayout.CENTER);

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
        panelLeft.setLayout(new java.awt.BorderLayout());

        panelLeftTop.setMaximumSize(new java.awt.Dimension(32767, 50));
        panelLeftTop.setMinimumSize(new java.awt.Dimension(100, 50));
        panelLeftTop.setPreferredSize(new java.awt.Dimension(400, 50));

        javax.swing.GroupLayout panelLeftTopLayout = new javax.swing.GroupLayout(panelLeftTop);
        panelLeftTop.setLayout(panelLeftTopLayout);
        panelLeftTopLayout.setHorizontalGroup(
            panelLeftTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        panelLeftTopLayout.setVerticalGroup(
            panelLeftTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        panelLeft.add(panelLeftTop, java.awt.BorderLayout.PAGE_START);

        panelLeftBottom.setMaximumSize(new java.awt.Dimension(32767, 5));
        panelLeftBottom.setMinimumSize(new java.awt.Dimension(100, 5));
        panelLeftBottom.setPreferredSize(new java.awt.Dimension(400, 5));

        javax.swing.GroupLayout panelLeftBottomLayout = new javax.swing.GroupLayout(panelLeftBottom);
        panelLeftBottom.setLayout(panelLeftBottomLayout);
        panelLeftBottomLayout.setHorizontalGroup(
            panelLeftBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        panelLeftBottomLayout.setVerticalGroup(
            panelLeftBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        panelLeft.add(panelLeftBottom, java.awt.BorderLayout.PAGE_END);

        panelLeftLeft.setMaximumSize(new java.awt.Dimension(5, 32767));
        panelLeftLeft.setMinimumSize(new java.awt.Dimension(5, 100));
        panelLeftLeft.setPreferredSize(new java.awt.Dimension(5, 638));

        javax.swing.GroupLayout panelLeftLeftLayout = new javax.swing.GroupLayout(panelLeftLeft);
        panelLeftLeft.setLayout(panelLeftLeftLayout);
        panelLeftLeftLayout.setHorizontalGroup(
            panelLeftLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        panelLeftLeftLayout.setVerticalGroup(
            panelLeftLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 638, Short.MAX_VALUE)
        );

        panelLeft.add(panelLeftLeft, java.awt.BorderLayout.LINE_START);

        panelLeftRight.setMaximumSize(new java.awt.Dimension(5, 32767));
        panelLeftRight.setMinimumSize(new java.awt.Dimension(5, 100));
        panelLeftRight.setPreferredSize(new java.awt.Dimension(5, 638));

        javax.swing.GroupLayout panelLeftRightLayout = new javax.swing.GroupLayout(panelLeftRight);
        panelLeftRight.setLayout(panelLeftRightLayout);
        panelLeftRightLayout.setHorizontalGroup(
            panelLeftRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        panelLeftRightLayout.setVerticalGroup(
            panelLeftRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 638, Short.MAX_VALUE)
        );

        panelLeft.add(panelLeftRight, java.awt.BorderLayout.LINE_END);

        javax.swing.GroupLayout panelSmallPageLayout = new javax.swing.GroupLayout(panelSmallPage);
        panelSmallPage.setLayout(panelSmallPageLayout);
        panelSmallPageLayout.setHorizontalGroup(
            panelSmallPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 390, Short.MAX_VALUE)
        );
        panelSmallPageLayout.setVerticalGroup(
            panelSmallPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 638, Short.MAX_VALUE)
        );

        panelLeft.add(panelSmallPage, java.awt.BorderLayout.CENTER);

        getContentPane().add(panelLeft, java.awt.BorderLayout.LINE_START);

        panelRight.setMaximumSize(new java.awt.Dimension(5, 32767));
        panelRight.setMinimumSize(new java.awt.Dimension(5, 100));
        panelRight.setPreferredSize(new java.awt.Dimension(5, 694));

        javax.swing.GroupLayout panelRightLayout = new javax.swing.GroupLayout(panelRight);
        panelRight.setLayout(panelRightLayout);
        panelRightLayout.setHorizontalGroup(
            panelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        panelRightLayout.setVerticalGroup(
            panelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 693, Short.MAX_VALUE)
        );

        getContentPane().add(panelRight, java.awt.BorderLayout.LINE_END);

        panelCenter.setLayout(new java.awt.BorderLayout());

        panelVerticalSeparator.setMaximumSize(new java.awt.Dimension(50, 32767));
        panelVerticalSeparator.setMinimumSize(new java.awt.Dimension(50, 100));
        panelVerticalSeparator.setPreferredSize(new java.awt.Dimension(50, 693));
        panelVerticalSeparator.setLayout(new java.awt.BorderLayout());

        panelVerticalLine.setMaximumSize(new java.awt.Dimension(1, 32767));
        panelVerticalLine.setMinimumSize(new java.awt.Dimension(1, 100));
        panelVerticalLine.setPreferredSize(new java.awt.Dimension(1, 693));

        javax.swing.GroupLayout panelVerticalLineLayout = new javax.swing.GroupLayout(panelVerticalLine);
        panelVerticalLine.setLayout(panelVerticalLineLayout);
        panelVerticalLineLayout.setHorizontalGroup(
            panelVerticalLineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );
        panelVerticalLineLayout.setVerticalGroup(
            panelVerticalLineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 693, Short.MAX_VALUE)
        );

        panelVerticalSeparator.add(panelVerticalLine, java.awt.BorderLayout.LINE_START);

        panelCenter.add(panelVerticalSeparator, java.awt.BorderLayout.LINE_START);

        panelMain.setLayout(new java.awt.BorderLayout());

        panelHorizontalSeparator.setMaximumSize(new java.awt.Dimension(32767, 50));
        panelHorizontalSeparator.setMinimumSize(new java.awt.Dimension(100, 50));
        panelHorizontalSeparator.setPreferredSize(new java.awt.Dimension(545, 50));

        javax.swing.GroupLayout panelHorizontalSeparatorLayout = new javax.swing.GroupLayout(panelHorizontalSeparator);
        panelHorizontalSeparator.setLayout(panelHorizontalSeparatorLayout);
        panelHorizontalSeparatorLayout.setHorizontalGroup(
            panelHorizontalSeparatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 545, Short.MAX_VALUE)
        );
        panelHorizontalSeparatorLayout.setVerticalGroup(
            panelHorizontalSeparatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        panelMain.add(panelHorizontalSeparator, java.awt.BorderLayout.PAGE_START);

        panelBigPage.setLayout(new java.awt.CardLayout());
        panelBigPage.add(pageLanguage, "card2");
        panelBigPage.add(pageAuthorization, "card3");
        panelBigPage.add(pageDownload, "card4");

        panelMain.add(panelBigPage, java.awt.BorderLayout.CENTER);

        panelCenter.add(panelMain, java.awt.BorderLayout.CENTER);

        getContentPane().add(panelCenter, java.awt.BorderLayout.CENTER);

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

    private static String theme;
    private static String language;
    private static int userId;
    private static Token accessToken;
    private static ArrayList<Team> teams;
    private static Team currentTeam;

    public static String getTheme() {
        return theme;
    }

    public static void setTheme(String theme) {
        HTSquirrel.theme = theme;
    }

    public static String getLanguage() {
        return language;
    }

    public static void setLanguage(String language) {
        HTSquirrel.language = language;
    }

    public static int getUserId() {
        return userId;
    }

    public static void setUserId(int userId) {
        HTSquirrel.userId = userId;
    }

    public static Token getAccessToken() {
        return accessToken;
    }

    public static void setAccessToken(Token accessToken) {
        HTSquirrel.accessToken = accessToken;
    }

    public static ArrayList<Team> getTeams() {
        return teams;
    }

    public static void setTeams(ArrayList<Team> teams) {
        HTSquirrel.teams = teams;
    }

    public static Team getCurrentTeam() {
        return currentTeam;
    }

    public static void setCurrentTeam(Team currentTeam) {
        HTSquirrel.currentTeam = currentTeam;
    }
    
    public static void applyTheme() {
        ColorUIResource colorWhite = new ColorUIResource(new java.awt.Color(242, 242, 242));
        ColorUIResource colorGreyLight = new ColorUIResource(new java.awt.Color(128, 128, 128));
        ColorUIResource colorGreyDark = new ColorUIResource(new java.awt.Color(77, 77, 77));
        ColorUIResource colorBlack = new ColorUIResource(new java.awt.Color(0, 0, 0));
        ColorUIResource colorOrange = new ColorUIResource(new java.awt.Color(255, 102, 0));
        if ("Light".equals(getTheme())) {
            UIManager.put("nimbusBase", colorGreyLight);
            UIManager.put("control", colorWhite);
            UIManager.put("text", colorBlack);
            UIManager.put("nimbusFocus", colorOrange);
            UIManager.put("nimbusSelectionBackground", colorOrange);
            UIManager.put("nimbusLightBackground", colorWhite);
            UIManager.put("nimbusOrange", colorOrange);
        } else {
            UIManager.put("nimbusBase", colorBlack);
            UIManager.put("control", colorGreyDark);
            UIManager.put("text", colorWhite);
            UIManager.put("nimbusFocus", colorOrange);
            UIManager.put("nimbusSelectionBackground", colorOrange);
            UIManager.put("nimbusLightBackground", colorGreyDark);
            UIManager.put("nimbusOrange", colorOrange);
        }
    }
    
    public static void hideBigPages() {
        Component[] pages = panelBigPage.getComponents();
        for (Component page : pages) {
            page.setVisible(false);
        }
    }
    
    public static void showLanguage() {
        hideBigPages();
        pageLanguage.setVisible(true);
    }
    
    public static void showAuthorization() {
        hideBigPages();
        pageAuthorization.setVisible(true);
        pageAuthorization.getAuthorizationBase1().refreshAuthorization();
    }
    
    public static void showDownload() {
        hideBigPages();
        pageDownload.setVisible(true);
        pageDownload.getDownloadBase1().refreshDownload();
    }
    
    public static Color getWhite() {
        Color color = new java.awt.Color(242, 242, 242);
        return color;
    }
    
    public static Color getGreyLight() {
        Color color = new java.awt.Color(128, 128, 128);
        return color;
    }
    
    public static Color getGreyDark() {
        Color color = new java.awt.Color(77, 77, 77);
        return color;
    }
    
    public static Color getBlack() {
        Color color = new java.awt.Color(0, 0, 0);
        return color;
    }
    
    public static Color getOrange() {
        Color color = new java.awt.Color(255, 102, 0);
        return color;
    }
    
    public static Color getRed() {
        Color color = new java.awt.Color(255, 0, 102);
        return color;
    }
    
    public static Color getGreen() {
        Color color = new java.awt.Color(0, 170, 68);
        return color;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static htsquirrel.gui.menu.Menu menu;
    private static htsquirrel.gui.pages.authorization.Authorization pageAuthorization;
    private static htsquirrel.gui.pages.download.Download pageDownload;
    private static htsquirrel.gui.pages.language.Language pageLanguage;
    private static javax.swing.JPanel panelBigPage;
    private javax.swing.JPanel panelBottom;
    private javax.swing.JPanel panelCenter;
    private javax.swing.JPanel panelHorizontalLine;
    private javax.swing.JPanel panelHorizontalSeparator;
    private javax.swing.JPanel panelLeft;
    private javax.swing.JPanel panelLeftBottom;
    private javax.swing.JPanel panelLeftLeft;
    private javax.swing.JPanel panelLeftRight;
    private javax.swing.JPanel panelLeftTop;
    private javax.swing.JPanel panelMain;
    private javax.swing.JPanel panelRight;
    private javax.swing.JPanel panelSmallPage;
    private javax.swing.JPanel panelTop;
    private javax.swing.JPanel panelVerticalLine;
    private javax.swing.JPanel panelVerticalSeparator;
    // End of variables declaration//GEN-END:variables
}
