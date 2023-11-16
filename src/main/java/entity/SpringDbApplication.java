package entity;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(scanBasePackages = "entity")
//@SpringBootApplication
public class SpringDbApplication {

    public static void main(String[] args) throws Exception {

        SpringApplication.run(SpringDbApplication.class, args);
//        UsersEntity user = new UsersEntity();
//        user.findUser("ariel")
        //CommandLineRunner runner = run(UserRepository);

    }

    @Bean
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

}
