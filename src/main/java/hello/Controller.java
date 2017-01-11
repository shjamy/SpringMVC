package hello;

import java.util.concurrent.atomic.AtomicLong;
import javafx.application.Application;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Application app(@RequestParam(value="name", defaultValue="World") String name) {
        return new ApplicationImpl(counter.incrementAndGet(),
                            String.format(template, name));
    }

    private static class ApplicationImpl extends Application {

        public ApplicationImpl(long incrementAndGet, String format) {
            super(incrementAndGet, format);
        }
    }
}