Interviews
==========
##Instructions for Java exercise – SMS messages
3 users with a smartphone each, are sending SMS messages simultaneously. The messages are sent to a message broker that distributes the messages to the following consumers:

1. Print service – prints all the messages to the console.
2. Word count service – Counts the total occurrences per word in a message

###Prerequisite
Download and install maven (http://maven.apache.org/download.cgi)

###Part I – Implementation
Your task is to implement the scenario described above, where some of the classes are already given. You will need to implement the following interfaces:

1.	`MessageBrokerImpl`
2.	`WordCountServiceImpl`

Run the program using the test class `SmartphoneTest`.

Comments:
* Please make sure that your MessageBrokerImpl is thread safe as multiple producers and consumers could use the broker at the same time
* The word count should not be case sensitive
* Sending a message to a consumer could potentially take some time. Make sure that increasing the number of consumers won't impact dramatically the time it takes the broker to send messages to all consumers

###Part II – Logging
Please add to the project a logging framework that you are familiar with.
Please create an INFO level log every time that SimpleSmsProducer send a message to the broker.

When finished please create a new branch (under your name) and push it to our github
