package com.intel.aa.interview.consumer;

import com.intel.aa.interview.data.SmsMessage;

public class PrintService implements SmsConsumer {

    private String messageText;

    @Override
    public void consume(SmsMessage message) {
        System.out.println(message.getUserId() + ", " + message.getText());
    }
}
