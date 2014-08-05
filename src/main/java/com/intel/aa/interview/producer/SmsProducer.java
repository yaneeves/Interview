package com.intel.aa.interview.producer;

import com.intel.aa.interview.data.SmsMessage;

public interface SmsProducer {

    public void produce(final SmsMessage message);
}
