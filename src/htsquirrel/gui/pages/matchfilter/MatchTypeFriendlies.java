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

import javax.swing.JCheckBox;

/**
 *
 * @author Aleksandar Cvetković <arcvetkovic@gmail.com>
 */
public class MatchTypeFriendlies extends javax.swing.JPanel {

    /**
     * Creates new form MatchTypeFriendlies
     */
    public MatchTypeFriendlies() {
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

        checkBoxFriendlies = new javax.swing.JCheckBox();
        panelFriendlies = new javax.swing.JPanel();
        checkBoxFriendlyNormal = new javax.swing.JCheckBox();
        checkBoxFriendlyCup = new javax.swing.JCheckBox();
        checkBoxIntFriendlyNormal = new javax.swing.JCheckBox();
        checkBoxIntFriendlyCup = new javax.swing.JCheckBox();

        setBorder(null);

        checkBoxFriendlies.setText("All friendlies");
        checkBoxFriendlies.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoxFriendliesActionPerformed(evt);
            }
        });

        panelFriendlies.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Friendlies"));

        checkBoxFriendlyNormal.setText("Friendly (normal rules)");
        checkBoxFriendlyNormal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoxFriendlyNormalActionPerformed(evt);
            }
        });

        checkBoxFriendlyCup.setText("Friendly (cup rules)");
        checkBoxFriendlyCup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoxFriendlyCupActionPerformed(evt);
            }
        });

        checkBoxIntFriendlyNormal.setText("International friendly (normal rules)");
        checkBoxIntFriendlyNormal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoxIntFriendlyNormalActionPerformed(evt);
            }
        });

        checkBoxIntFriendlyCup.setText("International friendly (cup rules)");
        checkBoxIntFriendlyCup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoxIntFriendlyCupActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelFriendliesLayout = new javax.swing.GroupLayout(panelFriendlies);
        panelFriendlies.setLayout(panelFriendliesLayout);
        panelFriendliesLayout.setHorizontalGroup(
            panelFriendliesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFriendliesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelFriendliesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkBoxFriendlyNormal)
                    .addComponent(checkBoxFriendlyCup)
                    .addComponent(checkBoxIntFriendlyNormal)
                    .addComponent(checkBoxIntFriendlyCup))
                .addContainerGap(127, Short.MAX_VALUE))
        );
        panelFriendliesLayout.setVerticalGroup(
            panelFriendliesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFriendliesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(checkBoxFriendlyNormal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(checkBoxFriendlyCup)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(checkBoxIntFriendlyNormal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(checkBoxIntFriendlyCup)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(checkBoxFriendlies)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(panelFriendlies, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(checkBoxFriendlies)
                .addGap(18, 18, 18)
                .addComponent(panelFriendlies, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void checkBoxFriendliesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBoxFriendliesActionPerformed
        if (checkBoxFriendlies.isSelected()) {
            checkBoxFriendlyNormal.setSelected(true);
            checkBoxFriendlyCup.setSelected(true);
            checkBoxIntFriendlyNormal.setSelected(true);
            checkBoxIntFriendlyCup.setSelected(true);
        } else {
            checkBoxFriendlyNormal.setSelected(false);
            checkBoxFriendlyCup.setSelected(false);
            checkBoxIntFriendlyNormal.setSelected(false);
            checkBoxIntFriendlyCup.setSelected(false);
        }
    }//GEN-LAST:event_checkBoxFriendliesActionPerformed

    private void checkBoxFriendlyNormalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBoxFriendlyNormalActionPerformed
        if (allFriendliesSelected()) {
            checkBoxFriendlies.setSelected(true);
        } else {
            checkBoxFriendlies.setSelected(false);
        }
    }//GEN-LAST:event_checkBoxFriendlyNormalActionPerformed

    private void checkBoxFriendlyCupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBoxFriendlyCupActionPerformed
        if (allFriendliesSelected()) {
            checkBoxFriendlies.setSelected(true);
        } else {
            checkBoxFriendlies.setSelected(false);
        }
    }//GEN-LAST:event_checkBoxFriendlyCupActionPerformed

    private void checkBoxIntFriendlyNormalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBoxIntFriendlyNormalActionPerformed
        if (allFriendliesSelected()) {
            checkBoxFriendlies.setSelected(true);
        } else {
            checkBoxFriendlies.setSelected(false);
        }
    }//GEN-LAST:event_checkBoxIntFriendlyNormalActionPerformed

    private void checkBoxIntFriendlyCupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBoxIntFriendlyCupActionPerformed
        if (allFriendliesSelected()) {
            checkBoxFriendlies.setSelected(true);
        } else {
            checkBoxFriendlies.setSelected(false);
        }
    }//GEN-LAST:event_checkBoxIntFriendlyCupActionPerformed

    public JCheckBox getCheckBoxFriendlies() {
        return checkBoxFriendlies;
    }

    public JCheckBox getCheckBoxFriendlyCup() {
        return checkBoxFriendlyCup;
    }

    public JCheckBox getCheckBoxFriendlyNormal() {
        return checkBoxFriendlyNormal;
    }

    public JCheckBox getCheckBoxIntFriendlyCup() {
        return checkBoxIntFriendlyCup;
    }

    public JCheckBox getCheckBoxIntFriendlyNormal() {
        return checkBoxIntFriendlyNormal;
    }

    private boolean allFriendliesSelected() {
        boolean result = false;
        result = checkBoxFriendlyNormal.isSelected() &&
                checkBoxFriendlyCup.isSelected() &&
                checkBoxIntFriendlyNormal.isSelected() &&
                checkBoxIntFriendlyCup.isSelected();
        return result;
    }

    public void resetMatchTypeFriendlies() {
        checkBoxFriendlies.setSelected(false);
        checkBoxFriendlyNormal.setSelected(false);
        checkBoxFriendlyCup.setSelected(false);
        checkBoxIntFriendlyNormal.setSelected(false);
        checkBoxIntFriendlyCup.setSelected(false);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox checkBoxFriendlies;
    private javax.swing.JCheckBox checkBoxFriendlyCup;
    private javax.swing.JCheckBox checkBoxFriendlyNormal;
    private javax.swing.JCheckBox checkBoxIntFriendlyCup;
    private javax.swing.JCheckBox checkBoxIntFriendlyNormal;
    private javax.swing.JPanel panelFriendlies;
    // End of variables declaration//GEN-END:variables
}
