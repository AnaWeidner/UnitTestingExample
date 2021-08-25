package Services;

import Repositories.UserRepository;
import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.lang.annotation.Documented;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    public void setup_BeforeEach() {
        System.out.println("Before Each test");
    }

    @BeforeAll
    public void setup_BeforeAll() {
        MockitoAnnotations.openMocks(this);
        System.out.println("Before All Test");
    }

    @AfterEach
    public void cleanup_AfterEach() {
        System.out.println("After Each Test");
    }

    @AfterAll
    public static void cleanup_AfterAll() {
        System.out.println("After All Test");
    }

    @Test
    void should_concatenateFirstAndLastName_when_parametersAreValid() {
        String fullName = userService.ConcatenateFirstAndLastName("Ana", "Weidner");
        assertEquals("AnaWeidner", fullName);
    }

    @Test
    void should_concatenateFirstAndLastName_when_parametersAreValid_assertTrueExample() {
        String fullName = userService.ConcatenateFirstAndLastName("Ana", "Weidner");
        assertTrue(fullName.equals("AnaWeidner"));
    }

    @Test
    void should_throwException_when_firstNameIsNull() {
        assertThrows(NullPointerException.class, () -> {
            userService.ConcatenateFirstAndLastName(null, "Weidner");
        });
    }

    @Test
    void should_callSaveMethodAndGetResultValue_when_SaveOnDatabaseMethodIsCalled() {
        when(userRepository.save(any())).thenReturn(true);
        Boolean wasSavedOnDatabase = userService.SaveOnDatabase("AnaWeidner");
        assertTrue(wasSavedOnDatabase);
    }

    @Test
    void should_callSaveMethod_when_SaveOnDatabaseMethodIsCalled() {
        userService.SaveOnDatabase("AnaWeidner");
        verify(userRepository, atLeastOnce()).save("AnaWeidner");
    }
}