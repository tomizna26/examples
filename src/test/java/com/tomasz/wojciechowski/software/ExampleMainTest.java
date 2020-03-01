package com.tomasz.wojciechowski.software;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.PrintStream;


class ExampleMainTest {

    private ExampleMain classUnderTest = new ExampleMain();

    private static class DecoratedOutputStream extends PrintStream{

        private PrintStream source;
        private String lastMessage;

        public DecoratedOutputStream(PrintStream out) {
            super(out);
            this.source = out;
        }

        @Override
        public void println(String x) {
            lastMessage = x;
            source.println(x);
        }

        public String getLastMessage(){
            return lastMessage;
        }

        public PrintStream getOriginalStream(){
            return source;
        }
    }

    @Test
    public void shouldPrintHelloWord() throws NoSuchFieldException, IllegalAccessException {
        //given
        String expectedResult = "Hello World";
        DecoratedOutputStream decoratedOut = new DecoratedOutputStream(System.out);
        System.setOut(decoratedOut);
        //when
        classUnderTest.main(new String[0]);

        //then
        System.setOut(decoratedOut.getOriginalStream());
        Assertions.assertEquals(expectedResult, decoratedOut.getLastMessage());

    }

}