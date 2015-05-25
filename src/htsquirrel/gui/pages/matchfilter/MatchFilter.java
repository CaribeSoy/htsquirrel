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
package htsquirrel.gui.pages.matchfilter;

import static htsquirrel.HTSquirrel.getLanguage;
import static htsquirrel.database.DatabaseManagement.createDatabaseConnection;
import static htsquirrel.database.Records.getMode;
import static htsquirrel.database.Records.showTotalTeamScore;
import htsquirrel.translations.Translations;
import java.awt.Component;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
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
        java.awt.GridBagConstraints gridBagConstraints;

        panelButtons = new javax.swing.JPanel();
        panelLeft = new javax.swing.JPanel();
        buttonReset = new javax.swing.JButton();
        panelRight = new javax.swing.JPanel();
        buttonCalculate = new javax.swing.JButton();
        panelIcons = new javax.swing.JPanel();
        jToggleButton1 = new javax.swing.JToggleButton();
        jToggleButton2 = new javax.swing.JToggleButton();
        jToggleButton3 = new javax.swing.JToggleButton();
        jToggleButton4 = new javax.swing.JToggleButton();
        jToggleButton5 = new javax.swing.JToggleButton();
        jToggleButton6 = new javax.swing.JToggleButton();
        jToggleButton7 = new javax.swing.JToggleButton();
        jToggleButton8 = new javax.swing.JToggleButton();
        panelFilters = new javax.swing.JPanel();
        panelMatchType = new htsquirrel.gui.pages.matchfilter.MatchType();
        panelPeriod = new htsquirrel.gui.pages.matchfilter.Period();
        panelArena = new htsquirrel.gui.pages.matchfilter.Arena();
        panelFormation = new htsquirrel.gui.pages.matchfilter.Formation();

        setMinimumSize(new java.awt.Dimension(400, 100));
        setLayout(new java.awt.GridBagLayout());

        panelButtons.setMaximumSize(new java.awt.Dimension(32767, 50));
        panelButtons.setMinimumSize(new java.awt.Dimension(100, 50));
        panelButtons.setPreferredSize(new java.awt.Dimension(400, 50));
        panelButtons.setLayout(new java.awt.GridLayout(1, 0));

        panelLeft.setLayout(new java.awt.GridBagLayout());

        buttonReset.setText("Reset");
        buttonReset.setMaximumSize(new java.awt.Dimension(120, 27));
        buttonReset.setMinimumSize(new java.awt.Dimension(120, 27));
        buttonReset.setPreferredSize(new java.awt.Dimension(120, 27));
        buttonReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonResetActionPerformed(evt);
            }
        });
        panelLeft.add(buttonReset, new java.awt.GridBagConstraints());

        panelButtons.add(panelLeft);

        panelRight.setLayout(new java.awt.GridBagLayout());

        buttonCalculate.setText("Calculate");
        buttonCalculate.setMaximumSize(new java.awt.Dimension(120, 27));
        buttonCalculate.setMinimumSize(new java.awt.Dimension(120, 27));
        buttonCalculate.setPreferredSize(new java.awt.Dimension(120, 27));
        buttonCalculate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCalculateActionPerformed(evt);
            }
        });
        panelRight.add(buttonCalculate, new java.awt.GridBagConstraints());

        panelButtons.add(panelRight);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        add(panelButtons, gridBagConstraints);

        panelIcons.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelIcons.setMaximumSize(new java.awt.Dimension(32767, 100));
        panelIcons.setLayout(new java.awt.GridLayout(1, 8));

        jToggleButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/htsquirrel/gui/images/match_type_off.png"))); // NOI18N
        jToggleButton1.setSelected(true);
        jToggleButton1.setMaximumSize(new java.awt.Dimension(50, 50));
        jToggleButton1.setMinimumSize(new java.awt.Dimension(50, 50));
        jToggleButton1.setPreferredSize(new java.awt.Dimension(50, 50));
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });
        panelIcons.add(jToggleButton1);

        jToggleButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/htsquirrel/gui/images/period_off.png"))); // NOI18N
        jToggleButton2.setMaximumSize(new java.awt.Dimension(50, 50));
        jToggleButton2.setMinimumSize(new java.awt.Dimension(50, 50));
        jToggleButton2.setPreferredSize(new java.awt.Dimension(50, 50));
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton2ActionPerformed(evt);
            }
        });
        panelIcons.add(jToggleButton2);

        jToggleButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/htsquirrel/gui/images/arena_off.png"))); // NOI18N
        jToggleButton3.setMaximumSize(new java.awt.Dimension(50, 50));
        jToggleButton3.setMinimumSize(new java.awt.Dimension(50, 50));
        jToggleButton3.setPreferredSize(new java.awt.Dimension(50, 50));
        jToggleButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton3ActionPerformed(evt);
            }
        });
        panelIcons.add(jToggleButton3);

        jToggleButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/htsquirrel/gui/images/formation_off.png"))); // NOI18N
        jToggleButton4.setMaximumSize(new java.awt.Dimension(50, 50));
        jToggleButton4.setMinimumSize(new java.awt.Dimension(50, 50));
        jToggleButton4.setPreferredSize(new java.awt.Dimension(50, 50));
        panelIcons.add(jToggleButton4);

        jToggleButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/htsquirrel/gui/images/blank.png"))); // NOI18N
        jToggleButton5.setMaximumSize(new java.awt.Dimension(50, 50));
        jToggleButton5.setMinimumSize(new java.awt.Dimension(50, 50));
        jToggleButton5.setPreferredSize(new java.awt.Dimension(50, 50));
        panelIcons.add(jToggleButton5);

        jToggleButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/htsquirrel/gui/images/blank.png"))); // NOI18N
        jToggleButton6.setMaximumSize(new java.awt.Dimension(50, 50));
        jToggleButton6.setMinimumSize(new java.awt.Dimension(50, 50));
        jToggleButton6.setPreferredSize(new java.awt.Dimension(50, 50));
        panelIcons.add(jToggleButton6);

        jToggleButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/htsquirrel/gui/images/blank.png"))); // NOI18N
        jToggleButton7.setMaximumSize(new java.awt.Dimension(50, 50));
        jToggleButton7.setMinimumSize(new java.awt.Dimension(50, 50));
        jToggleButton7.setPreferredSize(new java.awt.Dimension(50, 50));
        panelIcons.add(jToggleButton7);

        jToggleButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/htsquirrel/gui/images/blank.png"))); // NOI18N
        jToggleButton8.setMaximumSize(new java.awt.Dimension(50, 50));
        jToggleButton8.setMinimumSize(new java.awt.Dimension(50, 50));
        jToggleButton8.setPreferredSize(new java.awt.Dimension(50, 50));
        panelIcons.add(jToggleButton8);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        add(panelIcons, gridBagConstraints);

        panelFilters.setLayout(new java.awt.CardLayout());
        panelFilters.add(panelMatchType, "card2");
        panelFilters.add(panelPeriod, "card3");
        panelFilters.add(panelArena, "card4");
        panelFilters.add(panelFormation, "card5");

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(panelFilters, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    public MatchType getPanelMatchType() {
        return panelMatchType;
    }

    public Period getPanelPeriod() {
        return panelPeriod;
    }

    public Arena getPanelArena() {
        return panelArena;
    }

    public Formation getPanelFormation() {
        return panelFormation;
    }

    private void buttonResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonResetActionPerformed
        resetMatchFilter();
    }//GEN-LAST:event_buttonResetActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        jToggleButton1.setSelected(true);
        jToggleButton2.setSelected(false);
        jToggleButton3.setSelected(false);
        jToggleButton4.setSelected(false);
        jToggleButton5.setSelected(false);
        jToggleButton6.setSelected(false);
        jToggleButton7.setSelected(false);
        jToggleButton8.setSelected(false);
        jToggleButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/htsquirrel/gui/images/match_type_on.png")));
        jToggleButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/htsquirrel/gui/images/period_off.png")));
        jToggleButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/htsquirrel/gui/images/arena_off.png")));
        hideFilters();
        panelMatchType.setVisible(true);
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed
        jToggleButton1.setSelected(false);
        jToggleButton2.setSelected(true);
        jToggleButton3.setSelected(false);
        jToggleButton4.setSelected(false);
        jToggleButton5.setSelected(false);
        jToggleButton6.setSelected(false);
        jToggleButton7.setSelected(false);
        jToggleButton8.setSelected(false);
        jToggleButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/htsquirrel/gui/images/match_type_off.png")));
        jToggleButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/htsquirrel/gui/images/period_on.png")));
        jToggleButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/htsquirrel/gui/images/arena_off.png")));
        hideFilters();
        panelPeriod.setVisible(true);
    }//GEN-LAST:event_jToggleButton2ActionPerformed

    private void buttonCalculateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCalculateActionPerformed
        try {
            Connection db = createDatabaseConnection();
            if ("total_team_score".equals(getMode())) {
                showTotalTeamScore(db);
            }
            db.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MatchFilter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MatchFilter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MatchFilter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_buttonCalculateActionPerformed

    private void jToggleButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton3ActionPerformed
        jToggleButton1.setSelected(false);
        jToggleButton2.setSelected(false);
        jToggleButton3.setSelected(true);
        jToggleButton4.setSelected(false);
        jToggleButton5.setSelected(false);
        jToggleButton6.setSelected(false);
        jToggleButton7.setSelected(false);
        jToggleButton8.setSelected(false);
        jToggleButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/htsquirrel/gui/images/match_type_off.png")));
        jToggleButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/htsquirrel/gui/images/period_off.png")));
        jToggleButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/htsquirrel/gui/images/arena_on.png")));
        hideFilters();
        panelArena.setVisible(true);
    }//GEN-LAST:event_jToggleButton3ActionPerformed

    private void hideFilters() {
        Component[] filters = panelFilters.getComponents();
        for (Component filter : filters) {
            filter.setVisible(false);
        }
    }
    
    public void resetMatchFilter() {
        panelMatchType.resetMatchType();
        panelPeriod.resetPeriod();
        panelArena.resetArena();
        Translations translations = new Translations();
        Properties properties = null;
        try {
            properties = translations.getTranslations(getLanguage());
            buttonReset.setText(properties.getProperty("match_filter_reset"));
            buttonCalculate.setText(properties.getProperty("match_filter_calculate"));
        } catch (IOException ex) {
            Logger.getLogger(MatchFilter.class.getName()).log(Level.SEVERE, null, ex);
        }
        hideFilters();
        panelMatchType.setVisible(true);
        jToggleButton1.setSelected(true);
        jToggleButton2.setSelected(false);
        jToggleButton3.setSelected(false);
        jToggleButton4.setSelected(false);
        jToggleButton5.setSelected(false);
        jToggleButton6.setSelected(false);
        jToggleButton7.setSelected(false);
        jToggleButton8.setSelected(false);
        jToggleButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/htsquirrel/gui/images/match_type_on.png")));
        jToggleButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/htsquirrel/gui/images/period_off.png")));
        jToggleButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/htsquirrel/gui/images/arena_off.png")));
        jToggleButton1.requestFocus(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCalculate;
    private javax.swing.JButton buttonReset;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JToggleButton jToggleButton3;
    private javax.swing.JToggleButton jToggleButton4;
    private javax.swing.JToggleButton jToggleButton5;
    private javax.swing.JToggleButton jToggleButton6;
    private javax.swing.JToggleButton jToggleButton7;
    private javax.swing.JToggleButton jToggleButton8;
    private htsquirrel.gui.pages.matchfilter.Arena panelArena;
    private javax.swing.JPanel panelButtons;
    private javax.swing.JPanel panelFilters;
    private htsquirrel.gui.pages.matchfilter.Formation panelFormation;
    private javax.swing.JPanel panelIcons;
    private javax.swing.JPanel panelLeft;
    private htsquirrel.gui.pages.matchfilter.MatchType panelMatchType;
    private htsquirrel.gui.pages.matchfilter.Period panelPeriod;
    private javax.swing.JPanel panelRight;
    // End of variables declaration//GEN-END:variables
}
