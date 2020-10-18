package db.example.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "Dummy")
public class DummyEntity {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "createdAt", nullable = false, updatable = false)
    private LocalDateTime creationTime;

    @Column(name = "lastUpdated", nullable = false)
    private LocalDateTime lastUpdated;

    @PrePersist
    private void beforePersist() {
        creationTime = LocalDateTime.now(ZoneId.of("GMT"));
        lastUpdated = creationTime;
    }

    @PreUpdate
    private void beforeUpdate() {
        lastUpdated = LocalDateTime.now(ZoneId.of("GMT"));
    }
}
