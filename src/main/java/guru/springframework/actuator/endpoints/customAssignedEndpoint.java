package guru.springframework.actuator.endpoints;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
@Endpoint(id="customAssignedEndpoint")
public class customAssignedEndpoint {

    private Set<String> content = new HashSet<>();

    @ReadOperation
    public Set<String> readOp(){
         content.add("assignment 1");
         content.add("write my own endpoint");
         return content;
    }
}
