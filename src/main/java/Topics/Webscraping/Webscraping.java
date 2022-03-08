package Topics.Webscraping;

// Sample page web scraping from: https://jacobdgraham.com/

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Webscraping {

    private Document document;
    private Elements documentProjectsElements;
    private Elements elementsProjectDiv;
    private List<String> arrayListProjectDivContents;

    public Webscraping(String link) throws IOException {
        connectToWebsite(link);
    }

    private void connectToWebsite(String link) throws IOException {
        document = Jsoup.connect(link).get();
    }

    public String getDocumentTitle() throws IOException {
        return String.format("The title of the website is: %s", document.title());
    }

    public void fetchDOMElementsFromProjects() {
        documentProjectsElements = document.getElementsByClass("projectDiv");
    }
    /**
     * Specifically, this method will fetch project 2 from my personal website and place that into a hash set.
     */
    public void placeDOMElementsIntoElementsObject() {
        elementsProjectDiv = document.select("div#project2");
    }
    public void fetchDataFromElementsObject() {
        arrayListProjectDivContents = new ArrayList<>();

        for (Element element : elementsProjectDiv) {
            System.out.println(element.select("div#project2 div h4").text());
        }
    }

    public static void main(String[] args) throws IOException {
        final String CONNECTION_STRING = "https://jacobdgraham.com";
        Webscraping webscraping = new Webscraping(CONNECTION_STRING);
        final String documentTitle = webscraping.getDocumentTitle();
        webscraping.placeDOMElementsIntoElementsObject();
        webscraping.fetchDataFromElementsObject();
    }
}
