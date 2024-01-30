import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class SAXParserExample extends DefaultHandler {
    public void parseDocument(String filePath) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            saxParser.parse(new File(filePath), this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.print("Element: " + qName);

        // Print attributes if any
        for (int i = 0; i < attributes.getLength(); i++) {
            System.out.print(" (" + attributes.getQName(i) + "=" + attributes.getValue(i) + ")");
        }

        System.out.println();
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String data = new String(ch, start, length).trim();
        if (!data.isEmpty()) {
            System.out.println("    Text: " + data);
        }
    }

    public static void main(String[] args) {
        String filePath = "example.xml"; // Specify the path to your XML file

        SAXParserExample saxParserExample = new SAXParserExample();
        saxParserExample.parseDocument(filePath);
    }
}

