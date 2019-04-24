package com.cwk.springbootweb.cruddemo.listener;

import com.cwk.springbootweb.cruddemo.filter.MyFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class Mylistener implements ServletContextListener {

    private static Logger logger = LoggerFactory.getLogger(Mylistener.class);

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        logger.info("Mylistener contextInitialized");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        logger.info("Mylistener contextDestroyed");
    }
}
