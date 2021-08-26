import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SpyExampleTest {

    @Mock
    ArrayList mockedList;

    @Spy
    ArrayList spiedList;

    @BeforeAll
    public void SetUpBeforeAll(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void should_notAddStringToList_when_usingMockedObjects() {
        mockedList.add("test");
        verify(mockedList).add("test");
        assertEquals(0, mockedList.size());
    }

    @Test
    public void should_addStringToList_when_usingSpiedObjects() {
        spiedList.add("test");
        verify(spiedList).add("test");
        assertEquals(1, spiedList.size());
    }
}
