package uk.gov.hmrc.information.validator;

import com.google.gson.Gson;
import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import uk.gov.hmrc.information.model.Information;

@Component
public class InformationJsonValidator implements Validator {

    private static final JSONObject JSON_SCHEMA = new JSONObject(
            new JSONTokener(InformationJsonValidator.class.getResourceAsStream("/informationSchema.json")));

    @Override
    public boolean supports(Class<?> clazz) {
        return Information.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Schema schema = SchemaLoader.load(JSON_SCHEMA);
        try {
            JSONObject jsonObject = new JSONObject(new JSONTokener(new Gson().toJson(o)));
            schema.validate(jsonObject);
        }catch (Exception e){
            errors.reject(HttpStatus.BAD_REQUEST.getReasonPhrase(), "Invalid JSON request");
        }
    }
}
