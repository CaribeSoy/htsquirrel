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
package htsquirrel.gui.menu;

/**
 *
 * @author Aleksandar Cvetković <arcvetkovic@gmail.com>
 */
public class Menu extends javax.swing.JPanel {

    /**
     * Creates new form Menu
     */
    public Menu() {
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

        panelLeft = new javax.swing.JPanel();
        labelTeamName = new javax.swing.JLabel();
        labelSwitchTeam = new javax.swing.JLabel();
        panelRight = new javax.swing.JPanel();
        panelCenter = new javax.swing.JPanel();
        labelTeam = new javax.swing.JLabel();
        labelRecords = new javax.swing.JLabel();
        labelDownload = new javax.swing.JLabel();
        labelSettings = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(2147483647, 50));
        setLayout(new java.awt.BorderLayout());

        panelLeft.setBackground(new java.awt.Color(51, 51, 51));
        panelLeft.setMaximumSize(new java.awt.Dimension(450, 50));
        panelLeft.setMinimumSize(new java.awt.Dimension(450, 50));
        panelLeft.setPreferredSize(new java.awt.Dimension(450, 50));

        labelTeamName.setForeground(new java.awt.Color(255, 102, 0));
        labelTeamName.setText(" ");

        labelSwitchTeam.setForeground(new java.awt.Color(128, 128, 128));
        labelSwitchTeam.setText("switch team");

        javax.swing.GroupLayout panelLeftLayout = new javax.swing.GroupLayout(panelLeft);
        panelLeft.setLayout(panelLeftLayout);
        panelLeftLayout.setHorizontalGroup(
            panelLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLeftLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelTeamName)
                    .addComponent(labelSwitchTeam))
                .addContainerGap(369, Short.MAX_VALUE))
        );
        panelLeftLayout.setVerticalGroup(
            panelLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLeftLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelTeamName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelSwitchTeam)
                .addContainerGap(8, Short.MAX_VALUE))
        );

        add(panelLeft, java.awt.BorderLayout.LINE_START);

        panelRight.setBackground(new java.awt.Color(51, 51, 51));
        panelRight.setMaximumSize(new java.awt.Dimension(5, 50));
        panelRight.setMinimumSize(new java.awt.Dimension(5, 50));
        panelRight.setPreferredSize(new java.awt.Dimension(5, 50));

        javax.swing.GroupLayout panelRightLayout = new javax.swing.GroupLayout(panelRight);
        panelRight.setLayout(panelRightLayout);
        panelRightLayout.setHorizontalGroup(
            panelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        panelRightLayout.setVerticalGroup(
            panelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        add(panelRight, java.awt.BorderLayout.LINE_END);

        panelCenter.setBackground(new java.awt.Color(51, 51, 51));

        labelTeam.setFont(new java.awt.Font("DejaVu Sans", 0, 18)); // NOI18N
        labelTeam.setForeground(new java.awt.Color(128, 128, 128));
        labelTeam.setText("TEAM");

        labelRecords.setFont(new java.awt.Font("DejaVu Sans", 0, 18)); // NOI18N
        labelRecords.setForeground(new java.awt.Color(128, 128, 128));
        labelRecords.setText("RECORDS");

        labelDownload.setFont(new java.awt.Font("DejaVu Sans", 0, 18)); // NOI18N
        labelDownload.setForeground(new java.awt.Color(128, 128, 128));
        labelDownload.setText("DOWNLOAD");

        labelSettings.setFont(new java.awt.Font("DejaVu Sans", 0, 18)); // NOI18N
        labelSettings.setForeground(new java.awt.Color(128, 128, 128));
        labelSettings.setText("SETTINGS");

        javax.swing.GroupLayout panelCenterLayout = new javax.swing.GroupLayout(panelCenter);
        panelCenter.setLayout(panelCenterLayout);
        panelCenterLayout.setHorizontalGroup(
            panelCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCenterLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelTeam)
                .addGap(18, 18, 18)
                .addComponent(labelRecords)
                .addGap(18, 18, 18)
                .addComponent(labelDownload)
                .addGap(18, 18, 18)
                .addComponent(labelSettings)
                .addContainerGap(143, Short.MAX_VALUE))
        );
        panelCenterLayout.setVerticalGroup(
            panelCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCenterLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(panelCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTeam)
                    .addComponent(labelRecords)
                    .addComponent(labelDownload)
                    .addComponent(labelSettings))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        add(panelCenter, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel labelDownload;
    private javax.swing.JLabel labelRecords;
    private javax.swing.JLabel labelSettings;
    private javax.swing.JLabel labelSwitchTeam;
    private javax.swing.JLabel labelTeam;
    private javax.swing.JLabel labelTeamName;
    private javax.swing.JPanel panelCenter;
    private javax.swing.JPanel panelLeft;
    private javax.swing.JPanel panelRight;
    // End of variables declaration//GEN-END:variables
}
