package me.asaushkin.springjpa.echo;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
public class EchoController {

    @RequestMapping("/echo/{echoData}")
    public Echo getEcho(@PathVariable String echoData) {
        return new Echo(1, echoData);
    }

    @RequestMapping("/echo/{echoData}/{count}")
    public List<Echo> getEchos(@PathVariable String echoData, @PathVariable Integer count) {
        AtomicInteger atomicLong = new AtomicInteger(0);

        return Stream.generate(() -> new Echo(atomicLong.incrementAndGet(), echoData))
                .limit(count).collect(Collectors.toList());
    }

    static class Echo {
        private Integer id;
        private String data;
        private ZonedDateTime timestamp = ZonedDateTime.now(ZoneId.of("UTC"));

        public Echo(Integer id, String data) {
            this.id = id;
            this.data = data;
        }

        public Integer getId() {
            return id;
        }

        public String getData() {
            return data;
        }

        public ZonedDateTime getTimestamp() {
            return timestamp;
        }
    }
}
