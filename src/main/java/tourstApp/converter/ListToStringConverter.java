package tourstApp.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Converter
public class ListToStringConverter implements AttributeConverter<List<String>, String> {
    @Override
    public String convertToDatabaseColumn(List<String> attribute) {
        return attribute == null ? null : StringUtils.join(attribute, ",");
    }

    @Override
    public List<String> convertToEntityAttribute(String columnValue) {
        if (StringUtils.isBlank(columnValue)) {
            return Collections.emptyList();
        }

        return Arrays.asList(columnValue.split(","));
    }
}
