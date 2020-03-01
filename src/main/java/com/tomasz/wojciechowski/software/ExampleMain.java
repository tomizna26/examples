package com.tomasz.wojciechowski.software;

import java.util.Optional;

public class ExampleMain {
    public static void main(String[] args){
        String message = Optional.ofNullable( args.length >0 ? args[0] : null)
                .map( name -> "Hello "+name)
                .orElse("Hello World");
        System.out.println(message);
    }
}

