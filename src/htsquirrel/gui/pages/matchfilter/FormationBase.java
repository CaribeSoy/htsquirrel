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
import javax.swing.border.EtchedBorder;

/**
 *
 * @author Aleksandar Cvetković <arcvetkovic@gmail.com>
 */
public class FormationBase extends javax.swing.JPanel {

    /**
     * Creates new form FormationBase
     */
    public FormationBase() {
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

        checkBoxAllFormations = new javax.swing.JCheckBox();
        panelFormations = new javax.swing.JPanel();
        panelBasic = new javax.swing.JPanel();
        checkBox550 = new javax.swing.JCheckBox();
        checkBox541 = new javax.swing.JCheckBox();
        checkBox532 = new javax.swing.JCheckBox();
        checkBox523 = new javax.swing.JCheckBox();
        checkBox451 = new javax.swing.JCheckBox();
        checkBox442 = new javax.swing.JCheckBox();
        checkBox433 = new javax.swing.JCheckBox();
        checkBox352 = new javax.swing.JCheckBox();
        checkBox343 = new javax.swing.JCheckBox();
        checkBox253 = new javax.swing.JCheckBox();
        checkBoxOther = new javax.swing.JCheckBox();
        checkBoxSpecific = new javax.swing.JCheckBox();
        textFieldSpecific = new javax.swing.JFormattedTextField();

        checkBoxAllFormations.setText("All formations");

        panelFormations.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Formations"));

        panelBasic.setLayout(new java.awt.GridLayout(5, 2, 0, 6));

        checkBox550.setText("5-5-0");
        panelBasic.add(checkBox550);

        checkBox541.setText("5-4-1");
        panelBasic.add(checkBox541);

        checkBox532.setText("5-3-2");
        panelBasic.add(checkBox532);

        checkBox523.setText("5-2-3");
        panelBasic.add(checkBox523);

        checkBox451.setText("4-5-1");
        panelBasic.add(checkBox451);

        checkBox442.setText("4-4-2");
        panelBasic.add(checkBox442);

        checkBox433.setText("4-3-3");
        panelBasic.add(checkBox433);

        checkBox352.setText("3-5-2");
        panelBasic.add(checkBox352);

        checkBox343.setText("3-4-3");
        panelBasic.add(checkBox343);

        checkBox253.setText("2-5-3");
        panelBasic.add(checkBox253);

        checkBoxOther.setText("Other");

        checkBoxSpecific.setText("Specific:");

        try {
            textFieldSpecific.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#-#-#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        textFieldSpecific.setText("0-0-0");

        javax.swing.GroupLayout panelFormationsLayout = new javax.swing.GroupLayout(panelFormations);
        panelFormations.setLayout(panelFormationsLayout);
        panelFormationsLayout.setHorizontalGroup(
            panelFormationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFormationsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelFormationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelBasic, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelFormationsLayout.createSequentialGroup()
                        .addGroup(panelFormationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(checkBoxOther)
                            .addGroup(panelFormationsLayout.createSequentialGroup()
                                .addComponent(checkBoxSpecific)
                                .addGap(18, 18, 18)
                                .addComponent(textFieldSpecific, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 182, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelFormationsLayout.setVerticalGroup(
            panelFormationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFormationsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelBasic, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(checkBoxOther)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelFormationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkBoxSpecific)
                    .addComponent(textFieldSpecific, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                        .addComponent(checkBoxAllFormations)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(panelFormations, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(checkBoxAllFormations)
                .addGap(18, 18, 18)
                .addComponent(panelFormations, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    public void resetFormationBase() {
        checkBoxAllFormations.setSelected(true);
        checkBox550.setSelected(true);
        checkBox541.setSelected(true);
        checkBox532.setSelected(true);
        checkBox523.setSelected(true);
        checkBox451.setSelected(true);
        checkBox442.setSelected(true);
        checkBox433.setSelected(true);
        checkBox352.setSelected(true);
        checkBox343.setSelected(true);
        checkBox253.setSelected(true);
        checkBoxOther.setSelected(true);
        checkBoxSpecific.setSelected(false);
        textFieldSpecific.setText("0-0-0");
        Translations translations = new Translations();
        Properties properties = null;
        try {
            properties = translations.getTranslations(getLanguage());
            checkBoxAllFormations.setText(properties.getProperty("formation_all_formations"));
            panelFormations.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED), properties.getProperty("formation_panel_formations")));
            checkBoxOther.setText(properties.getProperty("formation_other"));
            checkBoxSpecific.setText(properties.getProperty("formation_specific"));
        } catch (IOException ex) {
            Logger.getLogger(FormationBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox checkBox253;
    private javax.swing.JCheckBox checkBox343;
    private javax.swing.JCheckBox checkBox352;
    private javax.swing.JCheckBox checkBox433;
    private javax.swing.JCheckBox checkBox442;
    private javax.swing.JCheckBox checkBox451;
    private javax.swing.JCheckBox checkBox523;
    private javax.swing.JCheckBox checkBox532;
    private javax.swing.JCheckBox checkBox541;
    private javax.swing.JCheckBox checkBox550;
    private javax.swing.JCheckBox checkBoxAllFormations;
    private javax.swing.JCheckBox checkBoxOther;
    private javax.swing.JCheckBox checkBoxSpecific;
    private javax.swing.JPanel panelBasic;
    private javax.swing.JPanel panelFormations;
    private javax.swing.JFormattedTextField textFieldSpecific;
    // End of variables declaration//GEN-END:variables
}
