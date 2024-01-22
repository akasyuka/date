package com.example.springtemplate;

public enum YesOrNot {

    YES("Да"),
    NO("Нет");

    private final String answer;

    YesOrNot(String answer) {
        this.answer = answer;
    }

    public String getAnswer() {
        return answer;
    }
}
