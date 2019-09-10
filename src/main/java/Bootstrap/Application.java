package Bootstrap;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;

@SpringBootApplication
//@RestController
//@EnableAutoConfiguration
public class Application {
//    @RequestMapping("/")
//    String home() {
//        return "Hello World!";
//    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
