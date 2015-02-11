package com.mobli.interview.consumer;


import com.mobli.interview.data.SmsMessage;

public interface SmsConsumer {

    public void consume(final SmsMessage message);
}
