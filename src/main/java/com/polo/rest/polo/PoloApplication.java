package com.polo.rest.polo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class PoloApplication {

	public static void main(String[] args) {
		SpringApplication.run(PoloApplication.class, args);
	}
	
    

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
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
        
}

