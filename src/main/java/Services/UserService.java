package Services;

import Repositories.UserRepository;

public class UserService {

    private UserRepository userRepository;
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }


    public String ConcatenateFirstAndLastName(String firstName, String lastName){
        return firstName.concat(lastName);
    }

    public boolean SaveOnDatabase(String fullName){
        return userRepository.save(fullName);
    }
}
