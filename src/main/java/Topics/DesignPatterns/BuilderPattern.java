package Topics.DesignPatterns;

public class BuilderPattern {

    /**
     * The Builder pattern allows you to create an instance of a class with many optional variables
     * Consider the following:
     *
     * public GraphicsCard graphicsCard;
     * public Monitor[] monitor;
     * public Process processor;
     * public Memory[] ram;
     *
     * Computer(GraphicsCard g, Monitor[] m, Processer p, Memory ram) {
     *
     * }
     * What if there are a lot more variables in this method/class and some of them are optional?
     * The builder pattern creates an inner class called Builder that is used to instantiate only the desired optional variables.
     * Methods exist for each optional variable which take the variable type as a parameter and return a Builder object so that the methods can be chained with each
     * other. Further, the Builder pattern also must include a build() method for each class which returns the encapsulating object and must be called at the end
     * of the chain of method calls when building the object of concern.
     *
     * Following from the previous example, this code uses the Builder pattern for the Computer class
     * public class Computer {
     *
     *     private GraphicsCard graphicsCard;
     *     private Monitor[] monitors;
     *     private Processor processor;
     *     private Memory[] ram;
     *
     *     private Computer(Builder builder) {
     *         this.graphicsCard = builder.graphicsCard;
     *         this.monitors = builder.monitors;
     *         this.processor = builder.processor;
     *         this.ram = builder.ram;
     *     }
     *
     *     public GraphicsCard getGraphicsCard() {
     *      return this.graphicsCard;
     *     }
     *
     *     public Monitor[] getMonitors() {
     *      return this.monitors;
     *     }
     *
     *     public Processor getProcessor() {
     *      return this.processor;
     *     }
     *
     *     public Memory[] getRam() {
     *      return this.ram;
     *     }
     *
         *     public static class Builder {
         *         private GraphicsCard graphicsCard;
         *         private Monitor[] monitors;
         *         private Processor processor;
         *         private Memory[] ram;
         *
     *
     *         public Builder(processor P) {
     *             this.processor = p;
     *         }
     *         public Builder graphicsCard(GraphicsCard g) {
     *             this.graphicsCard = g;
     *             return this;
     *         }
     *         public Builder monitors(Monitor[] mg) {
     *             this.monitors = mg;
     *             return this;
     *         }
     *         public Builder ram(Memory[] ram) {
     *             this.ram = ram;
     *             return this;
     *         }
     *         public Computer build() {
     *             return new Computer(this);
     *         }
     *     }
     * }
     *
     * An example of how this class is used:
     *
     * public class ComputerExample {
     *
     *     public static void main(String[] args) {
     *          Computer headlessComputer = new Computer.Builder(new Processor("Intel-i3"))
     *                                                  .graphicsCard(new GraphicsCard("GTX-960"))
     *                                                  .build();
     *
     *          Computer gamingPC = new Computer.Builder(new Processor("Intel-i7-quadcode"))
     *                                          .graphicsCard(new GraphicsCard("DX11"))
     *                                          .monitors(new Monitor[] = {new Monitor("acer-s7"), new Monitor("acer-s7")})
     *                                          .ram(new Memory[] = {new Memory("2GB"), new Memory("2GB"), new Memory("2GB"), new Memory("2GB")})
     *                                          .build();
     *    }
     * }
     * As you can see, the Builder pattern allows much flexibility when creating objects by allowing optional variable values.
     * For example, suppose you create a social media site that when a user signs up, it is mandatory that they enter their username, password, and email.
     * Optionally, they can also include a cover image, biography, career title, etc.
     * You can use the builder pattern to set default values (or make them null) when the values for variables are not supplied.
     */
}
