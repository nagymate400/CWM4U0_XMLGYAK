package SaxCWM4U01019;

import java.io.File;
import java.io.IOException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;

public class XsdValidation {
    public static void main(String[] args) {
        boolean result = validateXMLSchema("szemelyekCWM4U0.xsd", "szemelyekCWM4U0.xml");
        if(result) {
            System.out.println("Az XML és XSD dokumentumok validálása sikeres volt!");
        }else {
            System.out.println("Az XML és XSD dokumentumok validálása sikertelen volt!");
        }
    }

    public static boolean validateXMLSchema(String xsdPath, String xmlPath){

        try {
            SchemaFactory factory =
                    SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new File(xsdPath));
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(new File(xmlPath)));
        } catch (IOException | SAXException e) {
            System.out.println("Exception: "+e.getMessage());
            return false;
        }
        return true;
    }
}