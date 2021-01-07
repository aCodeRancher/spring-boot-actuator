package guru.springframework.actuator.health;

import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class CustomHealthIndicator implements HealthIndicator {

    @Override
    public Health health() {
        Random random = new Random();
        int nextNumber = random.nextInt(10);

        if (nextNumber <3) {
            return Health.down().withDetail("error-001", "random failure").build();
        }
         else if (nextNumber >=3 && nextNumber <=6)
                  return  Health.outOfService().withDetail("error-002", "unknown").build();
               else
                    return Health.up().withDetail("good", "service is up").build();
   }

}
