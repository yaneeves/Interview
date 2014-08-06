package com.intel.aa.interview.solution;

import com.intel.aa.interview.broker.MessageBroker;
import com.intel.aa.interview.consumer.SmsConsumer;
import com.intel.aa.interview.data.SmsMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.*;

public class MessageBrokerImpl implements MessageBroker {

    BlockingQueue que = new LinkedBlockingQueue();
    Map<SmsConsumer, Date> subscribers = new ConcurrentHashMap<>();
    Logger LOGGER = LoggerFactory.getLogger(MessageBrokerImpl.class);
    ExecutorService executorService;

    public MessageBrokerImpl() {
        executorService = Executors.newFixedThreadPool(20);
    }

    @Override
    public void receive(SmsMessage message) {
        que.add(message);
        broadcast();
    }

    @Override
    public void shutdown() {
        executorService.shutdown();
    }

    @Override
    public void addSubscriber(SmsConsumer consumer) {
        subscribers.put(consumer, new Date());
        LOGGER.info("Added subscriber.");
    }

    @Override
    public void removeSubscriber(SmsConsumer consumer) {
        subscribers.remove(consumer);
    }

    private void broadcast() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                // Empty que and broadcast all messages to subscribers
                while (!que.isEmpty()) {
                    try {
                        SmsMessage message = (SmsMessage) que.poll(1000, TimeUnit.MILLISECONDS);
                        if (message != null) {
                            for (SmsConsumer consumer : subscribers.keySet()) {
                                consumer.consume(message);
                            }
                        }
                    } catch (InterruptedException e) {
                        LOGGER.error("Error broadcasting message to consumers.", e);
                        return;
                    }
                }
            }
        };

        executorService.submit(runnable);
    }


}
