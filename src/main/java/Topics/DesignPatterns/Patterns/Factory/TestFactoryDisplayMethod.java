package Topics.DesignPatterns.Patterns.Factory;

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
