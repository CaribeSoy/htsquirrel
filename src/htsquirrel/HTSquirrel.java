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
package htsquirrel;

import static htsquirrel.utilities.ConfigProperties.getLanguageProperty;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Aleksandar Cvetković <arcvetkovic@gmail.com>
 */
public class HTSquirrel extends javax.swing.JFrame {

    /**
     * Creates new form HTSquirrel
     */
    public HTSquirrel() {
        initComponents();
        try {
            setLanguage(getLanguageProperty());
        } catch (IOException ex) {
            Logger.getLogger(HTSquirrel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelTop = new javax.swing.JPanel();
        panelHorizontalLine = new javax.swing.JPanel();
        panelBottom = new javax.swing.JPanel();
        panelLeft = new javax.swing.JPanel();
        panelLeftTop = new javax.swing.JPanel();
        panelLeftBottom = new javax.swing.JPanel();
        panelLeftLeft = new javax.swing.JPanel();
        panelLeftRight = new javax.swing.JPanel();
        panelSmallPage = new javax.swing.JPanel();
        panelRight = new javax.swing.JPanel();
        panelCenter = new javax.swing.JPanel();
        panelVerticalSeparator = new javax.swing.JPanel();
        panelVerticalLine = new javax.swing.JPanel();
        panelMain = new javax.swing.JPanel();
        panelHorizontalSeparator = new javax.swing.JPanel();
        panelBigPage = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelTop.setBackground(new java.awt.Color(51, 51, 51));
        panelTop.setMaximumSize(new java.awt.Dimension(32767, 52));
        panelTop.setMinimumSize(new java.awt.Dimension(100, 52));
        panelTop.setPreferredSize(new java.awt.Dimension(1000, 52));
        panelTop.setLayout(new java.awt.BorderLayout());

        panelHorizontalLine.setBackground(new java.awt.Color(204, 102, 0));
        panelHorizontalLine.setMaximumSize(new java.awt.Dimension(32767, 2));
        panelHorizontalLine.setMinimumSize(new java.awt.Dimension(100, 2));
        panelHorizontalLine.setPreferredSize(new java.awt.Dimension(1000, 2));

        javax.swing.GroupLayout panelHorizontalLineLayout = new javax.swing.GroupLayout(panelHorizontalLine);
        panelHorizontalLine.setLayout(panelHorizontalLineLayout);
        panelHorizontalLineLayout.setHorizontalGroup(
            panelHorizontalLineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1000, Short.MAX_VALUE)
        );
        panelHorizontalLineLayout.setVerticalGroup(
            panelHorizontalLineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        panelTop.add(panelHorizontalLine, java.awt.BorderLayout.PAGE_END);

        getContentPane().add(panelTop, java.awt.BorderLayout.PAGE_START);

        panelBottom.setBackground(new java.awt.Color(51, 51, 51));
        panelBottom.setMaximumSize(new java.awt.Dimension(32767, 5));
        panelBottom.setMinimumSize(new java.awt.Dimension(100, 5));
        panelBottom.setPreferredSize(new java.awt.Dimension(1000, 5));

        javax.swing.GroupLayout panelBottomLayout = new javax.swing.GroupLayout(panelBottom);
        panelBottom.setLayout(panelBottomLayout);
        panelBottomLayout.setHorizontalGroup(
            panelBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1000, Short.MAX_VALUE)
        );
        panelBottomLayout.setVerticalGroup(
            panelBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        getContentPane().add(panelBottom, java.awt.BorderLayout.PAGE_END);

        panelLeft.setBackground(new java.awt.Color(102, 102, 102));
        panelLeft.setMaximumSize(new java.awt.Dimension(400, 32767));
        panelLeft.setMinimumSize(new java.awt.Dimension(400, 100));
        panelLeft.setLayout(new java.awt.BorderLayout());

        panelLeftTop.setBackground(new java.awt.Color(102, 102, 102));
        panelLeftTop.setMaximumSize(new java.awt.Dimension(32767, 50));
        panelLeftTop.setMinimumSize(new java.awt.Dimension(100, 50));
        panelLeftTop.setPreferredSize(new java.awt.Dimension(400, 50));

        javax.swing.GroupLayout panelLeftTopLayout = new javax.swing.GroupLayout(panelLeftTop);
        panelLeftTop.setLayout(panelLeftTopLayout);
        panelLeftTopLayout.setHorizontalGroup(
            panelLeftTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        panelLeftTopLayout.setVerticalGroup(
            panelLeftTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        panelLeft.add(panelLeftTop, java.awt.BorderLayout.PAGE_START);

        panelLeftBottom.setBackground(new java.awt.Color(102, 102, 102));
        panelLeftBottom.setMaximumSize(new java.awt.Dimension(32767, 5));
        panelLeftBottom.setMinimumSize(new java.awt.Dimension(100, 5));
        panelLeftBottom.setPreferredSize(new java.awt.Dimension(400, 5));

        javax.swing.GroupLayout panelLeftBottomLayout = new javax.swing.GroupLayout(panelLeftBottom);
        panelLeftBottom.setLayout(panelLeftBottomLayout);
        panelLeftBottomLayout.setHorizontalGroup(
            panelLeftBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        panelLeftBottomLayout.setVerticalGroup(
            panelLeftBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        panelLeft.add(panelLeftBottom, java.awt.BorderLayout.PAGE_END);

        panelLeftLeft.setBackground(new java.awt.Color(102, 102, 102));
        panelLeftLeft.setMaximumSize(new java.awt.Dimension(5, 32767));
        panelLeftLeft.setMinimumSize(new java.awt.Dimension(5, 100));
        panelLeftLeft.setPreferredSize(new java.awt.Dimension(5, 638));

        javax.swing.GroupLayout panelLeftLeftLayout = new javax.swing.GroupLayout(panelLeftLeft);
        panelLeftLeft.setLayout(panelLeftLeftLayout);
        panelLeftLeftLayout.setHorizontalGroup(
            panelLeftLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        panelLeftLeftLayout.setVerticalGroup(
            panelLeftLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 638, Short.MAX_VALUE)
        );

        panelLeft.add(panelLeftLeft, java.awt.BorderLayout.LINE_START);

        panelLeftRight.setBackground(new java.awt.Color(102, 102, 102));
        panelLeftRight.setMaximumSize(new java.awt.Dimension(5, 32767));
        panelLeftRight.setMinimumSize(new java.awt.Dimension(5, 100));
        panelLeftRight.setPreferredSize(new java.awt.Dimension(5, 638));

        javax.swing.GroupLayout panelLeftRightLayout = new javax.swing.GroupLayout(panelLeftRight);
        panelLeftRight.setLayout(panelLeftRightLayout);
        panelLeftRightLayout.setHorizontalGroup(
            panelLeftRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        panelLeftRightLayout.setVerticalGroup(
            panelLeftRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 638, Short.MAX_VALUE)
        );

        panelLeft.add(panelLeftRight, java.awt.BorderLayout.LINE_END);

        panelSmallPage.setBackground(new java.awt.Color(102, 102, 102));

        javax.swing.GroupLayout panelSmallPageLayout = new javax.swing.GroupLayout(panelSmallPage);
        panelSmallPage.setLayout(panelSmallPageLayout);
        panelSmallPageLayout.setHorizontalGroup(
            panelSmallPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 390, Short.MAX_VALUE)
        );
        panelSmallPageLayout.setVerticalGroup(
            panelSmallPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 638, Short.MAX_VALUE)
        );

        panelLeft.add(panelSmallPage, java.awt.BorderLayout.CENTER);

        getContentPane().add(panelLeft, java.awt.BorderLayout.LINE_START);

        panelRight.setMaximumSize(new java.awt.Dimension(5, 32767));
        panelRight.setMinimumSize(new java.awt.Dimension(5, 100));
        panelRight.setPreferredSize(new java.awt.Dimension(5, 694));

        javax.swing.GroupLayout panelRightLayout = new javax.swing.GroupLayout(panelRight);
        panelRight.setLayout(panelRightLayout);
        panelRightLayout.setHorizontalGroup(
            panelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        panelRightLayout.setVerticalGroup(
            panelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 693, Short.MAX_VALUE)
        );

        getContentPane().add(panelRight, java.awt.BorderLayout.LINE_END);

        panelCenter.setLayout(new java.awt.BorderLayout());

        panelVerticalSeparator.setMaximumSize(new java.awt.Dimension(50, 32767));
        panelVerticalSeparator.setMinimumSize(new java.awt.Dimension(50, 100));
        panelVerticalSeparator.setPreferredSize(new java.awt.Dimension(50, 693));
        panelVerticalSeparator.setLayout(new java.awt.BorderLayout());

        panelVerticalLine.setMaximumSize(new java.awt.Dimension(1, 32767));
        panelVerticalLine.setMinimumSize(new java.awt.Dimension(1, 100));
        panelVerticalLine.setPreferredSize(new java.awt.Dimension(1, 693));

        javax.swing.GroupLayout panelVerticalLineLayout = new javax.swing.GroupLayout(panelVerticalLine);
        panelVerticalLine.setLayout(panelVerticalLineLayout);
        panelVerticalLineLayout.setHorizontalGroup(
            panelVerticalLineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );
        panelVerticalLineLayout.setVerticalGroup(
            panelVerticalLineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 693, Short.MAX_VALUE)
        );

        panelVerticalSeparator.add(panelVerticalLine, java.awt.BorderLayout.LINE_START);

        panelCenter.add(panelVerticalSeparator, java.awt.BorderLayout.LINE_START);

        panelMain.setLayout(new java.awt.BorderLayout());

        panelHorizontalSeparator.setMaximumSize(new java.awt.Dimension(32767, 50));
        panelHorizontalSeparator.setMinimumSize(new java.awt.Dimension(100, 50));
        panelHorizontalSeparator.setPreferredSize(new java.awt.Dimension(545, 50));

        javax.swing.GroupLayout panelHorizontalSeparatorLayout = new javax.swing.GroupLayout(panelHorizontalSeparator);
        panelHorizontalSeparator.setLayout(panelHorizontalSeparatorLayout);
        panelHorizontalSeparatorLayout.setHorizontalGroup(
            panelHorizontalSeparatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 545, Short.MAX_VALUE)
        );
        panelHorizontalSeparatorLayout.setVerticalGroup(
            panelHorizontalSeparatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        panelMain.add(panelHorizontalSeparator, java.awt.BorderLayout.PAGE_START);

        javax.swing.GroupLayout panelBigPageLayout = new javax.swing.GroupLayout(panelBigPage);
        panelBigPage.setLayout(panelBigPageLayout);
        panelBigPageLayout.setHorizontalGroup(
            panelBigPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 545, Short.MAX_VALUE)
        );
        panelBigPageLayout.setVerticalGroup(
            panelBigPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 643, Short.MAX_VALUE)
        );

        panelMain.add(panelBigPage, java.awt.BorderLayout.CENTER);

        panelCenter.add(panelMain, java.awt.BorderLayout.CENTER);

        getContentPane().add(panelCenter, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HTSquirrel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HTSquirrel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HTSquirrel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HTSquirrel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HTSquirrel().setVisible(true);
            }
        });
    }

    private static String language;

    public static String getLanguage() {
        return language;
    }

    public static void setLanguage(String language) {
        HTSquirrel.language = language;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel panelBigPage;
    private javax.swing.JPanel panelBottom;
    private javax.swing.JPanel panelCenter;
    private javax.swing.JPanel panelHorizontalLine;
    private javax.swing.JPanel panelHorizontalSeparator;
    private javax.swing.JPanel panelLeft;
    private javax.swing.JPanel panelLeftBottom;
    private javax.swing.JPanel panelLeftLeft;
    private javax.swing.JPanel panelLeftRight;
    private javax.swing.JPanel panelLeftTop;
    private javax.swing.JPanel panelMain;
    private javax.swing.JPanel panelRight;
    private javax.swing.JPanel panelSmallPage;
    private javax.swing.JPanel panelTop;
    private javax.swing.JPanel panelVerticalLine;
    private javax.swing.JPanel panelVerticalSeparator;
    // End of variables declaration//GEN-END:variables
}
