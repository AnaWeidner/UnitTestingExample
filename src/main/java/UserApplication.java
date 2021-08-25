import Repositories.UserRepository;
import Services.UserService;

public class UserApplication {
    public static void main(String[] args) {
        UserService userService = new UserService(new UserRepository());
        String fullName = userService.ConcatenateFirstAndLastName("Ana", "Weidner");
        System.out.println(fullName);
    }
}
