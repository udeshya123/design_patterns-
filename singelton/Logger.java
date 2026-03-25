package org.example;

public class Logger {
    private String name;
    private static Logger logger;//create single static instance

    private Logger(String name){//make constructor private ,so can't be called from outside
        try{
            Thread.sleep(2000);
        }
        catch (InterruptedException ex){
            ex.printStackTrace();
        }
        this.name = name;
    }

    public static Logger getInstance(String name){//provide static function to access that instance
        synchronized (Logger.class) {//added synchronised for handling multithreaded environment
            if (logger == null) {
                logger = new Logger(name);
            }
            return logger;
        }
    }
    public void log(String logMessage){
        System.out.println(name+" "+logMessage);
    }
}
