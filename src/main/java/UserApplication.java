import Services.UserService;

public class UserApplication {
    public static void main(String[] args) {
        UserService userService = new UserService();
        String fullName = userService.ConcatenateFirstAndLastName("Ana", "Weidner");
        System.out.println(fullName); // Display the string.
    }
}
