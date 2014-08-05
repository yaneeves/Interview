package com.intel.aa.interview.consumer;


import com.intel.aa.interview.data.SmsMessage;

public interface SmsConsumer {

    public void consume(final SmsMessage message);
}
