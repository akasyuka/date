package com.example.springtemplate;

public enum YesOrNotEnum {

    YES("Да"),
    NO("Нет");

    private final String answear;

    YesOrNotEnum(String answer) {
        this.answear = answer;
    }

    public String getAnswer() {
        return answear;
    }
}
