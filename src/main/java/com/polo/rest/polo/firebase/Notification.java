package com.polo.rest.polo.firebase;

public class Notification {

	private String to;
	private NotificationBody notification;
	
	public Notification() {
	}

	public Notification(String destinationDeviceToken, String title, String body, Long eventId) {
		NotificationBody notificationBody = new NotificationBody();
		notificationBody.setTitle(title);
		notificationBody.setBody(body);
		notificationBody.setEventId(eventId);
		
		this.to = destinationDeviceToken;
		this.notification = notificationBody;
	}
	
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public NotificationBody getNotification() {
		return notification;
	}
	public void setNotification(NotificationBody notification) {
		this.notification = notification;
	}
	
	@Override
	public String toString() {
		return "Notification [to=" + to + ", notification=" + notification + "]";
	}

	class NotificationBody {

	    private String title;
	    private String body;
	    private Long eventId;

	    public Long getEventId() {
			return eventId;
		}
		public void setEventId(Long eventId) {
			this.eventId = eventId;
		}
		public String getTitle() {
	        return title;
	    }
	    public void setTitle( String title ) {
	        this.title = title;
	    }
	    public String getBody() {
	        return body;
	    }
	    public void setBody( String body ) {
	        this.body = body;
	    }
	    
		@Override
		public String toString() {
			return "NotificationBody [title=" + title + ", body=" + body + ", eventId=" + eventId + "]";
		}
	    
	}
	
}
