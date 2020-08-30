package com.lombok.converter;

import com.lombok.converter.model.Person;
import com.lombok.converter.util.LombokConverter;

public class Main {
    public static void main(String[] args) {
        String lombokString = "Person(name=John, age=30, telephone=Telephone(codeArea=16, number=1111-2222))";
        Person person = LombokConverter.convertLombokToStringToPersonObject(lombokString);

        System.out.println("person object converted: " + person.toString());
    }
}
