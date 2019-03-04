package com.polo.rest.polo.dto;

public class PersonDto {
    
    private String name;
    private String number;
    private String type;
    
    public String getName() {
        return name;
    }
    public void setName( String name ) {
        this.name = name;
    }
    public String getNumber() {
        return number;
    }
    public void setNumber( String number ) {
        this.number = number;
    }
    public String getType() {
        return type;
    }
    public void setType( String type ) {
        this.type = type;
    }
    
    @Override
    public String toString() {
        return "PersonDto [name=" + name + ", number=" + number + ", type=" + type + "]";
    }
    
}
