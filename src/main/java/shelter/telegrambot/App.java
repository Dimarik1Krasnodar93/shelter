package shelter.telegrambot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableScheduling
public class App 
{//3/13
    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);
    }
}
