package com.polo.rest.polo.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.polo.rest.polo.dao.AccountDao;
import com.polo.rest.polo.dao.EventDao;
import com.polo.rest.polo.entity.Event;
import com.polo.rest.polo.exceptions.EventException;
import com.polo.rest.polo.firebase.FirebaseNotification;
import com.polo.rest.polo.responses.ResponseJson;

import static com.polo.rest.polo.constants.Actions.*;
import static com.polo.rest.polo.constants.ExceptionMessages.*;

import java.util.List;

@Service
public class EventService
{
    
    @Autowired
    private EventDao eventDao;
    
    @Autowired
    private AccountDao accountDao;
    
    @Autowired
    private FirebaseNotification firebaseNotification;
    
    public ResponseJson createEvent( Event event ) {
        Long eventId = eventDao.createEvent( event );
        
        String deviceToken = "cnebGj_bVGk:APA91bE_GjTEiUzuTxaQnazwR7Uj6Ewyz23XwTtkMYsq7PhmboitNtpNE_Xw1k0AFeF7LQRjvk8ZsyGkUz12uuTqT_OzmERbL0DUGRkM5Opjt1KrNRrqWxPmxgdMsRff6aITeRgmqq0t";
        String tokenJonny = "fQifALzSnaE:APA91bGreU3WKUeTzLhmNvwVvIcwcKVeaAl9JdQ6z-nKuSoXaUtMpGIArdYoXROXZYs4WMcQHR8WuktglRtLHH_dBxvt9WyQ7kI3NAkdop3BjWO29bkJik-38iFznjt9sz4OKa-2T4W7";
        String tokenJonnyExpirado = "enG6OnFVLzo:APA91bHSiu3sZ5tO0QzmlVTLIMS8gf5yUjqh20hM4T3yhoyzDU2aiP715u22c_UhU_X6uqGCUe7V9yXN702vbDhOVsb4_tnitMy_gQrwbty6NBcjjOBZYtSLNZiunswjmfkM8GOQx0If";
        
        String title = "Pro title of notif";
        String body = "Body??";
        int eventId1 = 2;
        
        
        FirebaseNotification.sendPushNotification(deviceToken, title, body, eventId);
        
        return new ResponseJson( CREATE, true, eventId );
    }

    public Event getEvent( Long eventId ) throws EventException {
        return eventDao.getEvent( eventId );
    }

    public List<Event> getAllEvents() {
        return eventDao.getAllEvents();
    }

    public List<Event> getEventsByCardId( int cardId ) {
        String target = accountDao.getAccountLevelByCardId( cardId );
        return eventDao.getEventsByTarget( target );
    }

    public ResponseJson deleteEventById( int id ) throws EventException {
        if ( !checkEventExists( id ) ) throw new EventException( EXCEPTION_EVENT_NOT_EXISTS + id );
        eventDao.deleteEventById( id );
        return new ResponseJson( DELETE, true, Long.valueOf( id ) );
    }

    public ResponseJson updateEvent( Event event ) throws EventException {
        if ( !checkEventExists( event.getId() ) ) throw new EventException( EXCEPTION_EVENT_NOT_EXISTS + event.getId() );
        eventDao.updateEvent( event );
        return new ResponseJson( UPDATE, true, event.getId() );
    }

    private boolean checkEventExists( long id ) {
        return eventDao.checkEventExists( id );
    }

}
