package hu.domparse.cwm4u0;

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
import java.io.File;
import java.io.IOException;

public class DomQueryCWM4U0 {

    public static void main(String[] args) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            //Fájl bolvasása
            Document document = builder.parse(new File("XMLcwm4u0.xml"));
            document.getDocumentElement().normalize();
            //Xpath készítése
            XPath xPath= XPathFactory.newInstance().newXPath();
            //Elérési út megadása
            //Összes előfizető lekérése
            String expression="root/Elofizetok/Elofizeto";

            //Lista elkészítése,path kifejezés megírása
            NodeList nodeList=(NodeList) xPath.compile(expression).evaluate(document, XPathConstants.NODESET);
            //For ciklus nodlist csomópontjainak végig itrálása
            for (int i=0;i<nodeList.getLength();i++){
                Node node=nodeList.item(i);
                //Elem kiírása
                System.out.println ("\nAktuális elem: " + node.getNodeName());

                //Vizsgálata, találtelemek kilistázása
                if(node.getNodeName().equals("Elofizeto")){
                    Element element=(Element) node;
                    System.out.println("Előfizetők neve : " + element.getElementsByTagName("Nev").item(0).getTextContent());
                }
            }
        } catch (ParserConfigurationException | XPathExpressionException | IOException | SAXException e){
            e.printStackTrace();
        }
    }

}
