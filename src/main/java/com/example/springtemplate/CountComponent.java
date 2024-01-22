package com.example.springtemplate;

import org.springframework.stereotype.Component;

@Component
public class CountComponent {

    private static int staticVariable = 0;

    public int getStaticVariable() {
        return staticVariable;
    }

    public void incrementStaticVariable() {
        staticVariable++;
    }
    public void decrementStaticVariable() {
        staticVariable--;
    }
}
