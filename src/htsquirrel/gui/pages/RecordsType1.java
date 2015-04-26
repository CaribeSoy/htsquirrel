/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2015 Aleksandar Cvetković
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package htsquirrel.gui.pages;

/**
 *
 * @author Aleksandar Cvetković <arcvetkovic@gmail.com>
 */
public class RecordsType1 extends javax.swing.JPanel {

    /**
     * Creates new form RecordsType1
     */
    public RecordsType1() {
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

        jPanel1 = new javax.swing.JPanel();
        labelTitle = new javax.swing.JLabel();
        label1 = new javax.swing.JLabel();
        label2 = new javax.swing.JLabel();

        jPanel1.setLayout(new java.awt.CardLayout());

        labelTitle.setFont(new java.awt.Font("DejaVu Sans", 0, 18)); // NOI18N
        labelTitle.setForeground(new java.awt.Color(204, 102, 0));
        labelTitle.setText("Title");

        label1.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        label1.setText("Text");

        label2.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        label2.setText("Text");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label2)
                    .addComponent(label1)
                    .addComponent(labelTitle))
                .addContainerGap(310, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(labelTitle)
                .addGap(18, 18, 18)
                .addComponent(label1)
                .addGap(18, 18, 18)
                .addComponent(label2)
                .addGap(0, 162, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    public static void setTitle(String title) {
        labelTitle.setText(title);
    }
    
    public static void hideLabels() {
        label1.setVisible(false);
        label2.setVisible(false);
    }
    
    public static void showLabel1(String text) {
        label1.setText(text);
        label1.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private static javax.swing.JLabel label1;
    private static javax.swing.JLabel label2;
    private static javax.swing.JLabel labelTitle;
    // End of variables declaration//GEN-END:variables
}
