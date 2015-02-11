package com.mobli.interview.producer;

import com.mobli.interview.data.SmsMessage;

public interface SmsProducer {

    public void produce(final SmsMessage message);
}
