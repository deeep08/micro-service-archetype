package db.example.respository;

import db.example.model.DummyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface DummyRepository extends JpaRepository<DummyEntity, UUID> {

    Optional<DummyEntity> findById(final UUID id);

    Optional<DummyEntity> findByName(final String name);
}
