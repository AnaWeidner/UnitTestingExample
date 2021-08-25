package Repositories;

public class UserRepository {
    public boolean save(String fullname){
        System.out.println(String.format("Saving fullName in database: %s", fullname));
        return true;
    }
}
