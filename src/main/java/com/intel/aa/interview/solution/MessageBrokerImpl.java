package com.intel.aa.interview.solution;

import com.intel.aa.interview.broker.MessageBroker;
import com.intel.aa.interview.consumer.SmsConsumer;
import com.intel.aa.interview.data.SmsMessage;

import java.util.HashSet;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class MessageBrokerImpl implements MessageBroker {

    BlockingQueue que = new LinkedBlockingQueue();
    HashSet<SmsConsumer> subscribers = new HashSet<SmsConsumer>();

    @Override
    public void receive(SmsMessage message) {
        que.add(message);

        for (SmsConsumer consumer : subscribers) {
            consumer.consume(message);
        }
    }

    @Override
    public void addSubscriber(SmsConsumer consumer) {
        subscribers.add(consumer);
    }

    @Override
    public void removeSubsriber(SmsConsumer consumer) {
        subscribers.remove(consumer);
    }
}
