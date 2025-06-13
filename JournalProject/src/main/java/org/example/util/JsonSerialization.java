package org.example.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.List;

public class JsonSerialization {
    private static final ObjectMapper mapper = new ObjectMapper();

    public static void serialize(Object data, OutputStream os) throws Exception {
        mapper.writeValue(os, data);
    }

    public static <T> List<T> deserializeList(FileInputStream fis, Class<T> type) throws Exception {
        return mapper.readValue(fis,
                mapper.getTypeFactory().constructCollectionType(List.class, type)
        );
    }
}