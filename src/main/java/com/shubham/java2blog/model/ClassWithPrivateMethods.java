package com.shubham.java2blog.model;

/**
 * @author : Shubham Aggarwal
 * @since : 10/09/17
 */
public class ClassWithPrivateMethods {

    private String printMessage(String message) {
        return message;
    }

    public String privateCall(String message) {
        return printMessage(message);
    }
}
