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
public class MatchType extends javax.swing.JPanel {

    /**
     * Creates new form MatchType
     */
    public MatchType() {
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
        buttonCompetitions = new javax.swing.JToggleButton();
        panelRight = new javax.swing.JPanel();
        buttonFriendlies = new javax.swing.JToggleButton();
        panelBottom = new javax.swing.JPanel();
        scrollPane = new javax.swing.JScrollPane();
        panelBase = new javax.swing.JPanel();
        panelCompetitions = new htsquirrel.gui.pages.matchfilter.MatchTypeCompetitions();
        panelFriendlies = new htsquirrel.gui.pages.matchfilter.MatchTypeFriendlies();

        setLayout(new java.awt.GridBagLayout());

        panelTop.setMaximumSize(new java.awt.Dimension(32767, 50));
        panelTop.setMinimumSize(new java.awt.Dimension(100, 50));
        panelTop.setPreferredSize(new java.awt.Dimension(400, 50));
        panelTop.setLayout(new java.awt.GridLayout(1, 0));

        panelLeft.setLayout(new java.awt.GridBagLayout());

        buttonCompetitions.setSelected(true);
        buttonCompetitions.setText("Competitions");
        buttonCompetitions.setMaximumSize(new java.awt.Dimension(180, 27));
        buttonCompetitions.setMinimumSize(new java.awt.Dimension(180, 27));
        buttonCompetitions.setPreferredSize(new java.awt.Dimension(180, 27));
        buttonCompetitions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCompetitionsActionPerformed(evt);
            }
        });
        panelLeft.add(buttonCompetitions, new java.awt.GridBagConstraints());

        panelTop.add(panelLeft);

        panelRight.setLayout(new java.awt.GridBagLayout());

        buttonFriendlies.setText("Friendlies");
        buttonFriendlies.setMaximumSize(new java.awt.Dimension(180, 27));
        buttonFriendlies.setMinimumSize(new java.awt.Dimension(180, 27));
        buttonFriendlies.setPreferredSize(new java.awt.Dimension(180, 27));
        buttonFriendlies.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonFriendliesActionPerformed(evt);
            }
        });
        panelRight.add(buttonFriendlies, new java.awt.GridBagConstraints());

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
        panelBase.add(panelCompetitions, "card2");
        panelBase.add(panelFriendlies, "card3");

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

    private void buttonCompetitionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCompetitionsActionPerformed
        buttonCompetitions.setSelected(true);
        buttonFriendlies.setSelected(false);
        panelCompetitions.setVisible(true);
        panelFriendlies.setVisible(false);
    }//GEN-LAST:event_buttonCompetitionsActionPerformed

    private void buttonFriendliesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonFriendliesActionPerformed
        buttonCompetitions.setSelected(false);
        buttonFriendlies.setSelected(true);
        panelCompetitions.setVisible(false);
        panelFriendlies.setVisible(true);
    }//GEN-LAST:event_buttonFriendliesActionPerformed

    public void resetMatchType() {
        panelCompetitions.resetMatchTypeCompetitions();
        panelFriendlies.resetMatchTypeFriendlies();
        panelCompetitions.setVisible(true);
        panelFriendlies.setVisible(false);
        buttonCompetitions.setSelected(true);
        buttonFriendlies.setSelected(false);
        Translations translations = new Translations();
        Properties properties = null;
        try {
            properties = translations.getTranslations(getLanguage());
            buttonCompetitions.setText(properties.getProperty("match_type_button_competitions"));
            buttonFriendlies.setText(properties.getProperty("match_type_button_friendlies"));
        } catch (IOException ex) {
            Logger.getLogger(MatchType.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton buttonCompetitions;
    private javax.swing.JToggleButton buttonFriendlies;
    private javax.swing.JPanel panelBase;
    private javax.swing.JPanel panelBottom;
    private htsquirrel.gui.pages.matchfilter.MatchTypeCompetitions panelCompetitions;
    private htsquirrel.gui.pages.matchfilter.MatchTypeFriendlies panelFriendlies;
    private javax.swing.JPanel panelLeft;
    private javax.swing.JPanel panelRight;
    private javax.swing.JPanel panelTop;
    private javax.swing.JScrollPane scrollPane;
    // End of variables declaration//GEN-END:variables
}
