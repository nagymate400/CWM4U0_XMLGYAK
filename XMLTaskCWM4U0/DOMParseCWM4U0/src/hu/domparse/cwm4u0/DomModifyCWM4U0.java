package hu.domparse.cwm4u0;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

    public class DomModifyCWM4U0 {
    public static void main(String[] args) {
        NodeList list;
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            // Fájl beolvasása
            Document document = builder.parse(new File("XMLcwm4u0.xml"));
            document.getDocumentElement().normalize();
            // Az elem meghatározása
            list = document.getElementsByTagName("Elofizeto");
            for (int i = 0; i < list.getLength(); i++) {
                Node node = list.item(i);
                // Az elem kiírása
                System.out.println("\nAktuális elem: " + node.getNodeName());
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    //Id eltárolása egy stringbe
                    String id=element.getAttribute("ElofizetoId");
                    //Elofizetők adatainak kiírása
                    System.out.println("Előfizető id : "
                            + element.getAttribute("ElofizetoId"));
                    System.out.println("Előfizetők neve : "
                            + element.getElementsByTagName("Nev").item(0).getTextContent());
                    System.out.println("Előfizetők utca: " + element.getElementsByTagName("Utca").item(0).getTextContent());
                    System.out.println("Előfizetők haszszam: "
                            +element.getElementsByTagName("Hazszam").item(0).getTextContent() );
                    Node nodenev = list.item(i);
                    if (nodenev.getNodeType() == Node.ELEMENT_NODE) {
                        Element element1 = (Element) node;
                        //Id vizsgálata és ha megegyezzik 1-el akkor Név módosítása Bélára
                        if (id.equals("1")) {
                            System.out.println("Siker");
                            element1.getElementsByTagName("Nev").item(0).setTextContent("Béla");

                        }
                        //Elofizetők új adatainak kiírás
                        System.out.println("Előfizetők neve : "
                                + element.getElementsByTagName("Nev").item(0).getTextContent());
                        System.out.println("Előfizetők utca: " + element.getElementsByTagName("Utca").item(0).getTextContent());
                        System.out.println("Előfizetők haszszam: "
                                +element.getElementsByTagName("Hazszam").item(0).getTextContent() );
                        }
                    }
                }
            //Lekérdezi az adatoktak és beleírja egy fájlba
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            Source input=new DOMSource(document);
            Result output = new StreamResult(new File("XMLcwm4u0mod.xml"));
            transformer.transform(input, output);

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
