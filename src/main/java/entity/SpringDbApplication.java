package entity;

import Repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.mail.MessagingException;

@SpringBootApplication(scanBasePackages = {"Controller","entity","Repository"})
@EnableJpaRepositories(basePackages = "Repository")


//@SpringBootApplication
public class SpringDbApplication {

    public static void main(String[] args) throws Exception {

        SpringApplication.run(SpringDbApplication.class, args);
//        UsersEntity user = new UsersEntity();
//        user.findUser("ariel")
        //CommandLineRunner runner = run(UserRepository);

    }


    //@Bean
    public static CommandLineRunner run(UserRepository repository) {
        return (args) -> {
            //insertFourEmployees(repository);
            //System.out.println(repository.findAll());
            System.out.println();
            System.out.println();
            System.out.println(repository.findUsersEntityByUserNameContaining("ariel").toString());
            //System.out.println(repository.findEmployeesByLastNameContaining(" "));
        };
    }
//    @Autowired
//    private EmailSenderService senderService;
    @EventListener(ApplicationReadyEvent.class)
    public void triggerMail() throws MessagingException {
//        senderService.sendSimpleEmail("sharel394@gmail.com",
//                "This is email body",
//                "The");
        //senderService.number();
    }

}
