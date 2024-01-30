import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class DOMParserExample {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("user.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);

            doc.getDocumentElement().normalize();

            String userIdToSearch = "2"; // Provide the user ID to search

            NodeList nodeList = doc.getElementsByTagName("user");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    String userId = element.getElementsByTagName("userId").item(0).getTextContent();

                    if (userId.equals(userIdToSearch)) {
                        System.out.println("User Details (DOM Parser):");
                        System.out.println("User ID: " + userId);
                        System.out.println("Name: " + element.getElementsByTagName("name").item(0).getTextContent());
                        System.out.println("Email: " + element.getElementsByTagName("email").item(0).getTextContent());
                        System.out.println("Age: " + element.getElementsByTagName("age").item(0).getTextContent());
                        break;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
