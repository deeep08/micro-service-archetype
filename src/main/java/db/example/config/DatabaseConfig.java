package db.example.config;

import db.example.model.DummyEntity;
import db.example.respository.DummyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.stream.IntStream;

@RequiredArgsConstructor
@Slf4j
@Component
public class DatabaseConfig implements CommandLineRunner {

    private final DummyRepository dummyRepository;

    @Override
    public void run(String... args) {
        log.info("Inserting dummy data...");

        IntStream.range(1, 10)
                .boxed()
                .map(i -> DummyEntity.builder()
                        .id(UUID.randomUUID())
                        .name("Dummy-" + i)
                        .build())
                .peek(data -> log.info("Inserted dummy entity: {}", data))
                .forEach(dummyRepository::save);

    }
}
