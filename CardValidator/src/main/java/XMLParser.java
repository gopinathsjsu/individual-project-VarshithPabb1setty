import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;

public class XMLParser implements FileParser {

    @Override
    public void parseFile(String inputFilePath, String outputFilePath) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document inputDoc = builder.parse(new File(inputFilePath));
            inputDoc.getDocumentElement().normalize();

            NodeList nList = inputDoc.getElementsByTagName("CARD");
            Document outputDoc = builder.newDocument();
            Element rootElement = outputDoc.createElement("CARDS");
            outputDoc.appendChild(rootElement);

            for (int i = 0; i < nList.getLength(); i++) {
                Node node = nList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    String cardNumber = element.getElementsByTagName("CARD_NUMBER").item(0).getTextContent();
                    
                    String cardType = CardValidationUtil.getCardTypeAndValidity(cardNumber);
                    Element cardElement = outputDoc.createElement("CARD");
                    cardElement.appendChild(createElement(outputDoc, "CARD_NUMBER", cardNumber));
                    cardElement.appendChild(createElement(outputDoc, "CARD_TYPE", cardType));
                    rootElement.appendChild(cardElement);
                }
            }

            // Convert XML Document to String
            StringWriter stringWriter = new StringWriter();
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
            transformer.transform(new DOMSource(outputDoc), new StreamResult(stringWriter));
            String xmlContent = stringWriter.toString();

            // Post-process and write to file
            writeProcessedXMLToFile(outputFilePath, xmlContent);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void writeProcessedXMLToFile(String filePath, String xmlContent) throws IOException {
        String processedXml = postProcessXML(xmlContent);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(processedXml);
        }
    }

    private String postProcessXML(String xmlContent) {
        // Replace self-closing tags with explicit open and close tags
        return xmlContent.replaceAll("<CARD_NUMBER/>", "<CARD_NUMBER></CARD_NUMBER>");
    }

    private Element createElement(Document doc, String name, String value) {
        Element element = doc.createElement(name);
        element.appendChild(doc.createTextNode(value != null ? value : ""));
        return element;
    }

    // private String getCardTypeAndValidity(String cardNumber) {
    //     if (cardNumber == null || cardNumber.isEmpty()) {
    //         return "Invalid: empty/null card number";
    //     }

    //     if (!cardNumber.matches("\\d+")) {
    //         return "Invalid: non numeric characters";
    //     }

    //     if (cardNumber.length() > 19) {
    //         return "Invalid: more than 19 digits";
    //     }

    //     CreditCard card = CreditCardFactory.getCreditCard(cardNumber, "", ""); // Assuming expiration date and cardholder name are not needed for type determination

    //     if (card == null) {
    //         return "Invalid: Not a possible card number";
    //     }

    //     boolean isValid = card.isValid();
    //     String cardType = getCardType(card);
    //     return isValid ? cardType : "Invalid: Not a possible card number";
    // }

    // private String getCardType(CreditCard card) {
    //     if (card instanceof VisaCC) {
    //         return "Visa";
    //     } else if (card instanceof MasterCC) {
    //         return "MasterCard";
    //     } else if (card instanceof AmExCC) {
    //         return "AmericanExpress";
    //     } else if (card instanceof DiscoverCC) {
    //         return "Discover";
    //     }
    //     return "Unknown";
    // }
}
