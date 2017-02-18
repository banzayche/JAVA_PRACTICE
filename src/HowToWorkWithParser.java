/**
 * Created by admin on 2/16/17.
 */

import java.io.File;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class HowToWorkWithParser {
    public void parseXml(){
        try {
            File inputFile = new File("some.xml");

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("book");
            System.out.println("----------------------------");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                System.out.println("\nCurrent Element :" + nNode.getNodeName());
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    System.out.println("Book id = "
                            + eElement.getAttribute("id"));
                    System.out.println("Name : "
                            + eElement
                            .getElementsByTagName("name")
                            .item(0)
                            .getTextContent());
                    System.out.println("Author : "
                            + eElement
                            .getElementsByTagName("author")
                            .item(0)
                            .getTextContent());
                    System.out.println("Price : "
                            + getCurrency(eElement
                                .getElementsByTagName("price")
                                .item(0)
                                .getTextContent()));
                }
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public String getCurrency(String howMuch){
        BigDecimal result = new BigDecimal(howMuch).setScale(2, BigDecimal.ROUND_HALF_UP);
        NumberFormat form = NumberFormat.getCurrencyInstance(new Locale("en", "US"));
        
        return form.format(result);
    }
}
