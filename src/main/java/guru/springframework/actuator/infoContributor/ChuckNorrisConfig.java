package guru.springframework.actuator.infoContributor;

import guru.springframework.norris.chuck.ChuckNorrisInfoContributor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ChuckNorrisConfig {

    @Bean
    public  ChuckNorrisInfoContributor chuckNorrisContributor(){
        return new ChuckNorrisInfoContributor();
    }
}
