package model;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import java.io.IOException;


public class ImportXMLFileTest {


   private static ImportXMLFile importXMLFile;

   @Before
   public void initialiseInstance(){
      importXMLFile = new ImportXMLFile();
    }

    @Test
    public void Happy() {
        assertTrue(importXMLFile.xmlFileContents("src/main/java/payload/requests.xml").contains(">"));
    }

    @Test
    public void unHappy() {
        assertFalse(importXMLFile.xmlFileContents(null).contains(">"));
    }


    @Test(expected = IOException.class)
    public void test_IOException() {
        importXMLFile.xmlFileContents(null);

    }

}




