package ua.pp.msk.julia.my.interviewtask;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ynahorna
 */
public class IsDictionaryTest {
    
    public IsDictionaryTest() {
    }

    @Test
    public void testGetDictionary() {
        Dictionary result = IsDictionary.getDictionary();
        assertNotNull(result);
        assertTrue(result instanceof IsDictionary);
    }

    @Test
    public void testStore() {
        Dictionary instance = IsDictionary.getDictionary();
        
        String word = "test";
        instance.store(word);
        assertEquals(1, instance.getOccurence(word));
        
        String word2 = "test ";
        instance.store(word2);
        assertEquals(2, instance.getOccurence(word));
        
        String word3 = "Test";
        instance.store(word3);
        assertEquals(3, instance.getOccurence(word3));
        
        //Additional tests
        String word4 = "\n\ttest";
        instance.store(word4);
        assertEquals(4, instance.getOccurence(word4));
    }

    @Test
    public void testGetOccurence() {
        Dictionary instance = IsDictionary.getDictionary();
        String word = "test_example";
        int expected = 10;
        for(int i = 0; i < expected; i++){
            instance.store(word);
        }
        int result = instance.getOccurence(word);
        assertEquals(expected, result);
    }
}
