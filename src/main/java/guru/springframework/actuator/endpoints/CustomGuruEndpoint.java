package guru.springframework.actuator.endpoints;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;
import java.util.HashSet;
import java.util.Set;

@Component
@Endpoint(id="customGuruEndpoint")
public class CustomGuruEndpoint {
    private Set<String> content = new HashSet<>();

    @ReadOperation
    public Set<String> readOp(){
        content.add("Umphrey's");
        content.add("McGee");
        content.add ("Zonkey rocks!");
        return content;
    }
}
