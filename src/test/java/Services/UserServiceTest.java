package Services;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class UserServiceTest {

    private UserService userService;

    @BeforeEach
    public void setupBeforeEach(){
        UserService userService = new UserService();
        this.userService = userService;
        System.out.println("Before Each test");
    }

    @BeforeAll
    public void setupBeforeAll(){
        System.out.println("Before All Test");
    }

    @AfterAll
    public static void cleanUp(){
        System.out.println("After All Test");
    }

    @AfterEach
    public void cleanUpEach(){
        System.out.println("After Each Test");
    }

    @Test
    void shouldConcatenateFirstAndLastName() {
        String fullName = userService.ConcatenateFirstAndLastName("Ana", "Weidner");
        assertEquals(fullName, "AnaWeidner");
    }

    @Test
    void shouldThrowExceptionIfFirstNameIsNull() {
        assertThrows(NullPointerException.class, () -> {
            userService.ConcatenateFirstAndLastName(null, "Weidner");
        });
    }
}