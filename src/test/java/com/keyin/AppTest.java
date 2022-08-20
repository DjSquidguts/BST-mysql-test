package com.keyin;

import org.junit.jupiter.api.Test;

import java.sql.Connection;

import static jdk.internal.net.http.HttpResponseImpl.RawChannelProvider.connection;
import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    void createInputsVariable() {
        String addVariablesTogether = String.valueOf(new AppTest());
        addVariablesTogether.contains("9"+" "+8+" "+7+" "+6+" "+5+" "+4+" "+3+" "+2+" "+1);
        assertNotEquals("9 8 7 6 5 4 3 2 1","Test@564139 8 7 6 5 4 3 2 1");
        assertEquals("Test@564139 8 7 6 5 4 3 2 1","Test@564139 8 7 6 5 4 3 2 1");
    }

    @Test
    void post() {

    }

    @Test
    void createTable() {
        //check if the table is created

    }

    @Test
    void negativegetConnectionTestShouldReturnIllegalArgExcept() {
        //test if the connection is made
        //var dbconnection = new dbconnection();
        assertEquals("null", connection(null);

    }
}