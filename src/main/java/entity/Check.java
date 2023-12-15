package entity;

import Repository.PasswordRepository;
import Repository.UserRepository;
import entity.PasswordsEntity;
import entity.UsersEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
@ComponentScan("entity")
@Service
public class Check {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordRepository passwordRepository;


    /**
     * @param userName the username to check
     * @param password
     * @return
     */
    public boolean isconnection(String userName, String password){
        Optional<UsersEntity> optionalUsersEntity = userRepository.findUsersEntityByUserNameContaining(userName);
        PasswordsEntity passwordsEntity = passwordRepository.findFirstByUserIdOrderByDateDesc(optionalUsersEntity.get().getId()).get();
        if(passwordsEntity.getPassword().equals(password)){
            return true;
        }
        return false;
    }
    public boolean isValidEmail(String email) {
        final String EMAIL_REGEX = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        System.out.println(email);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }


    /**
     * @param user_name Username of new user to test
     * @param password Password of new user to test
     * @return true if the conditions of the registration were passed successfully and false otherwise
     */
    public boolean checkUser(String user_name, String password){
        /*check user_name */
        if (user_name.length()<6||user_name.length()>12){
            System.out.println("the user name are not good");
            return false;
        }
        for (int i = 0; i < user_name.length(); i++) {
            if (!((user_name.charAt(i)>=32)&&
                    (user_name.charAt(i)<=127))){
                System.out.println("The user name contains invalid characters");
                return false;
            }

        }
        /*check password*/
        if (password.length()<6||password.length()>12){
            System.out.println("the password are not good");
            System.out.println(password.length());
            return false;
        }
        for (int i = 0; i < password.length(); i++) {
            if (!(password.charAt(i)>=32&&
                    password.charAt(i)<=127)){
                System.out.println("Password contains invalid characters");
                return false;
            }
        }

        return true;
    }
}
