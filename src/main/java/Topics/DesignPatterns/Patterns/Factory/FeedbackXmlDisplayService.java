package Topics.DesignPatterns.Patterns.Factory;

public class FeedbackXmlDisplayService extends DisplayService {

    @Override
    protected XmlParser getParser() {
        return new FeedbackXML();
    }
}
