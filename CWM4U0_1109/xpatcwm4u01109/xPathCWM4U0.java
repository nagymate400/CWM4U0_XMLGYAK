package xpatcwm4u01109;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.IOException;

public class xPathCWM4U0 {
    public static void main(String[] args) {
        try {


            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = factory.newDocumentBuilder();
            Document doc = dBuilder.parse("studentCWM4U0.xml");

            doc.getDocumentElement().normalize();
        XPath xPath = XPathFactory.newInstance().newXPath();
        //String expression = "class"
            // 1.f
        //String expression = "class/student";
        //2.f
            String expression = "class/student[1]";
            //3.f
            String expression = "";

            NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(doc, XPathConstants.NODESET);
            for (int i=0;i<nodeList.getLength();i++){
                Node node = nodeList.item(i);
                System.out.println("\n Aktuális elem: "+node.getNodeName());

                if (node.getNodeType() == Node.ELEMENT_NODE && node.getNodeName().equals("student")){
                    Element element = (Element) node;

                    System.out.println("Hallató ID: "+ element.getAttribute("id"));

                    System.out.println("Keresztnév: " +element.getElementsByTagName("keresztnev").item(0).getTextContent());
                    System.out.println("Vezetéknév: " +element.getElementsByTagName("vezeteknev").item(0).getTextContent());
                    System.out.println("Becenév: " +element.getElementsByTagName("becenev").item(0).getTextContent());
                    System.out.println("Kor: " +element.getElementsByTagName("kor").item(0).getTextContent());
                }
            }
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}
