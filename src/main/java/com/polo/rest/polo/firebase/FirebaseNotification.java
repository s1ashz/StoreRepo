package com.polo.rest.polo.firebase;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;

public class FirebaseNotification
{

    private static String token = "cnebGj_bVGk:APA91bE_GjTEiUzuTxaQnazwR7Uj6Ewyz23XwTtkMYsq7PhmboitNtpNE_Xw1k0AFeF7LQRjvk8ZsyGkUz12uuTqT_OzmERbL0DUGRkM5Opjt1KrNRrqWxPmxgdMsRff6aITeRgmqq0t";
    
    //cnebGj_bVGk:APA91bE_GjTEiUzuTxaQnazwR7Uj6Ewyz23XwTtkMYsq7PhmboitNtpNE_Xw1k0AFeF7LQRjvk8ZsyGkUz12uuTqT_OzmERbL0DUGRkM5Opjt1KrNRrqWxPmxgdMsRff6aITeRgmqq0t
    
    public FirebaseNotification() {
    }

    public static void sendNotification( String token ) throws JSONException {

//      JSONObject body = new JSONObject();
//      body.put("to", "/topics/");
//      body.put("priority", "high");
//
//      JSONObject notification = new JSONObject();
//      notification.put("title", "JSA Notification");
//      notification.put("body", "Happy Message!");
//      
//      JSONObject data = new JSONObject();
//      data.put("Key-1", "JSA Data 1");
//      data.put("Key-2", "JSA Data 2");
//
//      body.put("notification", notification);
//      body.put("data", data);

/**
      {
         "notification": {
            "title": "JSA Notification",
            "body": "Happy Message!"
         },
         "data": {
            "Key-1": "JSA Data 1",
            "Key-2": "JSA Data 2"
         },
         "to": "/topics/JavaSampleApproach",
         "priority": "high"
      }
*/
      System.out.println( "start" );
//      HttpEntity<String> request = new HttpEntity<>("dfasdf");
//
//      CompletableFuture<String> pushNotification = CompletableFuture.completedFuture(" dfasdf" );
//      CompletableFuture.allOf(pushNotification).join();
//
//      try {
//          String firebaseResponse = pushNotification.get();
//          
//          //return new ResponseEntity<>(firebaseResponse, HttpStatus.OK);
//      } catch (InterruptedException e) {
//          e.printStackTrace();
//      } catch (ExecutionException e) {
//          e.printStackTrace();
//      }
      
      
      
      System.out.println( "end" );
        
        
    }

    
    public static void main( String[] args ) throws JSONException {
        
        sendNotification( "s" );
  }
    
    
}
