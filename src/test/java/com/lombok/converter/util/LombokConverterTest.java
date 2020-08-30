package com.lombok.converter.util;

import com.lombok.converter.model.Person;
import org.junit.Test;

import static org.junit.Assert.*;

public class LombokConverterTest {

    @Test
    public void testConvertLombokToStringToPersonWithTelephoneObject() {
        String personString = "Person(name=John, age=30, telephone=Telephone(codeArea=16, number=1111-2222))";
        Person person = LombokConverter.convertLombokToStringToPersonObject(personString);

        System.out.println("person object converted: " + person.toString());
        assertNotNull(person);
        assertEquals("John", person.getName());
        assertEquals(30, person.getAge());
        assertNotNull(person.getTelephone());
        assertEquals(16, person.getTelephone().getCodeArea());
        assertEquals("1111-2222", person.getTelephone().getNumber());
    }

    @Test
    public void testConvertLombokToStringToPersonWithoutTelephoneObject() {
        String personString = "Person(name=John, age=30, telephone=null)";
        Person person = LombokConverter.convertLombokToStringToPersonObject(personString);

        System.out.println("person object converted: " + person.toString());
        assertNotNull(person);
        assertEquals("John", person.getName());
        assertEquals(30, person.getAge());
        assertNull(person.getTelephone());
    }
}