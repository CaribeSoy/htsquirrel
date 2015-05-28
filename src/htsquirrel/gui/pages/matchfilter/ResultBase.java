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
 * @author aleksandar
 */
public class ResultBase extends javax.swing.JPanel {

    /**
     * Creates new form ResultBase
     */
    public ResultBase() {
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

        panelResult = new javax.swing.JPanel();
        checkBoxFor = new javax.swing.JCheckBox();
        labelForFrom = new javax.swing.JLabel();
        spinnerForFrom = new javax.swing.JSpinner();
        labelForTo = new javax.swing.JLabel();
        spinnerForTo = new javax.swing.JSpinner();
        checkBoxAgainst = new javax.swing.JCheckBox();
        labelAgainstFrom = new javax.swing.JLabel();
        spinnerAgainstFrom = new javax.swing.JSpinner();
        labelAgainstTo = new javax.swing.JLabel();
        spinnerAgainstTo = new javax.swing.JSpinner();
        checkBoxTotal = new javax.swing.JCheckBox();
        labelTotalFrom = new javax.swing.JLabel();
        spinnerTotalFrom = new javax.swing.JSpinner();
        labelTotalTo = new javax.swing.JLabel();
        spinnerTotalTo = new javax.swing.JSpinner();
        checkBoxDifference = new javax.swing.JCheckBox();
        labelDifferenceFrom = new javax.swing.JLabel();
        spinnerDifferenceFrom = new javax.swing.JSpinner();
        labelDifferenceTo = new javax.swing.JLabel();
        spinnerDifferenceTo = new javax.swing.JSpinner();

        panelResult.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Result"));

        checkBoxFor.setText("Goals for");

        labelForFrom.setText("From:");

        spinnerForFrom.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));

        labelForTo.setText("To:");

        spinnerForTo.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(20), Integer.valueOf(0), null, Integer.valueOf(1)));

        checkBoxAgainst.setText("Goals against");

        labelAgainstFrom.setText("From:");

        spinnerAgainstFrom.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));

        labelAgainstTo.setText("To:");

        spinnerAgainstTo.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(20), Integer.valueOf(0), null, Integer.valueOf(1)));

        checkBoxTotal.setText("Goals total");

        labelTotalFrom.setText("From:");

        spinnerTotalFrom.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));

        labelTotalTo.setText("To:");

        spinnerTotalTo.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(20), Integer.valueOf(0), null, Integer.valueOf(1)));

        checkBoxDifference.setText("Goal difference");

        labelDifferenceFrom.setText("From:");

        spinnerDifferenceFrom.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(-20), null, null, Integer.valueOf(1)));

        labelDifferenceTo.setText("To:");

        spinnerDifferenceTo.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(20), null, null, Integer.valueOf(1)));

        javax.swing.GroupLayout panelResultLayout = new javax.swing.GroupLayout(panelResult);
        panelResult.setLayout(panelResultLayout);
        panelResultLayout.setHorizontalGroup(
            panelResultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelResultLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelResultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkBoxFor)
                    .addComponent(checkBoxAgainst)
                    .addComponent(checkBoxTotal)
                    .addComponent(checkBoxDifference)
                    .addGroup(panelResultLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(panelResultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panelResultLayout.createSequentialGroup()
                                .addComponent(labelDifferenceFrom)
                                .addGap(18, 18, 18)
                                .addComponent(spinnerDifferenceFrom))
                            .addGroup(panelResultLayout.createSequentialGroup()
                                .addComponent(labelTotalFrom)
                                .addGap(18, 18, 18)
                                .addComponent(spinnerTotalFrom))
                            .addGroup(panelResultLayout.createSequentialGroup()
                                .addComponent(labelAgainstFrom)
                                .addGap(18, 18, 18)
                                .addComponent(spinnerAgainstFrom))
                            .addGroup(panelResultLayout.createSequentialGroup()
                                .addComponent(labelForFrom)
                                .addGap(18, 18, 18)
                                .addComponent(spinnerForFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(panelResultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panelResultLayout.createSequentialGroup()
                                .addComponent(labelForTo)
                                .addGap(18, 18, 18)
                                .addComponent(spinnerForTo, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelResultLayout.createSequentialGroup()
                                .addComponent(labelAgainstTo)
                                .addGap(18, 18, 18)
                                .addComponent(spinnerAgainstTo))
                            .addGroup(panelResultLayout.createSequentialGroup()
                                .addComponent(labelTotalTo)
                                .addGap(18, 18, 18)
                                .addComponent(spinnerTotalTo))
                            .addGroup(panelResultLayout.createSequentialGroup()
                                .addComponent(labelDifferenceTo)
                                .addGap(18, 18, 18)
                                .addComponent(spinnerDifferenceTo)))))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        panelResultLayout.setVerticalGroup(
            panelResultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelResultLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(checkBoxFor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelResultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelForFrom)
                    .addComponent(spinnerForFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelForTo)
                    .addComponent(spinnerForTo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(checkBoxAgainst)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelResultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spinnerAgainstFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelAgainstFrom)
                    .addComponent(labelAgainstTo)
                    .addComponent(spinnerAgainstTo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(checkBoxTotal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelResultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTotalFrom)
                    .addComponent(spinnerTotalFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelTotalTo)
                    .addComponent(spinnerTotalTo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(checkBoxDifference)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelResultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelDifferenceFrom)
                    .addComponent(spinnerDifferenceFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelDifferenceTo)
                    .addComponent(spinnerDifferenceTo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelResult, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelResult, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox checkBoxAgainst;
    private javax.swing.JCheckBox checkBoxDifference;
    private javax.swing.JCheckBox checkBoxFor;
    private javax.swing.JCheckBox checkBoxTotal;
    private javax.swing.JLabel labelAgainstFrom;
    private javax.swing.JLabel labelAgainstTo;
    private javax.swing.JLabel labelDifferenceFrom;
    private javax.swing.JLabel labelDifferenceTo;
    private javax.swing.JLabel labelForFrom;
    private javax.swing.JLabel labelForTo;
    private javax.swing.JLabel labelTotalFrom;
    private javax.swing.JLabel labelTotalTo;
    private javax.swing.JPanel panelResult;
    private javax.swing.JSpinner spinnerAgainstFrom;
    private javax.swing.JSpinner spinnerAgainstTo;
    private javax.swing.JSpinner spinnerDifferenceFrom;
    private javax.swing.JSpinner spinnerDifferenceTo;
    private javax.swing.JSpinner spinnerForFrom;
    private javax.swing.JSpinner spinnerForTo;
    private javax.swing.JSpinner spinnerTotalFrom;
    private javax.swing.JSpinner spinnerTotalTo;
    // End of variables declaration//GEN-END:variables
}
