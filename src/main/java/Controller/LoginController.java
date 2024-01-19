package Controller;

import Repository.PasswordRepository;
import Repository.TryLoginRepository;
import Repository.UserRepository;
import entity.Check;
import entity.EmailSenderService;
import entity.TryLoginEntity;
import entity.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@Service
public class LoginController {
    @Autowired
    private Check check = new Check();
    @Autowired
    TryLoginRepository tryLoginRepository ;
    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordRepository passwordRepository;
    @Autowired
    EmailSenderService emailSenderService;
    @GetMapping ("/login")
    public String login2(@RequestBody UserDetails user) {
        System.out.println(user.getUsername());
        if (check.isconnection(user.getUsername(),user.getPassword())) {
            return "Login successful";
        } else {
            return "Invalid credentials";
        }

    }
    @PostMapping("/login1")
    public String login3(@RequestParam String username, @RequestParam String password) {
        System.out.println("Received login request for username: " + username);

        if (checkCredentials(username, password)) {
            //tryLoginRepository.save(new TryLoginEntity(username,password,true));
            return "Login successful";
        } else {
            //tryLoginRepository.save(new TryLoginEntity(username,password,false));
            return "Invalid credentials";
        }
    }
    @PostMapping("/login2")
    public String login(@RequestBody UserDetails user) {
        if (check.isconnection(user.getUsername(), user.getPassword())) {
            return "Login successful";
        } else {
            return "Invalid username or password";
        }
    }
    @PostMapping("/register")
    public String registerUser(@RequestParam String username, @RequestParam String email,
                               @RequestParam String password) {

        if (check.isValidEmail(email)){
            if (!(userRepository.findUsersEntityByEmail(email).isPresent())){
                System.out.println("The email isnt already in use");

                if (check.checkUser(username,password)){
                    System.out.println("The user name is not");

                }
                else {
                    System.out.println("The user name is not valid");
                }
            }
            else {
                System.out.println("The email is already in use");
            }

        }
        else {
            System.out.println("The email is not valid");
        }
        return "User registered failed";
    }
    @PostMapping("/generateCode")
    public int generateCode(@RequestBody String email) {
        String email1=email.replace("%40", "@");
        System.out.println(email1);
        String email2=email1.replace("email=","");
        if (!check.isValidEmail(email2)) {
            System.out.println("The email is valid");
        } else if (!(userRepository.findUsersEntityByEmail(email2).isPresent())) {
            System.out.println("The email is not valid");
        }
        // Send the code via email
        forgotPassword f=new forgotPassword();
        f.setEmail(email2);
        int code=emailSenderService.sendMail(email2);
        return code;
    }
    private boolean checkCredentials(String username, String password) {
        if (check.isconnection(username,password)) {
            return true;
        } else {
            return false;
        }
    }


}
