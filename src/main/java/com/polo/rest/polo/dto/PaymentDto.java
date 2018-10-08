package com.polo.rest.polo.dto;

import java.util.Map;

public class PaymentDto
{
    
    private int year;
    private Map<String, Double> monthPayments;
    
    public int getYear() {
        return year;
    }
    public void setYear( int year ) {
        this.year = year;
    }
    public Map<String, Double> getMonthPayments() {
        return monthPayments;
    }
    public void setMonthPayments( Map<String, Double> monthPayments ) {
        this.monthPayments = monthPayments;
    }
    
    @Override
    public String toString() {
        return "PaymentDto [year=" + year + ", monthPayments=" + monthPayments + "]";
    }
    

}
