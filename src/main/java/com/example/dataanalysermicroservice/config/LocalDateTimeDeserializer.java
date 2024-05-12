package com.example.dataanalysermicroservice.config;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.gson.*;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;
import java.time.LocalDateTime;

@Component
public class LocalDateTimeDeserializer implements JsonDeserializer<LocalDateTime> {
    @Override
    public LocalDateTime deserialize(JsonElement json,
                                     Type type,
                                     JsonDeserializationContext jsonDeserializationContext)
            throws JsonParseException {
        JsonArray jsonArray = json.getAsJsonArray();
        int year = jsonArray.get(0).getAsInt();
        int month = jsonArray.get(1).getAsInt();
        int day = jsonArray.get(2).getAsInt();
        int hour = jsonArray.get(3).getAsInt();
        int minute = jsonArray.get(4).getAsInt();
        int second = jsonArray.get(5).getAsInt();
        return LocalDateTime.of(year, month, day, hour, minute, second);
    }
}
