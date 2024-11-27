package model;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

import java.io.IOException;

public class AccountExtractorTest {

    private static AccountExtractor accountExtractor;

    @Before
    public void Before(){
        accountExtractor = new AccountExtractor();
    }

//    @Test
//    public void happy() {
//        assertTrue(accountExtractor.accountsExtracted("firstname").contains(">"));
//    }

    @Test
    public void sad() {
        assertFalse(accountExtractor.accountsExtracted(null).contains(">"));
    }

    @Test(expected = IOException.class)
    public void test_IOException() {
        accountExtractor.accountsExtracted(null);
    }


}
