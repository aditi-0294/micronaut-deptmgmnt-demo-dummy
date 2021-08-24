package com.utils;

import com.constants.Constants;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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

    public static ObjectMapper mapper = new ObjectMapper();

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

    public <T> T getDepartmentDetailedListfromJson(Class<T> type) {
        try {
            logger.debug("file path :- {}", jsonFileRead(Constants.jsonFilePath));
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




}
