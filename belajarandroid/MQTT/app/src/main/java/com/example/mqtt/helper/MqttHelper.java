package com.example.mqtt.helper;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;

import org.eclipse.paho.android.service.MqttAndroidClient;
import org.eclipse.paho.client.mqttv3.DisconnectedBufferOptions;
import org.eclipse.paho.client.mqttv3.IMqttActionListener;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.IMqttToken;
import org.eclipse.paho.client.mqttv3.MqttCallbackExtended;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class MqttHelper {
    public MqttAndroidClient mqttAndroidClient;

    final String serverUri = "tcp://riset.revolusi-it.com:1883";

    final String clientId="G2labClient1";

    final String subscriptionTopic="g2lab/XXX123A";

    final String username="candra";

    final String password ="demakdemek";

    public MqttHelper(Context context){
        mqttAndroidClient = new MqttAndroidClient(context,serverUri,clientId);
        mqttAndroidClient.setCallback(new MqttCallbackExtended() {
            @Override
            public void connectComplete(boolean b, String s) {
                Log.w("mqtt",s);
            }

            @Override
            public void connectionLost(Throwable throwable) {

            }

            @Override
            public void messageArrived(String topic, MqttMessage mqttmessage) throws Exception {
                Log.w("Mqtt",mqttmessage.toString());
            }

            @Override
            public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {

            }
        });
        connect();
    }

    public void setCallback(MqttCallbackExtended callback){
        mqttAndroidClient.setCallback(callback);
    }

    private void connect() {
        Log.w("try to connect mqtt","ok");
        MqttConnectOptions mqttConnectOptions = new MqttConnectOptions();
        mqttConnectOptions.setAutomaticReconnect(true);
        mqttConnectOptions.setCleanSession(false);
        mqttConnectOptions.setUserName(username);
        mqttConnectOptions.setPassword(password.toCharArray());

        try{

            mqttAndroidClient.connect(mqttConnectOptions, null, new IMqttActionListener() {
                @Override
                public void onSuccess(IMqttToken asyncActionToken) {
                    Log.w("try to connect mqtt","ok2");
                    DisconnectedBufferOptions disconnectedBufferOptions=new DisconnectedBufferOptions();

                    disconnectedBufferOptions.setBufferEnabled(true);
                            disconnectedBufferOptions.setBufferSize(100);

                     disconnectedBufferOptions.setPersistBuffer(false);
                     disconnectedBufferOptions.setDeleteOldestMessages(false);

                     mqttAndroidClient.setBufferOpts(disconnectedBufferOptions);
                            subscripeToTopic();
                }

                @Override
                public void onFailure(IMqttToken asyncActionToken, Throwable exception) {
                    Log.w("Mqtt","Failed to connect to: "+ serverUri+exception.toString());
                }
            });
        }catch (MqttException ex){
            ex.printStackTrace();
        }
    }

    private void subscripeToTopic(){
        Log.w("try to connect mqttT",subscriptionTopic);
        try {
            mqttAndroidClient.subscribe(subscriptionTopic, 0, null, new IMqttActionListener() {
                @Override
                public void onSuccess(IMqttToken asyncActionToken) {
                    Log.w("Mqtt","Subscribed!");
                }

                @Override
                public void onFailure(IMqttToken asyncActionToken, Throwable exception) {
                    Log.w("Mqtt","Subscribed fail!");
                }
            });
        } catch (MqttException ex){
            System.err.println("Exceptionst subscribing");
            ex.printStackTrace();
        }
    }

    public void publishMessage(@NonNull String msg,@NonNull String topic){
        MqttMessage mqqtMessage=new MqttMessage();
        mqqtMessage.setPayload(msg.getBytes());
        try{
            mqttAndroidClient.publish(topic,mqqtMessage);
        }catch (MqttException e){
            e.printStackTrace();
        }
    }

    public String getServerUri() {
        return serverUri;
    }

    public String getClientId() {
        return clientId;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
