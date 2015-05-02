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
package htsquirrel.game;

import java.sql.Timestamp;

/**
 *
 * @author Aleksandar Cvetković <arcvetkovic@gmail.com>
 */
public class Transfer {
    
    private int teamId;
    private int transferId;
    private Timestamp deadline;
    private int playerId;
    private String playerName;
    private int tsi;
    private String transferType;
    private int buyerTeamId;
    private String buyerTeamName;
    private int sellerTeamId;
    private String sellerTeamName;
    private int price;

    public Transfer() {
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public int getTransferId() {
        return transferId;
    }

    public void setTransferId(int transferId) {
        this.transferId = transferId;
    }

    public Timestamp getDeadline() {
        return deadline;
    }

    public void setDeadline(Timestamp deadline) {
        this.deadline = deadline;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getTsi() {
        return tsi;
    }

    public void setTsi(int tsi) {
        this.tsi = tsi;
    }

    public String getTransferType() {
        return transferType;
    }

    public void setTransferType(String transferType) {
        this.transferType = transferType;
    }

    public int getBuyerTeamId() {
        return buyerTeamId;
    }

    public void setBuyerTeamId(int buyerTeamId) {
        this.buyerTeamId = buyerTeamId;
    }

    public String getBuyerTeamName() {
        return buyerTeamName;
    }

    public void setBuyerTeamName(String buyerTeamName) {
        this.buyerTeamName = buyerTeamName;
    }

    public int getSellerTeamId() {
        return sellerTeamId;
    }

    public void setSellerTeamId(int sellerTeamId) {
        this.sellerTeamId = sellerTeamId;
    }

    public String getSellerTeamName() {
        return sellerTeamName;
    }

    public void setSellerTeamName(String sellerTeamName) {
        this.sellerTeamName = sellerTeamName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    
}
