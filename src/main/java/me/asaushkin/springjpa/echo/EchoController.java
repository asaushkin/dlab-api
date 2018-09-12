package me.asaushkin.springjpa.echo;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
public class EchoController {

    @RequestMapping("/echo/{echoData}")
    public Echo getEcho(@PathVariable String echoData) {
        return new Echo(echoData);
    }

    @RequestMapping("/echo/{echoData}/{count}")
    public List<Echo> getEchos(@PathVariable String echoData, @PathVariable Integer count) {
        return Stream.generate(() -> new Echo(echoData))
                .limit(count).collect(Collectors.toList());
    }

    static class Echo {
        private String data;
        private ZonedDateTime time = ZonedDateTime.now(ZoneId.of("UTC"));

        public Echo(String data) {
            this.data = data;
        }

        public String getData() {
            return data;
        }

        public ZonedDateTime getTime() {
            return time;
        }
    }
}
