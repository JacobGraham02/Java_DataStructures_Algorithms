package Topics.DesignPatterns;

public class SingletonPattern {

    /**
     * This design pattern is sometimes regarded as an anti-pattern. This is because some problems exist such as tight coupling, object controlling its own
     * entire lifecycle, and encouraging global state in an application. The first 2 reasons especially make unit testing difficult.
     *
     * The use of a singleton should be considered carefully before use, as there are usually better alternative design patterns.
     * The main problem is because of global variables, as they introduce external global mutable state. This means testing can be severely compromised. If something
     * has global state, it means that a singleton is not dependent on input parameters, but also on the state of the thing itself.
     *
     * Saying this, the issues presented by Singleton can be mitigated by using them in conjunction with creation patterns, so that the initial creation of the
     * singleton can be controlled.
     *
     * In essence, this pattern ensures only one instance of an object is created; only a single instance of itself can be created. The singleton pattern is one of
     * the Gang of Four design patterns and is a creational pattern.
     * *** the sealed keyword is used in C# to disallow inheritance for the class the keyword is defined on
     *
     * Example in Java (non-thread safe):
     * public class SingletonExample {
     *
     *     private static SingletonExample instance;
     *
     *     private SingletonExample() {
     *
     *     }

     *
     *     public static SingletonExample getInstance() {
     *             if (instance == null) {
     *                 instance = new SingletonExample();
     *             }
     *             return instance;
     *     }
     * }
     *
     * *** A variable declared as volatile access its value from main memory. Across all threads, this variable value must be the same value because of
     * non-caching and the variable residing in main memory.
     *
     * (thread-safe)
     * public class SingletonExampleThreadSafe {
     *     private static volatile SingletonThreadSafeExample instance;
     *
     *     private SingletonExample() {
     *
     *     }
     *
     *     public static SingletonThreadSafeExample getInstance() {
     *         if (instance == null) {
     *             createInstance();
     *         }
     *         return instance;
     *     }
     *
     *     private static void createInstance() {
     *         synchronized(SingletonThreadSafeExample.class) {
     *             if (instance == null) {
     *                 instance = new SingletonThreadSafeExample();
     *             }
     *         }
     *     }
     * }
     * Java has an object called ThreadLocal, which creates a single instance of an object on a thread-by-thread basis. This is helpful when each thread needs its
     * own version of an object
     *
     * public class SingletonThreadLocalExample {
     *
     *     private static ThreadLocal<SingletonThreadLocalExample> instance = new ThreadLocal<SingletonThreadLocalExample>();
     *
     *     private SingletonThreadLocalExample() {
     *          if (instance.get() == null) {
     *              instance.set(new SingletonThreadSafeExample());
     *          }
     *          return instance.get();
     *     }
     * }
     *
     * The most widely used Singleton Pattern is the Bill Pugh singleton pattern, which is thread safe and does not require synchronization:
     * public class SingletonExample {
     *
     *     private SingletonExample() {
     *
     *     }
     *     private static SingletonHolder {
     *         private static final SingletonExample INSTANCE = new SingletonExample();
     *     }
     *     public static SingletonExample getInstance() {
     *         return SingletonHolder.INSTANCE;
     *     }
     * }
     *
     * Real-life use cases for Singleton pattern:
     *  If you are developing a client-server application, you need a single instance of ConnectionManager, which manages tje life cycle of client connections
     *  The basic APIs in ConnectionManager:
     *      registerConnection - Add new connection to existing list
     *      closeConnection - Close the connection from event triggered by Client or Server
     *      broadcastMessage - Send a message to all existing client connections
     *
     *      This is an example implementation of a client-server using Singleton pattern
     * final class LazyConnectionManager {
     *     private Map<String, Connection> connections = new HashMap<String, Connection>();
     *     private LazyConnectionManager();
     *     public static LazyConnectionManager getInstance() {
     *      return LazyHolder.INSTANCE;
     *     }
     *     public static class LazyHolder {
     *         private static final LazyConnectionManager INSTANCE = new LazyConnectionManager();
     *     }
     *     // Ensure de-serialization does not create a new instance. De-serialization is where a stream is used to recreate a Java object in memory
     *     private object readResolve() {
     *         return LazyHolder.INSTANCE;
     *     }
     *     public void registerConnection() {
     *         connections.put(connection.getConnectionId(), connection);
     *     }
     *     public void closeConnection(String connectionId) {
     *         Connection connection = connections.get(connectionId);
     *         if (connection != null) {
     *             connection.close();
     *             connections.remove(connectionId);
     *         }
     *     }
     *     public void broadcastMessage(String message) {
     *         for (Map.Entry<String, Connection> entry: connections.entrySet()) {
     *          entry.getValue().sendMessage(message);
     *         }
     *     }
     *
     *     Sample server class:
     *
     *     class Server implements Runnable {
     *         ServerSocket socket;
     *         int id;
     *         public Server() {
     *             new Thread(this).start();
     *         }
     *         public void run() {
     *             try {
     *                 ServerSocket socket = new ServerSocket(3000);
     *                 while (true) {
     *                     Socket clientSocket = socket.accept();
     *                     ++id;
     *                     Connection connection = new Connection("" + id, clientSocket);
     *                     LazyConnectionManager.getInstance().registerConnection(connection);
     *                     LazyConnectionManager.getInstance().broadcastMessage("Message pushed by server: ");
     *                 }
     *             } catch (Exception err) {
     *                 err.printStackTrace();
     *             }
     *         }
     *     }
     */
}
