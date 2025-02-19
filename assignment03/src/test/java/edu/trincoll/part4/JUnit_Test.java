package edu.trincoll.part4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class JUnit_Test {

    @Test
    public void testInToPostConvert() {
        InToPost inToPost = new InToPost();
        String infix = "(1+2)*(3+4)/(12-5)";
        String expectedPostfix = "12+34+*125-/";
        String actualPostfix = inToPost.inToPost_convert(infix);
        assertEquals(expectedPostfix, actualPostfix);
    }

    @Test
    public void testInToPrefixConvert() {
        InToPrefix inToPrefix = new InToPrefix();
        String infix = "(1+2)*(3+4)/(12-5)";
        String expectedPrefix = "/*+12+34-125";
        String actualPrefix = inToPrefix.inToPrefixConvert(infix);
        assertEquals(expectedPrefix, actualPrefix);
    }
}