package com.polo.rest.polo.firebase;

public class FirebaseNotificationResponse {

	private String multicast_id;
	private int success;
	private int failure;
	private String canonical_ids;
	
	public String getMulticast_id() {
		return multicast_id;
	}
	public void setMulticast_id(String multicast_id) {
		this.multicast_id = multicast_id;
	}
	public int getSuccess() {
		return success;
	}
	public void setSuccess(int success) {
		this.success = success;
	}
	public int getFailure() {
		return failure;
	}
	public void setFailure(int failure) {
		this.failure = failure;
	}
	public String getCanonical_ids() {
		return canonical_ids;
	}
	public void setCanonical_ids(String canonical_ids) {
		this.canonical_ids = canonical_ids;
	}

	@Override
	public String toString() {
		return "FirebaseNotificationResponse [multicast_id=" + multicast_id + ", success=" + success + ", failure="
				+ failure + ", canonical_ids=" + canonical_ids + "]";
	}
	
}
