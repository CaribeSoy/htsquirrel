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
import htsquirrel.translations.Translations;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Aleksandar Cvetković <arcvetkovic@gmail.com>
 */
public class Formation extends javax.swing.JPanel {

    /**
     * Creates new form Formation
     */
    public Formation() {
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

        panelTop = new javax.swing.JPanel();
        panelLeft = new javax.swing.JPanel();
        buttonTeam = new javax.swing.JToggleButton();
        panelRight = new javax.swing.JPanel();
        buttonOpponent = new javax.swing.JToggleButton();
        panelBottom = new javax.swing.JPanel();
        scrollPane = new javax.swing.JScrollPane();
        panelBase = new javax.swing.JPanel();
        formationTeam = new htsquirrel.gui.pages.matchfilter.FormationBase();
        formationOpponent = new htsquirrel.gui.pages.matchfilter.FormationBase();

        setLayout(new java.awt.GridBagLayout());

        panelTop.setMaximumSize(new java.awt.Dimension(32767, 50));
        panelTop.setMinimumSize(new java.awt.Dimension(100, 50));
        panelTop.setPreferredSize(new java.awt.Dimension(400, 50));
        panelTop.setLayout(new java.awt.GridLayout(1, 0));

        panelLeft.setLayout(new java.awt.GridBagLayout());

        buttonTeam.setSelected(true);
        buttonTeam.setText("Team");
        buttonTeam.setMaximumSize(new java.awt.Dimension(180, 27));
        buttonTeam.setMinimumSize(new java.awt.Dimension(180, 27));
        buttonTeam.setPreferredSize(new java.awt.Dimension(180, 27));
        buttonTeam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonTeamActionPerformed(evt);
            }
        });
        panelLeft.add(buttonTeam, new java.awt.GridBagConstraints());

        panelTop.add(panelLeft);

        panelRight.setLayout(new java.awt.GridBagLayout());

        buttonOpponent.setText("Opponent");
        buttonOpponent.setMaximumSize(new java.awt.Dimension(180, 27));
        buttonOpponent.setMinimumSize(new java.awt.Dimension(180, 27));
        buttonOpponent.setPreferredSize(new java.awt.Dimension(180, 27));
        buttonOpponent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonOpponentActionPerformed(evt);
            }
        });
        panelRight.add(buttonOpponent, new java.awt.GridBagConstraints());

        panelTop.add(panelRight);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        add(panelTop, gridBagConstraints);

        panelBottom.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        scrollPane.setBorder(null);

        panelBase.setLayout(new java.awt.CardLayout());
        panelBase.add(formationTeam, "card2");
        panelBase.add(formationOpponent, "card3");

        scrollPane.setViewportView(panelBase);

        javax.swing.GroupLayout panelBottomLayout = new javax.swing.GroupLayout(panelBottom);
        panelBottom.setLayout(panelBottomLayout);
        panelBottomLayout.setHorizontalGroup(
            panelBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 396, Short.MAX_VALUE)
        );
        panelBottomLayout.setVerticalGroup(
            panelBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(panelBottom, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonTeamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTeamActionPerformed
        buttonTeam.setSelected(true);
        buttonOpponent.setSelected(false);
        formationTeam.setVisible(true);
        formationOpponent.setVisible(false);
    }//GEN-LAST:event_buttonTeamActionPerformed

    private void buttonOpponentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonOpponentActionPerformed
        buttonTeam.setSelected(false);
        buttonOpponent.setSelected(true);
        formationTeam.setVisible(false);
        formationOpponent.setVisible(true);
    }//GEN-LAST:event_buttonOpponentActionPerformed

    public void resetFormation() {
        formationTeam.resetFormationBase();
        formationOpponent.resetFormationBase();
        Translations translations = new Translations();
        Properties properties = null;
        try {
            properties = translations.getTranslations(getLanguage());
            buttonTeam.setText(properties.getProperty("formation_team"));
            buttonOpponent.setText(properties.getProperty("formation_opponent"));
        } catch (IOException ex) {
            Logger.getLogger(Formation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton buttonOpponent;
    private javax.swing.JToggleButton buttonTeam;
    private htsquirrel.gui.pages.matchfilter.FormationBase formationOpponent;
    private htsquirrel.gui.pages.matchfilter.FormationBase formationTeam;
    private javax.swing.JPanel panelBase;
    private javax.swing.JPanel panelBottom;
    private javax.swing.JPanel panelLeft;
    private javax.swing.JPanel panelRight;
    private javax.swing.JPanel panelTop;
    private javax.swing.JScrollPane scrollPane;
    // End of variables declaration//GEN-END:variables
}
