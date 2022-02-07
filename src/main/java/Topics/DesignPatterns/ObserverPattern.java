package Topics.DesignPatterns;

public class ObserverPattern {

    /**
     * subject --(pushes notifications to update)--> observer
     * subject <--         (reads and sets state)-- observer
     *
     * What is intent?
     *  Adopt the principle of separation of concerns
     *  Create a separation between the subject and observer
     *  Allow multiple observers to react to change a single subject
     * What is the structure?
     *  Subject provides a way to register, unregister, and notify
     *  Observer provides a way to update
     *
     * The observer pattern lets users of a class subscribe to events that happen when this class processes data or performs some action, and be notified
     * when these events occur, so the class can change. The following example shows how we can create a processing class and an observer class which will be notified
     * while processing a phrase if it finds words that are longer than 5 characters.
     * It is a behavioral design pattern that lets you define a subscription mechanism to notify multiple objects about any events that happen to the object they
     * are observing.
     *
     * The LongWordsObserver interfaces defines an observer, and you must implement this interface to register an instance of the observer to events.
     *
     * public interface LongWordsObserver {
     *     void notify(WordEvent event);
     * }
     *
     * The WordEvent class is the event that will be sent to the observer classes once certain events occur (in this case, long words found).
     * public class WordEvent {
     *     private String word;
     *
     *     public WordEvent(String word) {
     *         this.word = word;
     *     }
     *
     *     public String getWord() {
     *         return word;
     *     }
     * }
     * The below PhraseProcessor class processes a given phrase, and allows observers to be registered to a class using the addObserver method. Once long words
     * are found, these observers will be called using an instance of the WordEvent class.
     *
     * public class PhraseProcessor {
     *
     *     private List<LongWordsObserver> listOfObservers = new ArrayList<>();
     *
     *     public void registerObserverToList(LongWordsObserver observer) {
     *          listOfObservers.add(observer);
     *     }
     *
     *     // Inform all observers of String (word) with > 5 chars
     *     private void informAllObserversWordFound(String word) {
     *          listOfObservers.forEach(observer -> observer.notify(new WordEvent(word));
     *     }
     *
     *     public void processPhraseForMoreThan5Chars(String phrase) {
     *          for (String word : phrase.split(" ") {
     *              if (word.length() > 5) {
     *                  informObservers(word);
     *              }
     *          }
     *     }
     * }
     *
     * The LongWordsExample class shows how to register observers, call the processPhraseForMoreThan5Chars method and receive alerts when long words were found
     *
     * public class LongWordsExample {
     *
     *     public static void main(String[] args) {
     *         List<String> wordsGreaterThan5Chars = new ArrayList<>();
     *
     *         PhraseProcessor phraseProcessor = new PhraseProcessor();
     *
     *         // Register an observer and specify the action it should take when it receives events.
     *         phraseProcessor.addObserver(event -> wordsGreaterThan5Chars.add(event.getWord()));
     *
     *         // Call the process method and pass an argument with a String.
     *         processor.process("Lorum ipsum quacklop");
     *     }
     * }
     *
     *
     *
     */
}
