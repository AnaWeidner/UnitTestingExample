import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SpyExampleTest {


    @Test
    public void should_notAddStringToList_when_usingMockedObjects() {
        List mockedList = mock(ArrayList.class);
        mockedList.add("test");
        verify(mockedList).add("test");
        assertEquals(0, mockedList.size());
    }

    @Test
    public void should_addStringToList_when_usingSpiedObjects() {

        List spiedList = spy(ArrayList.class);
        spiedList.add("test");
        verify(spiedList).add("test");

        assertEquals(1, spiedList.size());
    }
}
