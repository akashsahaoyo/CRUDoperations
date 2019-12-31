package com.akash.demo.utils;


import java.util.logging.Level;
import java.util.logging.Logger;



public class LogUtil {
	
	private static final String LOG_FORMAT="{}";
	private org.apache.logging.log4j.Logger log4jLogger;
	private static final String Addbooks="Addbooks";
	
	private Logger logger;
	
	public LogUtil(Class classObj) {
		//logger=new Logger(Addbooks,classObj);
		log4jLogger = org.apache.logging.log4j.LogManager.getLogger(classObj);
		}
	
	
	public static LogUtil createLogger(Class classObj) {
		return new LogUtil(classObj);
	
	
	}
	
	public Logger createLogger() {
		return logger;
	}
	public void debug(String message){
        logger.log(Level.INFO, LOG_FORMAT, message);
        //log4jLogger.debug(message);
    }
    public void info(String message){
        logger.log(Level.INFO, LOG_FORMAT, message);
        //log4jLogger.info(message);
    }
    public void error(String message){
        logger.log(Level.WARNING, LOG_FORMAT, message);
        //log4jLogger.error(message);
    }
    public void error(Exception e, String message){
        logger.log(Level.WARNING,  LOG_FORMAT, message);
        //log4jLogger.error(message, e);
    }
    public void error(Exception e){
        logger.log(Level.WARNING,  LOG_FORMAT, e.getMessage());
        //log4jLogger.error(e.getMessage(), e);
    }
	

}
