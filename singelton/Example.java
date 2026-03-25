package org.example;

public class Example {
    public static void singleThreadedExample() {
        Logger logger1= Logger.getInstance("foo");
        Logger logger2= Logger.getInstance("bar");
        logger1.log("logger 1");
        logger2.log("logger 2");
    }

    public static void multiThreadedExample() {
        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                Logger logger = Logger.getInstance("foo");
                    logger.log("Thread 1");
            }
        });

        Thread b = new Thread(new Runnable() {
            @Override
            public void run() {
                Logger logger = Logger.getInstance("bar");
                logger.log("Thread 2");
            }
        });
        a.start();
        b.start();
    }
}
