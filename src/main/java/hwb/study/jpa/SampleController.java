package hwb.study.jpa;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

    @GetMapping("/hello")
    public String hello() {
        var msg = "Keesun";
        return msg + ", Good Morning!";
    }
}
