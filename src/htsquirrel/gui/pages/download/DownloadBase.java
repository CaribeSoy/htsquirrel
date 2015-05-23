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
package htsquirrel.gui.pages.download;

import static htsquirrel.HTSquirrel.getGreen;
import static htsquirrel.HTSquirrel.getGreyLight;
import static htsquirrel.HTSquirrel.getLanguage;
import static htsquirrel.HTSquirrel.getMenu;
import static htsquirrel.HTSquirrel.getOrange;
import static htsquirrel.HTSquirrel.getTeams;
import static htsquirrel.HTSquirrel.getUserId;
import static htsquirrel.HTSquirrel.setCurrentTeam;
import static htsquirrel.HTSquirrel.setTeams;
import static htsquirrel.database.DatabaseManagement.createDatabaseConnection;
import static htsquirrel.database.DatabaseManagement.ensureTablesExist;
import static htsquirrel.database.DeleteFrom.deleteFromCups;
import static htsquirrel.database.DeleteFrom.deleteFromLeagueIds;
import static htsquirrel.database.DeleteFrom.deleteFromLeagueNames;
import static htsquirrel.database.DeleteFrom.deleteFromLeagues;
import static htsquirrel.database.DeleteFrom.deleteFromMatchesExtended;
import static htsquirrel.database.DeleteFrom.deleteFromPlayers;
import static htsquirrel.database.DeleteFrom.deleteFromTeams;
import static htsquirrel.database.DeleteFrom.deleteFromTransfers;
import static htsquirrel.database.GetInfo.getLastMatchDateFromDb;
import static htsquirrel.database.GetInfo.getLastSeasonFromDb;
import static htsquirrel.database.GetInfo.getLeagueIdsFromDb;
import static htsquirrel.database.GetInfo.getMaxSeasonFromDb;
import static htsquirrel.database.GetInfo.getMinSeasonFromDb;
import static htsquirrel.database.GetInfo.getMissingMatchesFromDb;
import static htsquirrel.database.GetInfo.getMissingSeasonsFromDb;
import static htsquirrel.database.GetInfo.getNumberOfSeasonsFromDb;
import static htsquirrel.database.GetInfo.getTeamsFromDb;
import static htsquirrel.database.InsertInto.insertIntoBookings;
import static htsquirrel.database.InsertInto.insertIntoCups;
import static htsquirrel.database.InsertInto.insertIntoEvents;
import static htsquirrel.database.InsertInto.insertIntoGoals;
import static htsquirrel.database.InsertInto.insertIntoInjuries;
import static htsquirrel.database.InsertInto.insertIntoLeagueIds;
import static htsquirrel.database.InsertInto.insertIntoLeagueNames;
import static htsquirrel.database.InsertInto.insertIntoLeagues;
import static htsquirrel.database.InsertInto.insertIntoLineups;
import static htsquirrel.database.InsertInto.insertIntoMatchDetails;
import static htsquirrel.database.InsertInto.insertIntoMatches;
import static htsquirrel.database.InsertInto.insertIntoMatchesExtended;
import static htsquirrel.database.InsertInto.insertIntoPlayers;
import static htsquirrel.database.InsertInto.insertIntoReferees;
import static htsquirrel.database.InsertInto.insertIntoStartingLineups;
import static htsquirrel.database.InsertInto.insertIntoSubstitutions;
import static htsquirrel.database.InsertInto.insertIntoTeams;
import static htsquirrel.database.InsertInto.insertIntoTransfers;
import static htsquirrel.database.Update.updateSeason;
import htsquirrel.game.Booking;
import htsquirrel.game.Cup;
import htsquirrel.game.Event;
import htsquirrel.game.Goal;
import htsquirrel.game.Injury;
import htsquirrel.game.League;
import htsquirrel.game.Lineup;
import htsquirrel.game.Match;
import htsquirrel.game.MatchDetails;
import htsquirrel.game.Referee;
import htsquirrel.game.StartingLineup;
import htsquirrel.game.Substitution;
import htsquirrel.game.Team;
import htsquirrel.game.Transfer;
import htsquirrel.game.User;
import static htsquirrel.oauth.OAuth.getOAuthService;
import static htsquirrel.oauth.OAuth.getResponse;
import static htsquirrel.oauth.Responses.getBookingsFromHt;
import static htsquirrel.oauth.Responses.getCupsFromHt;
import static htsquirrel.oauth.Responses.getEventsFromHt;
import static htsquirrel.oauth.Responses.getGoalsFromHt;
import static htsquirrel.oauth.Responses.getInjuriesFromHt;
import static htsquirrel.oauth.Responses.getLeagueFromHt;
import static htsquirrel.oauth.Responses.getLeagueIdFromSeasonFromHt;
import static htsquirrel.oauth.Responses.getLineupFromHt;
import static htsquirrel.oauth.Responses.getMatchDetailsFromHt;
import static htsquirrel.oauth.Responses.getMatchesFromHt;
import static htsquirrel.oauth.Responses.getRefereesFromHt;
import static htsquirrel.oauth.Responses.getSeasonFromHt;
import static htsquirrel.oauth.Responses.getStartingLineupFromHt;
import static htsquirrel.oauth.Responses.getSubstitutionsFromHt;
import static htsquirrel.oauth.Responses.getTeamsFromHt;
import static htsquirrel.oauth.Responses.getTransferPagesFromHt;
import static htsquirrel.oauth.Responses.getTransfersFromHt;
import static htsquirrel.oauth.Responses.getUserFromHt;
import htsquirrel.translations.Translations;
import static htsquirrel.utilities.ConfigProperties.getAccessTokenProperty;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingWorker;
import org.scribe.model.Token;
import org.scribe.oauth.OAuthService;

/**
 *
 * @author Aleksandar Cvetković <arcvetkovic@gmail.com>
 */
public class DownloadBase extends javax.swing.JPanel {

    /**
     * Creates new form DownloadBase
     */
    public DownloadBase() {
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

        labelTitle = new javax.swing.JLabel();
        labelText1 = new javax.swing.JLabel();
        progressBar = new javax.swing.JProgressBar();
        labelInfo = new javax.swing.JLabel();
        buttonDownload = new javax.swing.JButton();

        labelTitle.setFont(new java.awt.Font("DejaVu Sans", 0, 18)); // NOI18N
        labelTitle.setForeground(new java.awt.Color(255, 102, 0));
        labelTitle.setText("Download");

        labelText1.setText("Press the button to download your Hattrick data.");

        labelInfo.setText("Info");

        buttonDownload.setText("Download");
        buttonDownload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDownloadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelTitle)
                    .addComponent(labelText1)
                    .addComponent(labelInfo)
                    .addComponent(buttonDownload, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelTitle)
                .addGap(50, 50, 50)
                .addComponent(labelText1)
                .addGap(18, 18, 18)
                .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelInfo)
                .addGap(50, 50, 50)
                .addComponent(buttonDownload)
                .addContainerGap(72, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonDownloadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDownloadActionPerformed
        buttonDownload.setEnabled(false);
        DownloadBasicInfo downloadBasicInfo = new DownloadBasicInfo();
        downloadBasicInfo.execute();
    }//GEN-LAST:event_buttonDownloadActionPerformed

    class DownloadBasicInfo extends SwingWorker<Void, Void> {
        
        @Override
        protected Void doInBackground() throws Exception {
            htsquirrel.HTSquirrel.getMenu().setVisible(false);
            htsquirrel.HTSquirrel.getMenu().getLabelSwitchTeam().setVisible(false);
            progressBar.setValue(0);
            labelInfo.setForeground(getGreyLight());
            OAuthService oAuthService = getOAuthService(); // TODO handle unsuccessful initialization
            Token accessToken = getAccessTokenProperty();
            // teams table
            Translations translations = new Translations();
            Properties properties = null;
            properties = translations.getTranslations(getLanguage());
            labelInfo.setText(properties.getProperty("download_info_teams"));
            String teamDetailsXml = getResponse(oAuthService, accessToken,
                    "teamdetails&version=3.2");
            User user = getUserFromHt(teamDetailsXml);
            ArrayList<Team> teams = getTeamsFromHt(teamDetailsXml);
            Connection db = createDatabaseConnection();
            deleteFromTeams(db, user);
            for (Team team : teams) {
                insertIntoTeams(db, user, team);
                // cups table
                deleteFromCups(db, team);
                String worldDetailsXml = getResponse(oAuthService, accessToken,
                        "worlddetails&version=1.6&leagueID="
                                + team.getLeagueId());
                ArrayList<Cup> cups = getCupsFromHt(worldDetailsXml, team);
                for (Cup cup : cups) {
                    insertIntoCups(db, cup);
                }
                // transfers table
                labelInfo.setText(properties.getProperty("download_info_transfers"));
                deleteFromTransfers(db, team);
                String transfersXml = getResponse(oAuthService, accessToken,
                        "transfersteam&version=1.2&teamID="
                                + team.getTeamId());
                int transferPages = getTransferPagesFromHt(transfersXml);
                for (int pageCnt = 1; pageCnt <= transferPages; pageCnt++) {
                    String transfersPageXml = getResponse(oAuthService,
                            accessToken,
                            "transfersteam&version=1.2&teamID="
                                    + team.getTeamId()
                                    + "&pageIndex=" + pageCnt);
                    ArrayList<Transfer> transfers = new ArrayList<>();
                    transfers = getTransfersFromHt(transfersPageXml, team);
                    for (Transfer transfer : transfers) {
                        insertIntoTransfers(db, transfer);
                    }
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
            // matches table
            Translations translations = new Translations();
            Properties properties = null;
            properties = translations.getTranslations(getLanguage());
            labelInfo.setText(properties.getProperty("download_info_match_list"));
            String teamDetailsXml = getResponse(oAuthService, accessToken,
                "teamdetails&version=3.2");
            ArrayList<Team> teams = getTeamsFromHt(teamDetailsXml);
            Connection db = createDatabaseConnection();
            int teamCnt = 0;
            for (Team team : teams) {
                teamCnt++;
                int currentSeason = getSeasonFromHt(oAuthService, accessToken, team);
                int lastSeason = getLastSeasonFromDb(db, team);
                Timestamp lastMatchDate = getLastMatchDateFromDb(db, team);
                for (int seasonCnt = lastSeason; seasonCnt <= currentSeason; seasonCnt++) {
                    progressBar.setValue((int) 10 * (teamCnt - 1) + 20 * (seasonCnt - lastSeason + 1) / ((currentSeason - lastSeason + 1) * teams.size()));
                    ArrayList<Match> matchesList = new ArrayList<>();
                    matchesList = getMatchesFromHt(oAuthService, accessToken,
                            team, seasonCnt, lastMatchDate);
                    for (Match match : matchesList) {
                        insertIntoMatches(db, match);
                    }
                }
            }
            // league ids table
            deleteFromLeagueIds(db);
            insertIntoLeagueIds(db);
            for (Team team : teams) {
                int seasons = getNumberOfSeasonsFromDb(db, team);
                ArrayList<Integer> missingSeasons = new ArrayList<>();
                missingSeasons = getMissingSeasonsFromDb(db, team);
                int firstSeason = getMinSeasonFromDb(db, team);
                int lastSeason = getMaxSeasonFromDb(db, team);
                if (missingSeasons.size() == 2) {
                    int firstLeagueId = getLeagueIdFromSeasonFromHt(oAuthService,
                            accessToken, team, firstSeason);
                    int lastLeagueId = team.getLeagueLevelUnitId();
                    updateSeason(db, team, firstSeason, firstLeagueId);
                    updateSeason(db, team, lastSeason, lastLeagueId);
                }
                if (missingSeasons.size() == 1) {
                    if (seasons > 1) {
                        if (missingSeasons.get(0) == firstSeason) {
                            int firstLeagueId = getLeagueIdFromSeasonFromHt(oAuthService,
                                    accessToken, team, firstSeason);
                            updateSeason(db, team, firstSeason, firstLeagueId);
                        } else {
                            int lastLeagueId = team.getLeagueLevelUnitId();
                            updateSeason(db, team, lastSeason, lastLeagueId);
                        }
                    } else {
                        int firstLeagueId = getLeagueIdFromSeasonFromHt(oAuthService,
                            accessToken, team, firstSeason);
                        if (firstLeagueId == 0) {
                            int lastLeagueId = team.getLeagueLevelUnitId();
                            updateSeason(db, team, lastSeason, lastLeagueId);
                        } else {
                            updateSeason(db, team, firstSeason, firstLeagueId);
                        }
                    }
                }
            }
            // league names table
            deleteFromLeagueNames(db);
            ArrayList<Integer> leagueIds = new ArrayList<>();
            leagueIds = getLeagueIdsFromDb(db);
            for (int leagueId : leagueIds) {
                League league = new League();
                league = getLeagueFromHt(oAuthService, accessToken, leagueId);
                insertIntoLeagueNames(db, league);
            }
            // leagues table
            deleteFromLeagues(db);
            insertIntoLeagues(db);
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
            // match details table
            Translations translations = new Translations();
            Properties properties = null;
            properties = translations.getTranslations(getLanguage());
            labelInfo.setText(properties.getProperty("download_info_match_details"));
            String teamDetailsXml = getResponse(oAuthService, accessToken,
                "teamdetails&version=3.2");
            ArrayList<Team> teams = getTeamsFromHt(teamDetailsXml);
            Connection db = createDatabaseConnection();
            int teamCnt = 0;
            for (Team team : teams) {
                teamCnt++;
                ArrayList<Match> matches = new ArrayList<>();
                matches = getMissingMatchesFromDb(db, team);
                int matchCnt = 0;
                for (Match match : matches) {
                    matchCnt++;
                    progressBar.setValue((int) 20 + 40 * (teamCnt - 1) + 80 * matchCnt / (matches.size() * teams.size()));
                    String matchDetailsXml = getResponse(oAuthService,
                            accessToken,
                            "matchdetails&version=2.7&matchEvents=true&matchID="
                                    + match.getMatchId());
                    MatchDetails matchDetails = getMatchDetailsFromHt(matchDetailsXml, match);
                    insertIntoMatchDetails(db, matchDetails);
                    ArrayList<Referee> referees = getRefereesFromHt(matchDetailsXml,
                            match);
                    for (Referee referee : referees) {
                        insertIntoReferees(db, referee);
                    }
                    ArrayList<Goal> goals = getGoalsFromHt(matchDetailsXml, match);
                    for (Goal goal : goals) {
                        insertIntoGoals(db, goal);
                    }
                    ArrayList<Booking> bookings = getBookingsFromHt(matchDetailsXml,
                            match);
                    for (Booking booking : bookings) {
                        insertIntoBookings(db, booking);
                    }
                    ArrayList<Injury> injuries = getInjuriesFromHt(matchDetailsXml,
                            match);
                    for (Injury injury : injuries) {
                        insertIntoInjuries(db, injury);
                    }
                    ArrayList<Event> events = getEventsFromHt(matchDetailsXml, match);
                    for (Event event : events) {
                        insertIntoEvents(db, event);
                    }
                    // lineups
                    String matchLineupXml = getResponse(oAuthService,
                            accessToken,
                            "matchlineup&version=1.8&matchID="
                                    + match.getMatchId()
                                    + "&teamID=" + match.getTeamId());
                    ArrayList<StartingLineup> startingLineups = getStartingLineupFromHt(matchLineupXml, match);
                    for (StartingLineup startingLineup : startingLineups) {
                        insertIntoStartingLineups(db, startingLineup);
                    }
                    ArrayList<Substitution> substitutions = getSubstitutionsFromHt(matchLineupXml, match);
                    for (Substitution substitution : substitutions) {
                        insertIntoSubstitutions(db, substitution);
                    }
                    ArrayList<Lineup> lineups = getLineupFromHt(matchLineupXml, match);
                    for (Lineup lineup : lineups) {
                        insertIntoLineups(db, lineup);
                    }
                }
            }
            // matches extended table
            deleteFromMatchesExtended(db);
            insertIntoMatchesExtended(db);
            // players table
            deleteFromPlayers(db);
            insertIntoPlayers(db);
            db.close();
            return null;
        }
        
        @Override
        public void done() {
            progressBar.setValue(100);
            buttonDownload.setEnabled(true);
            labelInfo.setForeground(getGreen());
            Translations translations = new Translations();
            Properties properties = null;
            try {
                properties = translations.getTranslations(getLanguage());
                labelInfo.setText(properties.getProperty("download_info_completed"));
            } catch (IOException ex) {
                Logger.getLogger(DownloadBase.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                Connection db = createDatabaseConnection();
                ensureTablesExist(db);
                setTeams(getTeamsFromDb(db, getUserId()));
                setCurrentTeam(getTeams().get(0));
                getMenu().refreshMenu();
                getMenu().getLabelDownload().setForeground(getOrange());
                db.close();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(DownloadBase.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(DownloadBase.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(DownloadBase.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    public void refreshDownload() {
        Translations translations = new Translations();
        Properties properties = null;
        try {
            properties = translations.getTranslations(getLanguage());
            labelTitle.setText(properties.getProperty("download_title"));
            labelText1.setText(properties.getProperty("download_text_1"));
            buttonDownload.setText(properties.getProperty("download_download"));
        } catch (IOException ex) {
            Logger.getLogger(DownloadBase.class.getName()).log(Level.SEVERE, null, ex);
        }
        labelInfo.setText(" ");
        progressBar.setValue(0);
        buttonDownload.setEnabled(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonDownload;
    private javax.swing.JLabel labelInfo;
    private javax.swing.JLabel labelText1;
    private javax.swing.JLabel labelTitle;
    private javax.swing.JProgressBar progressBar;
    // End of variables declaration//GEN-END:variables
}
