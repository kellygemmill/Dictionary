package com.kellygemmill.dictionary.model;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import static com.kellygemmill.dictionary.model.DictionaryType.*;

@Converter
public class TypeAttributeConverter  implements AttributeConverter<DictionaryType, String> {

    @Override
    public java.lang.String convertToDatabaseColumn(DictionaryType attribute) {
        if (attribute == null) {
            return null;
        }

        switch (attribute) {
            case JtoJ:
                return "JtoJ";

            case JtoE:
                return "JtoE";

            case EtoJ:
                return "EtoJ";

            case ALL:
                return "ALL";

            default:
                throw new IllegalArgumentException(attribute + " not supported.");
        }
    }

    @Override
    public DictionaryType convertToEntityAttribute(String dbData) {
        if (dbData == null) {
            return null;
        }

        switch (dbData) {
            case "JtoJ":
                return JtoJ;

            case "JtoE":
                return JtoE;

            case "EtoJ":
                return EtoJ;

            case "ALL":
                return ALL;
                
            default:
                throw new IllegalArgumentException(dbData + "not supported.");
        }
    }
}
