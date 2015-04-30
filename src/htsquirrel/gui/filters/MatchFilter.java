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
package htsquirrel.gui.filters;

import static htsquirrel.Records.*;
import static htsquirrel.database.DatabaseManagement.createDatabaseConnection;
import java.awt.Component;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Aleksandar Cvetković <arcvetkovic@gmail.com>
 */
public class MatchFilter extends javax.swing.JPanel {

    /**
     * Creates new form MatchFilter
     */
    public MatchFilter() {
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

        panelTop = new javax.swing.JPanel();
        panelTopBlank = new javax.swing.JPanel();
        panelTopMenu = new javax.swing.JPanel();
        labelMatchType = new javax.swing.JLabel();
        labelPeriod = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        panelBottom = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        buttonReset = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        buttonCalculate = new javax.swing.JButton();
        panelCenter = new javax.swing.JPanel();
        matchType = new htsquirrel.gui.filters.MatchType();
        period = new htsquirrel.gui.filters.Period();

        setLayout(new java.awt.BorderLayout());

        panelTop.setMaximumSize(new java.awt.Dimension(32767, 100));
        panelTop.setMinimumSize(new java.awt.Dimension(100, 100));
        panelTop.setPreferredSize(new java.awt.Dimension(400, 100));
        panelTop.setLayout(new java.awt.GridLayout(2, 1));

        javax.swing.GroupLayout panelTopBlankLayout = new javax.swing.GroupLayout(panelTopBlank);
        panelTopBlank.setLayout(panelTopBlankLayout);
        panelTopBlankLayout.setHorizontalGroup(
            panelTopBlankLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        panelTopBlankLayout.setVerticalGroup(
            panelTopBlankLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        panelTop.add(panelTopBlank);

        panelTopMenu.setLayout(new java.awt.GridLayout(1, 0));

        labelMatchType.setIcon(new javax.swing.ImageIcon(getClass().getResource("/htsquirrel/gui/images/match_type_on.png"))); // NOI18N
        labelMatchType.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelMatchType.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelMatchTypeMouseClicked(evt);
            }
        });
        panelTopMenu.add(labelMatchType);

        labelPeriod.setIcon(new javax.swing.ImageIcon(getClass().getResource("/htsquirrel/gui/images/period_off.png"))); // NOI18N
        labelPeriod.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelPeriod.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelPeriodMouseClicked(evt);
            }
        });
        panelTopMenu.add(labelPeriod);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/htsquirrel/gui/images/arena_off.png"))); // NOI18N
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panelTopMenu.add(jLabel3);

        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panelTopMenu.add(jLabel4);

        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panelTopMenu.add(jLabel5);

        jLabel6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panelTopMenu.add(jLabel6);

        jLabel7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panelTopMenu.add(jLabel7);

        jLabel8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panelTopMenu.add(jLabel8);

        panelTop.add(panelTopMenu);

        add(panelTop, java.awt.BorderLayout.PAGE_START);

        panelBottom.setMaximumSize(new java.awt.Dimension(32767, 50));
        panelBottom.setMinimumSize(new java.awt.Dimension(100, 50));
        panelBottom.setPreferredSize(new java.awt.Dimension(400, 50));
        panelBottom.setLayout(new java.awt.GridLayout(1, 0));

        jPanel1.setLayout(new java.awt.GridBagLayout());

        buttonReset.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        buttonReset.setText("Reset");
        buttonReset.setMaximumSize(new java.awt.Dimension(90, 31));
        buttonReset.setMinimumSize(new java.awt.Dimension(90, 31));
        buttonReset.setPreferredSize(new java.awt.Dimension(90, 31));
        jPanel1.add(buttonReset, new java.awt.GridBagConstraints());

        panelBottom.add(jPanel1);

        jPanel2.setLayout(new java.awt.GridBagLayout());

        buttonCalculate.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        buttonCalculate.setText("Calculate");
        buttonCalculate.setMaximumSize(new java.awt.Dimension(90, 31));
        buttonCalculate.setMinimumSize(new java.awt.Dimension(90, 31));
        buttonCalculate.setPreferredSize(new java.awt.Dimension(90, 31));
        buttonCalculate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCalculateActionPerformed(evt);
            }
        });
        jPanel2.add(buttonCalculate, new java.awt.GridBagConstraints());

        panelBottom.add(jPanel2);

        add(panelBottom, java.awt.BorderLayout.PAGE_END);

        panelCenter.setLayout(new java.awt.CardLayout());
        panelCenter.add(matchType, "card2");
        panelCenter.add(period, "card3");

        add(panelCenter, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonCalculateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCalculateActionPerformed
        try {
            Connection db = createDatabaseConnection();
            showTotalTeamScore(db);
            db.close();
        } catch (IOException ex) {
            Logger.getLogger(MatchFilter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MatchFilter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MatchFilter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_buttonCalculateActionPerformed

    private void labelMatchTypeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelMatchTypeMouseClicked
        hideFilters();
        matchType.setVisible(true);
        labelMatchType.setIcon(new javax.swing.ImageIcon(getClass().getResource("/htsquirrel/gui/images/match_type_on.png")));
    }//GEN-LAST:event_labelMatchTypeMouseClicked

    private void labelPeriodMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelPeriodMouseClicked
        hideFilters();
        period.setVisible(true);
                labelPeriod.setIcon(new javax.swing.ImageIcon(getClass().getResource("/htsquirrel/gui/images/period_on.png")));
    }//GEN-LAST:event_labelPeriodMouseClicked

    public MatchType getMatchType() {
        return matchType;
    }
    
    public Period getPeriod() {
        return period;
    }
    
    public static void resetFilters() {
        htsquirrel.HTSquirrel.getMatchFilter().getPeriod().getRbSeason().setSelected(true);
        htsquirrel.HTSquirrel.getMatchFilter().getPeriod().getRbLeagueLevel().setSelected(true);
        htsquirrel.HTSquirrel.getMatchFilter().getPeriod().getCbSeasonFrom().removeAllItems();
        htsquirrel.HTSquirrel.getMatchFilter().getPeriod().getCbSeasonTo().removeAllItems();
        htsquirrel.HTSquirrel.getMatchFilter().getPeriod().getCbLeagueFrom().removeAllItems();
        htsquirrel.HTSquirrel.getMatchFilter().getPeriod().getCbLeagueTo().removeAllItems();
        htsquirrel.HTSquirrel.getMatchFilter().getPeriod().getCbLeague().removeAllItems();
        try {
            Connection db = createDatabaseConnection();
            // season from and to
            String sqlCode = "SELECT SEASON FROM LEAGUES WHERE TEAM_ID = "
                    + htsquirrel.HTSquirrel.currentTeam.getTeamId();
            Statement statement1 = db.createStatement();
            ResultSet resultSet1 = statement1.executeQuery(sqlCode);
            while (resultSet1.next()) {
                int season = resultSet1.getInt("SEASON");
                htsquirrel.HTSquirrel.getMatchFilter().getPeriod().getCbSeasonFrom().addItem(season);
                htsquirrel.HTSquirrel.getMatchFilter().getPeriod().getCbSeasonTo().addItem(season);
            }
            htsquirrel.HTSquirrel.getMatchFilter().getPeriod().getCbSeasonTo().setSelectedIndex(htsquirrel.HTSquirrel.getMatchFilter().getPeriod().getCbSeasonTo().getItemCount() - 1);
            // specific league
            sqlCode = "SELECT LEAGUE_LEVEL_UNIT_NAME FROM (SELECT DISTINCT LEAGUE_LEVEL_UNIT_ID, LEAGUE_LEVEL_UNIT_NAME FROM LEAGUES  WHERE TEAM_ID = "
                    + htsquirrel.HTSquirrel.currentTeam.getTeamId() + " ORDER BY LEAGUE_LEVEL_UNIT_ID)";
            Statement statement2 = db.createStatement();
            ResultSet resultSet2 = statement2.executeQuery(sqlCode);
            while (resultSet2.next()) {
                String league = resultSet2.getString("LEAGUE_LEVEL_UNIT_NAME");
                htsquirrel.HTSquirrel.getMatchFilter().getPeriod().getCbLeague().addItem(league);
            }
            // league level from and to
            sqlCode = "SELECT DISTINCT LEAGUE_LEVEL FROM LEAGUES WHERE TEAM_ID = "
                    + htsquirrel.HTSquirrel.currentTeam.getTeamId() + " ORDER BY LEAGUE_LEVEL";
            Statement statement3 = db.createStatement();
            ResultSet resultSet3 = statement3.executeQuery(sqlCode);
            while (resultSet3.next()) {
                int level = resultSet3.getInt("LEAGUE_LEVEL");
                htsquirrel.HTSquirrel.getMatchFilter().getPeriod().getCbLeagueFrom().addItem(level);
                htsquirrel.HTSquirrel.getMatchFilter().getPeriod().getCbLeagueTo().addItem(level);
            }
            htsquirrel.HTSquirrel.getMatchFilter().getPeriod().getCbLeagueTo().setSelectedIndex(htsquirrel.HTSquirrel.getMatchFilter().getPeriod().getCbLeagueTo().getItemCount() - 1);
            // date from and to
            sqlCode = "SELECT TO_CHAR(MIN(MATCH_DATE), 'YYYY-MM-DD') AS FIRST_DATE,  TO_CHAR(MAX(MATCH_DATE) + 1, 'YYYY-MM-DD') AS LAST_DATE FROM MATCHES WHERE TEAM_ID = "
                    + htsquirrel.HTSquirrel.currentTeam.getTeamId();
            Statement statement4 = db.createStatement();
            ResultSet resultSet4 = statement4.executeQuery(sqlCode);
            while (resultSet4.next()) {
                String firstDate = resultSet4.getString("FIRST_DATE");
                String lastDate = resultSet4.getString("LAST_DATE");
                htsquirrel.HTSquirrel.getMatchFilter().getPeriod().getTfDateFrom().setText(firstDate);
                htsquirrel.HTSquirrel.getMatchFilter().getPeriod().getTfDateTo().setText(lastDate);
            }
            db.close();
        } catch (IOException ex) {
            Logger.getLogger(MatchFilter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MatchFilter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MatchFilter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void hideFilters() {
        Component[] filters = panelCenter.getComponents();
        for (Component filter : filters) {
            filter.setVisible(false);
        }
        labelMatchType.setIcon(new javax.swing.ImageIcon(getClass().getResource("/htsquirrel/gui/images/match_type_off.png")));
        labelPeriod.setIcon(new javax.swing.ImageIcon(getClass().getResource("/htsquirrel/gui/images/period_off.png")));
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCalculate;
    private javax.swing.JButton buttonReset;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel labelMatchType;
    private javax.swing.JLabel labelPeriod;
    private htsquirrel.gui.filters.MatchType matchType;
    private javax.swing.JPanel panelBottom;
    private javax.swing.JPanel panelCenter;
    private javax.swing.JPanel panelTop;
    private javax.swing.JPanel panelTopBlank;
    private javax.swing.JPanel panelTopMenu;
    private htsquirrel.gui.filters.Period period;
    // End of variables declaration//GEN-END:variables
}
