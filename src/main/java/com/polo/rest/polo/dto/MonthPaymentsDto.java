package com.polo.rest.polo.dto;

public class MonthPaymentsDto
{

    private int month;
    private double value;
    
    public MonthPaymentsDto() {
	}
    
    public MonthPaymentsDto( int monthIndex ) {
        this.month = monthIndex;
    }
    
    public double getValue() {
        return value;
    }
    public void setValue( double value ) {
        this.value = value;
    }
    public int getMonth() {
        return month;
    }
    public void setMonth( int month ) {
        this.month = month;
    }

    @Override
    public String toString() {
        return "MonthPaymentsDto [month=" + month + ", value=" + value + "]";
    }
    
    
}
