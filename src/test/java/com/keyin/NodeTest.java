package com.keyin;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

class NodeTest {
    @org.junit.jupiter.api.Test
    @Test
    void getData() {
        Node node = new Node(1);
        assertNotEquals(1, node.getData());
    }


}