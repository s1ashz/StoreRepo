package com.polo.rest.polo.dto;

import java.util.ArrayList;
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
        monthPayments = new ArrayList<>();
        MonthPaymentsDto january = new MonthPaymentsDto(Months.JANUARY.name().toUpperCase());
        MonthPaymentsDto february = new MonthPaymentsDto(Months.FEBRUARY.name().toUpperCase());
        MonthPaymentsDto march = new MonthPaymentsDto(Months.MARCH.name().toUpperCase());
        MonthPaymentsDto april = new MonthPaymentsDto(Months.APRIL.name().toUpperCase());
        MonthPaymentsDto may = new MonthPaymentsDto(Months.MAY.name().toUpperCase());
        MonthPaymentsDto june = new MonthPaymentsDto(Months.JUNE.name().toUpperCase());
        MonthPaymentsDto july = new MonthPaymentsDto(Months.JULY.name().toUpperCase());
        MonthPaymentsDto august = new MonthPaymentsDto(Months.AUGUST.name().toUpperCase());
        MonthPaymentsDto september = new MonthPaymentsDto(Months.SEPTEMBER.name().toUpperCase());
        MonthPaymentsDto october = new MonthPaymentsDto(Months.OCTOBER.name().toUpperCase());
        MonthPaymentsDto november = new MonthPaymentsDto(Months.NOVEMBER.name().toUpperCase());
        MonthPaymentsDto december = new MonthPaymentsDto(Months.DECEMBER.name().toUpperCase());
        monthPayments.add( january );
        monthPayments.add( february );
        monthPayments.add( march );
        monthPayments.add( april );
        monthPayments.add( may );
        monthPayments.add( june );
        monthPayments.add( july );
        monthPayments.add( august );
        monthPayments.add( september );
        monthPayments.add( october );
        monthPayments.add( november );
        monthPayments.add( december );
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
