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
public class Booking {
    
    private long matchId;
    private int teamId;
    private int bookingIndex;
    private int bookingPlayerId;
    private String bookingPlayerName;
    private int bookingTeamId;
    private int bookingType;
    private int bookingMinute;

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

    public int getBookingIndex() {
        return bookingIndex;
    }

    public void setBookingIndex(int bookingIndex) {
        this.bookingIndex = bookingIndex;
    }

    public int getBookingPlayerId() {
        return bookingPlayerId;
    }

    public void setBookingPlayerId(int bookingPlayerId) {
        this.bookingPlayerId = bookingPlayerId;
    }

    public String getBookingPlayerName() {
        return bookingPlayerName;
    }

    public void setBookingPlayerName(String bookingPlayerName) {
        this.bookingPlayerName = bookingPlayerName;
    }

    public int getBookingTeamId() {
        return bookingTeamId;
    }

    public void setBookingTeamId(int bookingTeamId) {
        this.bookingTeamId = bookingTeamId;
    }

    public int getBookingType() {
        return bookingType;
    }

    public void setBookingType(int bookingType) {
        this.bookingType = bookingType;
    }

    public int getBookingMinute() {
        return bookingMinute;
    }

    public void setBookingMinute(int bookingMinute) {
        this.bookingMinute = bookingMinute;
    }

    public Booking() {
    }
    
}
