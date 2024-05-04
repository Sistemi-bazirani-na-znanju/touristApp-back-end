package tourstApp.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

@Converter
public class ListToStringJsonConverter implements AttributeConverter<List<String>, String> {

    // Use a Jackson ObjectMapper to handle JSON serialization/deserialization
    private static final ObjectMapper objectMapper = new ObjectMapper();

    // Convert List<String> to JSON string
    @Override
    public String convertToDatabaseColumn(List<String> attribute) {
        if (attribute == null) {
            return null;
        }
        
        try {
            // Convert List<String> to JSON string using ObjectMapper
            return objectMapper.writeValueAsString(attribute);
        } catch (IOException e) {
            // Handle serialization error
            throw new RuntimeException("Failed to convert list to JSON string", e);
        }
    }

    // Convert JSON string to List<String>
    @Override
    public List<String> convertToEntityAttribute(String dbData) {
        if (dbData == null) {
            return null;
        }
        
        try {
            // Convert JSON string to List<String> using ObjectMapper
            return objectMapper.readValue(dbData, new TypeReference<List<String>>() {});
        } catch (IOException e) {
            // Handle deserialization error
            throw new RuntimeException("Failed to convert JSON string to list", e);
        }
    }
}
