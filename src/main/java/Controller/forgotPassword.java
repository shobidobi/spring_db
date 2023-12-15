package Controller;

import Repository.PasswordRepository;
import Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Service
@RequestMapping("/api/")
public class forgotPassword {
    @Autowired
    PasswordRepository passwordRepository;
    @Autowired
    UserRepository userRepository;
    private String email;
    @PostMapping("/resetPassword")
    public void resetPassword(@RequestParam String password,@RequestParam String emailr){
        int id=userRepository.findUsersEntityByEmail(emailr).get().getId();
        passwordRepository.save(new entity.PasswordsEntity(password,id,java.time.LocalDate.now()));
        System.out.println("password changed");
    }
    public void setEmail(String email){
        this.email=email;
    }
}
