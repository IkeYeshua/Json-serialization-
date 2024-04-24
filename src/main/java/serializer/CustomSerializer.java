package serializer;

import classes.Cat;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.logging.Logger;

public class CustomSerializer {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    private static final Logger log = Logger.getGlobal();


    public static String catToJson(Cat cat) {
        try {
            String catAsJson =
                    objectMapper.writeValueAsString(cat);
            log.info(catAsJson);
            return catAsJson;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static Cat jsonToCat(String testJsonString) {

        try {
            objectMapper.readValue(testJsonString, Cat.class);

        } catch (JsonProcessingException e){
            e.printStackTrace();

    }
        return null;

}
}
