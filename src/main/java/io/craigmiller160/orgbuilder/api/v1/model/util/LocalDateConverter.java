package io.craigmiller160.orgbuilder.api.v1.model.util;

import javax.persistence.AttributeConverter;
import java.sql.Date;
import java.time.LocalDate;

/**
 * Date conversion utility, used to convert
 * java.time.LocalDate to java.sql.Date
 * and vice-versa by persistence frameworks.
 *
 * Created by Craig on 1/7/2016.
 */
public class LocalDateConverter implements AttributeConverter<LocalDate,Date> {

    @Override
    public Date convertToDatabaseColumn(LocalDate localDate) {
        return localDate == null ? null : Date.valueOf(localDate);
    }

    @Override
    public LocalDate convertToEntityAttribute(Date date) {
        return date == null ? null : date.toLocalDate();
    }

}
