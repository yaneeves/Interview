package com.intel.aa.interview.consumer;

import com.intel.aa.interview.data.SmsMessage;

public class PrintService implements SmsConsumer {

    private int messageCounter = 0;

    @Override
    public synchronized void consume(SmsMessage message) {
        messageCounter++;
//        System.out.println(message.getUserId() + ", " + message.getText());
        System.out.println(messageCounter);
    }
}
