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

import static htsquirrel.ConfigProperties.*;
import static htsquirrel.database.DatabaseManagement.*;
import static htsquirrel.DownloadManagement.getSeason;
import static htsquirrel.OAuth.*;
import static htsquirrel.Responses.*;
import htsquirrel.game.*;
import java.sql.Connection;
import java.sql.Timestamp;
import java.util.ArrayList;
import javax.swing.SwingWorker;
import org.scribe.model.Token;
import org.scribe.oauth.OAuthService;

/**
 *
 * @author Aleksandar Cvetković <arcvetkovic@gmail.com>
 */
public class Download extends javax.swing.JPanel {

    /**
     * Creates new form Download
     */
    public Download() {
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();

        setMinimumSize(new java.awt.Dimension(555, 211));
        setLayout(new java.awt.CardLayout());

        jScrollPane1.setBorder(null);

        jLabel1.setFont(new java.awt.Font("DejaVu Sans", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 102, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Download");

        jLabel2.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Press the button to download your Hattrick data.");

        jButton1.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        jButton1.setText("Download");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Progress:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 499, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel1);

        add(jScrollPane1, "card2");
    }// </editor-fold>//GEN-END:initComponents

    class DownloadTeamDetails extends SwingWorker<Void, Void> {
        
        @Override
        protected Void doInBackground() throws Exception {
            OAuthService oAuthService = getOAuthService(); // TODO handle unsuccessful initialization
            Token accessToken = getAccessTokenProperty();
            ArrayList<Team> teams = getTeams(oAuthService, accessToken);
            User user = getUser(oAuthService, accessToken);
            Connection db = createDatabaseConnection();
            deleteFromTeams(db, user);
            for (Team team : teams) {
                insertIntoTeams(db, user, team);
                deleteFromCups(db, team);
                ArrayList<Cup> cups = getCups(oAuthService, accessToken, team);
                for (Cup cup : cups) {
                    insertIntoCups(db, cup);
                }
            }
            db.close();
            return null;
        }
        
        @Override
        public void done() {
            DownloadMatchesArchive downloadMatchesArchive = new DownloadMatchesArchive();
            downloadMatchesArchive.execute();
        }
        
    }
    
    class DownloadMatchesArchive extends SwingWorker<Void, Void> {
        
        @Override
        protected Void doInBackground() throws Exception {
            OAuthService oAuthService = getOAuthService(); // TODO handle unsuccessful initialization
            Token accessToken = getAccessTokenProperty();
            ArrayList<Team> teams = getTeams(oAuthService, accessToken);
            User user = getUser(oAuthService, accessToken);
            Connection db = createDatabaseConnection();
            int teamCnt = 0;
            for (Team team : teams) {
                teamCnt++;
                int currentSeason = getSeason(oAuthService, accessToken, team);
                int lastSeason = getLastSeason(db, team);
                Timestamp lastMatchDate = getLastMatchDate(db, team);
                for (int seasonCnt = lastSeason; seasonCnt <= currentSeason; seasonCnt++) {
                    jProgressBar1.setValue((int) 10 * (teamCnt - 1) + 20 * ((seasonCnt - lastSeason + 1) / ((currentSeason - lastSeason + 1) * teams.size())));
                    ArrayList<Match> matchesList = new ArrayList<>();
                    matchesList = getMatches(oAuthService, accessToken, team,
                            seasonCnt, lastMatchDate);
                    for (Match match : matchesList) {
                        insertIntoMatches(db, match);
                    }
                }
            }
            db.close();
            return null;
        }
        
        @Override
        public void done() {
            DownloadMatchDetails downloadMatchDetails = new DownloadMatchDetails();
            downloadMatchDetails.execute();
        }
        
    }
    
    class DownloadMatchDetails extends SwingWorker<Void, Void> {
        
        @Override
        protected Void doInBackground() throws Exception {
            OAuthService oAuthService = getOAuthService(); // TODO handle unsuccessful initialization
            Token accessToken = getAccessTokenProperty();
            ArrayList<Team> teams = getTeams(oAuthService, accessToken);
            User user = getUser(oAuthService, accessToken);
            Connection db = createDatabaseConnection();
            int teamCnt = 0;
            for (Team team : teams) {
                teamCnt++;
                ArrayList<Match> matches = new ArrayList<>();
                matches = getMissingMatches(db, team);
                int matchCnt = 0;
                for (Match match : matches) {
                    matchCnt++;
                    jProgressBar1.setValue((int) 20 + 40 * (teamCnt - 1) + 80 * matchCnt / (matches.size() * teams.size()));
                    String xmlString = getResponse(oAuthService, accessToken,
                            "matchdetails&version=2.7&matchEvents=true&matchID="
                                    + match.getMatchId());
                    MatchDetails matchDetails = getMatchDetails(xmlString,
                            match);
                    insertIntoMatchDetails(db, matchDetails);
                    ArrayList<Referee> referees = getReferees(xmlString, match);
                    for (Referee referee : referees) {
                        insertIntoReferees(db, referee);
                    }
                    ArrayList<Goal> goals = getGoals(xmlString, match);
                    for (Goal goal : goals) {
                        insertIntoGoals(db, goal);
                    }
                    ArrayList<Booking> bookings = getBookings(xmlString, match);
                    for (Booking booking : bookings) {
                        insertIntoBookings(db, booking);
                    }
                    ArrayList<Injury> injuries = getInjuries(xmlString, match);
                    for (Injury injury : injuries) {
                        insertIntoInjuries(db, injury);
                    }
                    ArrayList<Event> events = getEvents(xmlString, match);
                    for (Event event : events) {
                        insertIntoEvents(db, event);
                    }
                }
            }
            db.close();
            return null;
        }
        
        @Override
        public void done() {
            jProgressBar1.setValue(100);
            jButton1.setEnabled(true);
        }
        
    }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        jButton1.setEnabled(false);
        DownloadTeamDetails downloadTeamDetails = new DownloadTeamDetails();
        downloadTeamDetails.execute();
    }//GEN-LAST:event_jButton1ActionPerformed

    public void refreshDownload() {
        jProgressBar1.setValue(0);
        jButton1.setEnabled(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
