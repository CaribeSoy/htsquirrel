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
package htsquirrel.game;

/**
 *
 * @author Aleksandar Cvetković <arcvetkovic@gmail.com>
 */
public class Event {
    
    private long matchId;
    private int teamId;
    private int eventIndex;
    private int eventMinute;
    private int eventType;
    private int eventVariation;
    private int eventSubjectTeamId;
    private int eventSubjectPlayerId;
    private int eventObjectPlayerId;
    private String eventText;

    public long getMatchId() {
        return matchId;
    }

    public void setMatchId(long matchId) {
        this.matchId = matchId;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public int getEventIndex() {
        return eventIndex;
    }

    public void setEventIndex(int eventIndex) {
        this.eventIndex = eventIndex;
    }

    public int getEventMinute() {
        return eventMinute;
    }

    public void setEventMinute(int eventMinute) {
        this.eventMinute = eventMinute;
    }

    public int getEventType() {
        return eventType;
    }

    public void setEventType(int eventType) {
        this.eventType = eventType;
    }

    public int getEventVariation() {
        return eventVariation;
    }

    public void setEventVariation(int eventVariation) {
        this.eventVariation = eventVariation;
    }

    public int getEventSubjectTeamId() {
        return eventSubjectTeamId;
    }

    public void setEventSubjectTeamId(int eventSubjectTeamId) {
        this.eventSubjectTeamId = eventSubjectTeamId;
    }

    public int getEventSubjectPlayerId() {
        return eventSubjectPlayerId;
    }

    public void setEventSubjectPlayerId(int eventSubjectPlayerId) {
        this.eventSubjectPlayerId = eventSubjectPlayerId;
    }

    public int getEventObjectPlayerId() {
        return eventObjectPlayerId;
    }

    public void setEventObjectPlayerId(int eventObjectPlayerId) {
        this.eventObjectPlayerId = eventObjectPlayerId;
    }

    public String getEventText() {
        return eventText;
    }

    public void setEventText(String eventText) {
        this.eventText = eventText;
    }

    public Event() {
    }
    
}
