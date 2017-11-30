import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class SlicerTest {
    public Slicer slicer;

    @Test
    public void shouldHave3ArraysOfLenght1(){
        slicer = new Slicer(Arrays.asList("Cacho","Pedro","Wily"),1);
        assertEquals(1,slicer.slice().size());
        assertEquals(1,slicer.slice().size());
        assertEquals(1,slicer.slice().size());
        assertNull(slicer.slice());
    }

    @Test
    public void shouldHave1ArraysOfLenght2And1ArrayOf1(){
        slicer = new Slicer(Arrays.asList("Cacho","Pedro","Wily"),2);
        assertEquals(2,slicer.slice().size());
        assertEquals(1,slicer.slice().size());
        assertNull(slicer.slice());
    }
}