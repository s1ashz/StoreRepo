package com.polo.rest.polo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Payment
{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    private int cardId;
    private int year;
    private int month;
    private boolean paid;
    private double ammount;
    
    public long getId() {
        return id;
    }
    public void setId( long id ) {
        this.id = id;
    }
    public int getCardId() {
        return cardId;
    }
    public void setCardId( int cardId ) {
        this.cardId = cardId;
    }
    public int getYear() {
        return year;
    }
    public void setYear( int year ) {
        this.year = year;
    }
    public boolean isPaid() {
        return paid;
    }
    public void setPaid( boolean paid ) {
        this.paid = paid;
    }
    public double getAmmount() {
        return ammount;
    }
    public void setAmmount( double ammount ) {
        this.ammount = ammount;
    }
    public int getMonth() {
        return month;
    }
    public void setMonth( int month ) {
        this.month = month;
    }
    
    @Override
    public String toString() {
        return "Payment [id=" + id + ", cardId=" + cardId + ", year=" + year + ", month=" + month + ", paid=" + paid + ", ammount="
                + ammount + "]";
    }
    
}




// id   cardID      Year    Month      paid         ammount
// 1     113        2017      1        true          20.00
// 2     113        2017      2        true          25.00
// 3     113        2017      3        true          30.00
// 4     113        2017      4        true          10.00
//
//

//getBy year:

/*

// get payments 
GET account/{cardId}/payments

    [{
        year:2017
        months:[20.00, 25.00, 30.00, 10.00 ,...]
    }, 
    {
        year:2018
        months:[10.00, 10.00, 10.00, 10.00 ,...]
    }]

GET account/{cardId}/payments/{year}

    {
        amount: 10.00
        year:2018
        months:[true, false, false, false ,...]
    }

GET account/{cardId}/payments/{year}/{month}

    {
        amount: 10.00
        payed : true 
    }

*/