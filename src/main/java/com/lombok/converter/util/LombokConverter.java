package com.lombok.converter.util;

import com.google.gson.Gson;
import com.lombok.converter.JSONCharacters;
import com.lombok.converter.model.Person;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class LombokConverter {

    private LombokConverter(){}

    public static Person convertLombokToStringToPersonObject(String lombokString) {
        String personJson = convertLombokStringToJson(lombokString);

        return (new Gson()).fromJson(personJson, Person.class);

    }
    private static String convertLombokStringToJson(String lombokString) {
        String jsonFormatted = lombokString;

        List<Class<?>> classList= new ArrayList<>();

        getClassNamesRecursively(Person.class, classList);

        for(Class<?> classElement : classList) {
            String className  = classElement.getSimpleName();
            jsonFormatted = jsonFormatted.contains(className)
                    ? jsonFormatted.replaceAll(className, "")
                    : jsonFormatted;
        }

        for(JSONCharacters character : JSONCharacters.values()) {
            char currentChar = character.getOldChar();
            char newChar = character.getNewChar();
            jsonFormatted = jsonFormatted.contains(String.valueOf(currentChar))
                    ? jsonFormatted.replace(currentChar, newChar)
                    : jsonFormatted;
        }



        return jsonFormatted;
    }

    private static void getClassNamesRecursively(Class<?> rootClass, List<Class<?>> classList) {
        if(rootClass != null) {
            classList.add(rootClass);
            for (Field declaredField : rootClass.getDeclaredFields()) {
                if(!declaredField.getType().isPrimitive()
                        && !declaredField.getType().getPackageName().startsWith("java.")) {
                    getClassNamesRecursively(declaredField.getType(), classList);
                }
            }
        }
    }

}
