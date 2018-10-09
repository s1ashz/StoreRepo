package com.polo.rest.polo.dto;

public class MonthPaymentsDto
{

    private String month;
    private double value;
    
    public MonthPaymentsDto() {
	}
    
    public MonthPaymentsDto( String monthName ) {
        month = monthName;
    }
    
    public String getMonth() {
        return month;
    }
    public void setMonth( String month ) {
        this.month = month;
    }
    public double getValue() {
        return value;
    }
    public void setValue( double value ) {
        this.value = value;
    }
    
    @Override
    public String toString() {
        return "MonthPaymentsDto [month=" + month + ", value=" + value + "]";
    }
    
}
