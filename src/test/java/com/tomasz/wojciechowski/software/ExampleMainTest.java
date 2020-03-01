package com.tomasz.wojciechowski.software;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;


class ExampleMainTest {

    private ExampleMain classUnderTest = new ExampleMain();

    private static class DecoratedOutputStream extends PrintStream{

        private OutputStream source;
        private String lastMessage;

        public DecoratedOutputStream(OutputStream out) {
            super(out);
            this.source = out;
        }

        @Override
        public void println(String x) {
            super.println(x);
        }
    }

    @Test
    public void shouldPrintHelloWord() throws NoSuchFieldException, IllegalAccessException {
        //given
        String expectedResult = "Hello World";
        List<String> printedData = new ArrayList<>();

        //when
        classUnderTest.main(new String[0]);

        //then
        System.setOut(original);
        String result = printedData.get(0);
        Assertions.assertEquals(expectedResult, result);

    }

}