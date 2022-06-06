package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;


public class LoggerTest {
    private static final Logger logger = LogManager.getLogger(LoggerTest.class);

     @Test
    public void logLevelsTest() {
         logger.trace("Trace Message: Начало теста...");
         logger.debug("Trace Message: ...");
         logger.info("Info: ...");
         logger.warn("Warning Message: ...");
         logger.error("Error Message: ...");
         logger.fatal("Fatal Message: Конец теста...");

     }
}
