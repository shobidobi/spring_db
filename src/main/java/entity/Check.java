package entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Component
@ComponentScan("entity")
@Service
public class Check {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordRepository passwordRepository;


    public boolean isconnection(String userName, String password){
        UsersEntity usersEntity = userRepository.findUsersEntityByUserNameContaining(userName).get(0);
        PasswordsEntity passwordsEntity = passwordRepository.findByUserId(usersEntity.getId());
        if(passwordsEntity.getPassword().equals(password)){
            return true;
        }
        return false;
    }
}
