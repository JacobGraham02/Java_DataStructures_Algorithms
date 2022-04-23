package Topics.DesignPatterns.SOLID_Principles.OpenClosedBad;

public class Greeter {
    String formality;

    /**
     * Not only is this poor coding practices, it violates the Closed/Open principle. You can easily modify what value is returned directly in the Greeter class.
     * If you create separate classes for each formality, you only have to ensure those classes implement an interface with common methods.
     * @return
     */
    public String greet() {
        if (this.formality == "formal") {
            return "Good evening, sir";
        }
        else if (this.formality == "casual") {
            return "Sup bro?";
        }
        else if (this.formality == "intimate") {
            return "Hello darling";
        }
        else {
            return "Hello";
        }
    }
    public void setFormality(String formality) {
        this.formality = formality;
    }
}
