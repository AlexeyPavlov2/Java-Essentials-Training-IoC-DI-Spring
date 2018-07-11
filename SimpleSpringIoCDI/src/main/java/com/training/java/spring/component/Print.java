package com.training.java.spring.component;

import com.training.java.spring.component.figure.Figure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Print {
    @Autowired
    @Qualifier("circle")
    private Figure figure;

    public void showSquare() {
        System.out.println("Square of " + this.figure.getName() + " is " + this.figure.square());
    }
}