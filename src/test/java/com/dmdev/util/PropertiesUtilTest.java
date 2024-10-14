package com.dmdev.util;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class PropertiesUtilTest {

    @ParameterizedTest
    @MethodSource("getArguments")
    void get(String key, String expectedValue) {
        //db.url=jdbc:h2:mem:test;DB_CLOSE_DELAY=-1
        //db.user=sa
        //db.password=
        String actualResult = PropertiesUtil.get(key);

        assertEquals(expectedValue, actualResult);
    }

    static Stream<Arguments> getArguments(){
        return Stream.of(
                Arguments.of("db.url","jdbc:h2:mem:test;DB_CLOSE_DELAY=-1"),
                Arguments.of("db.pa",null),
                Arguments.of("db.user","sa")
        );
    }
}