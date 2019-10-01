import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class parseXml {
    public static String nameOfXmlFile = "/Users/elivalaparla/IdeaProjects/FirstSpringBootApp/src/main/resources/country.xml";


    public static Document readFile(String filename) throws Exception {
        SAXReader reader = new SAXReader();
        Document document = reader.read(new File(filename));
        return document;
    }

    public static void printRecursive(Element element, String tagName, String newValue) {
//    public static void printRecursive(Element element) {
        for (int i = 0, size = element.nodeCount(); i < size; i++) {
            Node node = element.node(i);
            if (node instanceof Element) {
                Element currentNode = (Element) node;
                if (currentNode.isTextOnly()) {

                    if (currentNode.getName() == tagName) {
                        System.out.println("country name is " + currentNode.getText());
                        System.out.println("tag name is " + tagName);
                        currentNode.setText(newValue);


                    }
                }
                printRecursive(currentNode, tagName, newValue);
//                printRecursive(currentNode);
            }
        }
    }


    public static void main(String[] args) throws Throwable {

//        try {
//            Element root = readFile(nameOfXmlFile).getRootElement();
//            String newString = "United Kingdom";
//            String tagToChange = "name";
////            printRecursive(root, tagToChange, newString);
//            printRecursive(root);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }


        try {
            File inputFile = new File(nameOfXmlFile);
            SAXReader reader = new SAXReader();
            Document document = reader.read(inputFile);

            Element classElement = document.getRootElement();

            String newString = "United Kingdom";
            String tagToChange = "name";
            printRecursive(classElement, tagToChange, newString);

            // Pretty print the document to System.out
            OutputFormat format = OutputFormat.createPrettyPrint();
            XMLWriter writer;
            FileOutputStream fos = new FileOutputStream("/Users/elivalaparla/IdeaProjects/FirstSpringBootApp/target/generated-sources/newCountry.xml");
//            writer = new XMLWriter( System.out, format );
            writer = new XMLWriter(fos, format);
            writer.write(document);
            writer.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
