package com.polo.rest.polo.dto;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.polo.rest.polo.constants.Months;

public class PaymentDto
{
    
    private int cardId;
    private int year;
    private List<MonthPaymentsDto> monthPayments;
    
    public PaymentDto() {
        createMonths();
    
    }

    private void createMonths() {
        monthPayments = new LinkedList<>();
        MonthPaymentsDto september = new MonthPaymentsDto( Months.SEPTEMBER.getMonthIndex() );
        MonthPaymentsDto october = new MonthPaymentsDto( Months.OCTOBER.getMonthIndex() );
        MonthPaymentsDto november = new MonthPaymentsDto( Months.NOVEMBER.getMonthIndex() );
        MonthPaymentsDto december = new MonthPaymentsDto( Months.DECEMBER.getMonthIndex() );
        MonthPaymentsDto january = new MonthPaymentsDto( Months.JANUARY.getMonthIndex() );
        MonthPaymentsDto february = new MonthPaymentsDto( Months.FEBRUARY.getMonthIndex() );
        MonthPaymentsDto march = new MonthPaymentsDto( Months.MARCH.getMonthIndex() );
        MonthPaymentsDto april = new MonthPaymentsDto( Months.APRIL.getMonthIndex() );
        MonthPaymentsDto may = new MonthPaymentsDto( Months.MAY.getMonthIndex() );
        MonthPaymentsDto june = new MonthPaymentsDto( Months.JUNE.getMonthIndex() );
        MonthPaymentsDto july = new MonthPaymentsDto( Months.JULY.getMonthIndex() );
        MonthPaymentsDto august = new MonthPaymentsDto( Months.AUGUST.getMonthIndex() );
        
        monthPayments.add( september );
        monthPayments.add( october );
        monthPayments.add( november );
        monthPayments.add( december );
        monthPayments.add( january );
        monthPayments.add( february );
        monthPayments.add( march );
        monthPayments.add( april );
        monthPayments.add( may );
        monthPayments.add( june );
        monthPayments.add( july );
        monthPayments.add( august );
        
        setMonthPayments( monthPayments );
    }
    
    public int getYear() {
        return year;
    }
    public void setYear( int year ) {
        this.year = year;
    }
    public List<MonthPaymentsDto> getMonthPayments() {
        return monthPayments;
    }
    public void setMonthPayments( List<MonthPaymentsDto> monthPayments ) {
        this.monthPayments = monthPayments;
    }
    public int getCardId() {
        return cardId;
    }
    public void setCardId( int cardId ) {
        this.cardId = cardId;
    }

    @Override
    public String toString() {
        return "PaymentDto [cardId=" + cardId + ", year=" + year + ", monthPayments=" + monthPayments + "]";
    }

}
