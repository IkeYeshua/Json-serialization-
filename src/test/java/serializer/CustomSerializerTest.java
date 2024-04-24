package serializer;

import classes.Cat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class CustomSerializerTest {
    private Cat cat;

    private String testJsonString;



    @BeforeEach
    void setUp(){
        cat = new Cat();
        cat.setName("Ologbo");
        cat.setAge(10);
        cat.setColor("black");
        testJsonString ="{\"name\":\"Ologbo\",\"age\":10,\"color\":\"black\"}";

    }

    @Test
    void testWriteCatToJson(){
        String CatAsJson = CustomSerializer.catToJson(cat);
        assertEquals(testJsonString, CatAsJson);


    }
    @Test
    void testReadFromJsonToCat(){
        Cat catDeserializedFromJsonString = CustomSerializer.jsonToCat(testJsonString);
        assertNotNull(catDeserializedFromJsonString);
        assertEquals(cat, catDeserializedFromJsonString);
        assertEquals("Ologbo", catDeserializedFromJsonString.getName());

    }

    @Test
    void testSerializeCatWithDateOfBirth(){
        cat.setDateOfBirth(LocalDateTime.now());
        String catInJson = CustomSerializer.catToJson(cat);
        assertNotNull(catInJson);
    }

}