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
import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.border.EtchedBorder;

/**
 *
 * @author Aleksandar Cvetković <arcvetkovic@gmail.com>
 */
public class MatchTypeCompetitions extends javax.swing.JPanel {

    /**
     * Creates new form MatchTypeCompetitions
     */
    public MatchTypeCompetitions() {
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

        checkBoxCompetitions = new javax.swing.JCheckBox();
        panelLeague = new javax.swing.JPanel();
        checkBoxLeague = new javax.swing.JCheckBox();
        checkBoxQualification = new javax.swing.JCheckBox();
        panelNationalCup = new javax.swing.JPanel();
        checkBoxNationalCup = new javax.swing.JCheckBox();
        checkBoxNationalEmerald = new javax.swing.JCheckBox();
        checkBoxNationalRuby = new javax.swing.JCheckBox();
        checkBoxNationalSapphire = new javax.swing.JCheckBox();
        checkBoxNationalConsolation = new javax.swing.JCheckBox();
        panelDivisionalCup = new javax.swing.JPanel();
        checkBoxDivisionalCup = new javax.swing.JCheckBox();
        checkBoxDivisionalEmerald = new javax.swing.JCheckBox();
        checkBoxDivisionalRuby = new javax.swing.JCheckBox();
        checkBoxDivisionalSapphire = new javax.swing.JCheckBox();
        checkBoxDivisionalConsolation = new javax.swing.JCheckBox();
        labelLevels = new javax.swing.JLabel();
        checkBoxLevel7 = new javax.swing.JCheckBox();
        checkBoxLevel8 = new javax.swing.JCheckBox();
        checkBoxLevel9 = new javax.swing.JCheckBox();
        panelHattrickMasters = new javax.swing.JPanel();
        checkBoxHattrickMasters = new javax.swing.JCheckBox();

        setBorder(null);

        checkBoxCompetitions.setSelected(true);
        checkBoxCompetitions.setText("All competitions");
        checkBoxCompetitions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoxCompetitionsActionPerformed(evt);
            }
        });

        panelLeague.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "League"));

        checkBoxLeague.setSelected(true);
        checkBoxLeague.setText("League");
        checkBoxLeague.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoxLeagueActionPerformed(evt);
            }
        });

        checkBoxQualification.setSelected(true);
        checkBoxQualification.setText("Qualification");
        checkBoxQualification.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoxQualificationActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelLeagueLayout = new javax.swing.GroupLayout(panelLeague);
        panelLeague.setLayout(panelLeagueLayout);
        panelLeagueLayout.setHorizontalGroup(
            panelLeagueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLeagueLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLeagueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkBoxLeague)
                    .addComponent(checkBoxQualification))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelLeagueLayout.setVerticalGroup(
            panelLeagueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLeagueLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(checkBoxLeague)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(checkBoxQualification)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelNationalCup.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "National Cup"));

        checkBoxNationalCup.setSelected(true);
        checkBoxNationalCup.setText("National Cup");
        checkBoxNationalCup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoxNationalCupActionPerformed(evt);
            }
        });

        checkBoxNationalEmerald.setSelected(true);
        checkBoxNationalEmerald.setText("Emerald Challenger Cup");
        checkBoxNationalEmerald.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoxNationalEmeraldActionPerformed(evt);
            }
        });

        checkBoxNationalRuby.setSelected(true);
        checkBoxNationalRuby.setText("Ruby Challenger Cup");
        checkBoxNationalRuby.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoxNationalRubyActionPerformed(evt);
            }
        });

        checkBoxNationalSapphire.setSelected(true);
        checkBoxNationalSapphire.setText("Sapphire Challenger Cup");
        checkBoxNationalSapphire.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoxNationalSapphireActionPerformed(evt);
            }
        });

        checkBoxNationalConsolation.setSelected(true);
        checkBoxNationalConsolation.setText("Consolation Cup");
        checkBoxNationalConsolation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoxNationalConsolationActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelNationalCupLayout = new javax.swing.GroupLayout(panelNationalCup);
        panelNationalCup.setLayout(panelNationalCupLayout);
        panelNationalCupLayout.setHorizontalGroup(
            panelNationalCupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelNationalCupLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelNationalCupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkBoxNationalCup)
                    .addComponent(checkBoxNationalEmerald)
                    .addComponent(checkBoxNationalRuby)
                    .addComponent(checkBoxNationalSapphire)
                    .addComponent(checkBoxNationalConsolation))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelNationalCupLayout.setVerticalGroup(
            panelNationalCupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelNationalCupLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(checkBoxNationalCup)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(checkBoxNationalEmerald)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(checkBoxNationalRuby)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(checkBoxNationalSapphire)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(checkBoxNationalConsolation)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelDivisionalCup.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Divisional Cup"));

        checkBoxDivisionalCup.setSelected(true);
        checkBoxDivisionalCup.setText("Divisional Cup");
        checkBoxDivisionalCup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoxDivisionalCupActionPerformed(evt);
            }
        });

        checkBoxDivisionalEmerald.setSelected(true);
        checkBoxDivisionalEmerald.setText("Emerald Challenger Cup");
        checkBoxDivisionalEmerald.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoxDivisionalEmeraldActionPerformed(evt);
            }
        });

        checkBoxDivisionalRuby.setSelected(true);
        checkBoxDivisionalRuby.setText("Ruby Challenger Cup");
        checkBoxDivisionalRuby.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoxDivisionalRubyActionPerformed(evt);
            }
        });

        checkBoxDivisionalSapphire.setSelected(true);
        checkBoxDivisionalSapphire.setText("Sapphire Challenger Cup");
        checkBoxDivisionalSapphire.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoxDivisionalSapphireActionPerformed(evt);
            }
        });

        checkBoxDivisionalConsolation.setSelected(true);
        checkBoxDivisionalConsolation.setText("Consolation Cup");
        checkBoxDivisionalConsolation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoxDivisionalConsolationActionPerformed(evt);
            }
        });

        labelLevels.setText("Divisional Cup levels:");

        checkBoxLevel7.setSelected(true);
        checkBoxLevel7.setText("7");
        checkBoxLevel7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoxLevel7ActionPerformed(evt);
            }
        });

        checkBoxLevel8.setSelected(true);
        checkBoxLevel8.setText("8");
        checkBoxLevel8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoxLevel8ActionPerformed(evt);
            }
        });

        checkBoxLevel9.setSelected(true);
        checkBoxLevel9.setText("9");
        checkBoxLevel9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoxLevel9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelDivisionalCupLayout = new javax.swing.GroupLayout(panelDivisionalCup);
        panelDivisionalCup.setLayout(panelDivisionalCupLayout);
        panelDivisionalCupLayout.setHorizontalGroup(
            panelDivisionalCupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDivisionalCupLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDivisionalCupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDivisionalCupLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(labelLevels)
                        .addGap(18, 18, 18)
                        .addComponent(checkBoxLevel7)
                        .addGap(18, 18, 18)
                        .addComponent(checkBoxLevel8)
                        .addGap(18, 18, 18)
                        .addComponent(checkBoxLevel9))
                    .addComponent(checkBoxDivisionalCup)
                    .addComponent(checkBoxDivisionalEmerald)
                    .addComponent(checkBoxDivisionalSapphire)
                    .addComponent(checkBoxDivisionalConsolation)
                    .addComponent(checkBoxDivisionalRuby))
                .addContainerGap(75, Short.MAX_VALUE))
        );
        panelDivisionalCupLayout.setVerticalGroup(
            panelDivisionalCupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDivisionalCupLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(checkBoxDivisionalCup)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(checkBoxDivisionalEmerald)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(checkBoxDivisionalRuby)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(checkBoxDivisionalSapphire)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(checkBoxDivisionalConsolation)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDivisionalCupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelLevels)
                    .addComponent(checkBoxLevel7)
                    .addComponent(checkBoxLevel8)
                    .addComponent(checkBoxLevel9))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelHattrickMasters.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Hattrick Masters"));

        checkBoxHattrickMasters.setSelected(true);
        checkBoxHattrickMasters.setText("Hattrick Masters");
        checkBoxHattrickMasters.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoxHattrickMastersActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelHattrickMastersLayout = new javax.swing.GroupLayout(panelHattrickMasters);
        panelHattrickMasters.setLayout(panelHattrickMastersLayout);
        panelHattrickMastersLayout.setHorizontalGroup(
            panelHattrickMastersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHattrickMastersLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(checkBoxHattrickMasters)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelHattrickMastersLayout.setVerticalGroup(
            panelHattrickMastersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHattrickMastersLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(checkBoxHattrickMasters)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelLeague, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelNationalCup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelDivisionalCup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(checkBoxCompetitions)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(panelHattrickMasters, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(checkBoxCompetitions)
                .addGap(18, 18, 18)
                .addComponent(panelLeague, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panelNationalCup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panelDivisionalCup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panelHattrickMasters, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void checkBoxCompetitionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBoxCompetitionsActionPerformed
        if (checkBoxCompetitions.isSelected()) {
            checkBoxLeague.setSelected(true);
            checkBoxQualification.setSelected(true);
            checkBoxNationalCup.setSelected(true);
            checkBoxNationalEmerald.setSelected(true);
            checkBoxNationalRuby.setSelected(true);
            checkBoxNationalSapphire.setSelected(true);
            checkBoxNationalConsolation.setSelected(true);
            checkBoxDivisionalCup.setSelected(true);
            checkBoxDivisionalEmerald.setSelected(true);
            checkBoxDivisionalRuby.setSelected(true);
            checkBoxDivisionalSapphire.setSelected(true);
            checkBoxDivisionalConsolation.setSelected(true);
            checkBoxLevel7.setSelected(true);
            checkBoxLevel8.setSelected(true);
            checkBoxLevel9.setSelected(true);
            checkBoxHattrickMasters.setSelected(true);
        } else {
            checkBoxLeague.setSelected(false);
            checkBoxQualification.setSelected(false);
            checkBoxNationalCup.setSelected(false);
            checkBoxNationalEmerald.setSelected(false);
            checkBoxNationalRuby.setSelected(false);
            checkBoxNationalSapphire.setSelected(false);
            checkBoxNationalConsolation.setSelected(false);
            checkBoxDivisionalCup.setSelected(false);
            checkBoxDivisionalEmerald.setSelected(false);
            checkBoxDivisionalRuby.setSelected(false);
            checkBoxDivisionalSapphire.setSelected(false);
            checkBoxDivisionalConsolation.setSelected(false);
            checkBoxLevel7.setSelected(false);
            checkBoxLevel8.setSelected(false);
            checkBoxLevel9.setSelected(false);
            checkBoxHattrickMasters.setSelected(false);
        }
    }//GEN-LAST:event_checkBoxCompetitionsActionPerformed

    private void checkBoxLeagueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBoxLeagueActionPerformed
        if (allCompetitionsSelected()) {
            checkBoxCompetitions.setSelected(true);
        } else {
            checkBoxCompetitions.setSelected(false);
        }
    }//GEN-LAST:event_checkBoxLeagueActionPerformed

    private void checkBoxQualificationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBoxQualificationActionPerformed
        if (allCompetitionsSelected()) {
            checkBoxCompetitions.setSelected(true);
        } else {
            checkBoxCompetitions.setSelected(false);
        }
    }//GEN-LAST:event_checkBoxQualificationActionPerformed

    private void checkBoxNationalCupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBoxNationalCupActionPerformed
        if (allCompetitionsSelected()) {
            checkBoxCompetitions.setSelected(true);
        } else {
            checkBoxCompetitions.setSelected(false);
        }
    }//GEN-LAST:event_checkBoxNationalCupActionPerformed

    private void checkBoxNationalEmeraldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBoxNationalEmeraldActionPerformed
        if (allCompetitionsSelected()) {
            checkBoxCompetitions.setSelected(true);
        } else {
            checkBoxCompetitions.setSelected(false);
        }
    }//GEN-LAST:event_checkBoxNationalEmeraldActionPerformed

    private void checkBoxNationalRubyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBoxNationalRubyActionPerformed
        if (allCompetitionsSelected()) {
            checkBoxCompetitions.setSelected(true);
        } else {
            checkBoxCompetitions.setSelected(false);
        }
    }//GEN-LAST:event_checkBoxNationalRubyActionPerformed

    private void checkBoxNationalSapphireActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBoxNationalSapphireActionPerformed
        if (allCompetitionsSelected()) {
            checkBoxCompetitions.setSelected(true);
        } else {
            checkBoxCompetitions.setSelected(false);
        }
    }//GEN-LAST:event_checkBoxNationalSapphireActionPerformed

    private void checkBoxNationalConsolationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBoxNationalConsolationActionPerformed
        if (allCompetitionsSelected()) {
            checkBoxCompetitions.setSelected(true);
        } else {
            checkBoxCompetitions.setSelected(false);
        }
    }//GEN-LAST:event_checkBoxNationalConsolationActionPerformed

    private void checkBoxDivisionalCupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBoxDivisionalCupActionPerformed
        if (allCompetitionsSelected()) {
            checkBoxCompetitions.setSelected(true);
        } else {
            checkBoxCompetitions.setSelected(false);
        }
    }//GEN-LAST:event_checkBoxDivisionalCupActionPerformed

    private void checkBoxDivisionalEmeraldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBoxDivisionalEmeraldActionPerformed
        if (allCompetitionsSelected()) {
            checkBoxCompetitions.setSelected(true);
        } else {
            checkBoxCompetitions.setSelected(false);
        }
    }//GEN-LAST:event_checkBoxDivisionalEmeraldActionPerformed

    private void checkBoxDivisionalRubyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBoxDivisionalRubyActionPerformed
        if (allCompetitionsSelected()) {
            checkBoxCompetitions.setSelected(true);
        } else {
            checkBoxCompetitions.setSelected(false);
        }
    }//GEN-LAST:event_checkBoxDivisionalRubyActionPerformed

    private void checkBoxDivisionalSapphireActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBoxDivisionalSapphireActionPerformed
        if (allCompetitionsSelected()) {
            checkBoxCompetitions.setSelected(true);
        } else {
            checkBoxCompetitions.setSelected(false);
        }
    }//GEN-LAST:event_checkBoxDivisionalSapphireActionPerformed

    private void checkBoxDivisionalConsolationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBoxDivisionalConsolationActionPerformed
        if (allCompetitionsSelected()) {
            checkBoxCompetitions.setSelected(true);
        } else {
            checkBoxCompetitions.setSelected(false);
        }
    }//GEN-LAST:event_checkBoxDivisionalConsolationActionPerformed

    private void checkBoxLevel7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBoxLevel7ActionPerformed
        if (allCompetitionsSelected()) {
            checkBoxCompetitions.setSelected(true);
        } else {
            checkBoxCompetitions.setSelected(false);
        }
    }//GEN-LAST:event_checkBoxLevel7ActionPerformed

    private void checkBoxLevel8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBoxLevel8ActionPerformed
        if (allCompetitionsSelected()) {
            checkBoxCompetitions.setSelected(true);
        } else {
            checkBoxCompetitions.setSelected(false);
        }
    }//GEN-LAST:event_checkBoxLevel8ActionPerformed

    private void checkBoxLevel9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBoxLevel9ActionPerformed
        if (allCompetitionsSelected()) {
            checkBoxCompetitions.setSelected(true);
        } else {
            checkBoxCompetitions.setSelected(false);
        }
    }//GEN-LAST:event_checkBoxLevel9ActionPerformed

    private void checkBoxHattrickMastersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBoxHattrickMastersActionPerformed
        if (allCompetitionsSelected()) {
            checkBoxCompetitions.setSelected(true);
        } else {
            checkBoxCompetitions.setSelected(false);
        }
    }//GEN-LAST:event_checkBoxHattrickMastersActionPerformed

    public JCheckBox getCheckBoxCompetitions() {
        return checkBoxCompetitions;
    }

    public JCheckBox getCheckBoxDivisionalConsolation() {
        return checkBoxDivisionalConsolation;
    }

    public JCheckBox getCheckBoxDivisionalCup() {
        return checkBoxDivisionalCup;
    }

    public JCheckBox getCheckBoxDivisionalEmerald() {
        return checkBoxDivisionalEmerald;
    }

    public JCheckBox getCheckBoxDivisionalRuby() {
        return checkBoxDivisionalRuby;
    }

    public JCheckBox getCheckBoxDivisionalSapphire() {
        return checkBoxDivisionalSapphire;
    }

    public JCheckBox getCheckBoxHattrickMasters() {
        return checkBoxHattrickMasters;
    }

    public JCheckBox getCheckBoxLeague() {
        return checkBoxLeague;
    }

    public JCheckBox getCheckBoxLevel7() {
        return checkBoxLevel7;
    }

    public JCheckBox getCheckBoxLevel8() {
        return checkBoxLevel8;
    }

    public JCheckBox getCheckBoxLevel9() {
        return checkBoxLevel9;
    }

    public JCheckBox getCheckBoxNationalConsolation() {
        return checkBoxNationalConsolation;
    }

    public JCheckBox getCheckBoxNationalCup() {
        return checkBoxNationalCup;
    }

    public JCheckBox getCheckBoxNationalEmerald() {
        return checkBoxNationalEmerald;
    }

    public JCheckBox getCheckBoxNationalRuby() {
        return checkBoxNationalRuby;
    }

    public JCheckBox getCheckBoxNationalSapphire() {
        return checkBoxNationalSapphire;
    }

    public JCheckBox getCheckBoxQualification() {
        return checkBoxQualification;
    }

    private boolean allCompetitionsSelected() {
        boolean result = false;
        result = checkBoxLeague.isSelected() &&
                checkBoxQualification.isSelected() &&
                checkBoxNationalCup.isSelected() &&
                checkBoxNationalEmerald.isSelected() &&
                checkBoxNationalRuby.isSelected() &&
                checkBoxNationalSapphire.isSelected() &&
                checkBoxNationalConsolation.isSelected() &&
                checkBoxDivisionalCup.isSelected() &&
                checkBoxDivisionalEmerald.isSelected() &&
                checkBoxDivisionalRuby.isSelected() &&
                checkBoxDivisionalSapphire.isSelected() &&
                checkBoxDivisionalConsolation.isSelected() &&
                checkBoxLevel7.isSelected() &&
                checkBoxLevel8.isSelected() &&
                checkBoxLevel9.isSelected() &&
                checkBoxHattrickMasters.isSelected();
        return result;
    }

    public void resetMatchTypeCompetitions() {
        checkBoxCompetitions.setSelected(true);
        checkBoxLeague.setSelected(true);
        checkBoxQualification.setSelected(true);
        checkBoxNationalCup.setSelected(true);
        checkBoxNationalEmerald.setSelected(true);
        checkBoxNationalRuby.setSelected(true);
        checkBoxNationalSapphire.setSelected(true);
        checkBoxNationalConsolation.setSelected(true);
        checkBoxDivisionalCup.setSelected(true);
        checkBoxDivisionalEmerald.setSelected(true);
        checkBoxDivisionalRuby.setSelected(true);
        checkBoxDivisionalSapphire.setSelected(true);
        checkBoxDivisionalConsolation.setSelected(true);
        checkBoxLevel7.setSelected(true);
        checkBoxLevel8.setSelected(true);
        checkBoxLevel9.setSelected(true);
        checkBoxHattrickMasters.setSelected(true);
        Translations translations = new Translations();
        Properties properties = null;
        try {
            properties = translations.getTranslations(getLanguage());
            checkBoxCompetitions.setText(properties.getProperty("match_type_competitions"));
            panelLeague.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED), properties.getProperty("match_type_panel_league")));
            checkBoxLeague.setText(properties.getProperty("match_type_league"));
            checkBoxQualification.setText(properties.getProperty("match_type_qualification"));
            panelNationalCup.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED), properties.getProperty("match_type_panel_national_cup")));
            checkBoxNationalCup.setText(properties.getProperty("match_type_national_cup"));
            checkBoxNationalEmerald.setText(properties.getProperty("match_type_national_emerald"));
            checkBoxNationalRuby.setText(properties.getProperty("match_type_national_ruby"));
            checkBoxNationalSapphire.setText(properties.getProperty("match_type_national_sapphire"));
            checkBoxNationalConsolation.setText(properties.getProperty("match_type_national_consolation"));
            panelDivisionalCup.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED), properties.getProperty("match_type_panel_divisional_cup")));
            checkBoxDivisionalCup.setText(properties.getProperty("match_type_divisional_cup"));
            checkBoxDivisionalEmerald.setText(properties.getProperty("match_type_divisional_emerald"));
            checkBoxDivisionalRuby.setText(properties.getProperty("match_type_divisional_ruby"));
            checkBoxDivisionalSapphire.setText(properties.getProperty("match_type_divisional_sapphire"));
            checkBoxDivisionalConsolation.setText(properties.getProperty("match_type_divisional_consolation"));
            labelLevels.setText(properties.getProperty("match_type_divisional_levels"));
            panelHattrickMasters.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED), properties.getProperty("match_type_panel_hattrick_masters")));
            checkBoxHattrickMasters.setText(properties.getProperty("match_type_hattrick_masters"));
        } catch (IOException ex) {
            Logger.getLogger(MatchTypeCompetitions.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox checkBoxCompetitions;
    private javax.swing.JCheckBox checkBoxDivisionalConsolation;
    private javax.swing.JCheckBox checkBoxDivisionalCup;
    private javax.swing.JCheckBox checkBoxDivisionalEmerald;
    private javax.swing.JCheckBox checkBoxDivisionalRuby;
    private javax.swing.JCheckBox checkBoxDivisionalSapphire;
    private javax.swing.JCheckBox checkBoxHattrickMasters;
    private javax.swing.JCheckBox checkBoxLeague;
    private javax.swing.JCheckBox checkBoxLevel7;
    private javax.swing.JCheckBox checkBoxLevel8;
    private javax.swing.JCheckBox checkBoxLevel9;
    private javax.swing.JCheckBox checkBoxNationalConsolation;
    private javax.swing.JCheckBox checkBoxNationalCup;
    private javax.swing.JCheckBox checkBoxNationalEmerald;
    private javax.swing.JCheckBox checkBoxNationalRuby;
    private javax.swing.JCheckBox checkBoxNationalSapphire;
    private javax.swing.JCheckBox checkBoxQualification;
    private javax.swing.JLabel labelLevels;
    private javax.swing.JPanel panelDivisionalCup;
    private javax.swing.JPanel panelHattrickMasters;
    private javax.swing.JPanel panelLeague;
    private javax.swing.JPanel panelNationalCup;
    // End of variables declaration//GEN-END:variables
}
