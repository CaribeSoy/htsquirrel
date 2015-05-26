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
public class Tactics extends javax.swing.JPanel {

    /**
     * Creates new form Tactics
     */
    public Tactics() {
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
        panelTeam = new htsquirrel.gui.pages.matchfilter.TacticsTeam();
        panelOpponent = new htsquirrel.gui.pages.matchfilter.TacticsOpponent();

        setLayout(new java.awt.GridBagLayout());

        panelTop.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelTop.setMaximumSize(new java.awt.Dimension(32767, 50));
        panelTop.setMinimumSize(new java.awt.Dimension(100, 50));
        panelTop.setPreferredSize(new java.awt.Dimension(400, 50));
        panelTop.setLayout(new java.awt.GridLayout());

        panelLeft.setLayout(new java.awt.GridBagLayout());

        buttonTeam.setSelected(true);
        buttonTeam.setText("Team");
        buttonTeam.setMaximumSize(new java.awt.Dimension(180, 27));
        buttonTeam.setMinimumSize(new java.awt.Dimension(180, 27));
        buttonTeam.setPreferredSize(new java.awt.Dimension(180, 27));
        panelLeft.add(buttonTeam, new java.awt.GridBagConstraints());

        panelTop.add(panelLeft);

        panelRight.setLayout(new java.awt.GridBagLayout());

        buttonOpponent.setText("Opponent");
        buttonOpponent.setMaximumSize(new java.awt.Dimension(180, 27));
        buttonOpponent.setMinimumSize(new java.awt.Dimension(180, 27));
        buttonOpponent.setPreferredSize(new java.awt.Dimension(180, 27));
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
        panelBase.add(panelTeam, "card2");
        panelBase.add(panelOpponent, "card3");

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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton buttonOpponent;
    private javax.swing.JToggleButton buttonTeam;
    private javax.swing.JPanel panelBase;
    private javax.swing.JPanel panelBottom;
    private javax.swing.JPanel panelLeft;
    private htsquirrel.gui.pages.matchfilter.TacticsOpponent panelOpponent;
    private javax.swing.JPanel panelRight;
    private htsquirrel.gui.pages.matchfilter.TacticsTeam panelTeam;
    private javax.swing.JPanel panelTop;
    private javax.swing.JScrollPane scrollPane;
    // End of variables declaration//GEN-END:variables
}
