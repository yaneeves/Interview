package com.mobli.interview.producer;

import com.mobli.interview.broker.MessageBroker;
import com.mobli.interview.data.SmsMessage;

public class SimpleSmsProducer implements SmsProducer {

    private MessageBroker broker;

    public SimpleSmsProducer(MessageBroker broker) {
        this.broker = broker;
    }

    @Override
    public void produce(final SmsMessage message) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                broker.receive(message);
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }
}
