package Topics.DesignPatterns.Patterns.Factory;


/**
 * To display parsed messages from each of the specific parsers (Error, Feedback, Order, and Response), an abstract service class must be created which each service will extend.
 */
public abstract class DisplayService {

    public void display() {
        XmlParser parser = getParser();
        String msg = parser.parse();
        System.out.println(msg);
    }

    protected abstract XmlParser getParser();
}
