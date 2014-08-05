package com.intel.aa.interview.consumer;

import java.util.Map;

public interface WordCountService extends SmsConsumer {

    public Map<String, Integer> getUserWords(String userId);

    public Map<String, Integer> getTotalWords();
}
