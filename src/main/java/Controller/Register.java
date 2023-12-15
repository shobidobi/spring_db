package Controller;

import Repository.PasswordRepository;
import Repository.UserRepository;
import entity.Check;
import entity.PasswordsEntity;
import entity.UsersEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;

@RestController
@Service
@RequestMapping("/api/users")
public class Register {
    Check check = new Check();
    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordRepository passwordRepository;
    @PostMapping("/register")
    public String registerUser(@RequestParam String username, @RequestParam String email,
                               @RequestParam String password) {
        if (check.isValidEmail(email)&&!(userRepository.findUsersEntityByEmail(email).isPresent())
        && check.checkUser(username,password)){

            userRepository.save(new UsersEntity(username,email));
            passwordRepository.save(new PasswordsEntity(password,
                    userRepository.findUsersEntityByUserNameContaining(username).get().getId(), LocalDate.now()));
            return "User registered successfully";
        }
        return "User registered failed";
    }
}
