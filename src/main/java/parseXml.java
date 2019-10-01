import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import java.io.File;

public class parseXml {

    public static Document readFile(String filename) throws Exception {
        SAXReader reader = new SAXReader();
        Document document = reader.read(new File(filename));
        return document;
    }

    public static void printRecursive(Element element, String tagName, String newValue) {
        for(int i = 0, size = element.nodeCount(); i < size; i++) {
            Node node = element.node(i);
            if(node instanceof Element) {
                Element currentNode = (Element) node;
                if(currentNode.isTextOnly()) {

                    if(currentNode.getName()==tagName){
                    System.out.println("country name is " + currentNode.getText());
                    System.out.println("tag name is " + tagName);

                    }
                }
                printRecursive(currentNode, tagName, newValue);
            }
        }
    }

    public static void main(String[] args) throws Throwable {
//        File fXmlFile = new File("/Users/elivalaparla/IdeaProjects/FirstSpringBootApp/src/main/resources/country.xml");
//        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
//        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
//        Document doc = dBuilder.parse(fXmlFile);
//        String location = doc.getElementsByTagName("name").item(0).getTextContent();
//        System.out.println("location is " + location);

        try {
            Element root = readFile("/Users/elivalaparla/IdeaProjects/FirstSpringBootApp/src/main/resources/country.xml").getRootElement();
            String newString = "United Kingdom";
            String tagToChange = "name";
            printRecursive(root, tagToChange, newString);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
