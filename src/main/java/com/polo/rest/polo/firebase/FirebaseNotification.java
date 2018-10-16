package com.polo.rest.polo.firebase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;

import org.json.JSONObject;

import com.google.gson.Gson;
import com.jayway.jsonpath.spi.mapper.GsonMappingProvider;

import net.bytebuddy.description.type.TypeVariableToken;

public class FirebaseNotification
{

    public final static String AUTH_KEY_GOOGLE_SERVER_FCM = "AAAA7YqSCLw:APA91bFNhyUemywPVE4nBFaGksFawByoC3GJlVYagBDN9uRWztZ6fz0dDZFLQ8Dz8_5Y2vNA95RltEMpmi-NW-vVZbvKxsd9YyBawtfqznqEc4md9ZbEs99EcNGoCGEWvxfjrg0u35H3";
    public final static String GOOGLE_API_SERVER_FCM = "https://fcm.googleapis.com/fcm/send";
    
    public static void main(String[] args) {
        String token = "cnebGj_bVGk:APA91bE_GjTEiUzuTxaQnazwR7Uj6Ewyz23XwTtkMYsq7PhmboitNtpNE_Xw1k0AFeF7LQRjvk8ZsyGkUz12uuTqT_OzmERbL0DUGRkM5Opjt1KrNRrqWxPmxgdMsRff6aITeRgmqq0t";
        String tokenJonny = "fQifALzSnaE:APA91bGreU3WKUeTzLhmNvwVvIcwcKVeaAl9JdQ6z-nKuSoXaUtMpGIArdYoXROXZYs4WMcQHR8WuktglRtLHH_dBxvt9WyQ7kI3NAkdop3BjWO29bkJik-38iFznjt9sz4OKa-2T4W7";
        String tokenJonnyExpirado = "enG6OnFVLzo:APA91bHSiu3sZ5tO0QzmlVTLIMS8gf5yUjqh20hM4T3yhoyzDU2aiP715u22c_UhU_X6uqGCUe7V9yXN702vbDhOVsb4_tnitMy_gQrwbty6NBcjjOBZYtSLNZiunswjmfkM8GOQx0If";
        
        System.out.println( token );
        
        sendPushNotification( token );
    }
    
    public static String sendPushNotification(String deviceToken) {
        String result = "";
        URL url;
        
        try {
            url = new URL(GOOGLE_API_SERVER_FCM);
            HttpURLConnection conn = createConnection( url );
            
            Gson gson = new Gson();
            
            NotificationObject notification = new NotificationObject();
            notification.setTitle( "this is the title" );
            notification.setBody( "This is the body of the message" );
            
            String jsonFromGson = gson.toJson( notification );
            
            JSONObject info = new JSONObject();
            JSONObject json = new JSONObject();
            
            info.put("title", "Notif"); // Notification title
            info.put("body", "New Event created"); // Notification
            // body
            json.put("to", deviceToken.trim());
            json.put("notification", info);


        
            OutputStreamWriter wr = new OutputStreamWriter( conn.getOutputStream() );
            System.out.println( json.toString() );
            wr.write( json.toString() );
            wr.flush();
 
            BufferedReader br = new BufferedReader( new InputStreamReader( (conn.getInputStream()) ) );
 
            String output;
            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                System.out.println(output);
            }
            result = "SUCCESS";
        } catch (Exception e) {
            e.printStackTrace();
            result = "FAILURE";
        }
             
        //System.out.println("GCM Notification is sent successfully");
 
        return result;
  
    }

    private static HttpURLConnection createConnection( URL url ) throws IOException, ProtocolException {
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
