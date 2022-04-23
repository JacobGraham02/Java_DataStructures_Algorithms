package Topics.DesignPatterns.Patterns.Factory;

public class ErrorXmlDisplayService extends DisplayService {

    @Override
    public XmlParser getParser() {
        return new ErrorXmlParser();
    }
}
