package hu.university.game.repository;

import hu.university.game.model.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository for storing and retrieving BoardEntity objects from MySQL.
 * Inherits CRUD operations from JpaRepository.
 */
public interface BoardRepository extends JpaRepository<BoardEntity, Long> {
    // No custom methods needed — Spring Data JPA provides CRUD
}
