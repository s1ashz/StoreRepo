package com.polo.rest.polo.responses;

public class ResponseJson {

	private String action;
	private boolean success;
	private Long id;
	
	public ResponseJson(String action, boolean success ) {
        this.action = action;
        this.success = success;
    }
    
	public ResponseJson(String action, boolean success, Long id ) {
		this.action = action;
		this.success = success;
		this.id = id;
	}

	public String getAction() {
        return action;
    }
    public void setAction( String action ) {
        this.action = action;
    }
    public boolean isSuccess() {
        return success;
    }
    public void setSuccess( boolean success ) {
        this.success = success;
    }
    public Long getId() {
        return id;
    }
    public void setId( Long id ) {
        this.id = id;
    }

    @Override
    public String toString() {
        if ( null == id ) return "ResponseJson [action=" + action + ", success=" + success + "]";
        return "ResponseJson [action=" + action + ", success=" + success + ", id=" + id + "]";
    }
	
}
