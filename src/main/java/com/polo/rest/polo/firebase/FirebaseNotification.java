package com.polo.rest.polo.firebase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;

import org.springframework.stereotype.Component;

import com.google.gson.Gson;

@Component
public class FirebaseNotification
{
	//"cnebGj_bVGk:APA91bE_GjTEiUzuTxaQnazwR7Uj6Ewyz23XwTtkMYsq7PhmboitNtpNE_Xw1k0AFeF7LQRjvk8ZsyGkUz12uuTqT_OzmERbL0DUGRkM5Opjt1KrNRrqWxPmxgdMsRff6aITeRgmqq0t";
    public final static String AUTH_KEY_GOOGLE_SERVER_FCM = "AAAA7YqSCLw:APA91bFNhyUemywPVE4nBFaGksFawByoC3GJlVYagBDN9uRWztZ6fz0dDZFLQ8Dz8_5Y2vNA95RltEMpmi-NW-vVZbvKxsd9YyBawtfqznqEc4md9ZbEs99EcNGoCGEWvxfjrg0u35H3";
    public final static String GOOGLE_API_SERVER_FCM = "https://fcm.googleapis.com/fcm/send";
    
    public boolean sendPushNotification(String deviceToken, String title, String body, Long eventId ) {
        boolean result = false;
        URL url;

        try {
            url = new URL(GOOGLE_API_SERVER_FCM);
            HttpURLConnection conn = createConnection( url );
            
            String jsonFromGson = createNotificationJSON(deviceToken, title, body, eventId);
            writeOutputStream(conn, jsonFromGson);
            
            //Output from server, probably not necessary
            BufferedReader br = new BufferedReader( new InputStreamReader( (conn.getInputStream()) ) );
            result = readFromOutputStream(result, br);
        } catch (Exception e) {
            e.printStackTrace();
            result = false;
        }
        return result;
    }

	private boolean readFromOutputStream(boolean result, BufferedReader br) throws IOException {
		String output;
		while ((output = br.readLine()) != null) {
		    FirebaseNotificationResponse response = new Gson().fromJson(output, FirebaseNotificationResponse.class);
		    if ( null != response ) {
		    	result = ( response.getSuccess() == 1 ) ? true : false;
		    }
		}
		return result;
	}

	private String createNotificationJSON(String deviceToken, String title, String body, Long eventId) {
		Notification notif = new Notification(deviceToken, title, body, eventId);
		return new Gson().toJson( notif );
	}

	private void writeOutputStream(HttpURLConnection conn, String jsonFromGson) throws IOException {
		OutputStreamWriter wr = new OutputStreamWriter( conn.getOutputStream() );
		wr.write( jsonFromGson );
		wr.flush();
	}

    private HttpURLConnection createConnection( URL url ) throws IOException, ProtocolException {
        HttpURLConnection conn;
        conn = (HttpURLConnection) url.openConnection();
        conn.setUseCaches(false);
        conn.setDoInput(true);
        conn.setDoOutput(true);
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Authorization", "key=" + AUTH_KEY_GOOGLE_SERVER_FCM);
        conn.setRequestProperty("Content-Type", "application/json");
        return conn;
    }

}
