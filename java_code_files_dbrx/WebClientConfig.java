import java.time.Duration;

import org.springframework.context.annotation.Bean;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;

import io.netty.channel.ChannelOption;
import reactor.netty.http.client.HttpClient;
import reactor.netty.tcp.TcpClient;

public class WebClientConfig {
    @Bean
    public WebClient webClient() {
        return WebClient.builder()
                .baseUrl("https://your-webservice-url")
                // Set Connection and Read Timeouts
                .clientConnector(new ReactorClientHttpConnector(
                        HttpClient.from(TcpClient.create()
                            .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 5000)
                            .wiretap("my-logger:http-data"))))
                // Set Write Timeout
                .exchangeStrategies(ExchangeStrategies.builder()
                    .codecs(configurer -> configurer
                        .defaultCodecs()
                        .maxInMemorySize(-1))
                    .build())
                .responseTimeout(Duration.ofMillis(60000)) // 60 seconds timeout for response handling
                .build();
    }
    public static void main(String[] args) {
    }
}