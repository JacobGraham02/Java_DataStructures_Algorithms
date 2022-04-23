package Topics.DesignPatterns.Patterns.Factory;

public class OrderXMLDisplayService extends DisplayService {

    @Override
    public XmlParser getParser() {
        return new OrderXMLParser();
    }
}
