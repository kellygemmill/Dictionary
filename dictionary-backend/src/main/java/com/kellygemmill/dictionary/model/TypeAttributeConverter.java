package com.kellygemmill.dictionary.model;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class TypeAttributeConverter  implements AttributeConverter<DictionaryType, String> {

    @Override
    public java.lang.String convertToDatabaseColumn(DictionaryType attribute) {
        if (attribute == null) {
            return null;
        }

        switch (attribute) {
            case MONOLINGUAL:
                return "MONOLINGUAL";

            case BILINGUAL:
                return "BILINGUAL";

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
            case "MONOLINGUAL":
                return DictionaryType.MONOLINGUAL;

            case "BILINGUAL":
                return DictionaryType.BILINGUAL;

            default:
                throw new IllegalArgumentException(dbData + "not supported.");
        }
    }
}
