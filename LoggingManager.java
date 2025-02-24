/**
 * This class does the logging of the actions performed by the
 * system. 
 */
import java.util.logging.*;

public class LoggingManager {
    private Logger logger;

    public LoggingManager() {
        logger = Logger.getLogger(LoggingManager.class.getName());
        ConsoleHandler consoleHandler = new ConsoleHandler();
        logger.addHandler(consoleHandler);
        logger.setLevel(Level.INFO); // Set to INFO to suppress lower level messages
    }

    public void log(String message) {
        logger.info(message);
    }
}