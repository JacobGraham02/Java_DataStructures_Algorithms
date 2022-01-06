package Topics.DesignPatterns;

public class AdapterPattern {

    /**
     * Let's say you have defined the following interface:
     * interface MyLogger {
     *     void logMessage(String message);
     *     void logException(Throwable exception);
     * }
     *
     * And you have several concrete implementations of these, namely MyFileLogger and MyConsoleLogger.
     *
     * class BluetoothManager {
     *     private FrameworkLogger logger;
     *
     *     public BluetoothManager(FrameworkLogger logger) {
     *         this.logger = logger;
     *     }
     * }
     * interface FrameworkLogger {
     *     void log(String message);
     *     void log(Throwable exception);
     * }
     * Let's suppose you try to use a framework interface that defines the same methods your interface does, and uses method overloading. Then, your BluetoothManager
     * class will now be able to only accept the framework-defined interface.
     *
     * You already have a bunch of MyLogger implementations that you would like to reuse, but they do not fit the interface of the FrameworkLogger.
     * By defining an adapter class that implements the FrameworkLogger interface and accepts a MyLogger implementation, the functionality can be mapped
     * between the different interfaces:
     *
     * class FrameworkLoggerAdapter implements FrameworkLogger {
     *     private MyLogger logger;
     *
     *     public FrameworkLoggerAdapter(MyLogger logger) {
     *         this.logger = logger;
     *     }
     * @Override
     * public void log(String message) {
     *     this.logger.logMessage(message);
     * }
     * @Override;
     * public void log(Throwable exception) {
     *     this.logger.logException(exception);
     * }
     *}
     *
     * FrameworkLogger fileLogger = new FrameworkLoggerAdapter(new MyFileLogger());
     * BluetoothManager manager = new BluetoothManager(fileLogger);
     *
     * FrameworkLogger consoleLogger = new FrameworkLoggerAdapter(new MyConsoleLogger());
     * BluetoothManager manager2 = new BluetoothManager(consoleLogger);
     *
     *
     *
     *
     * Let's suppose you're creating a stock market monitoring app. The app downloads stock data from multiple sources in XML format and then displays nice-looking
     * charts and diagrams for the user. Let's say you suppose integrating this data with some nice 3rd-party analytics library. However, the library only works with
     * data in JSON format.
     *
     * The solution to this is creating an adapter. This is a special object (class instance) that converts the interface of one object so another can understand it.
     * An adapter wraps one of the objects to hide the complexity of conversion happening behind the scenes. Adapters can not only convert data types into various
     * formats, but can also help objects with different interfaces collaborate with one another. Here is the general process for an adapter pattern:
     *  1. The adapter gets an interface, compatible with one of the existing objects
     *  2. Using this interface, the existing object can safely call the adapter's methods
     *  3. Upon receiving the call, the adapter passes the request to the second object, but in a format and order that the second object expects.
     */
}
