package com.polo.rest.polo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.CompletableFuture;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;


@SpringBootApplication
public class PoloApplication {

//	public static void main(String[] args) {
//		SpringApplication.run(PoloApplication.class, args);
//	}
//	
    

//    private static String sendFcmMessage(JsonObject sendObject, JsonObject notificationObject, JsonObject dataObject) throws IOException {
//    
//        String token = "cnebGj_bVGk:APA91bE_GjTEiUzuTxaQnazwR7Uj6Ewyz23XwTtkMYsq7PhmboitNtpNE_Xw1k0AFeF7LQRjvk8ZsyGkUz12uuTqT_OzmERbL0DUGRkM5Opjt1KrNRrqWxPmxgdMsRff6aITeRgmqq0t";
//        String firebase = "https://fcm.googleapis.com/fcm/send";
//        
//        
//        HttpPost httpPost = new HttpPost(firebase);
//
//        // Header setzen
//        httpPost.setHeader("Content-Type", "application/json");
//        httpPost.setHeader("Authorization", "key=" + "AIzaSyD7UpZ3-svqQxYkisM6z-H9g7OYVIo7qbU");
//
//        if (notificationObject != null) sendObject.add("notification", notificationObject);
//        if (dataObject != null) sendObject.add("data", dataObject);
//
//        String data = sendObject.toString();
//
//        StringEntity entity = new StringEntity(data);
//
//        // JSON-Object übergeben
//        httpPost.setEntity(entity);
//
//        /*
//        {
//            "to":
//              "d4_9RguWZNQ:APA91bH677zDilszjdf30-i12-0W-02314-0@0-123495-0-02-Something-rXEtW_wZNXa6K_-V96rEHPEysXSIfL",
//            "data": {
//              "title": "I'd tell you a chemistry joke",
//              "message": "but I know I wouldn't get a reaction",
//              "image-url":
//                "https://docs.centroida.co/wp-content/uploads/2017/05/notification.png"
//            }
//          }
//        */
////        JsonObject obj = new JsonObject();
////        obj.addProperty( "to", token );
////        JsonObject objData = new JsonObject();
////        objData.addProperty( "title", "lasdf" );
////        objData.addProperty( "message", "fck you" );
////        obj.add( "data", objData );
////        
////        String data = obj.toString();
////        StringEntity entity = new StringEntity(data);
//        //httpPost.setEntity(entity);
//        
//        HttpClient httpClient = HttpClientBuilder.create().build();
//
//        BasicResponseHandler responseHandler = new BasicResponseHandler();
//        String response = (String) httpClient.execute(httpPost, responseHandler);
//
//        return response;
//    }
//    
//    
//    public static void main( String[] args ) throws IOException {
//        
//        //testedudeemail@test.com
//        //oNILO4wM1TeT1BvJrczDLBJatJh2
//
//        
//        JsonObject sendObject = new JsonObject();
//        JsonObject notificationObject = new JsonObject();
//        JsonObject dataObject = new JsonObject();
//        
//        sendFcmMessage( sendObject, notificationObject, dataObject );
//    }
    
//    public static void main( String[] args ) throws IOException {
//
//        String token = "cnebGj_bVGk:APA91bE_GjTEiUzuTxaQnazwR7Uj6Ewyz23XwTtkMYsq7PhmboitNtpNE_Xw1k0AFeF7LQRjvk8ZsyGkUz12uuTqT_OzmERbL0DUGRkM5Opjt1KrNRrqWxPmxgdMsRff6aITeRgmqq0t";
//        String firebase = "https://firebase.google.com/docs/cloud-messaging/http-server-ref";
//        String firebaselink = "https://fcm.googleapis.com/fcm/send";
//        String firebaseServerToken = "AIzaSyD7UpZ3-svqQxYkisM6z-H9g7OYVIo7qbU";
//        
//        DefaultHttpClient httpClient = new DefaultHttpClient();
//        HttpPost postRequest = new HttpPost(firebaselink);
//
//        // we already created this model class.
//        // we will convert this model class to json object using google gson library.
//
//        NotificationRequestModel notificationRequestModel = new NotificationRequestModel();
//        NotificationData notificationData = new NotificationData();
//
//        notificationData.setDetail("this is firebase push notification from java client (server)");
//        notificationData.setTitle("Hello Firebase Push Notification");
//        notificationRequestModel.setData(notificationData);
//        notificationRequestModel.setTo(token);
//
//
//        Gson gson = new Gson();
//        Type type = new TypeToken<NotificationRequestModel>() {
//        }.getType();
//
//        String json = gson.toJson(notificationRequestModel, type);
//
//        StringEntity input = new StringEntity(json);
//        input.setContentType("application/json");
//        
//
//        // server key of your firebase project goes here in header field.
//        // You can get it from firebase console.
//
//        postRequest.addHeader("Authorization", "key=AIzaSyD7UpZ3-svqQxYkisM6z-H9g7OYVIo7qbU");
//        postRequest.setEntity(input);
//
//        System.out.println("reques:" + json);
//
//        HttpResponse response = httpClient.execute(postRequest);
//
//        if (response.getStatusLine().getStatusCode() != 200) {
//            throw new RuntimeException("Failed : HTTP error code : "
//                    + response.getStatusLine().getStatusCode());
//        } else if (response.getStatusLine().getStatusCode() == 200) {
//
//            System.out.println("response:" + EntityUtils.toString(response.getEntity()));
//           
//        }
//    }
    
    
    
    
    
    
    
    
    public static void main(String[] args) {
        String token = "cnebGj_bVGk:APA91bE_GjTEiUzuTxaQnazwR7Uj6Ewyz23XwTtkMYsq7PhmboitNtpNE_Xw1k0AFeF7LQRjvk8ZsyGkUz12uuTqT_OzmERbL0DUGRkM5Opjt1KrNRrqWxPmxgdMsRff6aITeRgmqq0t";
        String tokenJonny = "enG6OnFVLzo:APA91bHSiu3sZ5tO0QzmlVTLIMS8gf5yUjqh20hM4T3yhoyzDU2aiP715u22c_UhU_X6uqGCUe7V9yXN702vbDhOVsb4_tnitMy_gQrwbty6NBcjjOBZYtSLNZiunswjmfkM8GOQx0If";
        System.out.println( token );
        sendPushNotification( tokenJonny );
    }
    
    
    
    
    public final static String AUTH_KEY_FCM = "AAAA7YqSCLw:APA91bFNhyUemywPVE4nBFaGksFawByoC3GJlVYagBDN9uRWztZ6fz0dDZFLQ8Dz8_5Y2vNA95RltEMpmi-NW-vVZbvKxsd9YyBawtfqznqEc4md9ZbEs99EcNGoCGEWvxfjrg0u35H3";
    public final static String API_URL_FCM = "https://fcm.googleapis.com/fcm/send";
     
        public static String sendPushNotification(String deviceToken)
                 {
            String result = "";
            URL url;
                try {
                    url = new URL(API_URL_FCM);
                
            HttpURLConnection conn;
                conn = (HttpURLConnection) url.openConnection();
     
            conn.setUseCaches(false);
            conn.setDoInput(true);
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Authorization", "key=" + AUTH_KEY_FCM);
            conn.setRequestProperty("Content-Type", "application/json");
            
            JSONObject json = new JSONObject();
            
            String serverAPI = "AIzaSyD4p7M0xg-kJxbzUWJa1uKTpAkS03FXvao";
            
            json.put("to", deviceToken.trim());
            JSONObject info = new JSONObject();
            info.put("title", "pissas"); // Notification title
            info.put("body", "Po crl paneleiro, deves ir ver o filme da lady gaga"); // Notification
            // body
            json.put("notification", info);


            
                OutputStreamWriter wr = new OutputStreamWriter(
                        conn.getOutputStream());
                wr.write(json.toString());
                wr.flush();
     
                BufferedReader br = new BufferedReader(new InputStreamReader(
                        (conn.getInputStream())));
     
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
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
        
}

