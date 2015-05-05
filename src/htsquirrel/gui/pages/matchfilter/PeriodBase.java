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

/**
 *
 * @author Aleksandar Cvetković <arcvetkovic@gmail.com>
 */
public class PeriodBase extends javax.swing.JPanel {

    /**
     * Creates new form PeriodBase
     */
    public PeriodBase() {
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

        buttonGroupSeason = new javax.swing.ButtonGroup();
        buttonGroupLeague = new javax.swing.ButtonGroup();
        panelSeason = new javax.swing.JPanel();
        radioButtonSeason = new javax.swing.JRadioButton();
        labelFrom1 = new javax.swing.JLabel();
        comboBoxSeasonFrom = new javax.swing.JComboBox();
        labelTo1 = new javax.swing.JLabel();
        comboBoxSeasonTo = new javax.swing.JComboBox();
        radioButtonDate = new javax.swing.JRadioButton();
        labelFrom2 = new javax.swing.JLabel();
        textFieldDateFrom = new javax.swing.JFormattedTextField();
        labelTo2 = new javax.swing.JLabel();
        textFieldDateTo = new javax.swing.JFormattedTextField();
        panelLeague = new javax.swing.JPanel();
        radioButtonLeagueLevel = new javax.swing.JRadioButton();
        labelFrom3 = new javax.swing.JLabel();
        comboBoxLevelFrom = new javax.swing.JComboBox();
        labelTo3 = new javax.swing.JLabel();
        comboBoxLevelTo = new javax.swing.JComboBox();
        radioButtonSpecificLeague = new javax.swing.JRadioButton();
        labelLeagueName = new javax.swing.JLabel();
        comboBoxLeagueName = new javax.swing.JComboBox();

        setBorder(javax.swing.BorderFactory.createEtchedBorder());

        panelSeason.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Season and date"));

        buttonGroupSeason.add(radioButtonSeason);
        radioButtonSeason.setSelected(true);
        radioButtonSeason.setText("Season");

        labelFrom1.setText("From:");

        comboBoxSeasonFrom.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        labelTo1.setText("To:");

        comboBoxSeasonTo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        buttonGroupSeason.add(radioButtonDate);
        radioButtonDate.setText("Date");

        labelFrom2.setText("From:");

        textFieldDateFrom.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("yyyy-MM-dd"))));
        textFieldDateFrom.setText("2001-01-01");

        labelTo2.setText("To:");

        textFieldDateTo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("yyyy-MM-dd"))));
        textFieldDateTo.setText("2001-01-01");

        javax.swing.GroupLayout panelSeasonLayout = new javax.swing.GroupLayout(panelSeason);
        panelSeason.setLayout(panelSeasonLayout);
        panelSeasonLayout.setHorizontalGroup(
            panelSeasonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSeasonLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelSeasonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(radioButtonSeason)
                    .addComponent(radioButtonDate)
                    .addGroup(panelSeasonLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(panelSeasonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelSeasonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(labelFrom2)
                                .addComponent(labelFrom1))
                            .addComponent(labelTo1)
                            .addComponent(labelTo2))
                        .addGap(18, 18, 18)
                        .addGroup(panelSeasonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(textFieldDateFrom, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                            .addComponent(comboBoxSeasonTo, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comboBoxSeasonFrom, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(textFieldDateTo))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelSeasonLayout.setVerticalGroup(
            panelSeasonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSeasonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(radioButtonSeason)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelSeasonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelFrom1)
                    .addComponent(comboBoxSeasonFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelSeasonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBoxSeasonTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelTo1))
                .addGap(18, 18, 18)
                .addComponent(radioButtonDate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelSeasonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelFrom2)
                    .addComponent(textFieldDateFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelSeasonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textFieldDateTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelTo2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelLeague.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "League"));

        buttonGroupLeague.add(radioButtonLeagueLevel);
        radioButtonLeagueLevel.setSelected(true);
        radioButtonLeagueLevel.setText("League level");

        labelFrom3.setText("From:");

        comboBoxLevelFrom.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        labelTo3.setText("To:");

        comboBoxLevelTo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        buttonGroupLeague.add(radioButtonSpecificLeague);
        radioButtonSpecificLeague.setText("Specific league");

        labelLeagueName.setText("League name:");

        comboBoxLeagueName.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout panelLeagueLayout = new javax.swing.GroupLayout(panelLeague);
        panelLeague.setLayout(panelLeagueLayout);
        panelLeagueLayout.setHorizontalGroup(
            panelLeagueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLeagueLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLeagueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(radioButtonLeagueLevel)
                    .addComponent(radioButtonSpecificLeague)
                    .addGroup(panelLeagueLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(panelLeagueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelLeagueLayout.createSequentialGroup()
                                .addComponent(labelLeagueName)
                                .addGap(18, 18, 18)
                                .addComponent(comboBoxLeagueName, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelLeagueLayout.createSequentialGroup()
                                .addGroup(panelLeagueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelFrom3)
                                    .addComponent(labelTo3))
                                .addGap(18, 18, 18)
                                .addGroup(panelLeagueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(comboBoxLevelFrom, 0, 90, Short.MAX_VALUE)
                                    .addComponent(comboBoxLevelTo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addContainerGap(117, Short.MAX_VALUE))
        );
        panelLeagueLayout.setVerticalGroup(
            panelLeagueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLeagueLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(radioButtonLeagueLevel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelLeagueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelFrom3)
                    .addComponent(comboBoxLevelFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelLeagueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBoxLevelTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelTo3))
                .addGap(18, 18, 18)
                .addComponent(radioButtonSpecificLeague)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelLeagueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelLeagueName)
                    .addComponent(comboBoxLeagueName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelSeason, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelLeague, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelSeason, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panelLeague, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupLeague;
    private javax.swing.ButtonGroup buttonGroupSeason;
    private javax.swing.JComboBox comboBoxLeagueName;
    private javax.swing.JComboBox comboBoxLevelFrom;
    private javax.swing.JComboBox comboBoxLevelTo;
    private javax.swing.JComboBox comboBoxSeasonFrom;
    private javax.swing.JComboBox comboBoxSeasonTo;
    private javax.swing.JLabel labelFrom1;
    private javax.swing.JLabel labelFrom2;
    private javax.swing.JLabel labelFrom3;
    private javax.swing.JLabel labelLeagueName;
    private javax.swing.JLabel labelTo1;
    private javax.swing.JLabel labelTo2;
    private javax.swing.JLabel labelTo3;
    private javax.swing.JPanel panelLeague;
    private javax.swing.JPanel panelSeason;
    private javax.swing.JRadioButton radioButtonDate;
    private javax.swing.JRadioButton radioButtonLeagueLevel;
    private javax.swing.JRadioButton radioButtonSeason;
    private javax.swing.JRadioButton radioButtonSpecificLeague;
    private javax.swing.JFormattedTextField textFieldDateFrom;
    private javax.swing.JFormattedTextField textFieldDateTo;
    // End of variables declaration//GEN-END:variables
}
