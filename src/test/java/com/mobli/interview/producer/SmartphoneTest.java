package com.mobli.interview.producer;

import com.mobli.interview.broker.MessageBroker;
import com.mobli.interview.broker.MessageBrokerImpl;
import com.mobli.interview.consumer.PrintService;
import com.mobli.interview.consumer.WordCountService;
import com.mobli.interview.consumer.WordCountServiceImpl;
import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

public class SmartphoneTest {

    @Test
    public void testSendSmsMessages() throws Exception {

        final int numberOfMessagesPerSmartphone = 50;
        MessageBroker broker = new MessageBrokerImpl();

        PrintService printService = new PrintService();
        WordCountService wordCountService = new WordCountServiceImpl();

        broker.addSubscriber(printService);
        broker.addSubscriber(wordCountService);

        Smartphone phoneOne = new Smartphone();
        Smartphone phoneTwo = new Smartphone();
        Smartphone phoneThree = new Smartphone();

        for (int i = 0; i < numberOfMessagesPerSmartphone; i++) {
            phoneOne.sendSmsMessages(broker);
            phoneTwo.sendSmsMessages(broker);
            phoneThree.sendSmsMessages(broker);
        }

        Thread.sleep(1000);

        Map<String, Integer> totalWords = wordCountService.getTotalWords();
        int wordCounter = totalWords.get("quick");
        Assert.assertEquals((numberOfMessagesPerSmartphone * 3), wordCounter);
    }
}