package io.craigmiller160.orgbuilder.api.v1.model.util;

import javax.persistence.AttributeConverter;
import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * Date conversion utility, used to convert
 * java.time.LocalDateTime to java.sql.Timestamp
 * and vice-versa by persistence frameworks.
 *
 * Created by Craig on 1/7/2016.
 */
public class LocalDateTimeConverter implements AttributeConverter<LocalDateTime, Timestamp>{

    @Override
    public Timestamp convertToDatabaseColumn(LocalDateTime localDateTime) {
        return localDateTime == null ? null : Timestamp.valueOf(localDateTime);
    }

    @Override
    public LocalDateTime convertToEntityAttribute(Timestamp timestamp) {
        return timestamp == null ? null : timestamp.toLocalDateTime();
    }
}
