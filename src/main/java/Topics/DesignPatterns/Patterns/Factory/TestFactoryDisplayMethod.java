package Topics.DesignPatterns.Patterns.Factory;

/**
 * The below implementation works by letting the subclasses implement the various factory methods. By doing this, you can create different instances of XML parsers depending on
 * the one that is needed dynamically at runtime when required.
 */

/**
 * When to use the factory method:
 * A class cannot anticipate the class of objects it must create
 * A class wants its subclasses to specify the objects it creates
 * Classes delegate responsibility to one of several helper subclasses, and you want to localize the knowledge of which helper subclass is the delegate.
 */
public class TestFactoryDisplayMethod {

    public static void main(String[] args) {
        DisplayService service = new FeedbackXmlDisplayService();
        service.display();

        service = new ErrorXmlDisplayService();
        service.display();

        service = new OrderXMLDisplayService();
        service.display();

        service = new FeedbackXmlDisplayService();
        service.display();

        service = new ReponseXmlDisplayService();
        service.display();
    }
}
