package com.angelhack.moneygement.common.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class JsonUtil {

    public static final ObjectMapper objectMapper = new ObjectMapper();

    public static <T> T convertObject(Object obj, Class<T> clazz) {
        try {
            return objectMapper.convertValue(obj, clazz);
        } catch (Exception e) {
            log.error("Error converting object to object! {} to {}", obj, clazz);
            throw new RuntimeException("Error converting object to object!", e);
        }
    }

    public static <T> List<T> convertObjectToList(Object obj, Class<T> clazz) {
        try {
            return objectMapper.convertValue(obj, objectMapper.getTypeFactory().constructCollectionType(List.class, clazz));
        } catch (Exception e) {
            log.error("Error converting object to list! {} to List<{}>", obj, clazz);
            throw new RuntimeException("Error converting object to list!", e);
        }
    }

    public static <T> T convertJsonToObject(String json, Class<T> clazz) {
        try {
            return objectMapper.readValue(json, clazz);
        } catch (Exception e) {
            log.error("Error converting JSON string to object! JSON: {} to {}", json, clazz);
            throw new RuntimeException("Error converting JSON string to object!", e);
        }
    }

    public static <T> List<T> convertJsonToList(String json, Class<T> clazz) {
        try {
            return objectMapper.readValue(json, objectMapper.getTypeFactory().constructCollectionType(List.class, clazz));
        } catch (Exception e) {
            log.error("Error converting JSON string to list! JSON: {} to List<{}>", json, clazz);
            throw new RuntimeException("Error converting JSON string to list!", e);
        }
    }
}
