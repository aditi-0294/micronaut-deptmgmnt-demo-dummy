package com.utils;

import com.constants.Constants;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Singleton;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

@Singleton
public class JsonUtil {

    private static final Logger logger = LoggerFactory.getLogger(JsonUtil.class);

    public static ObjectMapper mapper = new ObjectMapper().registerModule(new Jdk8Module());

    public InputStream jsonFileRead(String path) throws FileNotFoundException {
        InputStream input = null;
        if (!path.equals("")) {
            try {
                input = new FileInputStream(this.getClass().getClassLoader().getResource(path).getFile());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return input;

    }


    public <T> T fromJson(Class<T> type) {
        try {
            logger.debug("file path :- {}", jsonFileRead(Constants.jsonFilePath).toString());
            mapper.configure(DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS, true);
            return mapper.readValue(jsonFileRead(Constants.jsonFilePath), type);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @SneakyThrows
    public <T> T fromJson(TypeReference <T> typeRefClass) {
        logger.debug("file path :- {}", jsonFileRead(Constants.jsonFilePath).toString());
        mapper.configure(DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS, true);
        return mapper.readValue(jsonFileRead(Constants.jsonFilePath), typeRefClass);
    }

/*
    public String toJson(ObjectFactory type) {
        *//*mapper.enable(SerializationFeature.INDENT_OUTPUT);
        FileOutputStream output = null;
        try {
            output = new FileOutputStream(this.getClass()
                        .getClassLoader().getResource(Constants.jsonWriteFile)
                        .getFile());
            mapper.writerWithDefaultPrettyPrinter().writeValue(output, type);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // mapper.writerWithDefaultPrettyPrinter().writeValueAsString(output,object);
       // output.close();
        return mapper.toString();*//*


        final String currentJsonArrayAsString;
        try {
            currentJsonArrayAsString = String.valueOf(
                    Files.readAllLines(
                            (Path) jsonFileRead(Constants.jsonWriteFile)));
            FileWriter fileWriter = new FileWriter(path.toFile(), false
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileWriter fileWriter = new FileWriter(path.toFile(), false)) {

            JSONObject jsonObject = new JSONObject(objectMapper.writeValueAsString(book));
            JSONArray jsonArray = new JSONArray(currentJsonArrayAsString);
            jsonArray.put(jsonObject);

            fileWriter.write(jsonArray.toString());
        }
    }*/

}
