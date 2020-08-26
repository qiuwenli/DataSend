package com.lgom.transport.config;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Mr qiu
 * @description Json 返回时间格式化
 * @date 2020-06-17 14:44
 */
//@Configuration
public class DateFormatConfig {


    private static SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static class DateJsonSerializer implements JsonSerializer<Date> {
        @Override
        public JsonElement serialize(Date date, Type type, JsonSerializationContext jsonSerializationContext) {
            return new JsonPrimitive(dateFormat.format(date));
        }
    }


    public static class DateJsonDeserializer implements JsonDeserializer<Date> {
        @Override
        public Date deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
            return new Date(jsonElement.getAsJsonPrimitive().getAsString());
        }
    }



}
