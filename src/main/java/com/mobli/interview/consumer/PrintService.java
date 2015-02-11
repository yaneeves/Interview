package com.mobli.interview.consumer;

import com.mobli.interview.data.SmsMessage;

public class PrintService implements SmsConsumer {

    private int messageCounter = 0;

    @Override
    public synchronized void consume(SmsMessage message) {
        messageCounter++;
        System.out.println(messageCounter);
    }
}
