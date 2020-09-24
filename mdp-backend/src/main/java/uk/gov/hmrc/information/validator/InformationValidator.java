package uk.gov.hmrc.information.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.xml.sax.SAXException;
import uk.gov.hmrc.information.model.Information;
import org.springframework.util.ResourceUtils;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.io.IOException;

@Component
public class InformationValidator implements Validator {

    private static final String XSD_PATH = "src/main/resources/xsd/information.xsd";

    @Override
    public boolean supports(Class<?> clazz) {
        return Information.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object o, Errors errors) {
        try {
            System.out.println(">>>>>>>>> Inside validator");

            SchemaFactory factory =
                    SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(ResourceUtils.getFile(XSD_PATH));
            javax.xml.validation.Validator validator = schema.newValidator();
            validator.validate((StreamSource)o);
        } catch (IOException | SAXException e) {
            System.out.println("Exception: "+e.getMessage());
//            return false;
        }
//        return true;
    }
}
