# Membrane Spring Boot Starter

A Spring Boot Starter for Membrane Service Proxy

```java
@EnableMembrane
@SpringBootApplication
public class Application {
    @Bean
    public ProxiesConfiguration proxies() {
        return p -> p
            .serviceProxy(s -> s
                .matches(m -> m.pathPrefix("/restnames/"))
                .target(t -> t.host("www.thomas-bayer.com")));
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
```
