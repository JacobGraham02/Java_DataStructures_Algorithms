package Topics.DesignPatterns;

public class FactoryPattern {

    /**
     * Provide an interface for creating families of related or dependent objects without specifying their concrete classes.
     * A factory decreases coupling between code that needs to create objects from object creation code. Object creation is not made explicit by calling a
     * class constructor, instead by calling a function that creates the object on behalf of the caller constructor.
     * Below is a simple example of this:
     */
    interface Car {

    }
    public class CarFactory {
        public Car create(String s) {
           switch(s) {
               default:
               case "american": return new Chrysler();
               case "german": return new Mercedes();
               case "japanese": return new Mazda();
           }
        }
    }
    class Chrysler implements Car {

    }
    class Mazda implements Car {

    }
    class Mercedes implements Car {

    }
    /**
     * public class CarFactory
     *  public static void main(String args[]) {
     *      Car car = CarFactory.create("american");
     *      System.out.println(car);
     *  }
     */


    /**
     * Factory method is a creation design pattern, thus is related to object creation. We create objects for a client without exposing any logic for creating
     * that object. Therefore, a common interface is used to create a new type of object with the factory method.
     * The main idea is to use a static member function (static factory method) that creates and returns instances, hiding the details from the user.
     * Using this, created objects do not have a tight coupling with a class hierarchy of a library.
     * A library is some third-party API and a client is some user who makes calls to those APIs to complete their tasks.
     * The actual implementation steps go something like this:
     * 1. Define a factory method inside an interface
     * 2. Let the subclass implement the above factory method and decide which object to create
     * By allowing subclasses to create an object, we are adding polymorphic behavior to an instance of a class.
     *
     * Consider we want to implement a notification serve through email, SMS, and push notification. Let's use the factory method design pattern to implement this.
     */
    public interface Notification {
        void notifyUser();
    }
    public class SMSNotification implements Notification {
        @Override
        public void notifyUser() {
            System.out.println("Sending an SMS notification");
        }
    }
    public class EmailNotification implements Notification {
        @Override
        public void notifyUser() {
            System.out.println("Sending an email notification");
        }
    }
    public class PushNotification implements Notification {
        @Override
        public void notifyUser() {
            System.out.println("Sending a push notification");
        }
    }

    public class NotificationFactory {
        public Notification createNotification(String channel) {
            if (channel == null || channel.isEmpty()) {
                return null;
            }
            if ("SMS".equals(channel)) {
                return new SMSNotification();
            }
            if ("EMAIL".equals(channel)) {
                return new EmailNotification();
            }
            if ("PUSH".equals(channel)) {
                return new PushNotification();
            }
            return null;
        }
    }

    public class NotificationService {
        public void main(String[] args) {
            NotificationFactory notificationFactory = new NotificationFactory();
            Notification notification = notificationFactory.createNotification("SMS");
            notification.notifyUser();
        }
    }
}
