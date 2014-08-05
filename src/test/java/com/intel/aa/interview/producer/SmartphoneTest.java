package com.intel.aa.interview.producer;

import com.intel.aa.interview.broker.MessageBroker;
import com.intel.aa.interview.consumer.PrintService;
import com.intel.aa.interview.consumer.WordCountService;
import com.intel.aa.interview.consumer.WordCountServiceImpl;
import com.intel.aa.interview.solution.MessageBrokerImpl;
import org.junit.Test;

public class SmartphoneTest {

    @Test
    public void testSendSmsMessages() throws Exception {

        MessageBroker broker = new MessageBrokerImpl();

        PrintService printService = new PrintService();
        WordCountService wordCountService = new WordCountServiceImpl();

        broker.addSubscriber(printService);
        broker.addSubscriber(wordCountService);

        Smartphone phoneOne = new Smartphone();
        Smartphone phoneTwo = new Smartphone();
        Smartphone phoneThree = new Smartphone();

        for (int i = 0; i < 50; i++) {
            phoneOne.sendSmsMessages(broker);
            phoneTwo.sendSmsMessages(broker);
            phoneThree.sendSmsMessages(broker);
        }
    }
}