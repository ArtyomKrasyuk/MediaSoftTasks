package org.example;

import java.lang.reflect.Field;

public class JsonSerializer {
    public static String getJson(Object object){
        String result = "{";
        for(Field field: object.getClass().getDeclaredFields()){
            if(field.isAnnotationPresent(JsonField.class)) {
                field.setAccessible(true);
                try{
                    result += String.format("\"%s\": %s, ", field.getAnnotation(JsonField.class).name(), field.get(object).toString());
                } catch (IllegalAccessException ignored){
                }
            }
        }
        result = result.substring(0, result.length() - 2);
        result += "}";
        return result;
    }
}
