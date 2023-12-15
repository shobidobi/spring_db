package entity;

import Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Random;


@Service
public class EmailSenderService {
    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    UserRepository userRepository;

    public void sendSimpleEmail(String toEmail,
                                String subject,
                                String body
    ) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("fromemail@gmail.com");
        message.setTo(toEmail);
        message.setText(body);
        message.setSubject(subject);
        mailSender.send(message);
        System.out.println("Mail Send...");


    }
    public int sendMail(String toEmail){
        Check check = new Check();
        int number=number();
//        if (check.isValidEmail(toEmail)&&userRepository.findUsersEntityByEmail(toEmail).isPresent()) {
//            String body="this is your code for password reset: "+number;
//            sendSimpleEmail(toEmail, "Forgot password", body);
//            return number;
//        }
//        return -1;
        String body="this is your code for password reset: "+number;
        sendSimpleEmail(toEmail, "Forgot password", body);
        return number;
    }
    public int number(){
        Random random = new Random();
        int randomDigits = random.nextInt(10000);
        if (numofdigits(randomDigits)<4){
            randomDigits+=1000;
        }
        int finalNumber = randomDigits;
        System.out.println("Generated Number: " + finalNumber);
        return finalNumber;
    }
    private int numofdigits(int number){
        int count=0;
        while(number!=0){
            number/=10;
            ++count;
        }
        return count;
    }





}