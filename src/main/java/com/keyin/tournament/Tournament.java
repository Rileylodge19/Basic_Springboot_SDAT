package com.keyin.tournament;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Tournament {
    @Id
    @SequenceGenerator(name = "tournament_sequence", sequenceName = "tournament_sequence", allocationSize = 1, initialValue=10)
    @GeneratedValue(generator = "tournament_sequence")

    private Long id;

    private Date StartDate;

    private Date EndDate;

    private String Location;

    private double EntryFee;

    private double CashPrizeAmount;

    public Tournament() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getStartDate() {
        return StartDate;
    }

    public void setStartDate(Date startDate) {
        StartDate = startDate;
    }

    public Date getEndDate() {
        return EndDate;
    }

    public void setEndDate(Date endDate) {
        EndDate = endDate;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public double getEntryFee() {
        return EntryFee;
    }

    public void setEntryFee(double entryFee) {
        EntryFee = entryFee;
    }

    public double getCashPrizeAmount() {
        return CashPrizeAmount;
    }

    public void setCashPrizeAmount(double cashPrizeAmount) {
        CashPrizeAmount = cashPrizeAmount;
    }
}
