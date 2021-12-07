package hu.domparse.cwm4u0;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DomReadCWM4U0 {
    public static void main(String[] args) {
        NodeList list;
        try {
            DocumentBuilderFactory documentBuilderFactoryfactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactoryfactory.newDocumentBuilder();

            // Fájl beolvasás
            Document document = documentBuilder.parse(new File("XMLcwm4u0.xml"));
            document.getDocumentElement().normalize();
            //Elem meghatározás
            list = document.getElementsByTagName("Elofizeto");
            for(int i = 0; i<list.getLength(); i++) {
                Node node = list.item(i);
                //Elem kiírása
                System.out.println("\nAktuális elem: " + node.getNodeName());

                //Előfizető adatainak kiírása
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    System.out.println("Előfizető neve : "  + element.getElementsByTagName("Nev").item(0).getTextContent());
                    System.out.println("Előfizető utca: "
                            + element.getElementsByTagName("Utca").item(0).getTextContent());
                    System.out.println("Hazszam : "
                            + element.getElementsByTagName("Hazszam").item(0).getTextContent());
                }

            }
            list = document.getElementsByTagName("Kihordo");
            for(int j = 0; j<list.getLength(); j++) {
                //Kihordó adatainak kiírása
                Node kihordonode = list.item(j);
                //Elem kiírása
                System.out.println("\nAktuális elem: " + kihordonode.getNodeName());
                if (kihordonode.getNodeType() == Node.ELEMENT_NODE) {
                    Element elementkihordo = (Element) kihordonode;
                    //Előfizetes adatainak kiírása
                    System.out.println("Név : "  + elementkihordo.getElementsByTagName("Knev").item(0).getTextContent());
                    System.out.println("Beosztás : " + elementkihordo.getElementsByTagName("Kbeosztas").item(0).getTextContent());
                    System.out.println("Város : " + elementkihordo.getElementsByTagName("Varos").item(0).getTextContent());
                }
            }
                list = document.getElementsByTagName("Elofizetes");
                for(int j = 0; j<list.getLength(); j++) {
                    //Előfizetes adatainak kiírása
                    Node elonode = list.item(j);
                    //Elem kiírása
                    System.out.println("\nAktuális elem: " + elonode.getNodeName());
                    if (elonode.getNodeType() == Node.ELEMENT_NODE) {
                        Element elementelofizetes = (Element) elonode;
                        //Előfizetes adatainak kiírása
                        System.out.println("Lap id : " + elementelofizetes.getAttribute("Lapid"));
                        System.out.println("Elo id : " + elementelofizetes.getAttribute("Eloid"));
                    }
                    if (elonode.getNodeType() == Node.ELEMENT_NODE) {
                        Element elementdb = (Element) elonode;
                        System.out.println("Darab : " + elementdb.getElementsByTagName("Db").item(0).getTextContent());
                    }
                }
                    list = document.getElementsByTagName("Szerkeszto");
                    for(int j = 0; j<list.getLength(); j++) {
                        //Előfizetes adatainak kiírása
                        Node szerknode = list.item(j);
                        //Elem kiírása
                        System.out.println("\nAktuális elem: " + szerknode.getNodeName());
                        if (szerknode.getNodeType() == Node.ELEMENT_NODE) {
                            Element elementelofizetes = (Element) szerknode;
                            //Előfizetes adatainak kiírása
                            System.out.println("Szerkesztő neve : " + elementelofizetes.getElementsByTagName("Sznev").item(0).getTextContent());
                            System.out.println("Szerkesztő beosztas : " + elementelofizetes.getElementsByTagName("Szbeosztas").item(0).getTextContent());
                            System.out.println("Szerkeszto adatai : " + elementelofizetes.getElementsByTagName("Szadatok").item(0).getTextContent());
                        }
                    }

            list = document.getElementsByTagName("Lap");
            for(int j = 0; j<list.getLength(); j++) {
                //Lap adatainak kiírása
                Node lapnode = list.item(j);
                //Elem kiírása
                System.out.println("\nAktuális elem: " + lapnode.getNodeName());
                if (lapnode.getNodeType() == Node.ELEMENT_NODE) {
                    Element elementelofizetes = (Element) lapnode;
                    //Előfizetes adatainak kiírása
                    System.out.println("Lap címe : " + elementelofizetes.getElementsByTagName("Cim").item(0).getTextContent());
                    System.out.println("Lap téma : " + elementelofizetes.getElementsByTagName("Tema").item(0).getTextContent());
                    System.out.println("Lap havi : " + elementelofizetes.getElementsByTagName("Havi").item(0).getTextContent());
                    System.out.println("Lap negyedéves : " + elementelofizetes.getElementsByTagName("Negyedeves").item(0).getTextContent());
                    System.out.println("Lap szid : " + elementelofizetes.getElementsByTagName("Szid").item(0).getTextContent());
                    System.out.println("Lap kid : " + elementelofizetes.getElementsByTagName("Kid").item(0).getTextContent());

                }
            }


        } catch (
                ParserConfigurationException e) {
            e.printStackTrace();
        } catch (
                IOException e) {
            e.printStackTrace();
        } catch (
                SAXException e) {
            e.printStackTrace();
        }
    }
}