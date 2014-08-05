package com.intel.aa.interview.producer;

import com.intel.aa.interview.broker.MessageBroker;
import com.intel.aa.interview.data.SmsMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleSmsProducer implements SmsProducer {

    private MessageBroker broker;

    private static final Logger LOGGER = LoggerFactory.getLogger(SimpleSmsProducer.class);

    public SimpleSmsProducer(MessageBroker broker) {
        this.broker = broker;
    }

    @Override
    public void produce(final SmsMessage message) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                broker.receive(message);
                LOGGER.info("SMS sent to broker.");
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }
}
