package entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Service
public class LoginController {
    Check check = new Check();

    @PostMapping("/login")
    public String login(@RequestBody UserDetails user) {
        System.out.println(user.getUsername());
        if (check.isconnection(user.getUsername(),user.getPassword())) {
            return "Login successful";
        } else {
            return "Invalid credentials";
        }

    }
}
