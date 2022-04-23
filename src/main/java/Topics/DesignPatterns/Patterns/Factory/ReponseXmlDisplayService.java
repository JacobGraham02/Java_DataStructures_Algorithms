package Topics.DesignPatterns.Patterns.Factory;

public class ReponseXmlDisplayService extends DisplayService {

    @Override
    protected XmlParser getParser() {
        return new ResponseXMLParser();
    }
}
