package com.bharath.skills.main;

import java.util.ArrayList;
import java.util.List;

class Field {

    public String type;
    public String name;

    public Field(String type, String name) {
        this.type = type;
        this.name = name;
    }

    @Override
    public String toString() {
        return "public " + type + " " + name+";";
    }

}

class Class {

    public String name;
    public List<Field> fields=new ArrayList<>();

    private static final String newLine = System.lineSeparator();

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("public class ").append(name).append(newLine).append('{').append(newLine);
        fields.forEach(field -> sb.append("  ").append(field.toString()).append(newLine));
        sb.append('}');

        return sb.toString();

    }

}


public class CodeBuilder {

    public Class theClass = new Class();

    public CodeBuilder(String className) {
        theClass.name = className;
    }

    public CodeBuilder addField(String name, String type) {
        theClass.fields.add(new Field(type, name));
        return this;
    }

    @Override
    public String toString() {
        return theClass.toString();
    }

    public static void main(String[] args) {
        CodeBuilder codeBuilder = new CodeBuilder("Person").
                addField("name", "String").
                addField("age", "int");
        System.out.println(codeBuilder.toString());

    }
}
