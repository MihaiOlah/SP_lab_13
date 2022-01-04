package Spring.controllers;

import Spring.difexample.ClientComponent;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class HelloController {
    private final ClientComponent cc_;

    //public HelloController(ClientComponent cc) {
      //  cc_ = cc;
    //}

    @RequestMapping
    public String index()
    {
        //return "Hello from Spring Boot";
        return "Hello from ClientComponent = ClientComponent@" + Integer.toHexString(System.identityHashCode(cc_));
    }
}
