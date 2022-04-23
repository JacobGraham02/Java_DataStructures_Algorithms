package Topics.DesignPatterns.Patterns.Factory;

/**
 * The Factory Method pattern defines an interface for creating an object, but lets subclasses decide which class to instantiate. Factory Method lets a class defer instantiation
 * to subclasses. For example if we are creating an XML parser for each order that a customer inputs into our system, it would be better to provide a factory object that instantiates
 * a parser to do the job according to the kind of XML the application receives from the user.
 *
 * This pattern gives us a way to encapsulate the instantiations of concrete types. The Factory Method pattern encapsulates the functionality required to select and instantiate an
 * appropriate class inside a designated method referred to as a factory method. The Factory Method selects an appropriate class from a class hierarchy based on the application context
 * and other factors. It then instantiates the selected class and returns it as an instance of the parent class type. Application objects can make use of the factory method
 * to get access to the appropriate class instance.
 *
 * Product:
 *  Defines the interface of objects the factory method creates
 * ConcreteProduct:
 *  Implements the Product interface
 * Creator
 *  Declares the factory method, which returns an object of type Product. Creator may also define a default implementation of the factory method that returns a default ConcreteProduct
 *  object.
 *  May call the factory method to create a Product object.
 * ConcreteCreator
 *  Overrides the factory method to return an instance of a ConcreteProduct
 */

interface XmlParser {
    public String parse();
}
public class ErrorXmlParser implements XmlParser {
    @Override
    public String parse() {
        System.out.println("Parsing error for the XML...");
        return "XML Error message";
    }
}
class FeedbackXML implements XmlParser {

    @Override
    public String parse() {
        System.out.println("Parsing feedback XML");
        return "Feedback XML message";
    }
}
class OrderXMLParser implements XmlParser{
    @Override
    public String parse() {
        System.out.println("Parsing order XML...");
        return "Order XML Message";
    }
}
class ResponseXMLParser implements XmlParser{
    @Override
    public String parse() {
        System.out.println("Parsing response XML...");
        return "Response XML Message";
    }
}
